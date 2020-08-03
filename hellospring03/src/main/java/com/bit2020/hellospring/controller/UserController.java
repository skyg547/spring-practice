package com.bit2020.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/****/
@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping(value="join", method=RequestMethod.GET)
	@ResponseBody
	public String join() {
		
		return "/WEB-INF/views/joinform.jsp";
	}
	@RequestMapping(value="join", method=RequestMethod.POST)
	@ResponseBody
	public String join(UserVo vo) {
		System.out.println(vo);
		return "redirect:/main";
	}
	@RequestMapping( value="value" )
	@ResponseBody
	public String update(@RequestParam("name") String name) {
		System.out.println("name"+name);
		return "UserController:update";
	}
	@RequestMapping( value="value" )
	@ResponseBody
	public String update02(@RequestParam(value = "n", required = true, defaultValue = "") String name , @RequestParam(value = "a", required = true, defaultValue = "0") int age) {
		System.out.println("name"+name+"age : "+ age);
		return "UserController:update";
	}
	
	
}
