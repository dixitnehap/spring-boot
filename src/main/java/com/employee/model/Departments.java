package com.employee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class Departments {
	@Id
	@Column
	private int DepartmentId;
	
	@Column
	private String Name;

	public int getDepartmentId() {
		return DepartmentId;
	}

	public void setDepartmentId(int deptId) {
		DepartmentId = deptId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	
}
