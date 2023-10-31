package com.mohmo.Pokemon.model.pokemon;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Set;

@JsonPropertyOrder({"count", "results"})
public record PokemonListRest(
        Integer count,

        @JsonProperty("results")
        Set<PokemonList> pokemonList

){
        }
