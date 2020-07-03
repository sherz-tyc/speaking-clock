import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import controller.SpeakingClockController;
import exception.TimeValueInputException;
import service.TimeConversionService;
import service.TimeConversionServiceImpl;
import validator.SpeakingClockValidator;

public class SpeakingClockTest {
	
	// Test from controller as entry point.
	SpeakingClockController controller;
	
	@Before
	public void setUp() {
		SpeakingClockValidator validator = new SpeakingClockValidator();
		TimeConversionService service = new TimeConversionServiceImpl();
		
		controller = new SpeakingClockController(validator, service);
	}
	
	@Test
	public void given0834AsInput_expectEightThirtyFour() {
		String inputTimeString = "08:34";
		String expected = "It\'s Eight Thirty Four";
		String actual = controller.getVerbalTimeFromDigits(inputTimeString);
		
		assertEquals(expected, actual);
	}

	@Test
	public void given2157AsInput_expectEightThirtyFour() {
		String inputTimeString = "21:57";
		String expected = "It\'s Twenty One Fifty Seven";
		String actual = controller.getVerbalTimeFromDigits(inputTimeString);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void given1200AsInput_expectMidday() {
		String inputTimeString = "12:00";
		String expected = "It\'s Midday";
		String actual = controller.getVerbalTimeFromDigits(inputTimeString);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void given0000AsInput_expectMidnight() {
		String inputTimeString = "00:00";
		String expected = "It\'s Midnight";
		String actual = controller.getVerbalTimeFromDigits(inputTimeString);
		
		assertEquals(expected, actual);
	}	
	
	@Test
	public void given0023AsInput_expectMidnight() {
		String inputTimeString = "00:23";
		String expected = "It\'s Twenty Three Minutes Past Midnight";
		String actual = controller.getVerbalTimeFromDigits(inputTimeString);
		
		assertEquals(expected, actual);
	}	
	
	@Test(expected = TimeValueInputException.class)
	public void givenInvalidBlankInput_expectExpectionThrown() {
		String inputTimeString = "";
		controller.getVerbalTimeFromDigits(inputTimeString);
	}
	
	@Test(expected = TimeValueInputException.class)
	public void givenInvalidInputOfOnlyNumbers_expectExpectionThrown() {
		String inputTimeString = "1230";
		controller.getVerbalTimeFromDigits(inputTimeString);
	}
	
	@Test(expected = TimeValueInputException.class)
	public void givenInvalidTimeInput_expectExpectionThrown() {
		String inputTimeString = "12:30:20";
		controller.getVerbalTimeFromDigits(inputTimeString);
	}
	
	@Test(expected = TimeValueInputException.class)
	public void givenInvalidTimeInputOf2460_expectExpectionThrown() {
		String inputTimeString = "24:60";
		controller.getVerbalTimeFromDigits(inputTimeString);
		
	}
	
	@Test(expected = TimeValueInputException.class)
	public void givenInvalidTimeInputOfTexts_expectExpectionThrown() {
		String inputTimeString = "Example";
		controller.getVerbalTimeFromDigits(inputTimeString);
		
	}
	
}
