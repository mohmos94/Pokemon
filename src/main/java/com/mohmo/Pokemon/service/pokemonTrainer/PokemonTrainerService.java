package com.mohmo.Pokemon.service.pokemonTrainer;

import com.mohmo.Pokemon.model.PokemonTrainer;

import java.util.List;

public interface PokemonTrainerService {

    PokemonTrainer getPokemonTrainer(String pokemonTrainer);
    List<PokemonTrainer> pokemonList();


}
