package com.ems.member.service;

import com.ems.member.Student;
import com.ems.member.dao.StudentDao;

public class StudentSelectService {

	private final StudentDao studentDao;

	public StudentSelectService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public Student select(String sNum) {
		if (verify(sNum)) {
			return studentDao.select(sNum);
		} else {
			System.out.println("Student information is not available.");
		}

		return null;
	}

	public boolean verify(String sNum) {
		Student student = studentDao.select(sNum);
		return student != null;
	}
}
