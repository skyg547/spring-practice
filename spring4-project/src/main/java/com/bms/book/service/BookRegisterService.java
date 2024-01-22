package com.bms.book.service;

import com.bms.book.Book;
import com.bms.book.dao.BookDao;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

public class BookRegisterService implements InitializingBean, DisposableBean {

	@Autowired
	private BookDao bookDao;

	public BookRegisterService() {
	}


	public void register(Book book) {
		bookDao.insert(book);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("bean 객체 생성");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("bean 객체 소멸");
	}

}
