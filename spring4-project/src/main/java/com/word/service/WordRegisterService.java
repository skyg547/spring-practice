package com.word.service;

import com.word.WordSet;
import com.word.dao.WordDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

public class WordRegisterService {

	@Resource
	private WordDao wordDao;

	public WordRegisterService() {
	}

	//	@Autowired
	public WordRegisterService(WordDao wordDao) {
		this.wordDao = wordDao;
	}

	public void register(WordSet wordSet) {
		String wordKey = wordSet.getWordKey();
		if (verify(wordKey)) {
			wordDao.insert(wordSet);
		} else {
			System.out.println("The word has already registered");
		}
	}

	boolean verify(String wordKey) {
		WordSet wordSet = wordDao.select(wordKey);
		return wordSet == null;
	}

	public void setWordDao(WordDao wordDao) {
		this.wordDao = wordDao;
	}
}
