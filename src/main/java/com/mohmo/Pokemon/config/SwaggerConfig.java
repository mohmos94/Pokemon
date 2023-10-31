package com.mohmo.Pokemon.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;


@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Pokémon simulator" +
                        "\n",
                version = "${api.version}",
                description =
                        "This application is a Pokémon simulator that allows users to catch, train, and battle other Pokémon trainers.\n" +
                        "\n" +
                        "The application uses the Pokémon API to access information about Pokémon, including stats, abilities, and evolutions.\n" +
                        "\n" +
                        "Users can catch Pokémon by throwing Poké Balls at them. The chance of a Pokémon being caught depends on the Pokémon's stats, the type of Poké Ball, and the user's skill."
        )
)
@SecurityScheme(
        name = "pokemonAPi",
        type = SecuritySchemeType.APIKEY,
        in = SecuritySchemeIn.HEADER,
        paramName = "pokemonAPiy",
        description = "An API token required to access the Pokémon API"
)
public class SwaggerConfig {
}
