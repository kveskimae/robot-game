package com.davidsonwp.robot.graphics;

import com.davidsonwp.robot.constants.Dimensions;
import com.davidsonwp.robot.constants.Colors;

import java.awt.Color;

public class CellColorCalculator {

    public static Color getCellColor(final int row, final int column) {
        if (isInVisibleArea(row, column)) {
            return Colors.TABLE;
        }
        return Colors.FLOOR;
    }

    private static boolean isInVisibleArea(final int row, final int column) {
        if (row >= Dimensions.TABLE_ROWS_START && row <= Dimensions.TABLE_ROWS_END) {
            if (column >= Dimensions.TABLE_COLS_START && column <= Dimensions.TABLE_COLS_END) {
                return true;
            }
        }
        return false;
    }

}
