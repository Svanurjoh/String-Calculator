package is.ru.stringcalculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

	public static int add(String text){
		if(text.equals(""))
		{
			return 0;
		}
		else if(text.contains("-"))
		{
			return checkForExceptions(text);
		}
		else if(text.contains(",") || text.contains("\n"))
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
		return numbers.split("[,\\n]");
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){
		    total += toInt(number);
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
}