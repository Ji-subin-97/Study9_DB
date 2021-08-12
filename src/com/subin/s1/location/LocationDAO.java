package com.subin.s1.location;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.subin.s1.util.DBConnect;

public class LocationDAO {
	
	DBConnect dbConnect = new DBConnect();
	
	
	//getcount
	//location의 주소 갯수를 리턴하고 출력
	public int getCount() {
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			con = dbConnect.getConnect();
			
			String sql = "SELECT COUNT(STREET_ADDRESS) AS COUNT FROM locations";
			
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			
			rs.next();
			System.out.println(rs.getInt("COUNT"));
			count = rs.getInt("COUNT");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
	
	//getSearch
	public ArrayList<LocationDTO> getSearch(String address) {
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<LocationDTO> ar = new ArrayList<>();
		
		try {
			con = dbConnect.getConnect();
			
			String sql = "SELECT * FROM locations WHERE STREET_ADDRESS LIKE '%'||?||'%'";
			
			st = con.prepareStatement(sql);
			st.setString(1, address);
			
			rs = st.executeQuery();
			
			while(rs.next()) {
				LocationDTO locationDTO = new LocationDTO();
				locationDTO.setLocation_id(rs.getInt("LOCATION_ID"));
				locationDTO.setStreet_address(rs.getString("STREET_ADDRESS"));
				locationDTO.setPostal_code(rs.getString("POSTAL_CODE"));
				locationDTO.setCity(rs.getString("CITY"));
				locationDTO.setState_province(rs.getString("STATE_PROVINCE"));
				locationDTO.setCountry_id(rs.getString("COUNTRY_ID"));
				ar.add(locationDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ar;
	}
	
	//Location Table에서 id와 일치하는 정보를 조회
	public LocationDTO getOne(LocationDTO locationDTO) {
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			con = dbConnect.getConnect();
			
			String sql = "SELECT * FROM locations WHERE LOCATION_ID = ?";
			
			st = con.prepareStatement(sql);
			st.setInt(1, locationDTO.getLocation_id());
			
			rs = st.executeQuery();
			
			if(rs.next()) {
				locationDTO = new LocationDTO();
				locationDTO.setLocation_id(rs.getInt("LOCATION_ID"));
				locationDTO.setStreet_address(rs.getString("STREET_ADDRESS"));
				locationDTO.setPostal_code(rs.getString("POSTAL_CODE"));
				locationDTO.setCity(rs.getString("CITY"));
				locationDTO.setState_province(rs.getString("STATE_PROVINCE"));
				locationDTO.setCountry_id(rs.getString("COUNTRY_ID"));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return locationDTO;
	}
	
	// location 전체 정보
	public ArrayList<LocationDTO> getList() {
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<LocationDTO> ar = new ArrayList<>();
		
		try {
			con = dbConnect.getConnect();
			System.out.println("접속 성공");
			
			String sql = "SELECT * FROM locations";
			
			st = con.prepareStatement(sql);
			
			rs = st.executeQuery();
			
			while(rs.next()) {
				LocationDTO locationDTO = new LocationDTO();
				locationDTO.setLocation_id(rs.getInt("LOCATION_ID"));
				locationDTO.setStreet_address(rs.getString("STREET_ADDRESS"));
				locationDTO.setPostal_code(rs.getString("POSTAL_CODE"));
				locationDTO.setCity(rs.getString("CITY"));
				locationDTO.setState_province(rs.getString("STATE_PROVINCE"));
				locationDTO.setCountry_id(rs.getString("COUNTRY_ID"));
				ar.add(locationDTO);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return ar;
		
	}
}
