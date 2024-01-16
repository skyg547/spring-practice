package com.bms.book.service;

import com.bms.book.Book;
import com.bms.book.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;

public class BookSearchService {
	@Autowired
	private BookDao bookDao;

	public BookSearchService() {
	}

	public Book searchBook(String bNum) {
		Book book = bookDao.select(bNum);
		return book;
	}
}
