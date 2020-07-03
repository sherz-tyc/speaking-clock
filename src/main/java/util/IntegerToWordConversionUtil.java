package util;

import data.IntegerToWordMappingSource;
import exception.WordingConversionException;

public class IntegerToWordConversionUtil {
	
	private static final String PREFIX_MSG = "It\'s ";
	private static final String PREFIX_SINGLE_DIGIT = "O ";
	private static final String STRING_SPACE = " ";
	
	
	private static final String MIDDAY = "Midday";
	private static final String MIDNIGHT = "Midnight";
	private static final String MINS_PAST_MIDNIGHT = " Minutes Past ";
	
	public static String getWording(int hour, int minute) throws WordingConversionException {
		
		if (hour > 23 || hour < 0 || minute > 59 || minute < 0) {
			throw new WordingConversionException(String.format("Unable to convert value %d:%d into word.", hour, minute));
		}
		
		if (hour == 12 && minute == 0) {
			// 12 noon
			return PREFIX_MSG + MIDDAY;
		} else if (hour == 0) {
			
			// N minutes past midnight
			if (minute > 0) {
				return PREFIX_MSG + getMinuteWording(minute) + MINS_PAST_MIDNIGHT + MIDNIGHT;
			} else {
				return PREFIX_MSG + MIDNIGHT;
			}
		}
		
		StringBuilder result = new StringBuilder(PREFIX_MSG);
		result.append(intToWording(hour));
		result.append(STRING_SPACE);
		result.append(getMinuteWording(minute));
		
		return result.toString();
	}
	
	private static String getMinuteWording(int minute) {
		// e.g. The minute in 12:04 is pronounced as 'O Four'
		if (minute < 10) {
			return PREFIX_SINGLE_DIGIT + intToWording(minute);
		} else {
			return intToWording(minute);
		}
	}
	
	private static String intToWording(int value) {
		
		StringBuilder verbalInteger = new StringBuilder();
		if (value < 20) {
			return IntegerToWordMappingSource.getWordingForLowerUnits(value);
		} else {
			verbalInteger.append(IntegerToWordMappingSource.getWordingForTenUnits(value / 10));
			if (value % 10 > 0) {
				verbalInteger.append(STRING_SPACE + IntegerToWordMappingSource.getWordingForLowerUnits(value % 10));
			}
			return verbalInteger.toString();
		}
	}

}
