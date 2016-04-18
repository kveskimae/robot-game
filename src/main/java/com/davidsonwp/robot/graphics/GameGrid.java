package com.davidsonwp.robot.graphics;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

import static com.davidsonwp.robot.constants.Dimensions.*;
import static com.davidsonwp.robot.constants.Colors.*;

public class GameGrid {

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
            g.setColor(cellColor);
            g.fillRect(x, y, GRID_CELL_SIDE, GRID_CELL_SIDE);
        }

        private void paintGridBackground(final Graphics g) {
            g.setColor(GRID_BORDERS);
            g.fillRect(0, 0, GRID_SIZE.width, GRID_SIZE.height);
        }
    };
    private final MainPanel mainPanel;

    public GameGrid(final MainPanel mainPanel) {
        this.mainPanel = mainPanel;
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

}
