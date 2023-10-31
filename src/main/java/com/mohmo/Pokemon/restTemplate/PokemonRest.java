package com.mohmo.Pokemon.restTemplate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mohmo.Pokemon.model.pokemon.Abilites;
import com.mohmo.Pokemon.model.pokemon.Moves;
import com.mohmo.Pokemon.model.pokemon.Sprites;
import com.mohmo.Pokemon.model.pokemon.Stats;

import java.util.List;

public record PokemonRest(
        Long id,
        String name,
        @JsonProperty("base_experience")
        String baseExperience,
        double height,
        double weight,
        Abilites[] abilities,
        List<Moves> moves,
        List<Stats> stats,
        Sprites sprites
) {
}
