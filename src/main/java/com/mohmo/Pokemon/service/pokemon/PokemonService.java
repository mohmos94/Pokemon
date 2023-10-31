package com.mohmo.Pokemon.service.pokemon;

import com.mohmo.Pokemon.model.pokemon.PokemonListRest;
import com.mohmo.Pokemon.restTemplate.PokemonRest;

public interface PokemonService {

    PokemonRest getPokemon(String pokemonName);

    PokemonListRest pokemonList();


}
