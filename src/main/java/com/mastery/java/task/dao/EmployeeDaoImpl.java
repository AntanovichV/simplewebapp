package com.mastery.java.task.dao;

import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.mapper.EmployeeMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public EmployeeDaoImpl(NamedParameterJdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Employee> findAllEmployees() {
        return jdbcTemplate.query("SELECT * FROM employee", new EmployeeMapper());
    }

    @Override
    public Employee addEmployee(Employee employee) {

        KeyHolder keyHolder = new GeneratedKeyHolder();

        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("first_name", employee.getFirstName())
                .addValue("last_name", employee.getLastName())
                .addValue("department_id", employee.getDepartmentId())
                .addValue("job_title", employee.getJobTitle())
                .addValue("gender", employee.getGender() == null ? "" : employee.getGender().toString())
                .addValue("date_of_birth", employee.getDateOfBirth());

        jdbcTemplate.update("INSERT INTO employee (first_name, last_name, department_id, job_title, gender, date_of_birth)" +
                " VALUES (:first_name,:last_name,:department_id, :job_title, :gender, :date_of_birth)", parameters, keyHolder, new String[]{"employee_id"});

        employee.setEmployeeId(keyHolder.getKey().intValue());

        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("employee_id", id);
        jdbcTemplate.update("DELETE FROM employee WHERE employee_id=:employee_id", parameters);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("employee_id", employee.getEmployeeId())
                .addValue("first_name", employee.getFirstName())
                .addValue("last_name", employee.getLastName())
                .addValue("department_id", employee.getDepartmentId())
                .addValue("job_title", employee.getJobTitle())
                .addValue("gender", employee.getGender() == null ? "" : employee.getGender().toString())
                .addValue("date_of_birth", employee.getDateOfBirth());

        jdbcTemplate.update("UPDATE employee SET first_name=:first_name, last_name=:last_name, department_id=:department_id, job_title=:job_title, gender=:gender, date_of_birth=:date_of_birth" +
                " WHERE employee_id=:employee_id", parameters);

        return employee;
    }

   @Override
    public Optional<Employee> findEmployeeById (int id) {
       SqlParameterSource parameters = new MapSqlParameterSource()
               .addValue("employee_id", id);

       List <Employee> employee = jdbcTemplate.query("SELECT * FROM employee WHERE employee_id = :employee_id", parameters,
               new EmployeeMapper());
       return employee.stream().findFirst();
    }
}
