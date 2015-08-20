package cn.com.zzn.ws.service;

import org.apache.tapestry5.json.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/account")
public class AccountService {

    @GET
    @Path("/validate")
    @Produces("application/json")
    public Response validate() {
        JSONObject JSONEntity = new JSONObject();
        JSONEntity.put("message","not Authenticated by zhouyc");
        return Response.status(Response.Status.BAD_REQUEST).entity(JSONEntity.toString()).build();
    }
}
