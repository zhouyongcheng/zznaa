package cn.com.zzn.ws.service;

import cn.com.zzn.common.models.Account;
import cn.com.zzn.services.common.AuthService;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/account")
public class AccountService {

    @Inject
    private AuthService authService;

    @GET
    @Path("/validate")
    @Produces("application/json")
    public Response validate() {
        JSONObject JSONEntity = new JSONObject();
        JSONEntity.put("message","not Authenticated by zhouyc");
        return Response.status(Response.Status.BAD_REQUEST).entity(JSONEntity.toString()).build();
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response login(Account account) {
        String jwt = authService.createJsonWebToken(account.getUsername(), 1L);
        return Response.status(Response.Status.OK).entity(jwt).build();
    }
}
