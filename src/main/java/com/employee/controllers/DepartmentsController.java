package com.employee.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.Departments;
import com.employee.services.DepartmentService;

@RestController
public class DepartmentsController {
//	@Autowired
	DepartmentService departmentService;
	
    public DepartmentsController(DepartmentService departmentService) {
    	this.departmentService = departmentService;
    }	
	
	@GetMapping("/departments/list")
	private ResponseEntity<List<Departments>> getAllDepartments() {
		return new ResponseEntity<>(departmentService.getAllDepartments(), HttpStatus.OK);
	}
}
