package com.davidsonwp.robot.command;

import com.davidsonwp.robot.Starter;

public class CommandHandler {

    private final Starter game;

    public CommandHandler(final Starter game) {
        this.game = game;
    }

    public void process(final Command command) {
        try {
            game.getGridState().process(command);
            game.repaintGrid();
            game.addText(command.getSuccessMessage());
        } catch (IllegalCommandException e) {
            game.addText("This is not allowed");
        }
    }

}
