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
	
	public static DataSource dataSource(){
		if(dataSource == null){
			dataSource = DataSourceBuilder
	                .create()
	                .url("jdbc:mysql://localhost:3306/userbase")
	                .username("root")
	                .password("")
	                .driverClassName("com.mysql.jdbc.Driver")
	                .build();
		}
		return dataSource;
	}


}
