CREATE TABLE IF NOT EXISTS badges (
    badge_id SERIAL PRIMARY KEY UNIQUE,
    name VARCHAR(255),
    symbol VARCHAR(255),
    level INT,
    gym_leader_id BIGINT,
    gym_leader_name VARCHAR(255),
    reward VARCHAR(255)
);

ALTER TABLE badges
ADD CONSTRAINT fk_badges_gym_leader
FOREIGN KEY (gym_leader_id)
REFERENCES gym_leaders (gym_leader_id);
