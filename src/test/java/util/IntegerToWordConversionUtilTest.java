package util;

import static org.junit.Assert.assertEquals;  
import org.junit.Test;

import exception.WordingConversionException;

public class IntegerToWordConversionUtilTest {
	
	@Test
	public void given12h00m_expectOutputOfMidday() {
		int hour = 12;
		int minute = 0;
		String expected = "It\'s Midday";
		String actual = IntegerToWordConversionUtil.getWording(hour, minute);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void given00h00m_expectOutputOfMidnight() {
		int hour = 0;
		int minute = 0;
		String expected = "It\'s Midnight";
		String actual = IntegerToWordConversionUtil.getWording(hour, minute);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void given00h23m_expectOutputOfTwentyThreeMinutesPastMidnight() {
		int hour = 0;
		int minute = 23;
		String expected = "It\'s Twenty Three Minutes Past Midnight";
		String actual = IntegerToWordConversionUtil.getWording(hour, minute);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void given08h34m_expectOutputOfEightThirtyFour() {
		int hour = 8;
		int minute = 34;
		String expected = "It\'s Eight Thirty Four";
		String actual = IntegerToWordConversionUtil.getWording(hour, minute);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void given12h04m_expectOutputOfTwelveOFour() {
		int hour = 12;
		int minute = 04;
		String expected = "It\'s Twelve O Four";
		String actual = IntegerToWordConversionUtil.getWording(hour, minute);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void given17h20m_expectOutputOfSeventeenTwenty() {
		int hour = 17;
		int minute = 20;
		String expected = "It\'s Seventeen Twenty";
		String actual = IntegerToWordConversionUtil.getWording(hour, minute);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void given23h59m_expectOutputOfSeventeenTwenty() {
		int hour = 23;
		int minute = 59;
		String expected = "It\'s Twenty Three Fifty Nine";
		String actual = IntegerToWordConversionUtil.getWording(hour, minute);
		
		assertEquals(expected, actual);
	}
	
	@Test(expected = WordingConversionException.class)
	public void given22h60m_expectOutputOfSeventeenTwenty() {
		int hour = 23;
		int minute = 60;
		IntegerToWordConversionUtil.getWording(hour, minute);
	}
	
	@Test(expected = WordingConversionException.class)
	public void given26h59m_expectExceptionThrown() {
		int hour = 24;
		int minute = 59;
		IntegerToWordConversionUtil.getWording(hour, minute);
	}
	
	@Test(expected = WordingConversionException.class)
	public void givenNegativeIntegers_expectExceptionThrown() {
		int hour = -12;
		int minute = -30;
		IntegerToWordConversionUtil.getWording(hour, minute);
	}
	
	@Test(expected = WordingConversionException.class)
	public void givenHugeIntegers_expectExceptionThrown() {
		int hour = 120000;
		int minute = 320000;
		IntegerToWordConversionUtil.getWording(hour, minute);
	}

}
