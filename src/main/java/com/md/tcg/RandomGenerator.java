package com.md.tcg;

import java.util.concurrent.ThreadLocalRandom;

public class RandomGenerator {
    public int getRandom(int max) {
        return ThreadLocalRandom.current().nextInt(0, max);
    }
}
