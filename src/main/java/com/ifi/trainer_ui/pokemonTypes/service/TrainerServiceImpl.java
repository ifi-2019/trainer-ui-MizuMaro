package com.ifi.trainer_ui.pokemonTypes.service;

import com.ifi.trainer_ui.pokemonTypes.bo.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService {

    RestTemplate template ;
    String  url ;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.template = restTemplate;
    }

    @Value("${trainer.service.url}")
    public void setPokemonTypeServiceUrl(String url) {
        this.url = url;
    }

    public List<Trainer> listTrainers() {
        Trainer[] pokemons = template.getForObject(url+"/trainers/", Trainer[].class);
        List<Trainer> list=  Arrays.asList(pokemons);
        return  list;
    }
}
