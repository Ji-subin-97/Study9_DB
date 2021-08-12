package com.subin.s1.location;

import java.util.ArrayList;
import java.util.Scanner;

public class LocationController {
	
	private LocationDAO locationDAO;
	private LocationDTO locationDTO;
	private LocationView locationView;
	private LocationInput locationInput;
	private Scanner sc;
	
	public LocationController() {
		locationDAO = new LocationDAO();
		locationDTO = new LocationDTO();
		locationView = new LocationView();
		locationInput = new LocationInput();
		sc = new Scanner(System.in);
	}
	
	
	public void start() {
		
		//DB 에서 Location Table의 모든 정보 조회
//		ArrayList<LocationDTO> ar = locationDAO.getList();
//		locationView.view(ar);
		
//		locationDTO = locationDAO.getOne(1000);
//		locationView.oneView(locationDTO);
		
//		ArrayList<LocationDTO> ar = locationDAO.getSearch("-");
//		locationView.view(ar);
		
		boolean flag = true;
		
		while(flag) {
			System.out.println("원하는 작업 입력");
			System.out.println("1. 전체 정보 출력");
			System.out.println("2. 한개 정보 출력");
			System.out.println("3. 나 가 기");
			int select = sc.nextInt();
			
			switch (select) {
			case 1:
				ArrayList<LocationDTO> ar = locationDAO.getList();
				if(ar.size()>0) {
					locationView.view(ar);
				}else {
					locationView.view("데이터가 없어요");
				}
				break;
			case 2:
				LocationDTO locationDTO = locationInput.inputId(sc);
				
				locationDTO = locationDAO.getOne(locationDTO);
				if(locationDTO != null) {
					locationView.view(locationDTO);
				}else {
					locationView.view("없는 ID 입니다.");
				}
				break;
			default :
				flag = false;
				break;
			}
		}
		
		
		
	}
}
