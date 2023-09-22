package com.ssafy.board.model.service;

import java.util.List;

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dao.BoardDaoImpl;

public class BoardServiceImpl implements BoardService {
	
//	TODO : BoardServiceImpl의 객체를 Singleton으로 새성하고 instance를 return하는 getBoardService()를 만드세요.
	private BoardServiceImpl() {};
	
	private static BoardServiceImpl instance = new BoardServiceImpl();

	public static BoardServiceImpl getBoardService() {
		return instance;
	}
//	END
	
	// BoardDao 객체 가져옴.
	BoardDao boardDao = BoardDaoImpl.getBoardDao();

	@Override
	public void registerArticle(BoardDto boardDto) {
		boardDao.registerArticle(boardDto);
		System.out.println("service register");
		return;
	}

	@Override
	public List<BoardDto> searchListAll() {
		return boardDao.searchListAll();
	}

	@Override
	public List<BoardDto> searchListBySubject(String subject) {
		return boardDao.searchListBySubject(subject);
	}

	@Override
	public BoardDto viewArticle(int no) {
		return boardDao.viewArticle(no);
	}

	@Override
	public void modifyArticle(BoardDto boardDto) {
		boardDao.modifyArticle(boardDto);
		return;
	}

	@Override
	public void deleteArticle(int no) {
		boardDao.deleteArticle(no);
		return;
	}

}
