package com.miage.altea.tp.pokemon_type_api.service;

import com.miage.altea.tp.pokemon_type_api.bo.PokemonType;

import com.miage.altea.tp.pokemon_type_api.repository.PokemonTypeRepository;
import com.miage.altea.tp.pokemon_type_api.repository.TranslationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class PokemonTypeServiceImpl implements PokemonTypeService{

    public PokemonTypeRepository  pokemonTypeRepository;
    public TranslationRepository translationRepository;

    @Autowired
    public PokemonTypeServiceImpl(){

    }

    @Override
    public PokemonType getPokemonType(int id) {

        PokemonType t = pokemonTypeRepository.findPokemonTypeById(id);

        t.setName(translationRepository.getPokemonName(id, LocaleContextHolder.getLocale()));
                return t;
    }

    @Override
    public List<PokemonType> getAllPokemonTypes(){

        List<PokemonType> trad = null;
        List<PokemonType> res  = pokemonTypeRepository.findAllPokemonType();
        for (PokemonType pt: res) {
            pt.setName(translationRepository.getPokemonName(pt.getId(), LocaleContextHolder.getLocale()));
            trad.add(pt);
        }
        return trad;
    }


    public PokemonTypeRepository getPokemonTypeRepository() {
        return pokemonTypeRepository;
    }
    @Autowired
    public void setPokemonTypeRepository(PokemonTypeRepository pokemonTypeRepository) {
        this.pokemonTypeRepository = pokemonTypeRepository;
    }


    public TranslationRepository getTranslationRepository() {
        return translationRepository;
    }
    @Autowired
    public void setTranslationRepository(TranslationRepository translationRepository) {
        this.translationRepository = translationRepository;
    }
}