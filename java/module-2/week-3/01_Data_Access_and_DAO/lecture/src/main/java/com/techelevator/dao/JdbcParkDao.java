package com.techelevator.dao;

import com.techelevator.model.Campground;
import com.techelevator.model.Park;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcParkDao implements ParkDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcParkDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Park getPark(int parkId) {
        Park park = null;
        String sql = "SELECT park_id, name, location, establish_date, area, visitors, description\n" +
                "FROM park\n" +
                "WHERE park_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, parkId);
        while (results.next()){
            park = mapRowToPark(results);
        }
        return park;
    }

    private Park mapRowToPark(SqlRowSet results) {
        Park park = new Park();
        park.setParkId(results.getInt("park_id"));
        park.setName(results.getString("name"));
        park.setArea(results.getInt("area"));
        park.setLocation(results.getString("location"));
        park.setDescription(results.getString("description"));
        park.setEstablishDate(results.getDate("establish_date").toLocalDate());
        park.setVisitors(results.getInt("visitors"));
        return park;
    }

    @Override
    public List<Park> getAllParks() {
        List<Park> parks = new ArrayList<>();
        String sql = "SELECT park_id, name, location, establish_date, area, visitors, description\n" +
                "FROM park\n" +
                "WHERE park_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            parks.add(mapRowToPark(results));


        }
        return parks;
    }

    @Override
    public Park createPark(Park park) {

        return null;
    }

    @Override
    public boolean updatePark(Park park) {

        return false;
    }

    @Override
    public void deletePark(int parkId) {

    }
}
