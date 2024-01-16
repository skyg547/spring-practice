package com.bms.book.service;

import com.bms.book.Book;
import com.bms.book.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;

public class BookRegisterService {

	@Autowired
	private BookDao bookDao;

	public BookRegisterService() {
	}


	public void register(Book book) {
		bookDao.insert(book);
	}








}
