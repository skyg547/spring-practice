package com.bit2020.aoptest.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bit2020.service.ProductService;
import com.bit2020.vo.ProductVo;

public class MainApp {

	public static void main(String[] args) {

		ApplicationContext ac = new ClassPathXmlApplicationContext("config/applicationContext.xml");
		
		
		ProductService ps =  ac.getBean(ProductService.class);
		
		ProductVo vo = ps.find("TV");
		
		System.out.println(vo);
		
		((ClassPathXmlApplicationContext)ac).close();
		
	}

}
