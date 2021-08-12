package com.subin.s1.employee;

import com.subin.s1.department.DepartmentDTO;

public class Emp_DepartDTO extends EmployeeDTO{
	
	private DepartmentDTO departmentDTO;

	public DepartmentDTO getDepartmentDTO() {
		return departmentDTO;
	}

	public void setDepartmentDTO(DepartmentDTO departmentDTO) {
		this.departmentDTO = departmentDTO;
	}
	
}
