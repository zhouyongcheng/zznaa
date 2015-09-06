package cn.com.zzn.persist.modules;

import cn.com.zzn.persist.service.CodeTableService;
import cn.com.zzn.persist.service.impl.CodeTableServiceImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.tapestry5.ioc.ScopeConstants;
import org.apache.tapestry5.ioc.ServiceBinder;
import org.apache.tapestry5.ioc.annotations.Scope;
import org.apache.tapestry5.services.ApplicationGlobals;
import org.slf4j.Logger;

import java.io.Reader;

/**
 * Created by cmwin on 6/17/15.
 */
public class ZznPersistModule {

    private final ApplicationGlobals globals;
    private final Logger log;

    public ZznPersistModule(ApplicationGlobals globals, Logger log) {
        this.globals = globals;
        this.log = log;
    }

    public static void bind(final ServiceBinder binder) {
        binder.bind(CodeTableService.class, CodeTableServiceImpl.class);
    }

    @Scope(ScopeConstants.DEFAULT)
    public SqlSessionFactory buildSqlSessionFactory() {
        SqlSessionFactory factory = null;
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            factory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
        return factory;
    }
}