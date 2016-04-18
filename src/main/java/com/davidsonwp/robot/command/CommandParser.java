package com.davidsonwp.robot.command;

import java.text.ParseException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by kristjanveskimae on 18/04/16.
 */
public class CommandParser {

	private static final Map<CommandType, Pattern> patterns;

	static {
		patterns = new HashMap<CommandType, Pattern>();
		for (CommandType type : CommandType.values()) {
			Pattern pattern;
			if (CommandType.PLACE.equals(type)) {
				pattern = Pattern.compile(getPlaceCommandPatternString(), Pattern.MULTILINE);
			} else {
				pattern = Pattern.compile("^[\\s]*"+type.toString()+"[\\s]*$", Pattern.MULTILINE);
			}
			patterns.put(type, pattern);
		}
	}

	public static Command parseCommand(final String text) throws ParseException {
		for (CommandType key : patterns.keySet()) {
			if (patterns.get(key).matcher(text).matches()) {
				if (CommandType.PLACE.equals(key)) {
					return parsePlace(text);
				} else {
					return new Command(key);
				}
			}
		}
		throw new ParseException(text, 0);
	}

	private static Command parsePlace(final String text) {
		int placeStartIdx = text.indexOf(CommandType.PLACE.toString());
		int placeEndIdx = placeStartIdx + CommandType.PLACE.toString().length();
		String cut = text.substring(placeEndIdx);
		String[] tokens = cut.split(",");
		int x = Integer.parseInt(tokens[0].trim());
		int y = Integer.parseInt(tokens[1].trim());
		CardinalDirection direction = CardinalDirection.valueOf(tokens[2].trim());
		return new PlaceCommand(x, y, direction);
	}

	private static String getPlaceCommandPatternString() {
		StringBuilder sb = new StringBuilder();
		sb.append("^[\\s]*");
		sb.append(CommandType.PLACE);
		sb.append("[\\s]+");
		sb.append("\\d+");
		sb.append(',');
		sb.append("\\d+");
		sb.append(',');
		sb.append('(');
		Iterator<CardinalDirection> it = Arrays.asList(CardinalDirection.values()).iterator();
		while (it.hasNext()) {
			sb.append(it.next().toString());
			if (it.hasNext()) {
				sb.append('|');
			}
		}
		sb.append(')');
		sb.append("[\\s]*$");
		return sb.toString();
	}
}
