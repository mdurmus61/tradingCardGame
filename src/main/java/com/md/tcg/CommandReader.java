package com.md.tcg;

import java.util.Scanner;

public class CommandReader {
    private final Scanner scanner;

    private final static String LIST_COMMAND = "list";
    private final static String PLAY_COMMAND = "play";
    private final static String PASS_COMMAND = "pass";

    public CommandReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public String readNextCommand() {
        return scanner.nextLine();
    }

    public Command getCommand(String commandStr) {
        if (commandStr.equalsIgnoreCase(LIST_COMMAND)) {
            return new ListCommand();
        }
        else if(commandStr.startsWith(PLAY_COMMAND) || commandStr.startsWith(PLAY_COMMAND.toUpperCase())){
            return new PlayCommand(parsePlayCommand(commandStr));
        }
        else if(commandStr.equalsIgnoreCase(PASS_COMMAND)){
            return new PassCommand();
        }

        System.out.println("Wrong Command Input. Please Enter a New Command");
        return null;
    }

    public int parsePlayCommand(String command) {
        try {
            return Integer.valueOf(command.split(" ")[1]);
        } catch (Exception e) {
            return -1;
        }
    }
}
