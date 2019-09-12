package com.md.tcg;

public class Card {
    private final int manaCost;

    public Card(int manaCost) {
        this.manaCost = manaCost;
    }

    public int getManaCost() { return manaCost; }

    @Override
    public String toString() {
        return "Card{" +
                "manaCost=" + manaCost +
                '}';
    }
}
