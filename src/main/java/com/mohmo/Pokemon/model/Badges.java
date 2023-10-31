package com.mohmo.Pokemon.model;

public record Badges(
        Long badges_id,
         String name,
         String symbol,
         int level,
         GymLeader gymLeader,
         String reward
) {
}
