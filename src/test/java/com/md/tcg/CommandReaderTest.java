package com.md.tcg;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

public class CommandReaderTest {
    @Test
    public void parse_fail_test() {
        Scanner scanner = new Scanner(System.in);
        CommandReader commandReader = new CommandReader(scanner);
        int index = commandReader.parsePlayCommand("PLAY 5");

        Assert.assertEquals(5, index);

        index = commandReader.parsePlayCommand("PLAY s");
        Assert.assertEquals(-1, index);
    }
}
