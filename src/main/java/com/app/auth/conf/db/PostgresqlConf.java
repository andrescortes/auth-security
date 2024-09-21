package com.app.auth.conf.db;

import com.app.auth.util.Constants;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class PostgresqlConf {

    @Bean
    public DataSource dataSource(DBProperties props) {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(props.getUrl());
        config.setUsername(props.getUsername());
        config.setPassword(props.getPassword());
        return new HikariDataSource(config);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
        bean.setDataSource(dataSource);
        bean.setPackagesToScan(Constants.COM_APP);
        bean.setPersistenceUnitName(Constants.PERSISTENCE_UNIT_NAME);
        bean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        Properties jpaProperties = new Properties();
        jpaProperties.setProperty(Constants.HIBERNATE_HBM_2_DDL_AUTO, Constants.CREATE_DROP);
        jpaProperties.setProperty(Constants.HIBERNATE_SHOW_SQL, Constants.TRUE);
        jpaProperties.setProperty(Constants.HIBERNATE_FORMAT_SQL, Constants.TRUE);
        jpaProperties.setProperty(Constants.HIBERNATE_USE_SQL_COMMENTS, Constants.TRUE);
        bean.setJpaProperties(jpaProperties);
        return bean;
    }
}
