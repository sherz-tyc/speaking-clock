package validator;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import exception.TimeValueInputException;

public class SpeakingClockValidator {
	
	private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("HH:mm");
	
	public void validateTimeString(String inputTimeString) throws TimeValueInputException {
		
		try {
            this.dateFormatter.parse(inputTimeString);
        } catch (DateTimeParseException e) {
            throw new TimeValueInputException("Format of input time is not valid.");
        }
	}

}
