package com.mohmo.Pokemon.exception;


import com.mohmo.Pokemon.exception.InternalPokemonServerError;
import com.mohmo.Pokemon.exception.PokemonErrorResponse;
import com.mohmo.Pokemon.exception.PokemonNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = PokemonNotFoundException.class)
    public ResponseEntity<PokemonErrorResponse> handlePokemonNotFoundException(PokemonNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new PokemonErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND));
    }
    @ExceptionHandler(value = InternalPokemonServerError.class)
    public ResponseEntity<PokemonErrorResponse> handleInternalPokemonException(InternalPokemonServerError ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new PokemonErrorResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @ExceptionHandler(value = CustomJDBCException.class)
    public ResponseEntity<GymLeaderErrorResponse> handleGymLeaderException(CustomJDBCException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new GymLeaderErrorResponse(ex.getMessage()));
    }
}
