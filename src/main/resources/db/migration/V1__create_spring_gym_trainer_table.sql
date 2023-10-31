CREATE TABLE IF NOT EXISTS gym_leaders (
    gym_leader_id BIGSERIAL PRIMARY KEY UNIQUE,
    given_name VARCHAR(255) NOT NULL,
    sur_name VARCHAR(255),
    full_name VARCHAR(255) NOT NULL,
    age INT NOT NULL,
    active_pokemon_id BIGINT,
    caught_pokemon_id BIGINT,
    description VARCHAR(255)
);
