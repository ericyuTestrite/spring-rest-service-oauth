package com.testritegroup.b2b.data;


import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.descriptor.web.ContextResource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiObjectFactoryBean;

@Configuration
public class DataSourceManager {
	private static DataSource dataSource;
	
	/**
	 * for tokenStore
	 * @return
	 */
	public static DataSource dataSource(){
		if(dataSource == null){
			dataSource = DataSourceBuilder
	                .create()
	                .url("jdbc:oracle:thin:@192.168.5.20:1521/tsrm")
	                .username("tcb")
	                .password("tcbtest")
	                .driverClassName("oracle.jdbc.driver.OracleDriver")
	                .build();
		}
		return dataSource;
	}


}
