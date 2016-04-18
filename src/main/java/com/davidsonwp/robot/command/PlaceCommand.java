package com.davidsonwp.robot.command;

public class PlaceCommand extends Command {

    private final int x, y;
    private final CardinalDirection direction;

    public PlaceCommand(final int x, final int y, final CardinalDirection direction) {
        super(CommandType.PLACE);
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public CardinalDirection getDirection() {
        return direction;
    }
}
