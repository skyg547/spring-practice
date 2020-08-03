package com.bit2020.guestbook03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit2020.guestbook03.repository.GuestBookRepository;
import com.bit2020.guestbook03.vo.GuestBookVo;

public class GuestBookContoroller {

	@Autowired
	private GuestBookRepository guestbookRepository;

	@RequestMapping("")
	public String index(Model model) {
		List<GuestBookVo> list = guestbookRepository.findAll();
		model.addAttribute("list", list);
		return "/WEB-INF/views/index.jsp";
	}

	@RequestMapping("/form")
	public String form() {
		return "/WEB-INF/views/form.jsp";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(GuestBookVo vo) {
		guestbookRepository.insert(vo);
		return "redirect:/";
	}
}
