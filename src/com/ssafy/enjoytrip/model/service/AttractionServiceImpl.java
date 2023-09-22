package com.ssafy.enjoytrip.model.service;

import java.util.List;

import com.ssafy.enjoytrip.model.AttractionInfoDto;
import com.ssafy.enjoytrip.model.dao.AttractionDao;
import com.ssafy.enjoytrip.model.dao.AttractionDaoImpl;

public class AttractionServiceImpl implements AttractionService {
	
	private AttractionServiceImpl() {}
	private static AttractionServiceImpl instance = new AttractionServiceImpl();
	public static AttractionServiceImpl getInstance() {
		return instance;
	}
	
	// AttractionDao 객체 생성
	private static AttractionDao attractionDao = AttractionDaoImpl.getInstance();
	
	@Override
	public List<AttractionInfoDto> attractionList(AttractionInfoDto attractionInfoDto) {
		// TODO 관광지검색(전체)
		return attractionDao.attractionList(attractionInfoDto);
	}

	@Override
	public List<AttractionInfoDto> searchByTitle(String title, int sidoCode) {
		// TODO 관광지검색(관광지명)
		return attractionDao.searchByTitle(title, sidoCode);
	}

}
