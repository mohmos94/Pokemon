package com.mohmo.Pokemon.controller;


import com.mohmo.Pokemon.exception.GymLeaderErrorResponse;
import com.mohmo.Pokemon.model.GymLeader;
import com.mohmo.Pokemon.model.ListGymLeaders;
import com.mohmo.Pokemon.service.gymLeader.GymLeaderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/gym/leader")
@Tag(name = "Gym leader")
public class GymLeaderController {

    GymLeaderService gymLeaderService;

    public GymLeaderController(GymLeaderService gymLeaderService) {
        this.gymLeaderService = gymLeaderService;
    }

    @Operation(summary = "Provides information about a Gym leader.",
            description = "Provides information about a Gym leader.",
            security = {@SecurityRequirement(name = "pokemonAPi")})
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Found gym leader",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = GymLeader.class))}),

                    @ApiResponse(responseCode = "404", description = "Not Found gym leader",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = GymLeaderErrorResponse.class))}),

                    @ApiResponse(responseCode = "500", description = "Internal error with pokeApi",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = GymLeaderErrorResponse.class))})
            }
    )

    @GetMapping("{gymLeader}")
    public ResponseEntity<Optional<GymLeader>> getGymLeader(
            @PathVariable
            String gymLeader
    ) {
        return ResponseEntity.ok(gymLeaderService.getGymLeader(gymLeader));
    }

    @Operation(summary = "Gets all the gym leader",
            description = "Gets all the gym leader",
            security = {@SecurityRequirement(name = "pokemonAPi")})
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Found all gym leaders",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ListGymLeaders.class))}),

                    @ApiResponse(responseCode = "404", description = "Not Found gym leader",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = GymLeaderErrorResponse.class))}),

                    @ApiResponse(responseCode = "500", description = "Internal error with pokeApi",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = GymLeaderErrorResponse.class))})
            }
    )

    @GetMapping
    public ResponseEntity<List<GymLeader>> getGymLeader() {
        return ResponseEntity.ok(gymLeaderService.getAllGymLeader());
    }

}
