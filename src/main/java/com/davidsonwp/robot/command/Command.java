package com.davidsonwp.robot.command;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

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

}
