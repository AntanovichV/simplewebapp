package com.mastery.java.task.service;

import com.mastery.java.task.dao.EmployeeDao;
import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.exceptons.NotFoundException;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeeDao;

    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeDao.findAllEmployees();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeDao.addEmployee(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeDao.deleteEmployee(id);
    }

    @Override
    public Employee updateEmployee(int id, Employee employee) {
        return employeeDao.findEmployeeById(id)
            .map(employeeToUpdate -> {
                employeeToUpdate.setFirstName(employee.getFirstName());
                employeeToUpdate.setLastName(employee.getLastName());
                employeeToUpdate.setDepartmentId(employee.getDepartmentId());
                employeeToUpdate.setJobTitle(employee.getJobTitle());
                employeeToUpdate.setGender(employee.getGender());
                employeeToUpdate.setDateOfBirth(employee.getDateOfBirth());
                return employeeDao.updateEmployee(employeeToUpdate);
            })
            .orElseThrow(()->new NotFoundException(id));
    }

    @Override
    public Employee findEmployeeById(int id) {
        return employeeDao.findEmployeeById(id).orElseThrow(() -> new NotFoundException(id));
    }
}