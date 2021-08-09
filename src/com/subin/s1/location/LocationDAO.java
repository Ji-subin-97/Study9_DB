package com.subin.s1.location;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.subin.s1.util.DBConnect;

public class LocationDAO {
	
	DBConnect dbConnect = new DBConnect();
	
	//Location Table에서 id와 일치하는 정보를 조회
	public ResultSet getOne(int location_id) {
		
		//ADD-DTO Branch
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			con = dbConnect.getConnect();
			
			String sql = "SELECT * FROM locations WHERE LOCATION_ID = ?";
			
			st = con.prepareStatement(sql);
			st.setString(1, "1000");
			
			rs = st.executeQuery();
			if(rs.next()) {
				System.out.println(rs.getString("LOCATION_ID"));
				System.out.println(rs.getString("STREET_ADDRESS"));
				System.out.println(rs.getString("POSTAL_CODE"));
				System.out.println(rs.getString("CITY"));
				System.out.println(rs.getString("STATE_PROVINCE"));
				System.out.println(rs.getString("COUNTRY_ID"));
			}
			
			return rs;
			
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
		return rs;
	}
	
	// location 전체 정보
	public void getList() {
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			dbConnect.getConnect();
			System.out.println("접속 성공");
			
			String sql = "SELECT * FROM locations";
			
			st = con.prepareStatement(sql);
			
			rs = st.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getString("LOCATION_ID"));
				System.out.println(rs.getString("STREET_ADDRESS"));
				System.out.println(rs.getString("POSTAL_CODE"));
				System.out.println(rs.getString("CITY"));
				System.out.println(rs.getString("STATE_PROVINCE"));
				System.out.println(rs.getString("COUNTRY_ID"));
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
		
		
	}
}
