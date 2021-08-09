package com.subin.s1.location;

import java.util.ArrayList;

public class LocationController {
	
	private LocationDAO locationDAO;
	private LocationDTO locationDTO;
	private LocationView locationView;
	
	public LocationController() {
		locationDAO = new LocationDAO();
		locationDTO = new LocationDTO();
		locationView = new LocationView();
	}
	
	
	public void start() {
		
		//DB 에서 Location Table의 모든 정보 조회
//		ArrayList<LocationDTO> ar = locationDAO.getList();
//		locationView.view(ar);
		
//		locationDTO = locationDAO.getOne(1000);
//		locationView.oneView(locationDTO);
		
//		ArrayList<LocationDTO> ar = locationDAO.getSearch("-");
//		locationView.view(ar);
		
		int count = locationDAO.getCount();
		locationView.view(count);
		
	}
}
