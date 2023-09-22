package com.ssafy.enjoytrip.model.service;

import java.util.List;

import com.ssafy.enjoytrip.model.AttractionInfoDto;

public interface AttractionService {

	List<AttractionInfoDto> attractionList(AttractionInfoDto attractionInfoDto);

	List<AttractionInfoDto> searchByTitle(String title, int sidoCode);
	
}
