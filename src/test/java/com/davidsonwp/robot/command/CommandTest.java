package com.davidsonwp.robot.command;

import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by kristjanveskimae on 18/04/16.
 */
public class CommandTest {

	@Test(expected = ParseException.class)
	public void testParseInvalid() throws ParseException {
		CommandParser.parseCommand("INVALID");
	}

	@Test
	public void testParseMove() throws ParseException {
		Command result = CommandParser.parseCommand("MOVE");
		assertNotNull(result);
		assertEquals(CommandType.MOVE, result.getType());
	}

	@Test
	public void testParseLeft() throws ParseException {
		Command result = CommandParser.parseCommand("LEFT");
		assertNotNull(result);
		assertEquals(CommandType.LEFT, result.getType());
	}

	@Test
	public void testParseRight() throws ParseException {
		Command result = CommandParser.parseCommand("RIGHT");
		assertNotNull(result);
		assertEquals(CommandType.RIGHT, result.getType());
	}

	@Test
	public void testParseReport() throws ParseException {
		Command result = CommandParser.parseCommand("REPORT");
		assertNotNull(result);
		assertEquals(CommandType.REPORT, result.getType());
	}

	@Test
	public void testParsePlace() throws ParseException {
		Command result = CommandParser.parseCommand("PLACE 1,2,EAST");
		assertNotNull(result);
		assertEquals(CommandType.PLACE, result.getType());
		PlaceCommand placeCommand = (PlaceCommand)result;
		assertEquals(CardinalDirection.EAST, placeCommand.getDirection());
		assertEquals(1, placeCommand.getX());
		assertEquals(2, placeCommand.getY());
	}

	@Test(expected = ParseException.class)
	public void testParsePlaceWithInvalidCardinalDirection() throws ParseException {
		CommandParser.parseCommand("PLACE 1,2,SOUTHEAST");
	}

	@Test(expected = ParseException.class)
	public void testParsePlaceWithInvalidX() throws ParseException {
		CommandParser.parseCommand("PLACE -1,2,EAST");
	}

	@Test(expected = ParseException.class)
	public void testParsePlaceWithInvalidY() throws ParseException {
		CommandParser.parseCommand("PLACE 1,s,EAST");
	}

}
