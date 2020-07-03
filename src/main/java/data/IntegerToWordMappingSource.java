package data;

import java.util.HashMap;

/*
 * For simplicity, mappings are hard-coded in this class. These data should be moved to config files 
 * in real world application.
 */
public class IntegerToWordMappingSource {
	
	public static String getWordingForLowerUnits(int value) {
		
		final String[] lowerUnitsStrArray = { "", "One", "Two", "Three", "Four", "Five", "Six", 
                "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
                "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", 
                "Eighteen", "Nineteen" };
		
		return lowerUnitsStrArray[value];
	}
	
	public static String getWordingForTenUnits(int value) {
		
		final HashMap<Integer, String> tenUnitsMap = new HashMap<Integer, String>();
		tenUnitsMap.put(2, "Twenty");
		tenUnitsMap.put(3, "Thirty");
		tenUnitsMap.put(4, "Forty");
		tenUnitsMap.put(5, "Fifty");
		tenUnitsMap.put(6, "Sixty");
		
		return tenUnitsMap.get(value);
	}
}
