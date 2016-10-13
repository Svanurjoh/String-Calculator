package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}	

	@Test
    public void testMultipleNumbers(){
    	assertEquals(6, Calculator.add("1,2,3"));
    }
	
	@Test
	public void testNumbWithNewline() {
		assertEquals(3, Calculator.add("1\n2"));
	}

	@Test
	public void testWithNewlineAndComma() {
		assertEquals(3, Calculator.add("0,1\n2"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void checkForNegNumbs() {
		Calculator.add("-1,2");
	}
	
	@Test
	public void displayErrorNumbersWithNegNumb() {
		try
		{
			Calculator.add("-1, 1");
		}
		catch(final IllegalArgumentException exception)
		{
			final String mess = "Negatives not allowed: -1";
			assertEquals(mess, exception.getMessage());
		}
	}
}