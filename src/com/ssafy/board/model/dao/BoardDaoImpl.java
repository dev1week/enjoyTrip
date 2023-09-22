package com.ssafy.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.board.model.BoardDto;
import com.ssafy.util.DBUtil;

public class BoardDaoImpl implements BoardDao {
	
//	싱글톤 start
	private static BoardDao boardDao = new BoardDaoImpl();
	
	private BoardDaoImpl() {}

	public static BoardDao getBoardDao() {
		return boardDao;
	}
// 싱글톤 end
 
	DBUtil dbutil = DBUtil.getInstance();
	
	@Override
	public void registerArticle(BoardDto boardDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
//		TODO : boardDto의 내용을 board table에 insert 하세요!!!
		
		try {
			// 2. DB 연결
			conn = dbutil.getConnection();
			
			// 3. SQL 실행준비
			// 3-1. SQL문 작성
			String sql = "insert into board (user_id, subject, content) values (?,?,?)";
			// 3-2. Statement 객체 생성
			pstmt = conn.prepareStatement(sql);
			// 3-3. 위치 홀더가 있을 경우 값 세팅
			pstmt.setString(1, boardDto.getUserId());
			pstmt.setString(2, boardDto.getSubject());
			pstmt.setString(3, boardDto.getContent());
			
			// 4. SQL 실행
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbutil.close(pstmt, conn);
		}
//		END
	}

	@Override
	public List<BoardDto> searchListAll() {
		List<BoardDto> list = new ArrayList<BoardDto>();
//		TODO : board table의 모든 글정보를 글번호순으로 정렬하여 list에 담고 return 하세요!!!
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dbutil.getConnection();
			
			String sql = "select * from board order by article_no";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int articleNo = rs.getInt("article_no");
				String subject = rs.getString("subject"); 
				String content = rs.getString("content");
				String userId = rs.getString("user_id");
				String registerTime = rs.getString("register_time");
				int hit = rs.getInt("hit");
				
				list.add(new BoardDto(articleNo, subject, content, userId, registerTime,hit));
			}
			
			if(list.size() > 0) {
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbutil.close(rs, pstmt, conn);
		}
		
		
//		END
		return null;
	}

	@Override
	public List<BoardDto> searchListBySubject(String rsubject) {
		List<BoardDto> list = new ArrayList<BoardDto>();
//		TODO : board table에서 제목에 subject를 포함하고 있는 글정보를 list에 담고 return 하세요!!!
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dbutil.getConnection();
			
			String sql = "select * from board where subject like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+rsubject+"%");
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int articleNo = rs.getInt("article_no");
				String subject = rs.getString("subject"); 
				String content = rs.getString("content");
				String userId = rs.getString("user_id");
				String registerTime = rs.getString("register_time");
				int hit = rs.getInt("hit");
				list.add(new BoardDto(articleNo, subject, content, userId, registerTime,hit));
			}
			if(list.size() > 0) {
				return list;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbutil.close(rs,pstmt, conn);
		}
	
		
//		END
		return null;
	}

	@Override
	public BoardDto viewArticle(int no) {
		BoardDto boardDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dbutil.getConnection();
			
			String sql = "select * from board where article_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int articleNo = rs.getInt("article_no");
				String rsubject = rs.getString("subject"); 
				String content = rs.getString("content");
				String userId = rs.getString("user_id");
				String registerTime = rs.getString("register_time");
				int hit = rs.getInt("hit");

				boardDto = new BoardDto(articleNo, rsubject, content, userId, registerTime, hit+1);
			}
	
			modifyArticle(boardDto);
			
			if(boardDto != null) {
				return boardDto;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbutil.close(rs, pstmt, conn);
		}
		
//		END
		return null;
	}

	@Override
	public void modifyArticle(BoardDto boardDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
//		TODO : boardDto의 내용을 이용하여 글번호에 해당하는 글제목과 내용을 수정하세요!!!
		
		try {
			conn = dbutil.getConnection();
			
			String sql = "Update board set subject = ?, content = ?, hit = ? where article_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardDto.getSubject());
			pstmt.setString(2, boardDto.getContent());
			pstmt.setInt(3, boardDto.getHit());
			pstmt.setInt(4, boardDto.getArticleNo());
			
			
			pstmt.executeUpdate();
			return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbutil.close(pstmt, conn);
		}
		
		
		return; 
//		END
	}

	@Override
	public void deleteArticle(int no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
//		TODO : board table에서 글번호가 no인 글 정보를 삭제하세요!!!
		try {
			conn = dbutil.getConnection();
			
			String sql = "delete from board where article_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			pstmt.executeUpdate();
			return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbutil.close(pstmt, conn);
		}
		
		return;
//		END
	}

}
