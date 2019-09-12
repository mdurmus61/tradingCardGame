package com.md.tcg;

public class PassCommand implements Command {
    @Override
    public void doCommand(PlayerWrapper apw, PlayerWrapper opw) {
        Player temp = apw.getPlayer();
        apw.setPlayer(opw.getPlayer());
        opw.setPlayer(temp);
        System.out.println("Active Player: " + apw.getPlayer().getName());
    }
}
