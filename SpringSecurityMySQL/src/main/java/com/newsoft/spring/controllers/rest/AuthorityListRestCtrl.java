package com.newsoft.spring.controllers.rest;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newsoft.spring.dao.user.Authority_listDao;
import com.newsoft.spring.vo.Authority_listVO;

@Controller
public class AuthorityListRestCtrl {
	
	private Authority_listDao dao;
	
	public AuthorityListRestCtrl(){
		dao = new Authority_listDao();
	}
	
	@RequestMapping(value = "/secured/adm/services/authority/list.json", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Authority_listVO> obtenerListaUsuario() {
		 return dao.getListAuthority_list();
	}

}
