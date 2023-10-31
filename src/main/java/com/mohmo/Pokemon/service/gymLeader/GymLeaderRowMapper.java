package com.mohmo.Pokemon.service.gymLeader;

import com.mohmo.Pokemon.model.GymLeader;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class GymLeaderRowMapper implements RowMapper<GymLeader> {


    @Override
    public GymLeader mapRow(ResultSet rs, int rowNum) throws SQLException {
        return  new GymLeader(
                rs.getString("given_name"),
                rs.getString("sur_name"),
                rs.getString("full_name"),
                rs.getString("age"),
                null,
                null,
                rs.getString("description"));
    }
}
