package com.davidsonwp.robot.state;

import com.davidsonwp.robot.command.*;

import static com.davidsonwp.robot.constants.Dimensions.*;

/**
 * Created by kristjanveskimae on 18/04/16.
 */
public class GridState {

	private Integer x, y;

	private CardinalDirection direction;

	public GridState() {
	}

	public Integer getY() {
		return y;
	}

	private void setY(Integer y) {
		this.y = y;
	}

	public Integer getX() {
		return x;
	}

	private void setX(Integer x) {
		this.x = x;
	}

	public boolean isPlaced() {
		return y != null && x != null && direction != null;
	}

	private void setDirection(final CardinalDirection direction) {
		this.direction = direction;
	}

	public CardinalDirection getDirection() {
		return direction;
	}

	public Integer calculateAbsoluteX() {
		return TABLE_ROWS_START + getY();
	}

	public Integer calculateAbsoluteY() {
		return TABLE_COLS_START + getX();
	}

	public String buildReport() {
		StringBuilder sb = new StringBuilder();
		sb.append(getX()).append(',').append(getY()).append(',').append(getDirection());
		return sb.toString();
	}

	public void process(final Command command) throws IllegalCommandException {
		if (!isPlaced() && !CommandType.PLACE.equals(command.getType())) {
			throw new IllegalCommandException();
		}
		switch (command.getType()) {
			case PLACE:
				processPlaceCommand(command);
				break;
			case LEFT:
				setDirection(getDirection().rotate90DegLeft());
				break;
			case RIGHT:
				setDirection(getDirection().rotate90DegRight());
				break;
			case MOVE:
				processMoveCommand(command);
				break;
			case REPORT:
				// Handled separately
				break;
			default:
				throw new IllegalArgumentException("Unsupported command type: " + command.getType());
		}
	}

	private void processMoveCommand(final Command command) throws IllegalCommandException {
		int newX = getX(), newY = getY();
		switch (getDirection()) {
			case EAST:
				newX += 1;
				break;
			case WEST:
				newX -= 1;
				break;
			case NORTH:
				newY += 1;
				break;
			case SOUTH:
				newY -= 1;
				break;
			default:
				throw new IllegalArgumentException("Unsupported direction: " + getDirection());
		}
		if (isTableSquare(newX, newY)) {
			setX(newX);
			setY(newY);
		} else {
			throw new IllegalCommandException();
		}
	}

	private void processPlaceCommand(final Command command) throws IllegalCommandException {
		PlaceCommand placeCommand = (PlaceCommand) command;
		if (isTableSquare(placeCommand.getX(), placeCommand.getY())) {
			setX(placeCommand.getX());
			setY(placeCommand.getY());
			setDirection(placeCommand.getDirection());
		} else {
			throw new IllegalCommandException();
		}
	}

	public boolean isTableSquare(int x, int y) {
		return x >= 0 && x < TABLE_ROWS && y >= 0 && y < TABLE_COLS;
	}
}
