package com.subin.s1.location;

import java.util.Scanner;

public class LocationInput {

	
	public LocationDTO inputId(Scanner sc) {
		LocationDTO locationDTO = new LocationDTO();
		System.out.println("Location Id를 입력하세요.");
		int location_id = sc.nextInt();
		locationDTO.setLocation_id(location_id);
		return locationDTO;
	}
	
	public LocationDTO inputInfo(Scanner sc) {
		LocationDTO locationDTO = new LocationDTO();
		System.out.println("추가할 정보를 입력해주세요.");
		
		System.out.println("지역아이디를 입력하세요.");
		int location_id = sc.nextInt();
		locationDTO.setLocation_id(location_id);
		
		System.out.println("지역 주소를 입력하세요.");
		String street_address = sc.next();
		locationDTO.setStreet_address(street_address);
		
		System.out.println("주소 번호를 입력하세요.");
		String postal_code = sc.next();
		locationDTO.setPostal_code(postal_code);
		
		System.out.println("도시명을 입력하세요");
		String city = sc.next();
		locationDTO.setCity(city);
		
		System.out.println("주를 입력하세요");
		String state_province = sc.next();
		locationDTO.setState_province(state_province);
		
		System.out.println("나라 번호를 입력하세요");
		String country_id = sc.next();
		locationDTO.setCountry_id(country_id);
		
		return locationDTO;
	}
	
	public LocationDTO delInfo(Scanner sc) {
		LocationDTO locationDTO = new LocationDTO();
		System.out.println("삭제할 로우의 아이디를 입력해주세요.");
		int location_id = sc.nextInt();
		locationDTO.setLocation_id(location_id);
		
		return locationDTO;
	}
}
