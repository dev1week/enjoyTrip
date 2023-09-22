package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.enjoytrip.model.AttractionInfoDto;
import com.ssafy.enjoytrip.model.service.AttractionService;
import com.ssafy.enjoytrip.model.service.AttractionServiceImpl;

public class EnjoyTripMain {

	private static AttractionService attractionService = AttractionServiceImpl.getInstance(); 
	private BufferedReader in;

	public EnjoyTripMain() {
		in = new BufferedReader(new InputStreamReader(System.in));
		menu();
	}

	private void menu() {
		while (true) {
			System.out.println("---------- 관광지 정보 ----------");
			System.out.println("1. 관광지검색(전체)");
			System.out.println("2. 관광지검색(관광지명)");
			System.out.println("-------------------------------------");
			System.out.println("0. 프로그램 종료");
			System.out.println("-------------------------------------");
			System.out.print("메뉴 선택 : ");
			try {
				int num = Integer.parseInt(in.readLine());
				switch (num) {
				case 1:
					attractionList();
					break;
				case 2:
					attractionSearch();
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

	// 지역 && 관광지 타입이 해당되는 관광지 검색
	private void attractionList() throws NumberFormatException, IOException {

		System.out.println("********** 관광지 목록(전체) **********");
		AttractionInfoDto attractionInfoDto = new AttractionInfoDto();
		System.out.println("0:전국, 1:서울, 3:대전, 5:광주, 6:부산, 35:경상북도");
		System.out.print("관광지 지역 선택 : ");
		attractionInfoDto.setSidoCode(Integer.parseInt(in.readLine()));
		System.out.println("0:모든타입, 12:관광지, 14:문화시설, 15:축제공연행사, 25:여행코스, 28:레포츠, 32:숙박, 38:쇼핑, 39:음식점");
		System.out.print("관광지 타입 선택 : ");
		attractionInfoDto.setContentTypeId(Integer.parseInt(in.readLine()));
		
		// service에 attractionList 요청
		List<AttractionInfoDto> list = new ArrayList<AttractionInfoDto>();
		list = attractionService.attractionList(attractionInfoDto);
		for (AttractionInfoDto infoDto : list) {
			System.out.println(infoDto.toString());
		}
	}

	// 관광지 이름이 title이고 지역이 sideCode인 관광지 검색
	private void attractionSearch() throws IOException {
		System.out.println("********** 관광지 이름으로 검색 **********");
		System.out.print("검색 할 관광지 이름 : ");
		String title = in.readLine();
		System.out.println("0:전국, 1:서울, 3:대전, 5:광주, 6:부산, 35:경상북도");
		System.out.print("관광지 지역 선택 : ");
		int sidoCode = Integer.parseInt(in.readLine());
		
		// service에 searchByTitle 요청
		List<AttractionInfoDto> list = new ArrayList<AttractionInfoDto>();
		list = attractionService.searchByTitle(title, sidoCode);
		for (AttractionInfoDto infoDto : list) {
			System.out.println(infoDto.toString());
		}
	}

	public static void main(String[] args) {
		new EnjoyTripMain();
	}
}
