package hangman;

import java.util.*;
 
 public class WordGenerator
 {
 		//create an ArrayList of String called myList
		ArrayList<String> myWordList; 
		
		public WordGenerator()
		{
			myWordList = new ArrayList<String>(Arrays.asList("monday", "tuesday", "wednesday", "thursday",
								"friday", "saturday", "sunday", "apple" , "banana", "pear", 
								"science", "computers", "engineering", "secret", "component", "button",
                        "encylopedia", "jazz", "fizz", "jinx", "programming", "java"));
		
		}
	    
		public  String getWord()
		{
			Random noGen = new Random();
			int wordIndex = noGen.nextInt(myWordList.size());
			return myWordList.get(wordIndex);

		}  
	
} 
