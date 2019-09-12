package com.md.tcg;

public class PlayCommand implements Command {
    private final int index;

    public PlayCommand(int index) {
        this.index = index;
    }

    @Override
    public void doCommand(PlayerWrapper apw, PlayerWrapper opw) {
        if(index < 0 || index > apw.getPlayer().getCardsInHand().size()) {
            System.out.println("PLAY command card index is invalid. Please Enter a New Command");
            return;
        }

        if(apw.getPlayer().getCurrentMana() < apw.getPlayer().getCardsInHand().get(index).getManaCost()) {
            System.out.println("Not Enough Mana. Please Enter a New Command");
            return;
        }

        apw.getPlayer().setCurrentMana(apw.getPlayer().getCurrentMana()- apw.getPlayer().getCardsInHand().get(index).getManaCost());
        opw.getPlayer().setHealth(opw.getPlayer().getHealth() - apw.getPlayer().getCardsInHand().get(index).getManaCost());
        apw.getPlayer().playCard(index);
    }
}
