package com.ssafy.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.ssafy.member.model.MemberDto;
import com.ssafy.util.DBUtil;

public class MemberDaoImpl implements MemberDao {
	
	// 싱글톤
	private MemberDaoImpl() {}
	private static MemberDaoImpl instance = new MemberDaoImpl();
	public static MemberDaoImpl getInstance() {
		return instance;
	}

	DBUtil dbutil = DBUtil.getInstance();
	
	static String user ="";
	
	@Override
	public void registerMember(MemberDto memberDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dbutil.getConnection();
			
			String sql = "insert into members(user_id, user_name, user_pass, joinDate)  values (?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDto.getUserId());
			pstmt.setString(2, memberDto.getUserName());
			pstmt.setString(3, memberDto.getUserPass());
	        // 현재 날짜 구하기
	        LocalDate now = LocalDate.now();
	        // 포맷 정의
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        // 포맷 적용
	        String formatedNow = now.format(formatter);
			pstmt.setString(4, formatedNow);
			
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbutil.close(pstmt, conn);
		}
	}

	@Override
	public MemberDto login(String userId, String userPass) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			MemberDto memberDto = new MemberDto();
			conn = dbutil.getConnection();
			String sql = "select * from members where user_id = ? and user_pass = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPass);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				memberDto.setUserId(userId);
				memberDto.setUserName(rs.getString("user_name"));
				memberDto.setUserPass(userPass);
			}
			
			user = userId;
			return memberDto;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbutil.close(rs, pstmt, conn);
		}
		
		return null;
	}

	@Override
	public void modifyMember(MemberDto memberDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dbutil.getConnection();
			String sql = "update members set user_name = ?, user_pass = ? where user_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDto.getUserName());
			pstmt.setString(2, memberDto.getUserPass());
			pstmt.setString(3, memberDto.getUserId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbutil.close(pstmt, conn);
		}	
		
	}

	@Override
	public int deleteMember() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dbutil.getConnection();
			String sql = "delete from members where user_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user);
			if(pstmt.executeUpdate()>0) {
				return 1;
			}else {
				return 0;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			dbutil.close(pstmt, conn);
		}
		
		return 0;

	}

}
