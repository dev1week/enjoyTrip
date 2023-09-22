package com.ssafy.board.model;

public class BoardDto {

	private int articleNo;
	private String subject;
	private String content;
	private String userId;
	private String registerTime;
	private int hit;
	
	public BoardDto() {
		
	};
	
	public BoardDto(int articleNo, String subject, String content, String userId, String registerTime) {
		super();
		this.articleNo = articleNo;
		this.subject = subject;
		this.content = content;
		this.userId = userId;
		this.registerTime = registerTime;
	}

	
	public BoardDto(int articleNo, String subject, String content, String userId, String registerTime, int hit) {
		super();
		this.articleNo = articleNo;
		this.subject = subject;
		this.content = content;
		this.userId = userId;
		this.registerTime = registerTime;
		this.hit = hit;
	}

	
	public int getArticleNo() {
		return articleNo;
	}

	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}

	
	
	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	@Override
	public String toString() {
		return "BoardDto [articleNo=" + articleNo + ", subject=" + subject + ", content=" + content + ", userId="
				+ userId + ", registerTime=" + registerTime + ", hit=" + hit + "]";
	}

}
