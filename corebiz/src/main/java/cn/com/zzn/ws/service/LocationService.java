package cn.com.zzn.ws.service;

import cn.com.zzn.model.persist.Area;
import cn.com.zzn.model.persist.City;
import cn.com.zzn.model.persist.Province;
import cn.com.zzn.persist.service.LocationDao;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.slf4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/location")
public class LocationService {

    @Inject
    private Logger log;

    @Inject
    private LocationDao locationDao;

    @GET
    @Path("/provinces")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProviences() {
        try {
            final GenericEntity<List<Province>> entity = new GenericEntity<List<Province>>(locationDao.getProvinces()) {
            };
            return Response.status(Response.Status.OK).entity(entity).build();
        } catch (Exception e) {
            log.error(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity("").build();
        }
    }

    @GET
    @Path("/cities/{provinceCode}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCities(@PathParam("provinceCode") String provinceCode) {
        try {
            final GenericEntity<List<City>> entity = new GenericEntity<List<City>>(locationDao.getCities(provinceCode)) {
            };
            return Response.status(Response.Status.OK).entity(entity).build();
        } catch (Exception e) {
            log.error(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity("").build();
        }
    }

    @GET
    @Path("/areas/{cityCode}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAreas(@PathParam("cityCode") String cityCode) {
        try {
            final GenericEntity<List<Area>> entity = new GenericEntity<List<Area>>(locationDao.getAreas(cityCode)) {
            };
            return Response.status(Response.Status.OK).entity(entity).build();
        } catch (Exception e) {
            log.error(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity("").build();
        }
    }
}
