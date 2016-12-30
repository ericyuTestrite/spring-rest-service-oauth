package com.testritegroup.b2b.data;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;

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
