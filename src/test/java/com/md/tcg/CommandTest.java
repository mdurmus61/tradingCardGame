package com.md.tcg;

import org.junit.Assert;
import org.junit.Test;

public class CommandTest {
    @Test
    public void play_command_test_fails() {
        Player activePlayer = new Player("player1", new Deck(new RandomGenerator()));
        Player opponentPlayer = new Player("player1", new Deck(new RandomGenerator()));

        activePlayer.setCurrentMana(2);
        opponentPlayer.setCurrentMana(2);

        PlayCommand command = new PlayCommand(-1);

        PlayerWrapper apw = new PlayerWrapper(activePlayer);
        PlayerWrapper opw = new PlayerWrapper(opponentPlayer);
        command.doCommand(apw, opw);

        Assert.assertEquals(2, activePlayer.getCurrentMana());
        Assert.assertEquals(30, opponentPlayer.getHealth());

        activePlayer.getCardsInHand().add(new Card(3));
        command.doCommand(apw, opw);

        Assert.assertEquals(2, activePlayer.getCurrentMana());
        Assert.assertEquals(30, opponentPlayer.getHealth());
    }

    @Test
    public void play_command_test_success() {
        Player activePlayer = new Player("player1", new Deck(new RandomGenerator()));
        Player opponentPlayer = new Player("player2", new Deck(new RandomGenerator()));

        activePlayer.setCurrentMana(4);
        activePlayer.getCardsInHand().add(new Card(3));

        PlayCommand command = new PlayCommand(0);

        PlayerWrapper apw = new PlayerWrapper(activePlayer);
        PlayerWrapper opw = new PlayerWrapper(opponentPlayer);
        command.doCommand(apw, opw);

        Assert.assertEquals(1, activePlayer.getCurrentMana());
        Assert.assertEquals(27, opponentPlayer.getHealth());
    }

    @Test
    public void pass_command_test() {
        Player activePlayer = new Player("player1", new Deck(new RandomGenerator()));
        Player opponentPlayer = new Player("player2", new Deck(new RandomGenerator()));

        PassCommand command = new PassCommand();

        PlayerWrapper apw = new PlayerWrapper(activePlayer);
        PlayerWrapper opw = new PlayerWrapper(opponentPlayer);
        command.doCommand(apw, opw);

        Assert.assertEquals("player2", apw.getPlayer().getName());
        Assert.assertEquals("player1", opw.getPlayer().getName());
    }

    @Test
    public void list_command_test() {
        Player activePlayer = new Player("player1", new Deck(new RandomGenerator()));
        Player opponentPlayer = new Player("player2", new Deck(new RandomGenerator()));

        activePlayer.getCardsInHand().add(activePlayer.drawCard());
        activePlayer.getCardsInHand().add(activePlayer.drawCard());
        activePlayer.getCardsInHand().add(activePlayer.drawCard());

        ListCommand command = new ListCommand();

        PlayerWrapper apw = new PlayerWrapper(activePlayer);
        PlayerWrapper opw = new PlayerWrapper(opponentPlayer);
        command.doCommand(apw, opw);

    }
}
