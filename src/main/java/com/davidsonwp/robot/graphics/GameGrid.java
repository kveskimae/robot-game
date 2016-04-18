package com.davidsonwp.robot.graphics;

import com.davidsonwp.robot.Starter;
import com.davidsonwp.robot.constants.Colors;

import javax.swing.*;
import java.awt.*;

import static com.davidsonwp.robot.constants.Colors.GRID_BORDERS;
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
            int y = (row + 1) * GRID_PADDING + row * GRID_CELL_SIDE;
            Color cellColor = CellColorCalculator.getCellColor(row, column);
            if (isRobotLocation(row, column)) {
                cellColor = Colors.ROBOT_CELL;
            }
            g.setColor(cellColor);
            g.fillRect(x, y, GRID_CELL_SIDE, GRID_CELL_SIDE);
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
            if (starter.getGridState().getAbsoluteX().equals(row) && starter.getGridState().getAbsoluteY().equals(column)) {
                return true;
            }
        }
        return false;
    }
}
