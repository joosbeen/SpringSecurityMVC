package com.newsoft.spring.controllers.reports;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newsoft.spring.dao.CommonResponce;
import com.newsoft.spring.dao.user.UserDao;
import com.newsoft.spring.reports.UsuarioReports;
import com.newsoft.spring.reports.util.General;
import com.newsoft.spring.vo.TypeVO;
import com.newsoft.spring.vo.UsuarioVO;

@Controller
public class UsuarioReporteRest {

	private static final Logger LOG = Logger.getLogger(UsuarioReporteRest.class.getName());

	private UserDao daouser;
	private UsuarioReports reportes;

	public UsuarioReporteRest() {
		daouser = new UserDao();
		reportes = new UsuarioReports();
	}

	@RequestMapping(value = "/secured/adm/services/users/reporte/users.json", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public CommonResponce generarPDF(@RequestBody TypeVO type) {
		LOG.info("objeto:" + type.toString());
		CommonResponce resp = new CommonResponce();
		resp.setEstado(true);
		/*
		 * String path = System.getProperty("user.home") + "\\Downloads\\";
		 * String titulo = ""; List<UsuarioVO> users = new
		 * ArrayList<UsuarioVO>();
		 * 
		 * if (type.getType().equals("all")) { titulo = "TODOS LOS USUARIOS";
		 * users = daouser.getListaUsuario(); path =
		 * path.concat("todosUsuarios"); } else if
		 * (type.getType().equals("activos")) { titulo = "USUARIOS ACTIVO";
		 * users = daouser.getListaUsuarioActivo(); path =
		 * path.concat("usuariosActivos"); } else if
		 * (type.getType().equals("inactivos")) { titulo = "USUARIOS INACTIVO";
		 * users = daouser.getListaUsuarioInactivos(); path =
		 * path.concat("usuarioInactivos"); } path =
		 * path.concat(General.getFechaHora() + ".pdf");
		 */
		Object[] datos = getTituloPath(type.getUsers());

		try {
			reportes.setTitulo(datos[0].toString());
			reportes.setPath(datos[1].toString() + "." + type.getType());
			reportes.setUsers((List<UsuarioVO>) datos[2]);
			if (type.getType().equals("pdf")) {
				reportes.generarPDF();
			} else if (type.getType().equals("xlsx")) {
				reportes.generarEXCEL();
			}
		} catch (Exception e) {
			resp.setEstado(false);
		}
		return resp;
	}

	private Object[] getTituloPath(String tipo) {
		String path = System.getProperty("user.home") + "\\Downloads\\";
		String titulo = "";
		List<UsuarioVO> users = new ArrayList<UsuarioVO>();

		if (tipo.equals("all")) {
			titulo = "TODOS LOS USUARIOS";
			users = daouser.getListaUsuario();
			path = path.concat("todosUsuarios");
		} else if (tipo.equals("activos")) {
			titulo = "USUARIOS ACTIVO";
			users = daouser.getListaUsuarioActivo();
			path = path.concat("usuariosActivos");
		} else if (tipo.equals("inactivos")) {
			titulo = "USUARIOS INACTIVO";
			users = daouser.getListaUsuarioInactivos();
			path = path.concat("usuarioInactivos");
		}
		path = path.concat(General.getFechaHora());

		return new Object[] { titulo, path, users };
	}

}
