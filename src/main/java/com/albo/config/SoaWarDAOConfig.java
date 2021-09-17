package com.albo.config;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(basePackages = "com.albo.war.*", entityManagerFactoryRef = "soaWarEntityManagerFactory", transactionManagerRef = "soaWarTransactionManager")
@ComponentScan(basePackages = { "com.albo.war.*" })
@EntityScan("com.albo.war.model")
public class SoaWarDAOConfig {

	@Value("${spring.datasource.soa-war.hibernate-hbm2ddl-auto}")
	private String ddlMode;

	@Bean
	public PlatformTransactionManager soaWarTransactionManager() {
		return new JpaTransactionManager(soaWarEntityManagerFactory().getObject());
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean soaWarEntityManagerFactory() {
		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();

		HashMap<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", ddlMode);
		properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");

		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

		factoryBean.setDataSource(soaWarDataSource());
		factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
		factoryBean.setPackagesToScan("com.albo.war.*");
		factoryBean.setJpaPropertyMap(properties);

		return factoryBean;
	}

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.soa-war")
	public DataSource soaWarDataSource() {
		return DataSourceBuilder.create().build();
	}

}
