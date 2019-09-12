package com.md.tcg;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final String name;
    private final Deck deck;
    private final List<Card> cardsInHand;
    private int health;
    private int manaSlot;
    private int currentMana;

    public Player(String name, Deck deck){
        this.name = name;
        this.deck = deck;
        this.health = 30;
        this.manaSlot = 0;
        this.currentMana = 0;
        this.cardsInHand = new ArrayList<>();
    }

    public Card drawCard() {
        return deck.giveRandomCard();
    }

    public String listCardsInHand() {
        String cards = "" ;
        for(int i = 0 ; i< cardsInHand.size(); i++)
            cards += ("Index:" + i + " , " + cardsInHand.get(i).toString() + "\n");

        return cards;
    }

    public void addCard(Card card) {
        cardsInHand.add(card);
    }

    public void drawInitialCards() {
        cardsInHand.add(drawCard());
        cardsInHand.add(drawCard());
        cardsInHand.add(drawCard());
    }

    public String getName() { return name; }

    public int getHealth() { return health; }

    public void setHealth(int health) { this.health = health; }

    public int getManaSlot() { return manaSlot; }

    public void setManaSlot(int manaSlot) { this.manaSlot = manaSlot; }

    public List<Card> getCardsInHand() { return cardsInHand; }

    public int getCurrentMana() { return currentMana; }

    public void setCurrentMana(int currentMana) { this.currentMana = currentMana; }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", manaSlot=" + manaSlot  + " ";
    }

    public void listStatus() {
        System.out.println("Health: "  +  getHealth() + " ,Current mana: " + currentMana + " , List cards in hand: \n" + listCardsInHand());
    }

    public void playCard(int index) {
        cardsInHand.remove(index);
    }
}
