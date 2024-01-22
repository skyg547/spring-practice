package com.bms.member.service;

import com.bms.member.Member;
import com.bms.member.dao.MemberDao;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

public class MemberSearchService implements InitializingBean, DisposableBean {

	@Autowired
	private MemberDao memberDao;

	public MemberSearchService() { }

	public Member searchMember(String mId) {
		return memberDao.select(mId);
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Object  Create");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Object  dispose");
	}
}
