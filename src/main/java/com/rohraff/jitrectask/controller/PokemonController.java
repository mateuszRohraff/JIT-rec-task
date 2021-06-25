package com.rohraff.jitrectask.controller;

import com.rohraff.jitrectask.model.Pokemon;
import com.rohraff.jitrectask.service.PokemonService;
import com.rohraff.jitrectask.service.PokemonValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/pokemon")
public class PokemonController {

    private PokemonService pokemonService;
    private PokemonValidator pokemonValidator;

    public PokemonController(PokemonService pokemonService, PokemonValidator pokemonValidator) {
        this.pokemonService = pokemonService;
        this.pokemonValidator = pokemonValidator;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addPokemon(@RequestParam String name, @RequestParam String type) {
        if(!pokemonValidator.pokemonTypeValidator(type))
            return new ResponseEntity<String>("Such type of pokemon does not exist", HttpStatus.BAD_REQUEST);

        if(pokemonService.addPokemon(name, type)) {
            return new ResponseEntity<String>("Pokemon added correctly", HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<String>("Something went wrong", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/all")
    public ResponseEntity getAllPokemons() {
        Optional<List<Pokemon>> listOfPokemons = pokemonService.getAllPokemons();
        if(listOfPokemons.isEmpty() || listOfPokemons.get().size() == 0) {
            return new ResponseEntity<String>("Not even one Pokemon was found", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<List<Pokemon>>(listOfPokemons.get(), HttpStatus.OK);
        }
    }

    @GetMapping("/type")
    public ResponseEntity getPokemonsByType(@RequestParam String type) {
        Optional<List<Pokemon>> pokemonList = pokemonService.getPokemonsByType(type);
        if (pokemonList.isEmpty() || pokemonList.get().size() == 0) {
            return new ResponseEntity<String>("There is no Pokemons of this type", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<List<Pokemon>>(pokemonList.get(), HttpStatus.OK);
        }
    }

    @GetMapping("/name")
    public ResponseEntity getPokemonsByName(@RequestParam String name) {
        Optional<List<Pokemon>> pokemonList = pokemonService.getPokemonsByName(name);
        if(pokemonList.isEmpty() || pokemonList.get().size() == 0) {
            return new ResponseEntity<String> ("There is so pokemon of this name", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<List<Pokemon>> (pokemonList.get(), HttpStatus.OK);
        }
    }

    @GetMapping
    public ResponseEntity getPokemonById(@RequestParam Integer pokemonId) {
        Optional<Pokemon> pokemon = pokemonService.getPokemonById(pokemonId);
        if(pokemon.isPresent()) {
            return new ResponseEntity<Pokemon>(pokemon.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Pokemon was not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deletePokemonById(@RequestParam Integer pokemonId) {
        if(pokemonService.deletePokemon(pokemonId)) {
            return new ResponseEntity<String>("Pokemon has been properly deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Pokemon was not deleted", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<String> updatePokemon
            (@RequestParam Integer pokemonId,
             @RequestParam(required = false) String name,
             @RequestParam(required = false) String type) {

        if(type != null) {
            if(!pokemonValidator.pokemonTypeValidator(type)) {
                return new ResponseEntity<String>("Such type of pokemon does not exist", HttpStatus.BAD_REQUEST);
            }
        }

        if(pokemonService.updatePokemon(new Pokemon(pokemonId, name, type))) {
            return new ResponseEntity<String>("Pokemon was updated correctly" , HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<String>("Pokemon was not updated correctly", HttpStatus.BAD_REQUEST);
        }
    }
}
