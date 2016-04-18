package com.davidsonwp.robot.command;

import com.davidsonwp.robot.Starter;

public class CommandHandler {

    private final Starter game;

    public CommandHandler(final Starter game) {
        this.game = game;
    }

    public void process(final Command command) {
        switch (command.getType()) {
            default:
                throw new IllegalArgumentException("Unkown command type: " + command.getType());
        }
    }

}
