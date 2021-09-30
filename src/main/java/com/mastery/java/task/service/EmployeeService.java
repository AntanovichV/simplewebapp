package com.mastery.java.task.service;

import com.mastery.java.task.dto.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAllEmployees();

    Employee addEmployee(Employee employee);

    void deleteEmployee(Long id);

    Employee updateEmployee(Long id, Employee employee);

    Employee findEmployeeById(Long id);
}
