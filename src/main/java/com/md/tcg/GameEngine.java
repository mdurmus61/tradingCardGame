package com.md.tcg;

public class GameEngine {
    private final CommandReader commandReader;

    private Player activePlayer;
    private Player opponentPlayer;
    private PlayerWrapper apw;
    private PlayerWrapper opw;
    private boolean winCondition = false;

    public GameEngine(CommandReader commandReader, Player activePlayer, Player opponentPlayer){
        this.commandReader = commandReader;
        this.activePlayer = activePlayer;
        this.opponentPlayer = opponentPlayer;
        apw = new PlayerWrapper(activePlayer);
        opw = new PlayerWrapper(opponentPlayer);
    }

    public void start(){
        apw.getPlayer().drawInitialCards();
        opw.getPlayer().drawInitialCards();
        while(!winCondition)
            playRound();
    }


    private void playRound() {
        increaseManaSlot();
        Card drawnCard = apw.getPlayer().drawCard();
        checkBleedOut(drawnCard);
        checkOverload(drawnCard);
        processCommand();

    }

    private void processCommand() {
        String commandStr;
        Command command;

        do {
            System.out.print("Please enter command (LIST: List your card info, PLAY {card index}: Play card from your hand with given index, " +
                    "PASS: End turn ): ");
            apw.getPlayer().setCurrentMana(apw.getPlayer().getManaSlot());
            commandStr = commandReader.readNextCommand();
            command = commandReader.getCommand(commandStr);
            System.out.println(commandStr);
            if(command == null) {
                System.out.println("Wrong Command Input. Please Enter a New Command");
                continue;
            }
            command.doCommand(apw, opw);
            checkWinCondition();


        } while (!(command instanceof PassCommand) && !winCondition) ;
    }

    public void increaseManaSlot() {
        if (apw.getPlayer().getManaSlot() < 10)
            apw.getPlayer().setManaSlot(apw.getPlayer().getManaSlot() + 1);
    }

    public void checkWinCondition() {
        if(opw.getPlayer().getHealth() <= 0) {
            winCondition = true;
            System.out.println(apw.getPlayer().toString() + " win!!");
        }
    }

    public void checkBleedOut(Card drawnCard) {
        if(drawnCard == null) {
            apw.getPlayer().setHealth(apw.getPlayer().getHealth()- 1);
            System.out.println(apw.getPlayer().getName() + " 's card deck is empty. Receive 1 damage. ");
        }
    }

    public void checkOverload(Card drawnCard) {
        if(apw.getPlayer().getCardsInHand().size() >= 5) {
            System.out.println(apw.getPlayer().getName() + " 's cards in hand size become>5. The Card: "
                    + drawnCard.toString() + " is discarded.");
            return;
        }

        apw.getPlayer().addCard(drawnCard);
    }
}
