package com.employee.controllers;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.Dept;
import com.employee.model.Employees;
import com.employee.services.DeptService;
import com.employee.services.EmployeeService;

@RestController
public class EmployeesController {

	private final AtomicInteger counter = new AtomicInteger();

	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	DeptService deptService;
	
	
	  @GetMapping("/") private String getDefault() { return "Hello"; }
	 

	/*
	 * @GetMapping("/") public String viewHomePage(Model model) { List<Employees>
	 * listEmployees= employeeService.getAllEmployees();
	 * model.addAttribute("listEmployees", listEmployees); return "index"; }
	 */
	
	@GetMapping("/list")
	private List<Employees> getAllEmployees() {
		return employeeService.getAllEmployees();
	}
	@GetMapping("/listDept")
	private List<Dept> getAllDept() {
		return deptService.getAllDept();
	}

	@PostMapping("/addEmp")
	private int saveEmployee(@RequestBody Employees employee) {
	
		//Employees employee =  new Employees(counter.incrementAndGet(), name);
	 employeeService.saveOrUpdate(employee);
	 return employee.getEmpId();
	}

	@GetMapping("/employee/{empid}")
	private Employees getEmployee(@PathVariable("empid") int empid) {

		return employeeService.getEmployeeById(empid);
	}

}
