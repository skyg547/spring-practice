package com.bit2020.emailist03.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class EmaillistContoroller {
	
	private EmaillistRepositroy emaillistRepositroy; 
	
	@ResponseBody
	@RequestMapping("")
	public String index() {
		
		
		return "/WEB-INF/views/index.jsp";
	}

}
