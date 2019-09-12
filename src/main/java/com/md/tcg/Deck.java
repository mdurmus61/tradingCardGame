package com.md.tcg;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    private final List<Card> cards;
    private final RandomGenerator randomGenerator;



    public Deck(RandomGenerator randomGenerator){
        this.randomGenerator = randomGenerator;

        cards = new ArrayList<Card>();
        cards.add(new Card(0));
        cards.add(new Card(0));
        cards.add(new Card(1));
        cards.add(new Card(1));
        cards.add(new Card(2));
        cards.add(new Card(2));
        cards.add(new Card(2));
        cards.add(new Card(3));
        cards.add(new Card(3));
        cards.add(new Card(3));
        cards.add(new Card(3));
        cards.add(new Card(4));
        cards.add(new Card(4));
        cards.add(new Card(4));
        cards.add(new Card(5));
        cards.add(new Card(5));
        cards.add(new Card(6));
        cards.add(new Card(6));
        cards.add(new Card(7));
        cards.add(new Card(8));
    }

    public Card giveRandomCard() {
        if (cards.size() > 0)
            return cards.remove(randomGenerator.getRandom(cards.size() - 1));

        return null;
    }
}
