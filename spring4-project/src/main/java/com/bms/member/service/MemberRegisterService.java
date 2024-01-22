package com.bms.member.service;

import com.bms.member.Member;
import com.bms.member.dao.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;

public class MemberRegisterService {
	@Autowired
	private MemberDao memberDao;

	public MemberRegisterService() {
	}

	public void register(Member member) {
		memberDao.insert(member);
	}

	private void initMethod() {
		System.out.println("-- init method --");
	}

	private void destroyMethod() {
		System.out.println("-- destory memthod --");
	}
}
