package com.md.tcg;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RandomGeneratorTest {

    @Test
    public void rangeTest() {
        RandomGenerator randomGenerator = new RandomGenerator();
        List<Integer> randNumbers = new ArrayList<>();

        for(int i = 0; i<100; i++) {
            randNumbers.add(randomGenerator.getRandom(20));
        }

        for(int i = 0; i<100; i++) {
            Assert.assertTrue(randNumbers.get(i) < 20);
        }
    }
}
