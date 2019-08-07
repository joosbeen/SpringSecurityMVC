package com.newsoft.spring.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.newsoft.spring.security.SecurityContextFacade;
import com.newsoft.spring.type.AllowedAuthorities;

@Controller
public class LoginController {

	private static final Logger logger = Logger.getLogger(LoginController.class);

	@RequestMapping(value = "login.htm", method = RequestMethod.GET)
	public ModelAndView index() {
		return new ModelAndView("login");
	}

	@RequestMapping(value = "/secured/access.htm")
	public String loginAction(Model model) {

		String paginaInicio = "main/index";
		try {
			paginaInicio = "index";

			if (SecurityContextFacade.hasAuthenticatedUserRole(AllowedAuthorities.ROLE_ADMIN)) {
				paginaInicio = "redirect:/secured/adm/index.htm";
			} else if (SecurityContextFacade.hasAuthenticatedUserRole(AllowedAuthorities.ROLE_STAFF)) {
				paginaInicio = "redirect:/secured/stf/index.htm";
			} else if (SecurityContextFacade.hasAuthenticatedUserRole(AllowedAuthorities.ROLE_USER)) {
				paginaInicio = "redirect:/secured/usr/index.htm";
			}
		} catch (Exception e) {
			System.out.print("error" + e);
			logger.error(e.getMessage(), e);
		}
		return paginaInicio;
	}

	@RequestMapping(value = "/secured/adm/index.htm")
	public String adminsHome() {
		return "foradmins/index";
	}

	@RequestMapping(value = "/secured/stf/index.htm")
	public String staffsHome() {
		return "forotherusers/index";
	}

	@RequestMapping(value = "/secured/usr/index.htm")
	public String usersHome() {
		return "forotherusers/index";
	}

}
