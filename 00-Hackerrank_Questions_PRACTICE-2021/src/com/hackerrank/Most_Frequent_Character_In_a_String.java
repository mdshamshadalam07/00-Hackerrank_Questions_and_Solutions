package com.hackerrank;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Most_Frequent_Character_In_a_String {
	
	    static final String TEST_CASE_1 = "Hello! Are you all fine? What are u doing today? Hey Guyz,Listen! I have a plan for today. Help!";
	    public static void main(String[] args) {
	    	Most_Frequent_Character_In_a_String test = new Most_Frequent_Character_In_a_String();
	        List<Character> result = test.maximumOccurringChars(TEST_CASE_1, true);
	        System.out.println(result);
	    }


	    public List<Character> maximumOccurringChars(String str) {
	        return maximumOccurringChars(str, false);
	    }

	    // set skipSpaces true if you want to skip spaces
	    public List<Character> maximumOccurringChars(String str, Boolean skipSpaces) {
	        Map<Character, Integer> map = new HashMap<>();
	        List<Character> occurrences = new ArrayList<>();
	        int maxOccurring = 0;

	        // creates map of all characters
	        for (int i = 0; i < str.length(); i++) {
	            char ch = str.charAt(i);

	            if (skipSpaces && ch == ' ')      // skips spaces if needed
	                continue;

	            if (map.containsKey(ch)) {
	                map.put(ch, map.get(ch) + 1);
	            } else {
	                map.put(ch, 1);
	            }

	            if (map.get(ch) > maxOccurring) {
	                maxOccurring = map.get(ch);         // saves max occurring
	            }
	        }

	        // finds all characters with maxOccurring and adds it to occurrences List
	        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
	            if (entry.getValue() == maxOccurring) {
	                occurrences.add(entry.getKey());
	            }
	        }

	        return occurrences;
	    }
}