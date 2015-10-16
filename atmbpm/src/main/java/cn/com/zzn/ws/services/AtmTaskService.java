package cn.com.zzn.ws.services;

import cn.com.zzn.common.models.ActTask;
import org.activiti.engine.ManagementService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.slf4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/tasks")
public class AtmTaskService {

    @Inject
    private TaskService taskService;

    @Inject
    private RuntimeService runtimeService;

    @Inject
    private ManagementService managementService;

    @Inject
    private Logger log;

    @GET
    @Path("{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserTasks(@PathParam("userId") String userId) {
        List<ActTask> actTasks = new ArrayList<ActTask>();
        try {
            List<Task> tasks = taskService.createTaskQuery()
                    .includeProcessVariables()
                    .includeTaskLocalVariables()
                    .taskAssignee(userId).list();
            for (Task task : tasks) {
                ActTask t = new ActTask();
                t.setId(task.getId());
                t.setName(task.getName());
                t.setAssignee(task.getAssignee());
                t.setOwner(task.getOwner());
                t.setCreateTime(task.getCreateTime());
                t.setDescription(task.getDescription());
                t.setDueDate(task.getDueDate());
                t.setExecutionId(task.getExecutionId());
                t.setProcessDefinitionId(task.getProcessDefinitionId());
                t.setProcessInstanceId(task.getProcessInstanceId());
                t.setCategory(task.getCategory());
                actTasks.add(t);
            }
            final GenericEntity<List<ActTask>> entity = new GenericEntity<List<ActTask>>(actTasks){};
            return Response.status(Response.Status.OK).entity(entity).build();
        } catch (Exception e) {
            log.error(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity("").build();
        }
    }
}
