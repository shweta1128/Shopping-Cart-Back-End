package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import com.techelevator.projects.model.Employee;
import org.springframework.jdbc.support.rowset.SqlRowSet;
//import com.techelevator.projects.model.Employee;

public class JdbcEmployeeDao implements EmployeeDao {

	private final JdbcTemplate jdbcTemplate;

	public JdbcEmployeeDao(DataSource dataSource) {

		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Employee> getAllEmployees() {

		List<Employee> employees = new ArrayList<>();
		String sql = "SELECT employee_id,department_id,first_name,last_name,birth_date,hire_date " +
				"FROM employee; ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while (results.next()){
			employees.add(mapToRowEmployee(results));
		}

		return employees;

	}

	private Employee mapToRowEmployee(SqlRowSet results) {
		Employee employee = new Employee();
		employee.setId(results.getInt("employee_id"));
		employee.setDepartmentId(results.getInt("department_id"));
		employee.setFirstName(results.getString("first_name"));
		employee.setLastName(results.getString("last_name"));
		if(results.getDate("birth_date") != null) {
			employee.setBirthDate(results.getDate("birth_date").toLocalDate());
		}
		if(results.getDate("hire_date") != null) {
			employee.setHireDate(results.getDate("hire_date").toLocalDate());
		}
		return employee;
	}

	@Override
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
		List<Employee> employees = new ArrayList<>();
		String sql = "SELECT employee_id,department_id,first_name,last_name, birth_date, hire_date FROM employee " +
				"WHERE first_name ILIKE ? " + "and last_name ILIKE ?;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql,"%" + firstNameSearch + "%", "%" + lastNameSearch + "%");
		while (results.next()) {
			employees.add(mapToRowEmployee(results));
		}
		return employees;
	}

	@Override
	public List<Employee> getEmployeesByProjectId(int projectId) {
		List<Employee> employees = new ArrayList<>();
		String sql = "SELECT *  FROM employee JOIN project_employee ON employee.employee_id = project_employee.employee_id " +
				"WHERE project_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, projectId);
		while (results.next()) {
			employees.add(mapToRowEmployee(results));
		}
		return employees;

	}

	@Override
	public void addEmployeeToProject(int projectId, int employeeId) {
		//List<Employee> employees = new ArrayList<>();
		String sql = "INSERT INTO project_employee (project_id,employee_id) " +
				"VALUES(? , ? )";
	     jdbcTemplate.update(sql, projectId, employeeId);

	}

	@Override
	public void removeEmployeeFromProject(int projectId, int employeeId) {
		String sql = "DELETE  FROM project_employee WHERE project_id = ? and employee_id = ?; " ;
		jdbcTemplate.update(sql, projectId, employeeId);

	}

	@Override
	public List<Employee> getEmployeesWithoutProjects() {
		List<Employee> employees = new ArrayList<>();
		String sql = "SELECT * FROM employee WHERE employee_id NOT IN (SELECT employee_id FROM project_employee );";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while(results.next()){
			employees.add(mapToRowEmployee(results));
		}
		return employees;
	}


}
