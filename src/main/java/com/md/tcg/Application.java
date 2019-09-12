package com.md.tcg;

import java.util.Scanner;

public class Application {
    public static void main(String[] args){
         Scanner scanner = new Scanner(System.in);
         RandomGenerator randomGenerator = new RandomGenerator();
         CommandReader commandReader = new CommandReader(scanner);
         System.out.print("Player 1 name: ");
         String playerName = commandReader.readNextCommand();
         Player player1 = new Player(playerName, new Deck(randomGenerator));
         System.out.print("Player 2 name: ");
         playerName = commandReader.readNextCommand();
         Player player2 = new Player(playerName, new Deck(randomGenerator));

         GameEngine gameEngine = new GameEngine(commandReader, player1, player2);
         gameEngine.start();

    }
}