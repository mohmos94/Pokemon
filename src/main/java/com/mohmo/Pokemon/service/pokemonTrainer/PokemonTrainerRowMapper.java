package com.mohmo.Pokemon.service.pokemonTrainer;

import com.mohmo.Pokemon.model.GymLeader;
import com.mohmo.Pokemon.model.PokemonTrainer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class PokemonTrainerRowMapper implements RowMapper<PokemonTrainer> {


    @Override
    public PokemonTrainer mapRow(ResultSet rs, int rowNum) throws SQLException {
        return  new PokemonTrainer(
                rs.getLong("pokemon_trainer_id"),
                rs.getString("given_name"),
                rs.getString("sur_name"),
                rs.getString("full_name"),
                rs.getString("age"),
                rs.getInt("money"),
                null,
                null,
                null,
                rs.getString("description"));
    }
}
