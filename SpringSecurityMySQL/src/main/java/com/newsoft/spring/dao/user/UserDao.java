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
import com.newsoft.spring.vo.UsuarioVO;

public class UserDao {

	private static final String QUERY_SQL_SELECT_USERS_ALL = "SELECT * FROM USERS;";
	private static final String QUERY_SQL_SELECT_USERS_ACTIVOS = "SELECT * FROM USERS WHERE ENABLED = TRUE;";
	private static final String QUERY_SQL_SELECT_USERS_INACTIVOS = "SELECT * FROM USERS WHERE ENABLED = FALSE;";
	private static final String QUERY_SQL_INSERT_USER = "INSERT INTO users(USERNAME, PASSWORD, ENABLED, NOMBRE, APELLIDOS, FECHA_NACIMIENTO, SEXO, FECHA_ALTA,   CORREO_ELECTRONICO_PPAL) VALUES (?,?,?,?,?,?,?,NOW(),?);";
	private static final String QUERY_SQL_UPDATE_USER = "UPDATE users SET USERNAME=?,PASSWORD=?,ENABLED=?,NOMBRE=?,APELLIDOS=?,FECHA_NACIMIENTO=?,SEXO=?,HUSO_HORARIO=?,CORREO_ELECTRONICO_PPAL=?,TRACKING=? WHERE USER_ID=?;";
	private static final String QUERY_SQL_UPDATE_ENABLED_USER = "UPDATE users SET ENABLED=? WHERE USER_ID=?;";

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public UserDao() {
		dataSource = new JDBCTemplate().dataSource();
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<UsuarioVO> getListaUsuario() {
		return this.jdbcTemplate.query(QUERY_SQL_SELECT_USERS_ALL, ROLES_MAPPER);
	}
	
	public List<UsuarioVO> getListaUsuarioActivo() {
		return this.jdbcTemplate.query(QUERY_SQL_SELECT_USERS_ACTIVOS, ROLES_MAPPER);
	}
	
	public List<UsuarioVO> getListaUsuarioInactivos() {
		return this.jdbcTemplate.query(QUERY_SQL_SELECT_USERS_INACTIVOS, ROLES_MAPPER);
	}

	public CommonResponce insertUsuario(UsuarioVO user) {
		CommonResponce responce = new CommonResponce();
		responce.setEstado(true);

		try {
			this.jdbcTemplate.update(QUERY_SQL_INSERT_USER,
					new Object[] { user.getUSERNAME(), user.getPASSWORD(), user.isENABLED(), user.getNOMBRE(),
							user.getAPELLIDOS(), user.getFECHA_NACIMIENTO(), user.getSEXO(),
							user.getCORREO_ELECTRONICO_PPAL() });

		} catch (DataAccessException e) {
			responce.setEstado(false);
			responce.setTipo("Servidor!");
			responce.setMensaje("Ocurrio un erro en el proceso.");
		}
		return responce;
	}

	public CommonResponce updateEstadoUsuario(UsuarioVO user) {
		CommonResponce responce = new CommonResponce();
		responce.setEstado(true);

		try {
			this.jdbcTemplate.update(QUERY_SQL_UPDATE_ENABLED_USER,
					new Object[] { !user.isENABLED(), user.getUSER_ID() });

		} catch (DataAccessException e) {
			responce.setTipo("Servidor!");
			responce.setMensaje("Ocurrio un erro en el proceso.");
		}
		return responce;
	}

	public CommonResponce updateUsuario(UsuarioVO user) {
		CommonResponce responce = new CommonResponce();
		responce.setEstado(true);

		try {
			this.jdbcTemplate.update(QUERY_SQL_UPDATE_USER,
					new Object[] { user.getUSERNAME(), user.getPASSWORD(), user.isENABLED(), user.getNOMBRE(),
							user.getAPELLIDOS(), user.getFECHA_NACIMIENTO(), user.getSEXO(), user.getHUSO_HORARIO(),
							user.getCORREO_ELECTRONICO_PPAL(), user.isTRACKING(), user.getUSER_ID() });

		} catch (DataAccessException e) {
			responce.setTipo("Servidor!");
			responce.setMensaje("Ocurrio un erro en el proceso.");
		}
		return responce;
	}

	private static final RowMapper<UsuarioVO> ROLES_MAPPER = new RowMapper<UsuarioVO>() {
		@Override
		public UsuarioVO mapRow(ResultSet rs, int num) throws SQLException {
			UsuarioVO result = new UsuarioVO();

			result.setUSER_ID(rs.getInt("USER_ID"));
			result.setUSERNAME(rs.getString("USERNAME"));
			result.setPASSWORD(rs.getString("PASSWORD"));
			result.setENABLED(rs.getBoolean("ENABLED"));
			result.setNOMBRE(rs.getString("NOMBRE"));
			result.setAPELLIDOS(rs.getString("APELLIDOS"));
			result.setFECHA_NACIMIENTO(rs.getDate("FECHA_NACIMIENTO"));
			result.setSEXO(rs.getString("SEXO"));
			result.setFECHA_ALTA(rs.getTimestamp("FECHA_ALTA"));
			result.setFECHA_MODIFICACION(rs.getTimestamp("FECHA_MODIFICACION"));
			result.setHUSO_HORARIO(rs.getString("HUSO_HORARIO"));
			result.setCORREO_ELECTRONICO_PPAL(rs.getString("CORREO_ELECTRONICO_PPAL"));
			result.setTRACKING(rs.getBoolean("TRACKING"));
			return result;
		}
	};

}
