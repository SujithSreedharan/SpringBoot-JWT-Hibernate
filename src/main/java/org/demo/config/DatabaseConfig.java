package org.demo.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DatabaseConfig {

	@Autowired
	private DataSource dataSource;
	@Value("${entitymanager.packagesToScan}")
	private String packageToScan;
	@Value("${hibernate.config.dialect}")
	private String dialect;
	@Value("${hibernate.config.show_sql}")
	private String show_sql;
	@Value("${hibernate.config.hbm2ddl}")
	private String hbm2ddl;

	@Bean
	public LocalSessionFactoryBean sessionFactory() {

		LocalSessionFactoryBean managerBean = new LocalSessionFactoryBean();
		managerBean.setDataSource(dataSource);
		managerBean.setPackagesToScan(packageToScan);
		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", dialect);
		hibernateProperties.put("hibernate.show_sql", show_sql);
		hibernateProperties.put("hibernate.hbm2ddl.auto", hbm2ddl);
		managerBean.setHibernateProperties(hibernateProperties);

		return managerBean;
	}

	@Bean
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}

}
