package com.mohmo.Pokemon.exception;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.HttpStatus;

public record PokemonErrorResponse(

        @Schema(
                description = "Error message",
                name = "message",
                type = "string",
                example = "Error...")
        String message,

        @Schema(
                description = "Error Code",
                name = "errorCode",
                type = "HttpStatus",
                example = "404")
        HttpStatus errorCode
) {


}
