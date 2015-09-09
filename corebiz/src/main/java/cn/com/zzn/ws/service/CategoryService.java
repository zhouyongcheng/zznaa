package cn.com.zzn.ws.service;

import cn.com.zzn.model.persist.Codetable;
import cn.com.zzn.model.view.Option;
import cn.com.zzn.persist.service.CodeTableService;
import org.apache.tapestry5.ioc.annotations.Inject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by cmwin on 9/6/15.
 */
@Path("/categories")
public class CategoryService {

    @Inject
    private CodeTableService codeTableService;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Option> getCategoryOptions(@PathParam("id") String category) {
        return codeTableService.getCodeValues(category);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Codetable> getCategoryOptions() {
        List<Codetable> result = codeTableService.getAllCategories();
        if (result != null) {
            System.out.println(result.size()+"----------------------");
        } else {
            System.out.println("----------null------------");
        }
        return result;
    }


}