package com.mohmo.Pokemon.service.pokemon;

import com.mohmo.Pokemon.adapter.PokemonRestAdapter;
import com.mohmo.Pokemon.model.pokemon.PokemonListRest;
import com.mohmo.Pokemon.restTemplate.PokemonRest;
import org.springframework.stereotype.Service;

@Service
public class PokemonServiceImplementation implements PokemonService {

    PokemonRestAdapter pokemonRestAdapter;

    public PokemonServiceImplementation(PokemonRestAdapter pokemonRestAdapter) {
        this.pokemonRestAdapter = pokemonRestAdapter;
    }

    @Override
    public PokemonRest getPokemon(String pokemonName) {
        return pokemonRestAdapter.pokemon(pokemonName);
    }

    @Override
    public PokemonListRest pokemonList() {
        return pokemonRestAdapter.pokemonList();
    }

}
