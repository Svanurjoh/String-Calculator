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
	public void testWithNegNumb()
	{
	  try
	  {
		Calculator.add("-1,2");
	  }
	  catch(final IllegalArgumentException ex)
	  {
	    final String mess = "Negatives not allowed: [-1]";
	    assertEquals(mess, ex.getMessage());
	  }
	}
	
	@Test
	public void testWithTwoNegNumbs()
	{
	  try
	  {
		Calculator.add("2,-4,3,-5");
	  }
	  catch(final IllegalArgumentException ex)
	  {
	    final String mess = "Negatives not allowed: [-4, -5]";
	    assertEquals(mess, ex.getMessage());
	  }
	}
	
	@Test
	public void testNumberLargerThan1000(){
		assertEquals(2, Calculator.add("1337,2"));
	}
	
	@Test
	public void testNumberEquals1000(){
		assertEquals(1002, Calculator.add("1000,2"));
	}
	
	@Test
	public void testIfDelimeter() {
		assertEquals(3, Calculator.add("//;\n1;2"));
	}
}