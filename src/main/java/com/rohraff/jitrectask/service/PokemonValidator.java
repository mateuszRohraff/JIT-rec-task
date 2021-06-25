package com.rohraff.jitrectask.service;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class PokemonValidator {

    private final static List<String> listOfPokemonTypes = new ArrayList<>();

    @EventListener(ApplicationReadyEvent.class)
    private static void add() {
        listOfPokemonTypes.add("ground");
        listOfPokemonTypes.add("fire");
        listOfPokemonTypes.add("normal");
        listOfPokemonTypes.add("poison");
        listOfPokemonTypes.add("water");
    }

    public PokemonValidator() {
    }

    public boolean pokemonTypeValidator(String type) {
        return listOfPokemonTypes.stream()
                .anyMatch(x -> x.equals(type.toLowerCase(Locale.ROOT)));
    }
}
