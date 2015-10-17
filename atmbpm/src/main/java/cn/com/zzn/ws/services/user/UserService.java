package cn.com.zzn.ws.services.user;

import cn.com.zzn.utils.AuthHelper;
import org.activiti.engine.IdentityService;
import org.apache.tapestry5.ioc.annotations.Inject;

import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/user")
public class UserService {

    @Inject
    private IdentityService identityService;

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @PermitAll
    public Response login(User user) {
        boolean checked = identityService.checkPassword(user.getUsername(), user.getPassword());
        if (checked) {
            String token = AuthHelper.createJsonWebToken(user.getUsername(), 1L);
            return Response.status(Response.Status.OK).entity(token).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity("").build();
        }
    }
}
