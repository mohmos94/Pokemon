package com.mohmo.Pokemon.model;

import com.mohmo.Pokemon.model.pokemon.Pokemon;

import java.util.List;

public record PokemonTrainer(

        Long pokemonTrainerId,
        String givenName,
        String surName,
        String fullName,
        String age,
        int money,
        List<Badges> ownedBadges,
        List<Pokemon> activePokemon,
        List<Pokemon> caughtPokemon,
        String description

) {
}
