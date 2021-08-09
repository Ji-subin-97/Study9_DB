package com.subin.s1;

import com.subin.s1.location.LocationController;

public class Study9Main {

	public static void main(String[] args) {
		
//	LocationDAO locationDAO = new LocationDAO();
//	locationDAO.getList();
	
	LocationController locationController = new LocationController();
	locationController.start();
		

	}

}
