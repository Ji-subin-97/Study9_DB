package com.subin.s1.department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.subin.s1.employee.EmployeeDTO;
import com.subin.s1.util.DBConnect;

public class DepartmentDAO {
	
	DBConnect dbConnect = new DBConnect();
	
	//getjoin
	public Depart_EmpDTO getJoin(DepartmentDTO departmentDTO) {	
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Depart_EmpDTO depart_EmpDTO = null;
		
		try {
			con = dbConnect.getConnect();
			
			String sql = "SELECT e.last_name, e.salary, e.hire_date, d.department_name "
					+ "FROM employees e inner join departments d "
					+ "USING (department_id) "
					+ "WHERE department_id = ?";
			
			st = con.prepareStatement(sql);
			st.setInt(1,departmentDTO.getDepartment_id());
			
			rs = st.executeQuery();
			
			depart_EmpDTO = new Depart_EmpDTO();
			depart_EmpDTO.setAr(new ArrayList<EmployeeDTO>());
			
			while(rs.next()) {
				EmployeeDTO eDto = new EmployeeDTO();
				eDto.setLast_name(rs.getString("last_name"));
				eDto.setSalary(rs.getInt("salary"));
				eDto.setHire_date(rs.getDate("hire_date"));
				depart_EmpDTO.getAr().add(eDto);
				depart_EmpDTO.setDepartment_name(rs.getString("department_name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return depart_EmpDTO;
	}
}
