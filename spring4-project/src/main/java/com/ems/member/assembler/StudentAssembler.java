package com.ems.member.assembler;

import com.ems.member.dao.StudentDao;
import com.ems.member.service.*;

public class StudentAssembler {

	private StudentDao studentDao;
	private com.ems.member.service.StudentRegisterService registerService;
	private com.ems.member.service.StudentModifyService modifyService;
	private StudentDeleteService deleteService;
	private com.ems.member.service.StudentSelectService selectService;
	private StudentAllSelectService allSelectService;

	public StudentAssembler() {
		studentDao = new StudentDao();
		registerService = new com.ems.member.service.StudentRegisterService(studentDao);
		modifyService = new com.ems.member.service.StudentModifyService(studentDao);
		deleteService = new StudentDeleteService(studentDao);
		selectService = new com.ems.member.service.StudentSelectService(studentDao);
		allSelectService = new StudentAllSelectService(studentDao);
	}

	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public com.ems.member.service.StudentRegisterService getRegisterService() {
		return registerService;
	}

	public void setRegisterService(com.ems.member.service.StudentRegisterService registerService) {
		this.registerService = registerService;
	}

	public com.ems.member.service.StudentModifyService getModifyService() {
		return modifyService;
	}

	public void setModifyService(com.ems.member.service.StudentModifyService modifyService) {
		this.modifyService = modifyService;
	}

	public StudentDeleteService getDeleteService() {
		return deleteService;
	}

	public void setDeleteService(StudentDeleteService deleteService) {
		this.deleteService = deleteService;
	}

	public com.ems.member.service.StudentSelectService getSelectService() {
		return selectService;
	}

	public void setSelectService(com.ems.member.service.StudentSelectService selectService) {
		this.selectService = selectService;
	}

	public StudentAllSelectService getAllSelectService() {
		return allSelectService;
	}

	public void setAllSelectService(StudentAllSelectService allSelectService) {
		this.allSelectService = allSelectService;
	}


}
