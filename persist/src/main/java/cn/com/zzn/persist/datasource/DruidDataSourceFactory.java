package cn.com.zzn.persist.datasource;


import org.apache.ibatis.datasource.DataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by zhouyc on 15-7-24.
 */
public class DruidDataSourceFactory implements DataSourceFactory {

    private DataSource dataSource;

    public void setProperties(Properties properties) {
        try {
            this.dataSource = com.alibaba.druid.pool.DruidDataSourceFactory.createDataSource(properties);
        } catch (final RuntimeException e) {
            throw e;
        } catch (final Exception e) {
            throw new RuntimeException("init datasource error", e);
        }
    }

    public DataSource getDataSource() {
        return this.dataSource;
    }
}
