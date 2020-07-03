import java.util.Scanner;

import controller.SpeakingClockController;
import exception.TimeValueInputException;
import service.TimeConversionService;
import service.TimeConversionServiceImpl;
import validator.SpeakingClockValidator;

public class SpeakingClock {
	
	
	
	public static void main(String[] args) {
		SpeakingClockValidator validator = new SpeakingClockValidator();
		TimeConversionService service = new TimeConversionServiceImpl();
		
		SpeakingClockController controller = new SpeakingClockController(validator, service);
		
		String inputTimeString = "";
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please input a valid 24-hours time representation in \'HH:MM\' format: ");
		
		try {
	        // read the input
			inputTimeString = scanner.next();
			
			// validate time format
			validator.validateTimeString(inputTimeString);
			
			// print result
			System.out.print(controller.getVerbalTimeFromDigits(inputTimeString));
			
		 } catch (TimeValueInputException tex) {
			 System.out.print(tex.getMessage() + " Please provide a valid \'Time\' input in HH:MM format.");
		 } catch (RuntimeException rex) {
			 System.out.print("Failed to capture input.");
		 } finally {
			 scanner.close();
		}
		
	}

}
