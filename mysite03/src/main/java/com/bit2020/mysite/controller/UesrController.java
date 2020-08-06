package com.bit2020.mysite.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bit2020.mysite.security.Auth;
import com.bit2020.mysite.service.UserService;
import com.bit2020.mysite.vo.UserVo;

@RequestMapping("/user")
@Controller
public class UesrController {
	
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/join", method = RequestMethod.GET)
	public String join(){
		return "user/join";
	}

	@RequestMapping(value="/join", method = RequestMethod.POST)
	public String join(UserVo userVo){
		
		userService.join(userVo);
		return "redirect:/user/joinsuccess";
	}

	@RequestMapping(value="/joinsuccess", method = RequestMethod.GET)
	public String joinSuccess(){
		return "user/joinsuccess";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(){
		return "user/login";
	}
	
	//@auth 인증을 해서 들어오라
	@Auth
	@RequestMapping(value="/update", method = RequestMethod.GET)
	public String update(@AuthUser UserVo authUser, Model model){
		//UserVo authUser = (UserVo)session.getAttribute("authUser");
		
		
		if(authUser == null) {
			return "redirect:/";
			
		}
		Long no = authUser.getNo();
		
		UserVo userVo = userService.getUser(no);
		model.addAttribute("userVo", userVo);
		return "user/update";
	}
	
	@Auth
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(@AuthUser UserVo authUser, UserVo vo){
		System.out.println(vo);
		vo.setNo(authUser.getNo());
		userService.updateUser(vo);
		return "redirect:/user/update";
	}
	/*
	 * @RequestMapping(value="/update", method = RequestMethod.POST) public String
	 * update(HttpSession session, Model model){ UserVo authUser =
	 * (UserVo)session.getAttribute("authUser"); Long no = authUser.getNo();
	 * 
	 * UserVo userVo = userService.getUser(no); model.addAttribute("userVo",
	 * userVo); return "user/update"; }
	 */
	
	/*
	 * @ExceptionHandler(Exception.class) public String handlerException() {
	 * 
	 * System.out.println("log"); //로깅 return "error/exception"; // 사과페이지
	 * 
	 * 
	 * 
	 * }
	 */
}
