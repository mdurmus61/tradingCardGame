package com.md.tcg;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ApplicationTest {
    private GameEngine gameEngine;
    private CommandReader commandReader;
    private RandomGenerator randomGenerator;
    private Player activePlayer;
    private Player opponentPlayer;

    @Before
    public void setUp() throws FileNotFoundException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("TestInput2.txt").getFile());
        System.setIn(new FileInputStream(file.getAbsolutePath()));

        Scanner scanner = new Scanner(file);
        commandReader = new CommandReader(scanner);
        randomGenerator = Mockito.mock(RandomGenerator.class);

        activePlayer = new Player("player1", new Deck(randomGenerator));
        opponentPlayer = new Player("player2", new Deck(randomGenerator));
        gameEngine = new GameEngine(commandReader, activePlayer, opponentPlayer);
    }

    @Test
    public void main_test() {
        for(int i = 1; i<=20; i++)
            Mockito.when(randomGenerator.getRandom(i)).thenReturn(0);

        Application.main(new String[0]);
    }
}
