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
@EnableJpaRepositories(basePackages = "com.albo.psg.*", entityManagerFactoryRef = "soaPsgEntityManagerFactory", transactionManagerRef = "soaPsgTransactionManager")
@ComponentScan(basePackages = { "com.albo.psg.*" })
@EntityScan("com.albo.psg.model")
public class SoaPsgDAOConfig {

	@Value("${spring.datasource.soa-psg.hibernate-hbm2ddl-auto}")
	private String ddlMode;

	@Bean
	public PlatformTransactionManager soaPsgTransactionManager() {
		return new JpaTransactionManager(soaPsgEntityManagerFactory().getObject());
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean soaPsgEntityManagerFactory() {
		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();

		HashMap<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", ddlMode);
		properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");

		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

		factoryBean.setDataSource(soaPsgDataSource());
		factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
		factoryBean.setPackagesToScan("com.albo.psg.*");
		factoryBean.setJpaPropertyMap(properties);

		return factoryBean;
	}

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.soa-psg")
	public DataSource soaPsgDataSource() {
		return DataSourceBuilder.create().build();
	}

}
