package cn.com.zzn.ws.service;

import cn.com.zzn.model.persist.Codetable;
import cn.com.zzn.model.view.Option;
import cn.com.zzn.persist.service.CodeTableService;
import org.apache.tapestry5.ioc.annotations.Inject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by cmwin on 9/6/15.
 */
@Path("/categories")
public class CategoryService {

    @Inject
    private CodeTableService codeTableService;

    @GET
    @Path("{category}/options")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Option> getOptions(@PathParam("category") String category) {
        return codeTableService.getOptions(category);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Codetable> getAllCategories() {
        return codeTableService.getAllCategories();
    }

    @GET
    @Path("{category}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Codetable> getCategories(@PathParam("category") String category) {
        return codeTableService.getCategories(category);
    }

    @GET
    @Path("{category}/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public Codetable getCategoryItem(@PathParam("category") String category, @PathParam("code") Integer code) {
        return codeTableService.getCategoryItem(category, code);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addCategory(Codetable category) {
       codeTableService.addCodetableRecord(category);
    }

    @PUT
    @Path("{category}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updCategory(Codetable category) {
        codeTableService.updCodetableRecord(category);
    }

    @DELETE
    @Path("/{category}/{code}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response delCategory(@PathParam("category") String category, @PathParam("code") Integer code) {
        Response r = null;
        try {
            codeTableService.delCategory(category, code);
            r = Response.ok("OK").build();
        } catch (Exception e) {
            r = Response.ok("ERROR").build();
        }
        return r;
    }
}