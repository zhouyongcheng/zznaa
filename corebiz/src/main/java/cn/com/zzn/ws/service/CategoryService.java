package cn.com.zzn.ws.service;

import cn.com.zzn.model.persist.Codetable;
import cn.com.zzn.model.view.Option;
import cn.com.zzn.persist.service.CodeTableService;
import org.apache.tapestry5.ioc.annotations.Inject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
    @Produces(MediaType.APPLICATION_JSON)
    public List<Option> getCategoryOptions(@QueryParam("type") String category) {
        return codeTableService.getCodeValues(category);
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Codetable> getAllCategory() {
        return codeTableService.getAllCategories();
    }

}