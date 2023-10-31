CREATE TABLE IF NOT EXISTS pokemon_trainer (
    pokemon_trainer_id BIGSERIAL PRIMARY KEY UNIQUE,
    given_name VARCHAR(255),
    sur_name VARCHAR(255),
    full_name VARCHAR(255),
    age VARCHAR(255),
    money INT,
    description VARCHAR(255),
    badge_id BIGINT
);

ALTER TABLE pokemon_trainer
ADD CONSTRAINT fk_pokemon_trainer_badges
FOREIGN KEY (badge_id)
REFERENCES badges (badge_id);
