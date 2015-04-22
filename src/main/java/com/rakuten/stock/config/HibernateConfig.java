package com.rakuten.stock.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@PropertySource(value = { "classpath:application.properties" })
//@ComponentScan({"com.mkyong.stock.config"})
public class HibernateConfig {
 
   @Autowired
   private Environment env;
 
   @Bean
   public LocalSessionFactoryBean sessionFactory() {
      LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
      sessionFactory.setDataSource(dataSource());
      sessionFactory.setPackagesToScan(new String[] { "com.rakuten.stock.model" });
      sessionFactory.setHibernateProperties(hibernateProperties());
 
      return sessionFactory;
   }
 
   @Bean
   public DataSource dataSource() {
	  DriverManagerDataSource dataSource = new DriverManagerDataSource();
      dataSource.setDriverClassName(env.getRequiredProperty("jdbc.driverClassName"));
      dataSource.setUrl(env.getRequiredProperty("jdbc.url"));
      dataSource.setUsername(env.getRequiredProperty("jdbc.username"));
      dataSource.setPassword(env.getRequiredProperty("jdbc.password"));
 
      return dataSource;
   }
 
   @Bean
   @Autowired
   public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
      HibernateTransactionManager txManager = new HibernateTransactionManager();
      txManager.setSessionFactory(sessionFactory);
 
      return txManager;
   }
 
   @Bean
   public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
      return new PersistenceExceptionTranslationPostProcessor();
   }
 
   Properties hibernateProperties() {
	   return new Properties() {
		   {
			   setProperty("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
			   setProperty("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
			   setProperty("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));
		   }
	   };
   }
}