package com.newsoft.spring.controllers.rest;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newsoft.spring.dao.CommonResponce;
import com.newsoft.spring.dao.user.AuthoritiesDao;
import com.newsoft.spring.vo.AuthoritiesVO;

@Controller
public class AuthoritiesRestCtrl {
	
	private AuthoritiesDao daoauto;
	
	public AuthoritiesRestCtrl(){
		daoauto = new AuthoritiesDao();
	}

	@RequestMapping(value = "/secured/adm/services/authorities/list.json", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<AuthoritiesVO> obtenerListaUsuario() {
		 return daoauto.getListaAuthorities();
	}
	

	@RequestMapping(value = "/secured/adm/services/authorities/add.json", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody CommonResponce insertUsuario(@RequestBody AuthoritiesVO auto) {
		 return daoauto.insertAuthorities(auto);
	}

}
