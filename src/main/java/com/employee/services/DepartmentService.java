package com.employee.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.model.Departments;
import com.employee.model.Employees;
import com.employee.repository.DepartmentRepository;
import com.employee.repository.EmployeesRepository;

@Service
public class DepartmentService {

	@Autowired
	DepartmentRepository departmentRepository;

	public List<Departments> getAllDepartments() {
		List<Departments> department = new ArrayList<Departments>();
		departmentRepository.findAll().forEach(department1 -> department.add(department1));
		return department;
	}

	public Departments getDepartmentId(int id) {
		return departmentRepository.findById(id).get();
	}

}
