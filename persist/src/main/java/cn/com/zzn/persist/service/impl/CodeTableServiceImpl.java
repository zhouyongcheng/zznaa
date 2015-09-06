package cn.com.zzn.persist.service.impl;

import cn.com.zzn.model.persist.Codetable;
import cn.com.zzn.model.view.Option;
import cn.com.zzn.persist.client.CodetableMapper;
import cn.com.zzn.persist.service.CodeTableService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;

import java.util.List;

/**
 * Created by cmwin on 9/6/15.
 */
public class CodeTableServiceImpl implements CodeTableService {

    private final Logger log;
    private final SqlSessionFactory sqlSessionFactory;

    public CodeTableServiceImpl(final Logger log, final SqlSessionFactory sqlSessionFactory) {
        this.log = log;
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public List<Codetable> getAllCategories() {
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            CodetableMapper mapper = session.getMapper(CodetableMapper.class);
            return mapper.selectAll();
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

    /**
     * get code value pairs for specified category
     * @param category
     * @return code value pairs list
     */
    public List<Option> getCodeValues(String category) {
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            CodetableMapper mapper = session.getMapper(CodetableMapper.class);
            return mapper.selectByCategory(category);
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

    /**
     * add codeTable record
     * @param record
     * @return
     */
    public int addCodetableRecord(Codetable record) {
        int count = -1;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            CodetableMapper mapper = session.getMapper(CodetableMapper.class);
            count = mapper.insert(record);
            session.commit();
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
        return count;
    }

    public int updCodetableRecord(Codetable record) {
        int count = -1;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            CodetableMapper mapper = session.getMapper(CodetableMapper.class);
            count = mapper.updateByPrimaryKey(record);
            session.commit();
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
        return count;
    }
}