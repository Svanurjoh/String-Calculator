package is.ru.stringcalculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

	public static int add(String text)
	{
		if(checkForNewline(text))
		{
			text = text.replace("\n",",");
		}
		
		if(text.equals(""))
		{
			return 0;
		}
		else if(text.contains("-"))
		{
			return checkForExceptions(text);
		}
		else if(checkForDelimiter(text))
		{
			return findDelimeter(text);
		}
		else if(text.contains(","))
		{
			return sum(splitNumbers(text));
		}
		else
		{
			return 1;
		}
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
		return numbers.split(",");
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){
			if(toInt(number) <= 1000)
			{
				total += toInt(number);
			}
		}
		return total;
    }
	
	private static int checkForExceptions(String message) 
	{
    	String[] numbers = splitNumbers(message);
    	int counter = 0;
    	List<Integer> negNumbs = new ArrayList<>();
    	for(String number : numbers)
		{
    		counter = toInt(number);
		    if(counter < 0)
			{
		    	negNumbs.add(counter);
			}
		}
		if(!negNumbs.isEmpty())
		{
			throw new IllegalArgumentException("Negatives not allowed: "+ negNumbs.toString());
		}
		return 1;
    }
	
	private static boolean checkForDelimiter(String message)
	{
        return(message.charAt(0) == '/' && message.charAt(1) == '/');
    }
	
	private static boolean checkForNewline(String message)
	{
		return(message.contains("\n"));
	}
	
	public static int findDelimeter(String message)
	{
		String delimiter = String.valueOf(message.charAt(2));
        message = message.substring(4, message.length());
        return sum(message.split(delimiter));
	}
}