package com.example.springjpademo.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.example.springjpademo.aop.LoggingAspect;
import com.example.springjpademo.entities.Department;
import com.example.springjpademo.entities.Employees;

/**
 * Created by Adi Adari on 12/28/2016.
 */
@Configuration
@EnableAspectJAutoProxy
@EnableTransactionManagement()
@EnableWebMvc
@ComponentScan(basePackages = "com.example.springjpademo")
public class DBConfig
{
    @Bean
    public DataSource getDataSource()
    {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521/XE");
        dataSource.setUsername("system");
        dataSource.setPassword("admin");
        return dataSource;
    }

  
    @Bean
    public LocalSessionFactoryBean sessionFactory()
    {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(getDataSource());
        sessionFactory.setAnnotatedClasses(Employees.class,Department.class);
        //sessionFactory.setAnnotatedPackages("com.example.springdemo.entities");
        Properties properties = new Properties();
        properties.setProperty("hibernate.cache.use_second_level_cache", "true");
        properties.setProperty("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.EhCacheRegionFactory");
        properties.setProperty("hibernate.cache.use_query_cache", "true");
        properties.setProperty("hibernate.generate_statistics", "true");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
        properties.setProperty("hibernate.default_schema", "HR");
        sessionFactory.setHibernateProperties(properties);
        return sessionFactory;
    }

    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory)
    {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);
        return transactionManager;
    }
    
    @Bean
    public LoggingAspect getLoggingAspect()
    {
    	return new LoggingAspect();
    }
    
    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation()
    {
    	return new PersistenceExceptionTranslationPostProcessor();
    }
    
    
}
