package com.mohmo.Pokemon.service.gymLeader;

import com.mohmo.Pokemon.model.GymLeader;

import java.util.List;
import java.util.Optional;

public interface GymLeaderService {

    Optional<GymLeader> getGymLeader(String gymLeader);
    List<GymLeader> getAllGymLeader();
}
