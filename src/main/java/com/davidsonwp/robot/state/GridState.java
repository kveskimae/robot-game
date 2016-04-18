package com.davidsonwp.robot.state;

import com.davidsonwp.robot.command.CardinalDirection;

import static com.davidsonwp.robot.constants.Dimensions.TABLE_COLS_START;
import static com.davidsonwp.robot.constants.Dimensions.TABLE_ROWS_START;

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

}
