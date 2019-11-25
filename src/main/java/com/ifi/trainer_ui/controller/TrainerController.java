package com.ifi.trainer_ui.controller;

import com.ifi.trainer_ui.pokemonTypes.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TrainerController {
    TrainerService ts ;


    @GetMapping("/trainer")
    public ModelAndView trainers(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("trainer");
        mav.addObject("trainers", ts.listTrainers() );
        mav.addObject("ts",ts);
        return mav;
    }
    @Autowired
    public void setPokemonTypeService(TrainerService ts) {
        this.ts = ts;
    }
}