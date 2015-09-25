package cn.com.zzn.persist.service.impl;

import cn.com.zzn.model.persist.Area;
import cn.com.zzn.model.persist.City;
import cn.com.zzn.model.persist.Province;
import cn.com.zzn.persist.client.CodetableMapper;
import cn.com.zzn.persist.client.LocationMapper;
import cn.com.zzn.persist.service.LocationDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tapestry5.func.Mapper;
import org.slf4j.Logger;

import java.util.List;

/**
 * Created by cmwin on 9/23/15.
 */
public class LocationDaoImpl implements LocationDao {

    private final Logger log;
    private final SqlSessionFactory sqlSessionFactory;

    public LocationDaoImpl(final Logger log, final SqlSessionFactory sqlSessionFactory) {
        this.log = log;
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public List<Province> getProvinces() {
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            LocationMapper mapper = session.getMapper(LocationMapper.class);
            return mapper.selectProvinces();
        } catch (Exception e) {
            log.error(e.getMessage());
            if (session != null) {
                session.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    public List<City> getCities(String proviceCode) {
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            LocationMapper mapper = session.getMapper(LocationMapper.class);
            return mapper.selectCities(proviceCode);
        } catch (Exception e) {
            log.error(e.getMessage());
            if (session != null) {
                session.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    public List<Area> getAreas(String citeCode) {
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            LocationMapper mapper = session.getMapper(LocationMapper.class);
            return mapper.selectAreas(citeCode);
        } catch (Exception e) {
            log.error(e.getMessage());
            if (session != null) {
                session.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }
}
