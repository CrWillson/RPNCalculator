package rpn;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Caleb Willson
 * @version 1.0
 * File: RpnCalculatorTest.java
 * Created: 2/16/23
 * 
 * JUnit tests for RpnCalculator.java
 * 
 */
public class RpnCalculatorTest {
    
    public RpnCalculatorTest() {
    }

    /**
     * Test a short calculation
     */
    @Test
    public void testCalculate() {
        String input = "23.3 5 16.2 + 8 * -";
        //String input = " ";
        
        double expected = -146.29999999999998;
        double output = RpnCalculator.calculate(input);
        assertEquals(expected, output);
    }
    
    /**
     * Test a longer calculation
     */
    @Test
    public void testLongerCalculate() {
        String input = "2.7 5 * 4 + 3.5 2.1 * 1 + / 23.3 5 16.2 + 8 * - +";
        // Equivalent to (((2.7*5)+4)/((3.5*2.1)+1))+(23.3-(5+16.2)*8) 
        
        double expected = -144.20419161676645;
        double output = RpnCalculator.calculate(input);
        assertEquals(expected, output);
    }
    
    /**
     * Test if calculate throws when an invalid symbol is given
     */
    @Test
    public void testInvalidSymbolException() {
        String input = "23.3 12 abc *";
        
        Exception exception = assertThrows(InvalidRPNString.class, () -> {
            RpnCalculator.calculate(input);
        });
        
        String expectedMessage = "Invalid symbol entered";
        String actualMessage = exception.getMessage();
        
        assertTrue(actualMessage.contains(expectedMessage));
    }
    
    /**
     * Test if calculate throws when it runs out of doubles
     */
    @Test
    public void testRanOutDoubleException() {
        String input = "24.5 *";
        
        Exception exception = assertThrows(InvalidRPNString.class, () -> {
            RpnCalculator.calculate(input);
        });
        
        String expectedMessage = "Ran out of doubles";
        String actualMessage = exception.getMessage();
        
        assertTrue(actualMessage.contains(expectedMessage));
    }
    
    /**
     * Test if calculate throws when it runs out of operators
     */
    @Test
    public void testRanOutOperatorException() {
        String input = "24.5 16 5.3 -";
        
        Exception exception = assertThrows(InvalidRPNString.class, () -> {
            RpnCalculator.calculate(input);
        });
        
        String expectedMessage = "Ran out of operators";
        String actualMessage = exception.getMessage();
        
        assertTrue(actualMessage.contains(expectedMessage));
    }
    
    /**
     * Test if calculate throws when it divides by zero
     */
    @Test
    public void testDivideByZeroException() {
        String input = "24.5 0 /";
        
        Exception exception = assertThrows(InvalidRPNString.class, () -> {
            RpnCalculator.calculate(input);
        });
        
        String expectedMessage = "Division by zero error";
        String actualMessage = exception.getMessage();
        
        assertTrue(actualMessage.contains(expectedMessage));
    }
    
    /**
     * Test if calculate throws when it is passed an empty string
     */
    @Test
    public void testEmptyStringException() {
        String input = " ";
        
        Exception exception = assertThrows(InvalidRPNString.class, () -> {
            RpnCalculator.calculate(input);
        });
        
        String expectedMessage = "Empty string entered error";
        String actualMessage = exception.getMessage();
        
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
