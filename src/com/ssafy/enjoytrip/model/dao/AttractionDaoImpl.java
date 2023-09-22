package com.ssafy.enjoytrip.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.enjoytrip.model.AttractionInfoDto;
import com.ssafy.util.DBUtil;

public class AttractionDaoImpl implements AttractionDao {

	// 싱글톤
	private AttractionDaoImpl() {}
	private static AttractionDaoImpl instance = new AttractionDaoImpl();
	public static AttractionDaoImpl getInstance() {
		return instance;
	}
	
	// 1. 드라이버 로딩
	DBUtil dbutil = DBUtil.getInstance();
	
	@Override
	public List<AttractionInfoDto> attractionList(AttractionInfoDto attractionInfoDto) {
		List<AttractionInfoDto> list = new ArrayList<AttractionInfoDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// 2. db 연결
			conn = dbutil.getConnection();
			
			System.out.println(attractionInfoDto);
			// 3. sql 실행 준비
			int inputSidoCode = attractionInfoDto.getSidoCode();
			int inputContentTypeId = attractionInfoDto.getContentTypeId();
			System.out.println(inputSidoCode + " "  + inputContentTypeId);
			String sql = "";
			if(inputSidoCode == 0) {
				if(inputContentTypeId == 0) {
					sql = "select * from attraction_info order by sido_code";
					pstmt = conn.prepareStatement(sql);
				}else {
					sql = "select * from attraction_info where content_type_id = ? order by sido_code";
					
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, inputContentTypeId);
				}
			}else {
				if(inputContentTypeId == 0) {
					sql = "select * from attraction_info where sido_code = ? order by sido_code";
					
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, inputSidoCode);
				}else {
					System.out.println("들어가니?");
					sql = "select * from attraction_info where sido_code = ? and content_type_id = ? order by sido_code";
					
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, inputSidoCode);
					pstmt.setInt(2, inputContentTypeId);
				}
			}

			// 4. sql 실행
			rs = pstmt.executeQuery();
			while (rs.next()) {
				 int contentId = rs.getInt("content_id");
				 int contentTypeId = rs.getInt("content_type_id");
				 String title = rs.getString("title");
				 String addr1 = rs.getString("addr1");
				 String addr2 = rs.getString("addr2");
				 String zipcode = rs.getString("zipcode");
				 String tel = rs.getString("tel");
				 String firstImage = rs.getString("first_image");
				 String firstImage2 = rs.getString("first_image2");
				 int readcount = rs.getInt("readcount");
				 int sidoCode = rs.getInt("sido_code");
				 int gugunCode = rs.getInt("gugun_code");
				 double latitude = rs.getDouble("latitude");
				 double longitude = rs.getDouble("longitude");
				 String mlevel = rs.getString("mlevel");
				 
				 list.add(new AttractionInfoDto(contentId, contentTypeId, title, addr1, addr2, zipcode, tel, firstImage, firstImage2, readcount, sidoCode, gugunCode, latitude, longitude, mlevel));
			}
			
			System.out.println(list);
			if(list.size() > 0) {
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			// 5. 해제, 종료
			dbutil.close(rs,pstmt, conn);
		}
		return null;
	}

	
	@Override
	public List<AttractionInfoDto> searchByTitle(String stitle, int ssidoCode) {
		List<AttractionInfoDto> list = new ArrayList<AttractionInfoDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// 2. db 연결
			conn = dbutil.getConnection();
			
			if(ssidoCode == 0) {
				String sql = "select * from attraction_info where title like ? order by sido_code";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%"+stitle+"%");
			}else {
				String sql = "select * from attraction_info where title like ? and sido_code = ? order by sido_code";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%"+stitle+"%");
				pstmt.setInt(2, ssidoCode);
			}
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				 int contentId = rs.getInt("content_id");
				 int contentTypeId = rs.getInt("content_type_id");
				 String title = rs.getString("title");
				 String addr1 = rs.getString("addr1");
				 String addr2 = rs.getString("addr2");
				 String zipcode = rs.getString("zipcode");
				 String tel = rs.getString("tel");
				 String firstImage = rs.getString("first_image");
				 String firstImage2 = rs.getString("first_image2");
				 int readcount = rs.getInt("readcount");
				 int sidoCode = rs.getInt("sido_code");
				 int gugunCode = rs.getInt("gugun_code");
				 double latitude = rs.getDouble("latitude");
				 double longitude = rs.getDouble("longitude");
				 String mlevel = rs.getString("mlevel");
				 
				 list.add(new AttractionInfoDto(contentId, contentTypeId, title, addr1, addr2, zipcode, tel, firstImage, firstImage2, readcount, sidoCode, gugunCode, latitude, longitude, mlevel));
			}
			
			if(list.size() > 0) {
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbutil.close(rs,pstmt, conn);
		}
		return null;
	}

}
