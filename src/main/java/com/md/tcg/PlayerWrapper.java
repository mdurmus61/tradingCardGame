package com.md.tcg;

public class PlayerWrapper {
    private Player player;

    public PlayerWrapper(Player player) {
        this.player = player;
    }

    public Player getPlayer() { return player; }

    public void setPlayer(Player player) { this.player = player; }
}
