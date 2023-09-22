package com.ssafy.member.model.service;

import com.ssafy.member.model.MemberDto;

public interface MemberService {

	void registerMember(MemberDto memberDto);

	MemberDto login(String userId, String userPass);

	void modifyMember(MemberDto memberDto);

	int deleteMember();

}
