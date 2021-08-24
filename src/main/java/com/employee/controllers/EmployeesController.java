package com.employee.controllers;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.Departments;
import com.employee.model.Employees;
import com.employee.services.DepartmentService;
import com.employee.services.EmployeeService;

@RestController
public class EmployeesController {

	private final AtomicInteger counter = new AtomicInteger();

//	@Autowired
	EmployeeService employeeService;
	
//	@Autowired
//	DepartmentService deptService;
//	
	
	@GetMapping("/hello") private String getDefault() { return "Hello"; }
	 
	public EmployeesController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	/*
	 * @GetMapping("/") public String viewHomePage(Model model) { List<Employees>
	 * listEmployees= employeeService.getAllEmployees();
	 * model.addAttribute("listEmployees", listEmployees); return "index"; }
	 */
	
	@GetMapping("/employees/list")
	private ResponseEntity<List<Employees>> getAllEmployees() {
		return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
	}
	
	@PostMapping("/employees/add")
	@Transactional
	private ResponseEntity<Employees> saveEmployee(@RequestBody Employees employee) {
	 //Employees employee =  new Employees(counter.incrementAndGet(), name);
	 employeeService.saveOrUpdate(employee);
		return new ResponseEntity<Employees>(employee, HttpStatus.CREATED);
	}

	@GetMapping("/employees/{empid}")
	private ResponseEntity<Employees> getEmployee(@PathVariable("empid") int empid) {
		return new ResponseEntity<Employees>(employeeService.getEmployeeById(empid), HttpStatus.OK);
	}

}
