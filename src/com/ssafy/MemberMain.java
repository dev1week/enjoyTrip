package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.service.MemberService;
import com.ssafy.member.model.service.MemberServiceImpl;

public class MemberMain {
	
	MemberService memberService = MemberServiceImpl.getInstance();
	
	private BufferedReader in;

	static boolean checkLogin = false;
	
	public MemberMain() {
		in = new BufferedReader(new InputStreamReader(System.in));
		menu();
	}

	private void menu() {
		while (true) {
			System.out.println("---------- 회원 메뉴 ----------");
			System.out.println("1. 회원가입");
			if(!checkLogin) {
				System.out.println("2. 로그인");
			}
			if(checkLogin) {
				System.out.println("2. 로그아웃");
				System.out.println("3. 회원정보수정");
				System.out.println("4. 회원탈퇴");
			}
			System.out.println("-------------------------------------");
			System.out.println("0. 프로그램 종료");
			System.out.println("-------------------------------------");
			System.out.print("메뉴 선택 : ");
			try {
				int num = Integer.parseInt(in.readLine());
				switch (num) {
				case 1:
					registerMember();
					break;
				case 2:
					if(!checkLogin) {
						login();
					}else {
						checkLogin = false;
					}
					break;
				case 3:
					modifyMember();
					break;
				case 4:
					deleteMember();
					break;
				default:
					System.out.println("프로그램을 종료합니다!!!");
					System.exit(0);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


 /**
  * private String userId;
	private String userName;
	private String userPass;
	private String joinDate;

  * @throws IOException
  */
	private void registerMember() throws IOException {
		System.out.println("---------회원가입----------");
		System.out.print("아이디 : ");
		String userId = in.readLine();
		System.out.print("이름 : ");
		String userName = in.readLine();
		System.out.print("비밀번호 : ");
		String userPass = in.readLine();
		
		MemberDto memberDto = new MemberDto(userId, userName, userPass);
		memberService.registerMember(memberDto);
	}

	private void login() throws IOException {
		System.out.println("---------로그인----------");
		System.out.print("아이디를 입력해주세요 : ");
		String userId = in.readLine();
		System.out.print("비밀번호를 입력해주세요 : ");
		String userPass = in.readLine();
		
		MemberDto memberDto =  memberService.login(userId, userPass);
		if(!memberDto.getUserId().equals("")) {
			checkLogin = true;
		}
		
	}

	private void modifyMember() throws IOException {
		System.out.println("---------회원 정보 수정----------");
		System.out.print("아이디를 입력해주세요 : ");
		String userId = in.readLine();
		System.out.print("변경할 비밀번호를 입력해주세요 : ");
		String userPass = in.readLine();
		System.out.print("변경할 이름을 입력해주세요 : ");
		String userName = in.readLine();
		
		MemberDto memberDto = new MemberDto(userId, userName, userPass);
		memberService.modifyMember(memberDto);
	}

	private void deleteMember() throws IOException {
		if(memberService.deleteMember()==1) {
			checkLogin = false;
		}else {
			checkLogin = true;
		}
		
	}

	public static void main(String[] args) {
		new MemberMain();
	}
}
