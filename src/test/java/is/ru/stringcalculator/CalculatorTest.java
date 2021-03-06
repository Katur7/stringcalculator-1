package is.ru.stringcalculator;

import static org.junit.Assert.*;
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
	public void testOne() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwo() {
		assertEquals(3, Calculator.add("1,2"));
	}

	@Test
	public void testForArbitraryInput() {
		assertEquals(13, Calculator.add("1,2,4,6"));
	}

	@Test
	public void testSplitOnNewline() {
		assertEquals(13, Calculator.add("1,2\n4\n6"));
	}

	@Test
	public void testArbitraryDelimitor() {
		assertEquals(13, Calculator.add("//;\n1,2;4\n6"));
	}

	@Test
	public void testArbitraryDelimitor2() {
		assertEquals(13, Calculator.add("//tt\n1,2tt4\n6"));
	}

	@Test (expected = IllegalArgumentException.class)
	public void testCatchEmAll() {
	    // act
	    Calculator.add("-1,-2,3");
	}

	@Test
	public void testOver9000() {
		assertEquals(2, Calculator.add("9000,2"));
	}

	@Test
	public void testArbitraryMultipleDelimitor() {
		assertEquals(10, Calculator.add("//***%%%%$$+\n1***2+3%4"));
	}
}