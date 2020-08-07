package com.bit2020.mysite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	@RequestMapping("")
	public String index() {
		return "main/index";
	}
	
	@ResponseBody
	//@RequestMapping()
}