package com.rohraff.jitrectask.service;

import com.rohraff.jitrectask.mapper.PokemonMapper;
import com.rohraff.jitrectask.model.Pokemon;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class PokemonService {

    private final PokemonMapper pokemonMapper;

    public PokemonService(PokemonMapper pokemonMapper) {
        this.pokemonMapper = pokemonMapper;
    }

    public Optional<Pokemon> getPokemonById(Integer id) {
        return Optional.ofNullable(pokemonMapper.getPokemonById(id)) ;
    }

    public Optional<List<Pokemon>> getAllPokemons() {
        return Optional.ofNullable(pokemonMapper.getAllPokemons());
    }

    public boolean addPokemon(String name, String type) {
        int pokemonId = pokemonMapper.insert(new Pokemon(null, name, type.toLowerCase(Locale.ROOT)));
        Optional<Pokemon> pokemon = getPokemonById(pokemonId);
        if(pokemon.isPresent()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean deletePokemon(int pokemonId) {
        if(getPokemonById(pokemonId).isPresent()) {
            pokemonMapper.deletePokemon(pokemonId);
            if(getPokemonById(pokemonId).isEmpty()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean updatePokemon(Pokemon pokemon) {
        Optional<Pokemon> pokemonToUpdate = getPokemonById(pokemon.getPokemonID());
        if(pokemonToUpdate.isPresent()) {
            if(pokemon.getName() != null)
                pokemonToUpdate.get().setName(pokemon.getName());

            if(pokemon.getType() != null)
                pokemonToUpdate.get().setType(pokemon.getType().toLowerCase(Locale.ROOT));

            pokemonMapper.updatePokemon(pokemonToUpdate.get());
            return true;
        } else {
            return false;
        }
    }

    public Optional<List<Pokemon>> getPokemonsByType(String type) {
        return Optional.ofNullable(pokemonMapper.getPokemonsByType(type));
    }

    public Optional<List<Pokemon>> getPokemonsByName(String name) {
        return Optional.ofNullable(pokemonMapper.getPokemonsByName(name));
    }
}
