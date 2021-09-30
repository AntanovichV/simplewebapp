package com.mastery.java.task.service;

import com.mastery.java.task.dao.EmployeeDao;
import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.exceptons.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    @Override
    public List<Employee> findAllEmployees() {
        return employeeDao.findAll();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeDao.save(employee);
    }

    static final String MESSAGE = "Employee with id \"%s\" not found.";

    @Override
    public void deleteEmployee(Long id) {
        Employee employee = employeeDao.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format(MESSAGE, id)));
        employeeDao.delete(employee);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        Employee existingEmployee = employeeDao.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format(MESSAGE, id)));
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setDepartmentId(employee.getDepartmentId());
        existingEmployee.setJobTitle(employee.getJobTitle());
        existingEmployee.setGender(employee.getGender());
        existingEmployee.setDateOfBirth(employee.getDateOfBirth());
        return employeeDao.save(existingEmployee);
    }

    @Override
    public Employee findEmployeeById(Long id) {
        return employeeDao.findById(id).orElseThrow(() -> new NotFoundException(String.format(MESSAGE, id)));
    }
}