package com.subin.s1.location;

public class LocationController {
	
	private LocationDAO locationDAO;
	private LocationView locationView;
	
	public LocationController() {
		locationDAO = new LocationDAO();
		locationView = new LocationView();
	}
	
	
	public void start() {
		
		//DB 에서 Location Table의 모든 정보 조회
		//locationDAO.getList();
		locationView.oneView();
		
	}
}
