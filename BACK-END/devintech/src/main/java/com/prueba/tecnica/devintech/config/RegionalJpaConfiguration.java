package com.prueba.tecnica.devintech.config;

import java.util.HashMap;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { "com.prueba.tecnica.devintech.repository",
		"com.prueba.tecnica.devintech.entity" }, entityManagerFactoryRef = "entityRegionalFactory", transactionManagerRef = "regionalTransactionManager")
public class RegionalJpaConfiguration {

	@Autowired
	private Environment env;

	@Bean(name = "h2DataSource")
	@Primary
	public DataSource regionalDataSource() {

		if (env.getProperty("spring.profiles.active").equals("release")) {
			JndiDataSourceLookup datasourceJdni = new JndiDataSourceLookup();
			return datasourceJdni.getDataSource(env.getProperty("spring.datasource.jndiName"));
		} else {
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
			dataSource.setUrl(env.getProperty("spring.datasource.url"));
			dataSource.setUsername(env.getProperty("spring.datasource.username"));
			dataSource.setPassword(env.getProperty("spring.datasource.password"));
			return dataSource;
		}

	}

	@Bean
	public JpaTransactionManager regionalTransactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}

	@Primary
	@Bean
	public LocalContainerEntityManagerFactoryBean entityRegionalFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(regionalDataSource());
		em.setPackagesToScan(new String[] { "com.prueba.tecnica.devintech.entity",
				"com.prueba.tecnica.devintech.repository" });
		em.setPersistenceUnitName("regional-persistence-unit");
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaPropertyMap(hibernateProperties());
		return em;
	}

	private HashMap<String, Object> hibernateProperties() {
		HashMap<String, Object> properties = new HashMap<>();
//		properties.put(org.hibernate.cfg.Environment.HBM2DDL_AUTO, env.getProperty("spring.jpa.hibernate.ddl.auto"));
		properties.put(org.hibernate.cfg.Environment.DIALECT,
				env.getProperty("spring.jpa.properties.hibernate.dialect"));
		properties.put(org.hibernate.cfg.Environment.FORMAT_SQL,
				env.getProperty("spring.jpa.properties.hibernate.format_sql"));
		properties.put(org.hibernate.cfg.Environment.STATEMENT_BATCH_SIZE,
				10000);
		return properties;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
}