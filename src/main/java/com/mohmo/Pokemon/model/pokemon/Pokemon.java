package com.mohmo.Pokemon.model.pokemon;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mohmo.Pokemon.model.GymLeader;
import com.mohmo.Pokemon.model.PokemonTrainer;

import java.util.List;
import java.util.Set;

public record Pokemon(
        Long id,
        String name,
        String baseExperience,
        double height,
        double weight,
        Abilites[] abilities,
        List<Moves> moves,
        List<Stats> stats,
        Sprites sprites,
        boolean caught,
        Set<PokemonTrainer> pokemonTrainer,
        Set<GymLeader> gymLeader

) {
}
