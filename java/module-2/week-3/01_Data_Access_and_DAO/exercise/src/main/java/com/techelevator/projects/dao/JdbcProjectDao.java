package com.techelevator.projects.dao;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.techelevator.projects.model.Department;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Project;

public class JdbcProjectDao implements ProjectDao {

	private final JdbcTemplate jdbcTemplate;

	public JdbcProjectDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Project getProject(int projectId) {
		Project project = null;
		String sql = " SELECT project_id,name,from_date,to_date " +
				"FROM project " +
				"WHERE project_id = ?;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, projectId);
		while (results.next()) {
			project = mapRowToProject(results);
		}
        return project;
	}

	private Project mapRowToProject(SqlRowSet results) {
		Project project = new Project();
		project.setId(results.getInt("project_id"));
		project.setName(results.getString("name"));
		// As my delete project was giving me a null pointer exception , i had to wrap the localDate to and from in the if statement
		// with a not null pointer exception, i could use a try cacth exception too for this.
		if(results.getDate("from_date") != null) {
			project.setFromDate(results.getDate("from_date").toLocalDate());
		}
		if(results.getDate("to_date") != null) {
			project.setToDate(results.getDate("to_date").toLocalDate());
		}
		return project;
	}

	@Override
	public List<Project> getAllProjects() {
		List<Project> projects = new ArrayList<>();
		String sql =
				"SELECT project_id, name ,from_date,to_date FROM project ;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while (results.next()) {
			projects.add(mapRowToProject(results));
		}
		return projects;
	}

	@Override
	public Project createProject(Project newProject) {
     String sql = "INSERT INTO project (project_id, name ,from_date,to_date)" +
			 "VALUES ( ?, ?, ? ,? )" +
			 "RETURNING project_id";
      int projectId =jdbcTemplate.queryForObject(sql, int.class, newProject.getId(), newProject.getName(),newProject.getFromDate(),newProject.getToDate());

             newProject.setId(projectId);
		return newProject;
	}

	@Override
	public void deleteProject(int projectId) {
       String deleteProjectEmployeeSql = "DELETE FROM project_employee WHERE project_id = ?;";
       jdbcTemplate.update(deleteProjectEmployeeSql, projectId);
	   String deleteProjectSql = "DELETE  FROM project WHERE project_id = ?;";
	   jdbcTemplate.update(deleteProjectSql, projectId);
	}
	

}
