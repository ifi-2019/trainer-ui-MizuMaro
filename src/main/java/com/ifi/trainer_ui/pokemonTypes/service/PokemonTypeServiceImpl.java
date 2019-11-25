package com.ifi.trainer_ui.pokemonTypes.service;

import com.ifi.trainer_ui.pokemonTypes.bo.PokemonType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Service
public class PokemonTypeServiceImpl implements PokemonTypeService {

    RestTemplate template ;
    String  url ;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.template = restTemplate;
    }

    @Value("${pokemonType.service.url}")
    public void setPokemonTypeServiceUrl(String url) {
        this.url = url;
    }

    public List<PokemonType> listPokemonsTypes() {
        PokemonType[] pokemons = template.getForObject(url+"/pokemon-types/", PokemonType[].class);
        List<PokemonType> list=  Arrays.asList(pokemons);
        list.sort(Comparator.comparingInt(PokemonType::getId));
        return  list;
    }

    public PokemonType getPokemonsType(int id) {
        PokemonType pokemon = template.getForObject(url+"/pokemon-types/", PokemonType.class,id);
        return  pokemon;
    }
}
