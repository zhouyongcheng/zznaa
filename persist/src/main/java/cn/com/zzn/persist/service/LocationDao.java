package cn.com.zzn.persist.service;

import cn.com.zzn.model.persist.Area;
import cn.com.zzn.model.persist.City;
import cn.com.zzn.model.persist.Province;

import java.util.List;

/**
 * Created by cmwin on 9/23/15.
 */
public interface LocationDao {
    List<Province> getProvinces();
    List<City> getCities(String proviceCode);
    List<Area> getAreas(String citeCode);
}
