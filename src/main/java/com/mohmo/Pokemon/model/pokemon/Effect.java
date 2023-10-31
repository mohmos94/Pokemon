package com.mohmo.Pokemon.model.pokemon;

/**
 * @param effect      parameter of a Pokémon ability is a more detailed description of the ability's effect.
 *                    It typically includes information about what the ability does, how it works, and any restrictions or limitations.
 * @param shortEffect parameter of a Pokémon ability is a shorter, more concise description of the ability's effect.
 *                    It is typically used in places where space is limited, such as in the Pokémon games or on the Pokémon website.
 */
public record Effect(
        String effect,
        String shortEffect
) {
}
