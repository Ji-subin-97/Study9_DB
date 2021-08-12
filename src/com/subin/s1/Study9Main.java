package com.subin.s1;

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
		
	LocationController controller = new LocationController();
	controller.start();
	
	}

}
