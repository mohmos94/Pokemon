package com.mohmo.Pokemon.exception;

public class InternalPokemonServerError extends RuntimeException {


    public InternalPokemonServerError(String message) {
        super(message);
    }

    public InternalPokemonServerError(String message, final Throwable cause) {
        super(message, cause);
    }
}
