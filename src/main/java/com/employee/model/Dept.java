package com.employee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class Dept {
	@Id
	@Column
	private int DeptId;
	
	@Column
	private String Name;

	public int getDeptId() {
		return DeptId;
	}

	public void setDeptId(int deptId) {
		DeptId = deptId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	
}
