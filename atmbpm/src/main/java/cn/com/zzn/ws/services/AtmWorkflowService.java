package cn.com.zzn.ws.services;


import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.jboss.resteasy.core.ServerResponse;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

@Path("/workflow")
public class AtmWorkflowService {

    @Inject
    private RepositoryService repositoryService;

    @Inject
    private TaskService taskService;

    @Inject
    private RuntimeService runtimeService;

    @GET
    @Path("/diagram/{taskId}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public ServerResponse findPngForTask(@PathParam("taskId") String taskId, @Context HttpServletResponse response) {
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        String processDefinitionId = task.getProcessDefinitionId();
        ProcessDefinition pd = repositoryService.createProcessDefinitionQuery().processDefinitionId(processDefinitionId).singleResult();
        InputStream in = repositoryService.getResourceAsStream(pd.getDeploymentId(), pd.getDiagramResourceName());
        //3：从response对象获取输出流
        ServerResponse sr = null;
        try {
            OutputStream out = response.getOutputStream();
            for(int b=-1; (b=in.read())!=-1;) {
                out.write(b);
            }
            out.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
            sr = new ServerResponse();
        }
        return sr;
    }

    @GET
    @Path("/diagram/coord/{taskId}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> findCoordingByTask(@PathParam("taskId") String taskId) {
        //存放坐标
        Map<String, Object> map = new HashMap<String,Object>();
        //使用任务ID，查询任务对象
        Task task = taskService.createTaskQuery()//
                .taskId(taskId)//使用任务ID查询
                .singleResult();
        //获取流程定义的ID
        String processDefinitionId = task.getProcessDefinitionId();
        //获取流程定义的实体对象（对应.bpmn文件中的数据）
        ProcessDefinitionEntity processDefinitionEntity = (ProcessDefinitionEntity)repositoryService.getProcessDefinition(processDefinitionId);
        //流程实例ID
        String processInstanceId = task.getProcessInstanceId();
        //使用流程实例ID，查询正在执行的执行对象表，获取当前活动对应的流程实例对象
        ProcessInstance pi = runtimeService.createProcessInstanceQuery()//创建流程实例查询
                .processInstanceId(processInstanceId)//使用流程实例ID查询
                .singleResult();
        //获取当前活动的ID
        String activityId = pi.getActivityId();
        //获取当前活动对象
        ActivityImpl activityImpl = processDefinitionEntity.findActivity(activityId);//活动ID
        //获取坐标
        map.put("x", activityImpl.getX());
        map.put("y", activityImpl.getY());
        map.put("width", activityImpl.getWidth());
        map.put("height", activityImpl.getHeight());
        return map;
    }



}
