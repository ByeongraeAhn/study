package io.github.wotjd243.pokemon.pokemon.domain;

import java.util.Objects;

public class CaptureRate {
    private static final int MINIMUM_CAPTURE_RATE = 3;
    private static final int MAXIMUM_CAPTURE_RATE = 255;

    private final int rate;

    private CaptureRate(final int rate) {
        validate(rate);
        this.rate = rate;
    }

    static CaptureRate valueOf(final int captureRate) {
        return new CaptureRate(captureRate);
    }

    int toInt() {
        return rate;
    }

    private void validate(final int captureRate) {
        if (captureRate < MINIMUM_CAPTURE_RATE || captureRate > MAXIMUM_CAPTURE_RATE) {
            throw new IllegalArgumentException();
        }
    }


}
