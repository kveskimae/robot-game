package com.davidsonwp.robot.graphics;

import com.davidsonwp.robot.Starter;
import com.davidsonwp.robot.constants.Colors;

import javax.swing.*;
import java.awt.*;

import static com.davidsonwp.robot.constants.Colors.*;
import static com.davidsonwp.robot.constants.Dimensions.*;

public class GameGrid {

    private final Starter starter;

    private JPanel panel = new JPanel() {

        @Override
        public void paint(final Graphics g) {
            paintGridBackground(g);
            for (int row = 0; row < GRID_ROWS; row++) {
                for (int column = 0; column < GRID_COLUMNS; column++) {
                    paintCell(g, row, column);
                }
            }
        }

        private void paintCell(final Graphics g, final int row, final int column) {
            int x = (column + 1) * GRID_PADDING + column * GRID_CELL_SIDE;
            int y = GRID_SIZE.height - ((row + 1) * GRID_PADDING + (row + 1) * GRID_CELL_SIDE);
            Color cellColor;
            boolean isRobotLocation = isRobotLocation(row, column);
            if (isRobotLocation) {
                cellColor = Colors.ROBOT_CELL;
            } else {
                cellColor = CellColorCalculator.getCellColor(row, column);
            }
            g.setColor(cellColor);
            g.fillRect(x, y, GRID_CELL_SIDE, GRID_CELL_SIDE);
            if (isRobotLocation) {
                g.setColor(ARROW_COLOR);
                Polygon polygon = new Polygon();
                int x1, y1, x2, y2, x3, y3;
                int halfCell = GRID_CELL_SIDE / 2;
                switch (starter.getGridState().getDirection()) {
                    case NORTH:
                    case SOUTH:
                        x1 = x;
                        x2 = x + GRID_CELL_SIDE;
                        y1 = y2 = y + halfCell;
                        break;
                    case EAST:
                    case WEST:
                        y1 = y;
                        y2 = y + GRID_CELL_SIDE;
                        x1 = x2 = x + halfCell;
                        break;
                    default:
                        throw new IllegalArgumentException("Unsupported direction: " + starter.getGridState().getDirection());
                }
                switch (starter.getGridState().getDirection()) {
                    case NORTH:
                        x3 = x + halfCell;
                        y3 = y;
                        break;
                    case SOUTH:
                        x3 = x + halfCell;
                        y3 = y + GRID_CELL_SIDE;
                        break;
                    case EAST:
                        x3 = x + GRID_CELL_SIDE;
                        y3 = y + halfCell;
                        break;
                    case WEST:
                        x3 = x;
                        y3 = y + halfCell;
                        break;
                    default:
                        throw new IllegalArgumentException("Unsupported direction: " + starter.getGridState().getDirection());
                }
                polygon.addPoint(x1, y1);
                polygon.addPoint(x2, y2);
                polygon.addPoint(x3, y3);
                g.fillPolygon(polygon);
            }
        }

        private void paintGridBackground(final Graphics g) {
            g.setColor(GRID_BORDERS);
            g.fillRect(0, 0, GRID_SIZE.width, GRID_SIZE.height);
        }

    };

    public GameGrid(final Starter starter) {
        this.starter = starter;
        setSize();
    }

    private void setSize() {
        panel.setMinimumSize(GRID_SIZE);
        panel.setSize(GRID_SIZE);
        panel.setMaximumSize(GRID_SIZE);
        panel.setPreferredSize(GRID_SIZE);
    }

    public JPanel getPanel() {
        return panel;
    }

    public boolean isRobotLocation(final int row, final int column) {
        if (starter.getGridState().isPlaced()) {
            if (starter.getGridState().calculateAbsoluteX().equals(row) && starter.getGridState().calculateAbsoluteY().equals(column)) {
                return true;
            }
        }
        return false;
    }
}
