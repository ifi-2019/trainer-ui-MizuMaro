package com.ifi.trainer_ui.pokemonTypes.service;

import com.ifi.trainer_ui.pokemonTypes.bo.Trainer;

import java.util.List;

public interface TrainerService {
    List<Trainer> listTrainers();
    List<Trainer> listOtherTrainers(Trainer principal);
    Trainer getTrainer(String name);
}
