package com.mohmo.Pokemon.adapter;

import com.mohmo.Pokemon.exception.InternalPokemonServerError;
import com.mohmo.Pokemon.exception.PokemonNotFoundException;
import com.mohmo.Pokemon.model.pokemon.PokemonListRest;
import com.mohmo.Pokemon.restTemplate.PokemonRest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientResponseException;


@Component
public class PokemonRestAdapter {
    private final String POKEMON = "https://pokeapi.co/api/v2/pokemon/";
    private final String POKEMONLIST = "https://pokeapi.co/api/v2/pokemon?limit=100000&offset=0";

    private final PokemonRestClient pokemonRestClient;

    public PokemonRestAdapter(PokemonRestClient pokemonRestClient) {
        this.pokemonRestClient = pokemonRestClient;
    }


    public PokemonRest pokemon(String pokemonName) {

        try {
            return pokemonRestClient.pokemonAPI(POKEMON + pokemonName, PokemonRest.class);

        } catch (RestClientResponseException ex) {

            return handleException(ex);
        }
    }

    public PokemonListRest pokemonList() {

        try {
            return pokemonRestClient.pokemonAPI(POKEMONLIST, PokemonListRest.class);


        } catch (RestClientResponseException ex) {

            return handleException(ex);
        }
    }

    private <T> T handleException(RestClientResponseException ex) {
        HttpStatusCode statusCode = ex.getStatusCode();

        if (statusCode == HttpStatus.NOT_FOUND) {
            throw new PokemonNotFoundException("Could not find pokemon", ex);
        } else {
            throw new InternalPokemonServerError("Internal error with pokeAPi", ex);
        }
    }
}
