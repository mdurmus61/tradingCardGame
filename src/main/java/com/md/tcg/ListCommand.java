package com.md.tcg;

public class ListCommand implements Command {
    @Override
    public void doCommand(PlayerWrapper apw, PlayerWrapper opw) {
        apw.getPlayer().listStatus();
    }
}
