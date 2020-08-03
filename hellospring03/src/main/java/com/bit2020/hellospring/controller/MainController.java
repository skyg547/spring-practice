package com.bit2020.hellospring.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	@ResponseBody
	@RequestMapping({"", "/main", "/a/b/c/e/f"})
	public String main() {
		return "MainController:main()";
	}
	@ResponseBody
	@RequestMapping({"test"})
	public String test(HttpServletRequest httpRequest) throws UnsupportedEncodingException {
		httpRequest.setCharacterEncoding("utf-8");
		return "MainController:main()";
	}

}
