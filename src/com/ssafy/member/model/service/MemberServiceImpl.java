package com.ssafy.member.model.service;

import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.dao.MemberDao;
import com.ssafy.member.model.dao.MemberDaoImpl;

public class MemberServiceImpl implements MemberService {

	// 싱글톤
	private  MemberServiceImpl() {}
	private static MemberServiceImpl instance = new MemberServiceImpl();
	public static MemberServiceImpl getInstance() {
		return instance;
	}
	
	MemberDao memberDao = MemberDaoImpl.getInstance();
	
	@Override
	public void registerMember(MemberDto memberDto) {
		memberDao.registerMember(memberDto);
		return;
	}

	@Override
	public MemberDto login(String userId, String userPass) {
		return memberDao.login(userId, userPass);
		
	}

	@Override
	public void modifyMember(MemberDto memberDto) {
		memberDao.modifyMember(memberDto);
	}

	@Override
	public int deleteMember() {
		return memberDao.deleteMember();
	}

}
