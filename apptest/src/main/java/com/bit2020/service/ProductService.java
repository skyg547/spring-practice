package com.bit2020.service;

import org.springframework.stereotype.Service;

import com.bit2020.vo.ProductVo;

@Service
public class ProductService {

	
	public ProductVo find(String name) {
		
		
		System.out.println("[PorductServic ] findeing");
		
		return new ProductVo(name);

	}
}
