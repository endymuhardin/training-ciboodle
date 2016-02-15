package com.brainmatics.training.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:jdbc.properties")
@ComponentScan(basePackages="com.brainmatics.training.dao")
@EnableTransactionManagement
public class Konfigurasi {
	@Autowired private Environment env;
	
	@Bean
	public DataSource konfigurasiDataSource(){
		org.apache.tomcat.jdbc.pool.DataSource ds = new org.apache.tomcat.jdbc.pool.DataSource();
		
		ds.setDriverClassName(env.getProperty("database.driver"));
		ds.setUrl(env.getProperty("database.url"));
		ds.setUsername(env.getProperty("database.username"));
		ds.setPassword(env.getProperty("database.password"));
		
		return ds;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean konfigurasiEntityManager(){
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(konfigurasiDataSource());
		emf.setPackagesToScan("com.brainmatics.training.entity");
		emf.setPersistenceUnitName("training");
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		
		Properties p = new Properties();
		p.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		p.setProperty("hibernate.hbm2ddl.auto", "create");
		p.setProperty("hibernate.show_sql", "true");
		p.setProperty("hibernate.format_sql", "true");
		
		emf.setJpaProperties(p);
		return emf;
	}
	
	@Bean
	public PlatformTransactionManager konfigurasiTransactionManager(EntityManagerFactory emf){
		JpaTransactionManager tx = new JpaTransactionManager();
		tx.setEntityManagerFactory(emf);
		return tx;
	}
}
