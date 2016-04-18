package com.davidsonwp.robot.state;

import com.davidsonwp.robot.command.*;
import org.junit.Before;
import org.junit.Test;

import static com.davidsonwp.robot.constants.Dimensions.TABLE_COLS;
import static com.davidsonwp.robot.constants.Dimensions.TABLE_ROWS;
import static org.junit.Assert.assertEquals;

/**
 * Created by kristjanveskimae on 18/04/16.
 */
public class GridStateTest {

	private GridState state;

	@Before
	public void initializeState() {
		state = new GridState();
	}

	@Test(expected = IllegalCommandException.class)
	public void testMoveWithoutPlace() throws IllegalCommandException {
		state.process(new Command(CommandType.MOVE));
	}

	@Test(expected = IllegalCommandException.class)
	public void testLeftWithoutPlace() throws IllegalCommandException {
		state.process(new Command(CommandType.LEFT));
	}

	@Test(expected = IllegalCommandException.class)
	public void testIllegalPlaceWithNeg() throws IllegalCommandException {
		state.process(new PlaceCommand(-1, 1, CardinalDirection.NORTH));
	}

	@Test(expected = IllegalCommandException.class)
	public void testIllegalPlaceOutside() throws IllegalCommandException {
		state.process(new PlaceCommand(1, TABLE_COLS, CardinalDirection.NORTH));
	}

	@Test
	public void testCorretPlaceOnCorner() throws IllegalCommandException {
		state.process(new PlaceCommand(TABLE_ROWS - 1, TABLE_COLS - 1, CardinalDirection.NORTH));
		assertEquals(new Integer(TABLE_ROWS - 1), state.getY());
		assertEquals(new Integer(TABLE_COLS - 1), state.getX());
	}

	@Test
	public void testLegalMoveDownFromCorner() throws IllegalCommandException {
		state.process(new PlaceCommand(TABLE_ROWS - 1, TABLE_COLS - 1, CardinalDirection.SOUTH));
		state.process(new Command(CommandType.MOVE));
		assertEquals(new Integer(TABLE_COLS - 1), state.getX());
		assertEquals(new Integer(TABLE_ROWS - 2), state.getY());
	}

	@Test(expected = IllegalCommandException.class)
	public void testIllegalMoveUpFromCorner() throws IllegalCommandException {
		state.process(new PlaceCommand(TABLE_ROWS - 1, TABLE_COLS - 1, CardinalDirection.NORTH));
		state.process(new Command(CommandType.MOVE));
	}

	@Test
	public void testLegalMoveUpFromZero() throws IllegalCommandException {
		state.process(new PlaceCommand(0, 0, CardinalDirection.NORTH));
		state.process(new Command(CommandType.MOVE));
		assertEquals(new Integer(0), state.getX());
		assertEquals(new Integer(1), state.getY());
	}

	@Test(expected = IllegalCommandException.class)
	public void testIllegalMoveLeftFromZero() throws IllegalCommandException {
		state.process(new PlaceCommand(0, 0, CardinalDirection.WEST));
		state.process(new Command(CommandType.MOVE));
	}

	@Test(expected = IllegalCommandException.class)
	public void testIllegalReport() throws IllegalCommandException {
		state.process(new Command(CommandType.REPORT));
	}

	@Test
	public void testBuildReportWithExampleC() throws IllegalCommandException {
		state.process(new PlaceCommand(1, 2, CardinalDirection.EAST));
		state.process(new Command(CommandType.MOVE));
		state.process(new Command(CommandType.MOVE));
		state.process(new Command(CommandType.LEFT));
		state.process(new Command(CommandType.MOVE));
		assertEquals("3,3,NORTH", state.buildReport());

	}

}
