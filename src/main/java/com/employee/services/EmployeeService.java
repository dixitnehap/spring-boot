package com.employee.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.model.Employees;
import com.employee.repository.EmployeesRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeesRepository employeeRepository;

	public List<Employees> getAllEmployees() {
		List<Employees> employees = new ArrayList<Employees>();
		employeeRepository.findAll().forEach(employees1 -> employees.add(employees1));
		return employees;
	}

	public Employees getEmployeeById(int id) {
		return employeeRepository.findById(id).get();
	}

	// saving a specific record by using the method save() of CrudRepository
	public Employees saveOrUpdate(Employees employee) {
		return employeeRepository.save(employee);
	}

}
