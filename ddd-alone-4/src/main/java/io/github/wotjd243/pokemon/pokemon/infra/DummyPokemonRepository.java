package io.github.wotjd243.pokemon.pokemon.infra;

import org.springframework.stereotype.Repository;

import io.github.wotjd243.pokemon.pokemon.domain.NationalPokedexNumber;
import io.github.wotjd243.pokemon.pokemon.domain.Pokemon;
import io.github.wotjd243.pokemon.pokemon.domain.PokemonRepository;

@Repository
public class DummyPokemonRepository implements PokemonRepository {

    @Override
    public Pokemon findById(final NationalPokedexNumber number) {
        return DummyPokemonData.get(number);
    }
    

}