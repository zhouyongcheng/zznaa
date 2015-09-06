package cn.com.zzn.persist.service.impl;

import cn.com.zzn.persist.client.AAthMapper;
import cn.com.zzn.persist.service.AAthDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;

import java.util.List;

/**
 * Created by cmwin on 8/5/15.
 */
public class AAthDaoImpl implements AAthDao {

    private final Logger log;
    private final SqlSessionFactory sqlSessionFactory;

    public AAthDaoImpl(final Logger log, final SqlSessionFactory sqlSessionFactory) {
        this.log = log;
        this.sqlSessionFactory = sqlSessionFactory;
    }

//    @Override
//    public SysUsers findUserById(Long id) {
//        SqlSession session = null;
//        SysUsers user = null;
//        try {
//            session = sqlSessionFactory.openSession();
//            AAthMapper mapper = session.getMapper(AAthMapper.class);
//            return mapper.findUserById(id);
//        } catch (Exception e) {
//            log.error(e.getMessage());
//            if (session != null) {
//                session.rollback();
//            }
//        } finally {
//            if (session != null) {
//                session.close();
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public SysUsers findUserByName(String username) {
//        SqlSession session = null;
//        SysUsers user = null;
//        try {
//            session = sqlSessionFactory.openSession();
//            AAthMapper mapper = session.getMapper(AAthMapper.class);
//            return mapper.findUserByName(username);
//        } catch (Exception e) {
//            log.error(e.getMessage());
//            if (session != null) {
//                session.rollback();
//            }
//        } finally {
//            if (session != null) {
//                session.close();
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public int createUser(SysUsers user) {
//        int count = -1;
//        SqlSession session = null;
//        try {
//            session = sqlSessionFactory.openSession();
//            AAthMapper mapper = session.getMapper(AAthMapper.class);
//            count = mapper.createUser(user);
//            session.commit();
//        } catch (Exception e) {
//            log.error(e.getMessage());
//            if (session != null) {
//                session.rollback();
//            }
//        } finally {
//            if (session != null) {
//                session.close();
//            }
//        }
//        return count;
//    }

    public int updatePassword(Long userId, String newPassword) {
        int count = -1;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            AAthMapper mapper = session.getMapper(AAthMapper.class);
            count = mapper.updatePassword(userId, newPassword);
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

    public void addRoles(Long userId, Long... roleIds) {
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            AAthMapper mapper = session.getMapper(AAthMapper.class);
            for (Long roleId : roleIds) {
                mapper.addRole(userId, roleId);
            }
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
    }

    public void removeRoles(Long userId, Long... roleIds) {
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            AAthMapper mapper = session.getMapper(AAthMapper.class);
            mapper.removeRoles(userId, roleIds);
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
    }

    public void addPermissions(Long userId, Long... permissions) {
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            AAthMapper mapper = session.getMapper(AAthMapper.class);
            for (Long perm : permissions) {
                mapper.addPermission(userId, perm);
            }
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
    }

    public void removePermissions(Long userId, Long... permissions) {
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            AAthMapper mapper = session.getMapper(AAthMapper.class);
            mapper.removePermissions(userId, permissions);
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
    }

    public List<String> findRoles(String username) {
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            AAthMapper mapper = session.getMapper(AAthMapper.class);
            return mapper.findRoles(username);
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

    public List<String> findPermissions(String username) {
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            AAthMapper mapper = session.getMapper(AAthMapper.class);
            return mapper.findPermissions(username);
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
