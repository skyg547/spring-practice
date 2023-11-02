package com.ems.member.service;

import com.ems.member.Student;
import com.ems.member.dao.StudentDao;

public class StudentRegisterService {

	private final StudentDao studentDao;

	public StudentRegisterService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public void register(Student student) {
		String sNum = student.getsNum();
		if (verify(student.getsNum())) {
			studentDao.insert(student);
		} else {
			System.out.println("The student has already registered.");
		}
	}

	public boolean verify(String sNum) {
		Student student = studentDao.select(sNum);
		return student == null;
	}
}
