package service;

import util.IntegerToWordConversionUtil;

public class TimeConversionServiceImpl implements TimeConversionService {

	public String convertToWord(String inputTimeString) {
		
		String[] splitTime = inputTimeString.split(":");
		
		int hour = Integer.parseInt(splitTime[0]);
		int minute = Integer.parseInt(splitTime[1]);
		
		return IntegerToWordConversionUtil.getWording(hour, minute);
		
	}

}
