package com.mohmo.Pokemon.controller;


import com.mohmo.Pokemon.exception.GymLeaderErrorResponse;
import com.mohmo.Pokemon.model.PokemonTrainer;
import com.mohmo.Pokemon.service.pokemonTrainer.PokemonTrainerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/gym/pokemon/trainer")
public class PokemonTrainerController {

    private final PokemonTrainerService pokemonTrainerService;

    public PokemonTrainerController(PokemonTrainerService pokemonTrainerService) {
        this.pokemonTrainerService = pokemonTrainerService;
    }

    @Operation(summary = "Provides information about a pokemonTrainer.",
            description = "Provides information about a pokemonTrainer.",
            security = {@SecurityRequirement(name = "pokemonAPi")})
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Found a pokemonTrainer",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = PokemonTrainer.class))}),

                    @ApiResponse(responseCode = "404", description = "Not Found pokemonTrainer",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = GymLeaderErrorResponse.class))}),

                    @ApiResponse(responseCode = "500", description = "Internal error with pokeApi",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = GymLeaderErrorResponse.class))})
            })
    @GetMapping("{pokemonTrainer}")
    public ResponseEntity<PokemonTrainer> getPokemonTrainer(
            @PathVariable
            String pokemonTrainer
    ) {
        return ResponseEntity.ok(pokemonTrainerService.getPokemonTrainer(pokemonTrainer));
    }


    @Operation(summary = "Provides information about a pokemonTrainer.",
            description = "Provides information about a pokemonTrainer.",
            security = {@SecurityRequirement(name = "pokemonAPi")})
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Found a pokemonTrainer",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = PokemonTrainer.class))}),

                    @ApiResponse(responseCode = "404", description = "Not Found pokemonTrainer",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = GymLeaderErrorResponse.class))}),

                    @ApiResponse(responseCode = "500", description = "Internal error with pokeApi",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = GymLeaderErrorResponse.class))})
            })
    @GetMapping
    public ResponseEntity<List<PokemonTrainer>> listOfPokemonTrainer() {
        return ResponseEntity.ok(pokemonTrainerService.pokemonList());
    }
}
