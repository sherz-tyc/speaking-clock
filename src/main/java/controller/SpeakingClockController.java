package controller;

import exception.TimeValueInputException;
import service.TimeConversionService;
import validator.SpeakingClockValidator;

/*
 * Entry point for this micro-service application. De-coupled from the medium which provides the input value via
 * Console or API or any medium. Console was chosen for this demonstration.
 */
public class SpeakingClockController {
	
	SpeakingClockValidator validator;
	TimeConversionService timeConversionService;
	
	/* Constructor injection is used here for simplicity of this demo.
	 * Dependency injection via @Autowired would be a more sensible choice if Spring is in use.
	 */
	public SpeakingClockController(SpeakingClockValidator validator, TimeConversionService timeConversionService) {
		this.validator = validator;
		this.timeConversionService = timeConversionService;
	}

	public String getVerbalTimeFromDigits(String inputTimeString) throws TimeValueInputException {
		// validate
		validator.validateTimeString(inputTimeString);
		
		return timeConversionService.convertToWord(inputTimeString);
	}
}
