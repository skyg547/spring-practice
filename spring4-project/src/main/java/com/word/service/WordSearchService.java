package com.word.service;

import com.word.WordSet;
import com.word.dao.WordDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

public class WordSearchService {


	@Autowired //--> default 생성자 구현 필수
	@Qualifier("usedDao")
	private WordDao wordDao;

	public WordSearchService() {
	}

//	@Autowired
	public WordSearchService(WordDao wordDao) {
		this.wordDao = wordDao;
	}

	public WordSet searchWord(String wordKey) {
		if (verify(wordKey)) {
			return wordDao.select(wordKey);
		} else {
			System.out.println("WordKey information is available.");
		}

		return null;
	}

	public boolean verify(String wordKey) {
		WordSet wordSet = wordDao.select(wordKey);
		return wordSet != null;
	}

	//	@Autowired --> default 생성자 구현 필수
	public void setWordDao(WordDao wordDao) {
		this.wordDao = wordDao;
	}
}
