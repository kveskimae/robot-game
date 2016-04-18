package com.davidsonwp.robot.state;

import com.davidsonwp.robot.command.CardinalDirection;
import com.davidsonwp.robot.command.Command;
import com.davidsonwp.robot.command.IllegalCommandException;
import com.davidsonwp.robot.command.PlaceCommand;

import static com.davidsonwp.robot.constants.Dimensions.*;

/**
 * Created by kristjanveskimae on 18/04/16.
 */
public class GridState {

	private Integer x, y;

	private CardinalDirection direction;

	public GridState() {
	}

	public Integer getRelativeX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getRelativeY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}

	public boolean isPlaced() {
		return x != null && y != null && direction != null;
	}

	public void setDirection(final CardinalDirection direction) {
		this.direction = direction;
	}

	public CardinalDirection getDirection() {
		return direction;
	}

	public Integer getAbsoluteX() {
		return TABLE_ROWS_START + getRelativeX();
	}

	public Integer getAbsoluteY() {
		return TABLE_COLS_START + getRelativeY();
	}

	public void process(final Command command) throws IllegalCommandException {
		switch (command.getType()) {
			case PLACE:
				PlaceCommand placeCommand = (PlaceCommand) command;
				if (placeCommand.getX() >= 0 && placeCommand.getX() < TABLE_ROWS && placeCommand.getY() >= 0 && placeCommand.getY() < TABLE_COLS) {
					setX(placeCommand.getX());
					setY(placeCommand.getY());
					setDirection(placeCommand.getDirection());
				} else {
					throw new IllegalCommandException();
				}
				break;
			default:
				throw new IllegalArgumentException("Unsupported command type: " + command.getType());
		}
	}
}
