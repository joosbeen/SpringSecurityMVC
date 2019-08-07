package com.newsoft.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class GeneralController {

	@RequestMapping(value = "/index.htm")
	public String index() {
			
		return "index";
	}

}
