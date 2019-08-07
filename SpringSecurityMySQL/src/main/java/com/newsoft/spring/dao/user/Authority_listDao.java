package com.newsoft.spring.dao.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.newsoft.spring.dao.JDBCTemplate;
import com.newsoft.spring.vo.Authority_listVO;

public class Authority_listDao {
	
	private static final String  QUERY_SELECT_ALL_AUTORITY_LIST = "SELECT `AUTHORITY`, `DESCRIPTION` FROM authority_list;";
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public Authority_listDao() {
		dataSource = new JDBCTemplate().dataSource();
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	public List<Authority_listVO> getListAuthority_list(){
		return this.jdbcTemplate.query(QUERY_SELECT_ALL_AUTORITY_LIST,AUTHORITIES_LIST_MAPPER);
		
	}
	
	private static final RowMapper<Authority_listVO> AUTHORITIES_LIST_MAPPER = new RowMapper<Authority_listVO>() {
		@Override
		public Authority_listVO mapRow(ResultSet rs, int num) throws SQLException {
			Authority_listVO result = new Authority_listVO();

			result.setDESCRIPTION(rs.getString("DESCRIPTION"));
			result.setAUTHORITY(rs.getString("AUTHORITY"));

			return result;
		}
	};

}
