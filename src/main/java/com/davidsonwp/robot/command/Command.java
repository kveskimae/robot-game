package com.davidsonwp.robot.command;

import java.text.ParseException;

/**
 * Created by kristjanveskimae on 18/04/16.
 */
public class Command {

	private final CommandType type;

	public Command(final CommandType type) {
		this.type = type;
	}

	public CommandType getType() {
		return type;
	}

	public static Command parseCommand(final String text) throws ParseException {
		throw new ParseException(text, 0);
	}
}
