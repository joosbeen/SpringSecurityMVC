package com.newsoft.spring.controllers.rest;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newsoft.spring.dao.CommonResponce;
import com.newsoft.spring.dao.user.UserDao;
import com.newsoft.spring.vo.UsuarioVO;

//org.springframework.security.authentication.encoding.ShaPasswordEncoder
@Controller
public class UsersRestCtrl {

	private static final Logger LOG = Logger.getLogger(UsersRestCtrl.class.getName());

	private UserDao daouser;

	public UsersRestCtrl() {
		daouser = new UserDao();
	}

	@RequestMapping(value = "/secured/adm/services/users/list.json", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<UsuarioVO> obtenerListaUsuario() {
		LOG.info("");
		return daouser.getListaUsuario();
	}

	@RequestMapping(value = "/secured/adm/services/users/status.json", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody CommonResponce updateEstadoUsuario(@RequestBody UsuarioVO user) {
		LOG.info("");
		return daouser.updateEstadoUsuario(user);
	}

	@RequestMapping(value = "/secured/adm/services/users/add.json", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody CommonResponce insertUsuario(@RequestBody UsuarioVO user) {
		LOG.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> add");

		CommonResponce responce = getValidarCampos(user);
		if (!responce.isEstado()) {
			return responce;
		}

		ShaPasswordEncoder passwordEncoder = new ShaPasswordEncoder(256);
		passwordEncoder.setEncodeHashAsBase64(true);
		user.setPASSWORD(passwordEncoder.encodePassword(user.getPASSWORD(), null));
		return daouser.insertUsuario(user);
	}

	@RequestMapping(value = "/secured/adm/services/users/update.json", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody CommonResponce updateUsuario(@RequestBody UsuarioVO user) {
		LOG.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> update");

		CommonResponce responce = getValidarCampos(user);
		if (!responce.isEstado()) {
			return responce;
		}

		ShaPasswordEncoder passwordEncoder = new ShaPasswordEncoder(256);
		passwordEncoder.setEncodeHashAsBase64(true);
		user.setPASSWORD(passwordEncoder.encodePassword(user.getPASSWORD(), null));
		return daouser.updateUsuario(user);
	}

	private CommonResponce getValidarCampos(UsuarioVO user) {
		CommonResponce responce = new CommonResponce();
		responce.setEstado(false);

		if (user.getUSERNAME() == null || user.getUSERNAME().isEmpty() || user.getUSERNAME().length() < 6
				|| user.getUSERNAME().length() > 25) {
			responce.setMensaje(" El campo 'USRENAME' no cumple con los requisitos, [a-z A-Z 0-9] min:6 max:12.");
			return responce;
		}
		if (user.getPASSWORD() == null || user.getPASSWORD().isEmpty() || user.getPASSWORD().length() < 6
				|| user.getPASSWORD().length() > 12) {
			responce.setMensaje(" El campo 'PASSWORD' no cumple con los requisitos, [a-z A-Z 0-9] min:6 max:12.");
			return responce;
		}
		if (user.getNOMBRE() == null || user.getNOMBRE().isEmpty() || user.getNOMBRE().length() < 2) {
			responce.setMensaje(" El campo 'NOMBRE' no cumple con los requisitos, [a-z A-Z] min:2.");
			return responce;
		}
		if (user.getAPELLIDOS() == null || user.getAPELLIDOS().isEmpty() || user.getAPELLIDOS().length() < 2) {
			responce.setMensaje(" El campo 'APELLIDOS' no cumple con los requisitos, [a-z A-Z] min:2.");
			return responce;
		}
		if (user.getCORREO_ELECTRONICO_PPAL() == null || user.getCORREO_ELECTRONICO_PPAL().isEmpty()
				|| user.getCORREO_ELECTRONICO_PPAL().length() < 2) {
			responce.setMensaje(" El campo 'CORREO' no cumple con los requisitos, [a-z A-Z].");
			return responce;
		}
		if (user.getHUSO_HORARIO() == null || user.getHUSO_HORARIO().isEmpty() || user.getHUSO_HORARIO().length() < 2) {
			responce.setMensaje(" El campo 'HUSO HORARIO' no cumple con los requisitos, [a-z A-Z].");
			return responce;
		}

		responce.setEstado(true);
		return responce;
	}
}
