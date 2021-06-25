package com.rohraff.jitrectask.mapper;

import com.rohraff.jitrectask.model.Pokemon;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PokemonMapper {

    @Select("SELECT * FROM POKEMONS WHERE pokemonID = #{pokemonID}")
    Pokemon getPokemonById(Integer pokemonID);

    @Select("SELECT * FROM POKEMONS")
    List<Pokemon> getAllPokemons();

    @Insert("INSERT INTO POKEMONS (pokemonName, pokemonType) VALUES(#{name}, #{type})")
    @Options(useGeneratedKeys = true, keyProperty = "pokemonID")
    int insert(Pokemon pokemon);

    @Delete("DELETE FROM POKEMONS WHERE pokemonID =#{pokemonID}")
    int deletePokemon(int pokemonID);

    @Update("UPDATE POKEMONS SET pokemonName=#{name}, pokemonType =#{type} WHERE pokemonID =#{pokemonID}")
    void updatePokemon(Pokemon pokemon);

    @Select("SELECT * FROM POKEMONS WHERE pokemonType=#{type}")
    List<Pokemon> getPokemonsByType(String type);

    @Select("SELECT * FROM POKEMONS WHERE pokemonName=#{name}")
    List<Pokemon> getPokemonsByName(String name);
}
