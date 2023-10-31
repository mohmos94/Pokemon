package com.mohmo.Pokemon.service.pokemonTrainer;

import com.mohmo.Pokemon.exception.CustomJDBCException;
import com.mohmo.Pokemon.model.PokemonTrainer;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonTrainerServiceImplementation implements PokemonTrainerService {

    private final String SQL_FIND_POKEMON_TRAINER =
            """
                    SELECT * 
                     FROM pokemon_trainer
                     WHERE full_name = ?
                     """;
    private final String SQL_FIND_ALL_POKEMON_TRAINER =
            """
                    SELECT * 
                     FROM pokemon_trainer
                     """;

    private final JdbcTemplate jdbcTemplate;

    public PokemonTrainerServiceImplementation(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public PokemonTrainer getPokemonTrainer(String pokemonTrainer) {
        try {
            return jdbcTemplate.queryForObject(SQL_FIND_POKEMON_TRAINER,
                    new PokemonTrainerRowMapper(),
                    pokemonTrainer);
        } catch (DataAccessException ex) {
            handleGymLeaderException(ex);
        }
        throw new RuntimeException("No data visible");
    }

    @Override
    public List<PokemonTrainer> pokemonList() {
        try {
            return jdbcTemplate.query(SQL_FIND_ALL_POKEMON_TRAINER,
                    new PokemonTrainerRowMapper());
        } catch (DataAccessException ex) {
            handleGymLeaderException(ex);
        }
        throw new RuntimeException("No data visible");
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
