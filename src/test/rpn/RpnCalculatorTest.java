/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package rpn;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Caleb Willson
 */
public class RpnCalculatorTest {
    
    public RpnCalculatorTest() {
    }

    /**
     * Test of calculate method, of class RpnCalculator.
     */
    @Test
    public void testCalculate() {
        String input = "23.3 5 16.2 + 8 * -";
        //String input = " ";
        
        double expected = -146.29999999999998;
        double output = RpnCalculator.calculate(input);
        assertEquals(expected, output);
    }
    
    @Test
    public void testLongerCalculate() {
        String input = "2.7 5 * 4 + 3.5 2.1 * 1 + / 23.3 5 16.2 + 8 * - +";
        // Equivalent to (((2.7*5)+4)/((3.5*2.1)+1))+(23.3-(5+16.2)*8) 
        
        double expected = -144.20419161676645;
        double output = RpnCalculator.calculate(input);
        assertEquals(expected, output);
    }
    
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
