package cn.com.zzn.ws.services.vacation;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.slf4j.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lenovo on 2015/10/8.
 */

@Path("/vacation")
public class VacationProcess {

    @Inject
    private RuntimeService runtimeService;

    @Inject
    private Logger log;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void request(VacationEntity vacationRequest) {
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("employeeName", vacationRequest.getEmployeeName());
        variables.put("numberOfDays", vacationRequest.getNumberOfDays());
        variables.put("vacationMotivation", vacationRequest.getVacationMotivation());

        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("vacationRequest", variables);
        log.info("Number of process instances: " + runtimeService.createProcessInstanceQuery().count());
    }

}
