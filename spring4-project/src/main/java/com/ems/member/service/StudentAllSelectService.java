package com.ems.member.service;

import com.ems.member.Student;
import com.ems.member.dao.StudentDao;

import java.util.Map;

public class StudentAllSelectService {

	private final StudentDao studentDao;

	public StudentAllSelectService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public Map<String, Student> allSelect() {
		return studentDao.getStudentDB();
	}

}