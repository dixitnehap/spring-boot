package com.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.employee.model.Departments;
import com.employee.model.Employees;

public interface DepartmentRepository extends JpaRepository<Departments, Integer>
{
}
