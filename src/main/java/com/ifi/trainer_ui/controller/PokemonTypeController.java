package com.ifi.trainer_ui.controller;

import com.ifi.trainer_ui.pokemonTypes.service.PokemonTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PokemonTypeController {
    PokemonTypeService pts ;
    @GetMapping("/pokedex")
    public ModelAndView pokedex(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("pokedex");
        mav.addObject("pokemonTypes", pts.listPokemonsTypes() );
        return mav;
    }
    @Autowired
    public void setPokemonTypeService(PokemonTypeService pokemonTypeService) {
        this.pts = pokemonTypeService;
    }
}