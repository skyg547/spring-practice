package com.bms.member.dao;

import com.bms.member.Member;

import java.util.HashMap;
import java.util.Map;

public class MemberDao {
	private static final Map<String, Member> memberDB = new HashMap<>();

	public void insert(Member member) {
		memberDB.put(member.getmId(), member);
	}

	public Member select(String mId) {
		return memberDB.get(mId);
	}

	public void update(Member member) {

	}

	public void delete(String mId) {
	}

	public Map<String, Member> getMemberDB() {
		return memberDB;
	}
}
