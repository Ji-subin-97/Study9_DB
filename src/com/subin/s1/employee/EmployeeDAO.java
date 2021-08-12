package com.subin.s1.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.subin.s1.department.DepartmentDTO;
import com.subin.s1.util.DBConnect;

public class EmployeeDAO {
	
	DBConnect dbConnect = new DBConnect();  // DB연결
	//////////////////////////////////////////
	
	public Emp_DepartDTO getJoin(EmployeeDTO employeeDTO) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Emp_DepartDTO departDTO = null;
		
		try {
			con = dbConnect.getConnect();
			
			String sql = "SELECT e.first_name, e.salary, e.hire_date, d.department_name "
					+ "FROM employees e inner join departments d "
					+ "ON e.department_id = d.department_id "
					+ "WHERE e.employee_id = ?";
			
			st = con.prepareStatement(sql);
			st.setInt(1, employeeDTO.getEmployee_id());
			
			rs = st.executeQuery();
			if(rs.next()) {
				departDTO = new Emp_DepartDTO();
				departDTO.setDepartmentDTO(new DepartmentDTO());
				
				departDTO.setFirst_name(rs.getString("first_name"));
				departDTO.setSalary(rs.getInt("salary"));
				departDTO.setHire_date(rs.getDate("hire_date"));
				departDTO.getDepartmentDTO().setDepartment_name(rs.getString("department_name"));
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
		return departDTO;
	}
	
	public ArrayList<EmployeeDTO> getlist() {
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<EmployeeDTO> ar = new ArrayList<>();
		
		try {
			con = dbConnect.getConnect();
			
			String sql = "SELECT * FROM employees";
			st = con.prepareStatement(sql);
			
			rs = st.executeQuery();
			
			while(rs.next()) {
				EmployeeDTO employeeDTO = new EmployeeDTO();
				employeeDTO.setEmployee_id(rs.getInt(1));
				employeeDTO.setFirst_name(rs.getString(2));
				employeeDTO.setLast_name(rs.getString(3));
				employeeDTO.setEmail(rs.getString(4));
				employeeDTO.setPhone_number(rs.getString(5));
				employeeDTO.setHire_date(rs.getDate(6));
				employeeDTO.setJob_id(rs.getString(7));
				employeeDTO.setSalary(rs.getDouble(8));
				employeeDTO.setCommission_pct(rs.getDouble(9));
				employeeDTO.setManager_id(rs.getInt(10));
				employeeDTO.setDepartment_id(rs.getInt(11));
				ar.add(employeeDTO);
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
	
	/////
	public EmployeeDTO getOne(int em_num) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		EmployeeDTO employeeDTO = null;

		try {
			con = dbConnect.getConnect();
			
			String sql = "SELECT * FROM employees WHERE EMPLOYEE_ID = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, em_num);
			
			rs = st.executeQuery();
			
			if(rs.next()) {
				employeeDTO = new EmployeeDTO();
				employeeDTO.setEmployee_id(rs.getInt(1));
				employeeDTO.setFirst_name(rs.getString(2));
				employeeDTO.setLast_name(rs.getString(3));
				employeeDTO.setEmail(rs.getString(4));
				employeeDTO.setPhone_number(rs.getString(5));
				employeeDTO.setHire_date(rs.getDate(6));
				employeeDTO.setJob_id(rs.getString(7));
				employeeDTO.setSalary(rs.getDouble(8));
				employeeDTO.setCommission_pct(rs.getDouble(9));
				employeeDTO.setManager_id(rs.getInt(10));
				employeeDTO.setDepartment_id(rs.getInt(11));
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
		return employeeDTO;
	}
}
