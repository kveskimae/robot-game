package com.davidsonwp.robot.constants;


import java.awt.Dimension;

public interface Dimensions {

    int
            TABLE_ROWS = 5,
            TABLE_COLS = 5,
            GRID_ROWS = 7,
            GRID_COLUMNS = 7,
            TABLE_ROWS_START = 1,
            TABLE_COLS_START = 1,
            TABLE_ROWS_END = TABLE_ROWS_START + TABLE_ROWS -1,
            TABLE_COLS_END = TABLE_COLS_START + TABLE_COLS -1,
            GRID_CELL_SIDE = 40,
            GRID_PADDING = 2 + GRID_CELL_SIDE / 10,
            FEEDBACK_PANEL_INSET_TOP = 10,
            MAIN_PANEL_PADDING = 15;

    Dimension GRID_SIZE = new java.awt.Dimension(GRID_ROWS * GRID_CELL_SIDE + (GRID_ROWS + 1) * GRID_PADDING, GRID_COLUMNS * GRID_CELL_SIDE + (GRID_COLUMNS + 1) * GRID_PADDING),
            FEEDBACK_SIZE = new java.awt.Dimension(GRID_SIZE.width, GRID_SIZE.height / 2),
            COMMAND_INPUT_SIZE = new java.awt.Dimension(GRID_SIZE.width, GRID_SIZE.height / 4),
            MAIN_PANEL_SIZE = new Dimension(GRID_SIZE.width + 2 * MAIN_PANEL_PADDING, GRID_SIZE.height + (int)Math.round(1.5 * FEEDBACK_SIZE.height) + FEEDBACK_PANEL_INSET_TOP + 2 * MAIN_PANEL_PADDING);

}
