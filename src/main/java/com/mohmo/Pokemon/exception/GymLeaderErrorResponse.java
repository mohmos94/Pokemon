package com.mohmo.Pokemon.exception;

import io.swagger.v3.oas.annotations.media.Schema;

public record GymLeaderErrorResponse(
        @Schema(
                description = "Error message",
                name = "message",
                type = "string",
                example = "Error...")
        String message
) {


}
