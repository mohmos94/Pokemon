package com.mohmo.Pokemon.controller;


import com.mohmo.Pokemon.exception.PokemonErrorResponse;
import com.mohmo.Pokemon.model.pokemon.PokemonListRest;
import com.mohmo.Pokemon.restTemplate.PokemonRest;
import com.mohmo.Pokemon.service.pokemon.PokemonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pokemon/")
@Tag(name = "Pokédex")
public class PokemonController {

    PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @Operation(summary = "Provides information about a Pokémon species.",
            description = "Provides information about a Pokémon species. Including name, moves, abilities, stats and image",
            security = {@SecurityRequirement(name = "pokemonAPi")})
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Found pokemon",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = PokemonRest.class))}),

                    @ApiResponse(responseCode = "404", description = "Not Found pokemon",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = PokemonErrorResponse.class))}),

                    @ApiResponse(responseCode = "500", description = "Internal error with pokeApi",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = PokemonErrorResponse.class))})
            }
    )
    @GetMapping("{pokemonName}")
    public ResponseEntity<PokemonRest> pokemon(
            @PathVariable
            @NotBlank(message = "You must write the name of the pokemon in order for you to find a pokemon")
            @Pattern(regexp = "^[a-z]+$", message = "Pokemon names must start with lowercase letters")
            String pokemonName
    ) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("request-header-sucsess", "${header.path}");
        return new ResponseEntity<>(pokemonService.getPokemon(pokemonName), responseHeaders, 200);
    }

    @Operation(summary = "Display all pokemon",
            description = "Display all pokemon. Following property are displayed: name and image",
            security = {@SecurityRequirement(name = "pokemonAPi")})
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Display pokemon list",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = PokemonListRest.class))}),

                    @ApiResponse(responseCode = "500", description = "Internal error with pokeApi",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = PokemonErrorResponse.class))})
            }
    )
    @GetMapping
    public ResponseEntity<PokemonListRest> pokemon() {
        return ResponseEntity.ok(pokemonService.pokemonList());
    }
}
