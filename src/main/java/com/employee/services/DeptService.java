package com.employee.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.model.Dept;
import com.employee.model.Employees;
import com.employee.repository.DeptRepository;
import com.employee.repository.EmployeesRepository;

@Service
public class DeptService {

	@Autowired
	DeptRepository deptRepository;

	public List<Dept> getAllDept() {
		List<Dept> dept = new ArrayList<Dept>();
		deptRepository.findAll().forEach(dept1 -> dept.add(dept1));
		return dept;
	}

	public Dept getDeptById(int id) {
		return deptRepository.findById(id).get();
	}

}
