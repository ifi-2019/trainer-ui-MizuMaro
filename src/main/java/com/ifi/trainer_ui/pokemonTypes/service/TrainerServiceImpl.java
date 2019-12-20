package com.ifi.trainer_ui.pokemonTypes.service;

import com.ifi.trainer_ui.pokemonTypes.bo.Pokemon;
import com.ifi.trainer_ui.pokemonTypes.bo.PokemonType;
import com.ifi.trainer_ui.pokemonTypes.bo.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService {

    RestTemplate template ;
    String  url ;
    String ptsUrl;
    @Autowired
    @Qualifier("trainerApiRestTemplate")
    void setRestTemplate(RestTemplate restTemplate) {
        this.template = restTemplate;
    }

    @Value("${trainer.service.url}")
    public void setPokemonTypeServiceUrl(String url) {
        this.url = url;
    }

    @Value("${pokemonType.service.url}")
    public void setPokemonTypeServiceurl(String url) {
        this.ptsUrl = url;
    }

    public List<Trainer> listTrainers() {
        Trainer[] trainers = template.getForObject(url+"/trainers/", Trainer[].class);
        List<Trainer> list=  Arrays.asList(trainers);
        for(Trainer t : trainers){
            if(t.getTeam()!=null) {
                //
                for (Pokemon p : t.getTeam()) {
                    for ( PokemonType pt: listPokemons()) {
                        if(pt.getId() == p.getPokemonType()){
                            p.setPt(pt);
                        }
                    }
                } ;
            }
        }

        return  list;
    }

    @Override
    public List<Trainer> listOtherTrainers(Trainer principal) {
        List <Trainer> list = new LinkedList<>(listTrainers());
        Iterator<Trainer> i = list.iterator();
        while (i.hasNext()) {
            Trainer t = i.next(); // must be called before you can call i.remove()
            if (principal.getName().equals(t.getName())) {
                i.remove();
            }
        }
        return list;
    }
    // todo passer l'id en parametre et récup un pokemonType et non une liste
    public List<PokemonType> listPokemons() {
        PokemonType[] pokemons = template.getForObject(ptsUrl+"/pokemon-types/", PokemonType[].class);
        List<PokemonType> list=  Arrays.asList(pokemons);
        return  list;
    }

    @Override
    public Trainer getTrainer(String name) {
        var trainer = template.getForObject(url+"/trainers/{name}", Trainer.class, name);
        if(trainer.getTeam()!=null) {
            for (Pokemon p : trainer.getTeam()) {
                for ( PokemonType pt: listPokemons()) {
                    if(pt.getId() == p.getPokemonType()){
                        p.setPt(pt);
                    }
                }
            } ;
        }
        return trainer;
    }
}
