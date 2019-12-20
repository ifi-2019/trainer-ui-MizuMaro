package com.ifi.trainer_ui.pokemonTypes.bo;

public class Pokemon {

    private int pokemonType;

    private int level;

    PokemonType pt ;

    public Pokemon() {
    }

    public Pokemon(int pokemonType, int level) {
        this.pokemonType = pokemonType;
        this.level = level;
    }


    public int getPokemonType() {
        return pokemonType;
    }

    public void setPokemonType(int pokemonType) {
        this.pokemonType = pokemonType;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public PokemonType getPt() {
        return pt;
    }

    public void setPt(PokemonType pt) {
        this.pt = pt;
    }
}