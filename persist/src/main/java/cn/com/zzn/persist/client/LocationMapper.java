package cn.com.zzn.persist.client;

import cn.com.zzn.model.persist.Area;
import cn.com.zzn.model.persist.City;
import cn.com.zzn.model.persist.Province;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by cmwin on 9/23/15.
 */
public interface LocationMapper {
    List<Province> selectProvinces();

    List<City> selectCities(@Param("proviceCode") String proviceCode);

    List<Area> selectAreas(@Param("cityCode") String cityCode);
}
