package com.mohmo.Pokemon.service.gymLeader;


import com.mohmo.Pokemon.exception.CustomJDBCException;
import com.mohmo.Pokemon.model.GymLeader;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GymLeaderImplementation implements GymLeaderService {

    private final String SQL_FIND_GYM_LEADER =
            """
                    SELECT * 
                    FROM gym_leaders 
                    WHERE full_name = ?;
                    """;

    private final String SQL_GET_ALL_GYM_LEADER =
            """
                    SELECT * 
                    FROM gym_leaders
                    LIMIT 100;
                    """;

    private final JdbcTemplate jdbcTemplate;

    public GymLeaderImplementation(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Optional<GymLeader> getGymLeader(String gymLeaderName) {
        ;
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(SQL_FIND_GYM_LEADER,
                    new GymLeaderRowMapper(),
                    gymLeaderName));
        } catch (DataAccessException ex) {
            handleGymLeaderException(ex);
        }
        return Optional.empty();
    }

    @Override
    public List<GymLeader> getAllGymLeader() {

        try {
            return jdbcTemplate.query(SQL_GET_ALL_GYM_LEADER,
                    new GymLeaderRowMapper());
        } catch (DataAccessException ex) {
            handleGymLeaderException(ex);
        }
        return null;
    }

    private void handleGymLeaderException(DataAccessException ex) {
        Throwable cause = ex.getCause();
        if (cause instanceof BadSqlGrammarException) {
            throw new CustomJDBCException(ex.getMessage(), ex);
        } else if (cause instanceof DataIntegrityViolationException) {
            throw new CustomJDBCException(ex.getMessage(), ex);
        } else if (cause instanceof DataAccessResourceFailureException) {
            throw new CustomJDBCException(ex.getMessage(), ex);
        }
    }
}
