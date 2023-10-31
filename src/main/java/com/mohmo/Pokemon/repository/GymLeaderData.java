package com.mohmo.Pokemon.repository;

import org.springframework.jdbc.core.JdbcTemplate;

public class GymLeaderData {

    private final JdbcTemplate jdbcTemplate;

    public GymLeaderData(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}
