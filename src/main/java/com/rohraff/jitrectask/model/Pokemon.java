package com.rohraff.jitrectask.model;

public class Pokemon {
    private Integer pokemonID;
    private String name;
    private String type;

    public Pokemon(Integer pokemonID, String name, String type) {
        this.pokemonID = pokemonID;
        this.name = name;
        this.type = type;
    }

    public Integer getPokemonID() {
        return pokemonID;
    }

    public void setPokemonID(Integer pokemonID) {
        this.pokemonID = pokemonID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
