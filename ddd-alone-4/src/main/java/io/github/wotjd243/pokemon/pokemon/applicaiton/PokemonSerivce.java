package io.github.wotjd243.pokemon.pokemon.applicaiton;

import org.springframework.stereotype.Service;

import io.github.wotjd243.pokemon.pokemon.domain.NationalPokedexNumber;
import io.github.wotjd243.pokemon.pokemon.domain.Pokemon;
import io.github.wotjd243.pokemon.pokemon.domain.PokemonRepository;

@Service
public class PokemonSerivce {
    private final PokemonRepository pokemonRepository;

    public PokemonSerivce(final PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public Pokemon find(final int number) {
        return getById(number);
    }

    public Pokemon getById(final int number) {
        return pokemonRepository.findById(NationalPokedexNumber.valueOf(number));
    }

}