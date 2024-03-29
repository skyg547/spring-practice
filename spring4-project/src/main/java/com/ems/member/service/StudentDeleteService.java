package com.ems.member.service;

import com.ems.member.Student;
import com.ems.member.dao.StudentDao;

public class StudentDeleteService {

	private final StudentDao studentDao;

	public StudentDeleteService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public void delete(Student student) {
		if (verify(student.getsNum())) {
			studentDao.delete(student.getsNum());
		} else {
			System.out.println("Student information is not available.");
		}
	}

	public boolean verify(String sNum) {
		Student student = studentDao.select(sNum);
		return student != null;
	}
}
