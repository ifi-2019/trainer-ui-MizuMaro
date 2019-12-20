package com.ifi.trainer_ui.pokemonTypes.bo;


import java.util.List;

public class Trainer {

    private String name;

    private String password;

    private String avatar;

    private List<Pokemon> team;

    private List<PokemonType> teamPT;

    public Trainer() {
    }

    public Trainer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Pokemon> getTeam() {
        return team;
    }

    public void setTeam(List<Pokemon> team) {
        this.team = team;
    }

    public List<PokemonType> getTeamPT() {
        return teamPT;
    }

    public void setTeamPT(List<PokemonType> teamPT) {
        this.teamPT = teamPT;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}