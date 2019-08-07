package com.newsoft.spring.dao.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.newsoft.spring.dao.CommonResponce;
import com.newsoft.spring.dao.JDBCTemplate;
import com.newsoft.spring.vo.AuthoritiesVO;

public class AuthoritiesDao {

	public static final String QUERY_SELECT_ALL_AUTHORITIES = "SELECT `USERNAME`, `AUTHORITY` FROM `authorities`;";
	public static final String QUERY_SELECT_USERNAME_AUTHORITIES = "SELECT `USERNAME`, `AUTHORITY` FROM `authorities` WHERE `USERNAME` = ?;";
	public static final String QUERY_SELECT_AUTHORITY_AUTHORITIES = "SELECT `USERNAME`, `AUTHORITY` FROM `authorities` WHERE `AUTHORITY` = ?";

	private static final String QUERY_INSERT_AUTHORITIES = "INSERT INTO `authorities`(`USERNAME`, `AUTHORITY`) VALUES (?,?);";
	private static final String QUERY_UPDATE_USERNAME_AUTHORITIES = "UPDATE `authorities` SET `USERNAME`=? WHERE `AUTHORITY`=?;";
	private static final String QUERY_UPDATE_AUTHORITY_AUTHORITIES = "UPDATE `authorities` SET `AUTHORITY`=? WHERE `USERNAME`=?;";

	private static final String QUERY_DELETE_SPECIFIC_AUTHORITIES = "DELETE FROM `authorities` WHERE `USERNAME`=? AND `AUTHORITY`=?;";
	private static final String QUERY_DELETE_ALL_AUTHORITIES = "DELETE FROM `authorities` WHERE `USERNAME`=?";

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public AuthoritiesDao() {
		dataSource = new JDBCTemplate().dataSource();
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<AuthoritiesVO> getListaAuthorities() {
		return this.jdbcTemplate.query(QUERY_SELECT_ALL_AUTHORITIES, AUTHORITIES_MAPPER);
	}

	public CommonResponce insertAuthorities(AuthoritiesVO auto) {
		CommonResponce responce = new CommonResponce();
		responce.setEstado(true);

		try {
			this.jdbcTemplate.update(QUERY_INSERT_AUTHORITIES,
					new Object[] { auto.getUSERNAME(), auto.getAUTHORITY() });
		} catch (DataAccessException e) {
			responce.setEstado(false);
			responce.setTipo("Servidor!");
			responce.setMensaje("Ocurrio un error inesperado.");
		}
		return responce;

	}

	private static final RowMapper<AuthoritiesVO> AUTHORITIES_MAPPER = new RowMapper<AuthoritiesVO>() {
		@Override
		public AuthoritiesVO mapRow(ResultSet rs, int num) throws SQLException {
			AuthoritiesVO result = new AuthoritiesVO();

			result.setUSERNAME(rs.getString("USERNAME"));
			result.setAUTHORITY(rs.getString("AUTHORITY"));

			return result;
		}
	};

}
