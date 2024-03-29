package com.bms.book.dao;

import com.bms.book.Book;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.util.HashMap;
import java.util.Map;

public class BookDao  {

	private Map<String, Book> bookDB = new HashMap<String, Book>();

	public void insert(Book book) {
		bookDB.put(book.getbNum(), book);
	}

	public Book select(String bNum) {
		return bookDB.get(bNum);
	}

	public void update(Book book) {

	}

	public void delete() {

	}

	public Map<String, Book> getBookDB() {
		return bookDB;
	}

}
