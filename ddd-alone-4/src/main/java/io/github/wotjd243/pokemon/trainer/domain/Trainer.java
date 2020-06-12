package io.github.wotjd243.pokemon.trainer.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Trainer {
    @Id
    private String id;

    @Embedded
    private Level level;

    @ElementCollection
    private List<PokemonCaught> party = new ArrayList<>();

    public Trainer() {
    }

    public Trainer(final String id) {
        this(id, new Level(1), new ArrayList<>());
    }

    public Trainer(final String id, final Level level, final List<PokemonCaught> party) {
        this.id = id;
        this.level = level;
        this.party = party;
    }

    public void addPokemon(final int number, final String name) {
        addPokemon(new PokemonCaught(number, name));
    }

    public void addPokemon(final PokemonCaught pokemonCaught) {
        party.add(pokemonCaught);
        levelUp();
    }

    public void levelUp() {
        this.level = level.up();

    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Trainer)) {
            return false;
        }
        Trainer trainer = (Trainer) o;
        return Objects.equals(id, trainer.id) && level == trainer.level && Objects.equals(party, trainer.party);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, level, party);
    }


}