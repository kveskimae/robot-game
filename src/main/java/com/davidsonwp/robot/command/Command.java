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

	public String getSuccessMessage() {
		switch (type) {
			case LEFT:
				return "Rotated 90 deg left";
			case RIGHT:
				return "Rotated 90 deg right";
			case MOVE:
				return "Moved one square";
			case PLACE:
				return "Placed on row " + ((PlaceCommand)this).getX() + " and column " + ((PlaceCommand)this).getY() + ", facing " + ((PlaceCommand)this).getDirection();
			default:
				throw new IllegalArgumentException("Unsupported command type: " + type);
		}
	}
}
