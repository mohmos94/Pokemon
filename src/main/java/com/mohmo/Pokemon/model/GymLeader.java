package com.mohmo.Pokemon.model;

import com.mohmo.Pokemon.model.pokemon.Pokemon;

import java.util.List;

public record GymLeader(
        String givenName,
        String surName,
        String fullName,
        String age,
        List<Pokemon> activePokemon,
        List<Pokemon> caughtPokemon,
        String description


) {
}
