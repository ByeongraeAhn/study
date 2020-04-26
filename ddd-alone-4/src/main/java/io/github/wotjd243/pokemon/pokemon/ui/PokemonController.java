package io.github.wotjd243.pokemon.pokemon.ui;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.github.wotjd243.pokemon.pokemon.applicaiton.PokemonSerivce;
import io.github.wotjd243.pokemon.pokemon.domain.Pokemon;

@RestController
public class PokemonController {
    private final PokemonSerivce pokemonSerivce;

    public PokemonController(final PokemonSerivce pokemonSerivce) {
        this.pokemonSerivce = pokemonSerivce;
    }

    @GetMapping("/api/pokemons/{number}")
    public ResponseEntity<Pokemon> find(@PathVariable final int number) {
        return ResponseEntity.ok().body(pokemonSerivce.find(number));
    }

}