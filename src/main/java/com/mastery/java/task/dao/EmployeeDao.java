package com.mastery.java.task.dao;

import com.mastery.java.task.dto.Employee;
import java.util.List;
import java.util.Optional;

public interface EmployeeDao {

    List<Employee> findAllEmployees();

    Employee addEmployee(Employee employee);

    void deleteEmployee(int id);

    Employee updateEmployee(Employee employee);

    Optional<Employee> findEmployeeById(int id);
}
