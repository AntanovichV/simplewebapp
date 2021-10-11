package com.mastery.java.task.dao;

import com.mastery.java.task.dto.Employee;

public interface EmployeeDao {

    List<Employee> findAllEmployees();

    Employee addEmployee(Employee employee);

    void deleteEmployee(Long id);

    Employee updateEmployee(Long id, Employee employee);

    Employee findEmployeeById(Long id);
}
