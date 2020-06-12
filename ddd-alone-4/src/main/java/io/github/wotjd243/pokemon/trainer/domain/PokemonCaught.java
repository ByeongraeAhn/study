package io.github.wotjd243.pokemon.trainer.domain;

import javax.persistence.Embeddable;

@Embeddable
public class PokemonCaught {
    private int number;
    private String nickName;

    protected PokemonCaught() {
    }

    public PokemonCaught(final int number, final String nickName) {
        this.number = number;
        this.nickName = nickName;

    }

}