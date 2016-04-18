package com.davidsonwp.robot.command;

public enum CardinalDirection {

    NORTH, SOUTH, EAST, WEST;

	public CardinalDirection rotate90DegLeft() {
		switch (this) {
			case EAST:
				return NORTH;
			case NORTH:
				return WEST;
			case WEST:
				return SOUTH;
			case SOUTH:
				return EAST;
			default:
				throw new IllegalArgumentException("Unsupported direction type: " + this);
		}
	}

	public CardinalDirection rotate90DegRight() {
		switch (this) {
			case EAST:
				return SOUTH;
			case NORTH:
				return EAST;
			case WEST:
				return NORTH;
			case SOUTH:
				return WEST;
			default:
				throw new IllegalArgumentException("Unsupported direction type: " + this);
		}
	}
}
