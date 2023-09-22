package com.ssafy.member.model;

public class MemberDto {

	private String userId;
	private String userName;
	private String userPass;
	private String joinDate;


	public MemberDto() {
		super();
	}

	
	
	public MemberDto(String userId, String userPass) {
		super();
		this.userId = userId;
		this.userPass = userPass;
	}

	public MemberDto(String userId, String userName, String userPass) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPass = userPass;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}



	@Override
	public String toString() {
		return "MemberDto [userId=" + userId + ", userName=" + userName + ", userPass=" + userPass + ", joinDate="
				+ joinDate + "]";
	}
	
	

}
