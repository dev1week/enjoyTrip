package com.ssafy.member.model.dao;

import com.ssafy.member.model.MemberDto;

public interface MemberDao {

	void registerMember(MemberDto memberDto);

	MemberDto login(String userId, String userPass);

	void modifyMember(MemberDto memberDto);

	int deleteMember();
	
}
