package com.newsoft.spring.security;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

public class CustomJdbcDaoImpl extends JdbcDaoImpl implements UserDetailsService {

	public static final String DEF_USERS_BY_USERNAME_QUERY = "SELECT "
			+ " username, user_id, password, enabled, nombre, apellidos, fecha_nacimiento, sexo, fecha_alta, "
			+ "fecha_modificacion, huso_horario, correo_electronico_ppal, tracking FROM USERS "
			+ "WHERE username  = ? ";

	public CustomJdbcDaoImpl() {
	}

	@Override
	public List<UserDetails> loadUsersByUsername(String username) {

		return getJdbcTemplate().query(DEF_USERS_BY_USERNAME_QUERY, new String[] { username }, new RowMapper<UserDetails>() {
			public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {

				String username = rs.getString(1);
				Long userId = rs.getLong(2);
				String password = rs.getString(3);
				boolean enabled = rs.getBoolean(4);
				String nombre = rs.getString(5);
				String apellidos = rs.getString(6);
				Date fechaNacimiento = rs.getTimestamp(7);
				String sexo = rs.getString(8);
				Date fechaAlta = rs.getTimestamp(9);
				String husoHorario = rs.getString(11);
				String correoElectronico = rs.getString(12);

				return new SecurityUser(username, password, enabled, true, true, true, AuthorityUtils.NO_AUTHORITIES,
						userId, nombre, apellidos, fechaNacimiento, sexo, fechaAlta, null, correoElectronico,
						husoHorario, null);
			}
		});
	}

	protected UserDetails createUserDetails(String username, UserDetails userFromUserQuery, List combinedAuthorities) {

		SecurityUser securityUser = (SecurityUser) userFromUserQuery;
		return new SecurityUser(securityUser.getUsername(), securityUser.getPassword(), securityUser.isEnabled(), true,
				true, true, combinedAuthorities, securityUser.getUserId(), securityUser.getNombre(),
				securityUser.getApellidos(), securityUser.getFechaNacimiento(), securityUser.getSexo(),
				securityUser.getFechaAlta(), securityUser.getFechaModificacion(),
				securityUser.getCorreElectronicoPpal(), securityUser.getHusoHorario(), securityUser.getDefaultLang());
	}

}
