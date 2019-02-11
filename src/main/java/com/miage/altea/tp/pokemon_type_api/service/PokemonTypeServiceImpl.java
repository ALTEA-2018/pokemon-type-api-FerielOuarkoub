package com.miage.altea.tp.pokemon_type_api.service;

import com.miage.altea.tp.pokemon_type_api.bo.PokemonType;
import com.miage.altea.tp.pokemon_type_api.repository.PokemonTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonTypeServiceImpl implements PokemonTypeService{

    public PokemonTypeRepository  pokemonTypeRepository;

    public PokemonTypeServiceImpl(PokemonTypeRepository repository){
        this.pokemonTypeRepository = repository;
    }

    @Override
    public PokemonType getPokemonType(int id) {

        return pokemonTypeRepository.findPokemonTypeById(id);
    }

    @Override
    public List<PokemonType> getAllPokemonTypes(){
        return pokemonTypeRepository.findAllPokemonType();
    }

    public PokemonTypeRepository getPokemonTypeRepository() {
        return pokemonTypeRepository;
    }

    public void setPokemonTypeRepository(PokemonTypeRepository pokemonTypeRepository) {
        this.pokemonTypeRepository = pokemonTypeRepository;
    }
}