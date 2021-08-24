package com.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.employee.model.Dept;
import com.employee.model.Employees;

public interface DeptRepository extends JpaRepository<Dept, Integer>
{
}
