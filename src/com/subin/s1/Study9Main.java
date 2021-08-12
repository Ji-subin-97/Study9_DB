package com.subin.s1;

import com.subin.s1.department.Depart_EmpDTO;
import com.subin.s1.department.DepartmentDAO;
import com.subin.s1.department.DepartmentDTO;
import com.subin.s1.employee.Emp_DepartDTO;
import com.subin.s1.employee.EmployeeDAO;
import com.subin.s1.employee.EmployeeDTO;
import com.subin.s1.location.LocationController;

public class Study9Main {

	public static void main(String[] args) {
		
//	LocationDAO locationDAO = new LocationDAO();
//	locationDAO.getList();
	
//	EmployeeDAO dao = new EmployeeDAO();
//	EmployeeDTO employeeDTO = new EmployeeDTO();
//	employeeDTO.setEmployee_id(101);
//	Emp_DepartDTO dto = dao.getJoin(employeeDTO);
//	
//	System.out.println(dto.getFirst_name());
//	System.out.println(dto.getSalary());
//	System.out.println(dto.getHire_date());
//	System.out.println(dto.getDepartmentDTO().getDepartment_name());
		
//		DepartmentDAO dao = new DepartmentDAO();
//		DepartmentDTO dto = new DepartmentDTO();
//		dto.setDepartment_id(90);
//		
//		Depart_EmpDTO depart_EmpDTO = dao.getJoin(dto);
//		System.out.println(depart_EmpDTO.getDepartment_name());
//		for(int i=0;i<depart_EmpDTO.getAr().size();i++) {
//			System.out.println(depart_EmpDTO.getAr().get(i).getLast_name());
//			System.out.println(depart_EmpDTO.getAr().get(i).getSalary());
//			System.out.println(depart_EmpDTO.getAr().get(i).getHire_date());
//		}
		
		DepartmentDAO dao = new DepartmentDAO();
		DepartmentDTO departmentDTO = new DepartmentDTO();
		departmentDTO.setDepartment_id(290);
		departmentDTO.setDepartment_name("Test2");
		departmentDTO.setManager_id(205);
		departmentDTO.setLocation_id(1700);
		
		int result = dao.setInsert(departmentDTO);
		if(result>0) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
	
	}

}
