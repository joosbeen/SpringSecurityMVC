package com.newsoft.spring.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JDBCTemplate {

	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/springmvcsecurity?zeroDateTimeBehavior=convertToNull");
		dataSource.setUsername("root");
		dataSource.setPassword("root1234");
		return dataSource;
	}

}
