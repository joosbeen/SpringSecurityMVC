package com.newsoft.spring.dao;

import java.util.Calendar;

import javax.sql.DataSource;
import org.apache.commons.lang.StringUtils;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class Jdbc {
	
	protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	protected JdbcTemplate jdbcTemplate;
	protected static Calendar aCalendar = Calendar.getInstance();	
	
	public final void setDataSource(DataSource dataSource) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	

	protected void checkAffected(int affected) {
        if (affected > 1) {
            throw new RuntimeException("La operacion afecto mas de 1 registro.");
        }
        if (affected < 1) {
            throw new RuntimeException("La operacion no afecto ningun registro.");
        }
    }
	    
	protected void checkAffectedAllRows(int affected) {
	        if (affected == 0) {
	            throw new RuntimeException("La operacion no afecto ningun registro.");
	        }
	    }
    public static String getCustomValue(String val){
    	return StringUtils.isBlank(val)?"":val;	
		
	}
    
    public static String getCustomValue(String val, String def){
    	return StringUtils.isBlank(val)?def:val;
    }

}
