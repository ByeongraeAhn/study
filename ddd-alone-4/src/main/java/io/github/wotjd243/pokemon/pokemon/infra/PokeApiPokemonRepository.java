package io.github.wotjd243.pokemon.pokemon.infra;

import org.springframework.stereotype.Repository;

import io.github.wotjd243.pokemon.pokemon.domain.NationalPokedexNumber;
import io.github.wotjd243.pokemon.pokemon.domain.Pokemon;
import io.github.wotjd243.pokemon.pokemon.domain.PokemonRepository;

@Repository
public class PokeApiPokemonRepository implements PokemonRepository {

    //원래 api로 가져와야 하는데 라이브러리가 추가안되어 더미repo로함
    @Override
    public Pokemon findById(NationalPokedexNumber number) {
        return null;
    }

}