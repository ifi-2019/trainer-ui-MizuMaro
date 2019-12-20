package com.ifi.trainer_ui.controller;

import com.ifi.trainer_ui.pokemonTypes.service.PokemonTypeService;
import com.ifi.trainer_ui.pokemonTypes.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TrainerController {
    TrainerService ts ;
    PokemonTypeService ps;

    @GetMapping("/trainers")
    public ModelAndView trainers(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User principal = (User) auth.getPrincipal();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("trainers");
        mav.addObject("trainers", ts.listOtherTrainers(ts.getTrainer(principal.getUsername())) );
        mav.addObject("ts",ts);

        return mav;
    }

    @GetMapping("/profile")
    public ModelAndView profile(){
        ModelAndView  mav = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User principal = (User) auth.getPrincipal();
        mav.setViewName("profileTrainer");
        mav.addObject("trainer", ts.getTrainer(principal.getUsername()) );
        mav.addObject("ts",ts);

        return mav;
    }

    @Autowired
    public void setPokemonTypeService(TrainerService ts) {
        this.ts = ts;
    }
}