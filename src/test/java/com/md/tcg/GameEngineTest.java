package com.md.tcg;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GameEngineTest {
    private GameEngine gameEngine;
    private CommandReader commandReader;
    private RandomGenerator randomGenerator;
    private Player activePlayer;
    private Player opponentPlayer;
    private Scanner scanner;

    @Before
    public void setUp() throws FileNotFoundException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("TestInput.txt").getFile());
        System.setIn(new FileInputStream(file.getAbsolutePath()));

        scanner = new Scanner(file);
        commandReader = new CommandReader(scanner);
        randomGenerator = Mockito.mock(RandomGenerator.class);

        activePlayer = new Player("player1", new Deck(randomGenerator));
        opponentPlayer = new Player("player2", new Deck(randomGenerator));
        gameEngine = new GameEngine(commandReader, activePlayer, opponentPlayer);
    }

    @Test
    public void increase_mana_slot_test(){
        gameEngine.increaseManaSlot();
        Assert.assertEquals(1, activePlayer.getManaSlot());

        activePlayer.setManaSlot(5);
        gameEngine.increaseManaSlot();
        Assert.assertEquals(6, activePlayer.getManaSlot());

        activePlayer.setManaSlot(10);
        gameEngine.increaseManaSlot();
        Assert.assertEquals(10, activePlayer.getManaSlot());
    }

    @Test
    public void check_deck_size() {
        Deck deck = new Deck(randomGenerator);

        for(int i = 1; i<=20; i++)
            Mockito.when(randomGenerator.getRandom(i)).thenReturn(0);

        for(int i = 0 ; i<20; i++) {
            Card card = deck.giveRandomCard();
            Assert.assertNotNull(card);
        }

        Card card = deck.giveRandomCard();
        Assert.assertNull(card);

    }

    @Test
    public void check_bleed_out() {
        Card card = new Card(5);
        gameEngine.checkBleedOut(card);
        Assert.assertEquals(30, activePlayer.getHealth());

        gameEngine.checkBleedOut(null);
        Assert.assertEquals(29, activePlayer.getHealth());
    }

    @Test
    public void check_overload() {
        Card card = new Card(5);
        gameEngine.checkOverload(card);
        Assert.assertEquals(1, activePlayer.getCardsInHand().size());

        gameEngine.checkOverload(card);
        Assert.assertEquals(2, activePlayer.getCardsInHand().size());

        gameEngine.checkOverload(card);
        Assert.assertEquals(3, activePlayer.getCardsInHand().size());

        gameEngine.checkOverload(card);
        Assert.assertEquals(4, activePlayer.getCardsInHand().size());

        gameEngine.checkOverload(card);
        Assert.assertEquals(5, activePlayer.getCardsInHand().size());

        gameEngine.checkOverload(card);
        Assert.assertEquals(5, activePlayer.getCardsInHand().size());
    }

    @Test
    public void player1_wins() {
        for(int i = 1; i<=20; i++)
            Mockito.when(randomGenerator.getRandom(i)).thenReturn(0);

        gameEngine.start();
    }

}
