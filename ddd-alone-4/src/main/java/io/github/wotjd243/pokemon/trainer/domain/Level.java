package io.github.wotjd243.pokemon.trainer.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Level {
    private static final int MIN_LEVEL = 1;
    private static final int MAX_LEVEL = 30;

    private int level;

    public Level() {

    }
    public Level(final int level) {
        if (level < MIN_LEVEL || level > MAX_LEVEL) {
            throw new IllegalArgumentException();
        }
        this.level = level;
    }

	public Level up() {
        if(level > MAX_LEVEL) {
            return this;
        }
		return new Level(level + 1);
	}


}
