package com.libtest.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

import static org.hibernate.cfg.Environment.*;

//import org.springframework.orm.hibernate5.HibernateTransactionManager;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
//import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:db.properties")
//@ComponentScan("com.libtest.spring")
//@ComponentScan({"com.libtest.com.libtest.spring.controller","com.libtest.com.libtest.spring.service"})
//@EnableTransactionManagement
public class AppConfig {

    @Autowired
    private Environment env;


    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(env.getProperty("h2.driver"));
        dataSourceBuilder.url(env.getProperty("h2.url"));
        dataSourceBuilder.username(env.getProperty("h2.user"));
        dataSourceBuilder.password(env.getProperty("h2.password"));
        return dataSourceBuilder.build();
    }

    @Bean
    public LocalSessionFactoryBean getSessionFactory(DataSource dataSource) {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        Properties props = new Properties();
        // Setting JDBC properties
//        props.put(DRIVER, env.getProperty("h2.driver"));
//        props.put(URL, env.getProperty("h2.url"));
//        props.put(USER, env.getProperty("h2.user"));
//        props.put(PASS, env.getProperty("h2.password"));

        // Setting Hibernate properties
        props.put(DIALECT,env.getProperty("hibernate.dialect"));
        props.put(SHOW_SQL, env.getProperty("hibernate.show_sql"));
        props.put(HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));

        // Setting C3P0 properties
        /*props.put(C3P0_MIN_SIZE, env.getProperty("hibernate.c3p0.min_size"));
        props.put(C3P0_MAX_SIZE, env.getProperty("hibernate.c3p0.max_size"));
        props.put(C3P0_ACQUIRE_INCREMENT,
                env.getProperty("hibernate.c3p0.acquire_increment"));
        props.put(C3P0_TIMEOUT, env.getProperty("hibernate.c3p0.timeout"));
        props.put(C3P0_MAX_STATEMENTS, env.getProperty("hibernate.c3p0.max_statements"));
*/
        factoryBean.setHibernateProperties(props);
        factoryBean.setPackagesToScan("com.libtest.com.libtest.spring.model");

        return factoryBean;
    }

    @Bean
    public HibernateTransactionManager getTransactionManager(DataSource dataSource) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory(dataSource).getObject());
        return transactionManager;
    }
}
