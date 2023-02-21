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
     * Test the + operator
     */
    @Test
    public void testAdd() {
        String input = "2 3 +";
        
        double expected = 5;
        double output = RpnCalculator.calculate(input);
        assertEquals(expected, output);
    }
    
    /**
     * Test the - operator
     */
    @Test
    public void testSubtract() {
        String input = "5 2 -";
        
        double expected = 3;
        double output = RpnCalculator.calculate(input);
        assertEquals(expected, output);
    }
    
    /**
     * Test the * operator
     */
    @Test
    public void testMultiply() {
        String input = "5 3 *";

        double expected = 15;
        double output = RpnCalculator.calculate(input);
        assertEquals(expected, output);
    }
    
    /**
     * Test the / operator
     */
    @Test
    public void testDivide() {
        String input = "20 4 /";

        double expected = 5;
        double output = RpnCalculator.calculate(input);
        assertEquals(expected, output);
    }
    
    /**
     * Test a short calculation
     */
    @Test
    public void testCalculate() {
        String input = "23.3 5 16.2 + 8 * -";
        
        double expected = -146.30;
        double output = RpnCalculator.calculate(input);
        
        output *= 100;
        output = Math.round(output);
        output /= 100;
        
        assertEquals(expected, output);
    }
    
    /**
     * Test a longer calculation with all four operators
     */
    @Test
    public void testLongerCalculate() {
        String input = "2.7 5 * 4 + 3.5 2.1 * 1 + / 23.3 5 16.2 + 8 * - +";
        // Equivalent to (((2.7*5)+4)/((3.5*2.1)+1))+(23.3-(5+16.2)*8) 
        
        double expected = -144.20;
        double output = RpnCalculator.calculate(input);
        
        output *= 100;
        output = Math.round(output);
        output /= 100;
        
        assertEquals(expected, output);
    }
    
    /**
     * Test if calculate throws when an invalid symbol is given
     */
    @Test
    public void testInvalidSymbolException() {
        String input = "23.3 12 abc *";
        
        Exception exception = assertThrows(InvalidRPNException.class, () -> {
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
        
        Exception exception = assertThrows(InvalidRPNException.class, () -> {
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
        
        Exception exception = assertThrows(InvalidRPNException.class, () -> {
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
        
        Exception exception = assertThrows(InvalidRPNException.class, () -> {
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
        
        Exception exception = assertThrows(InvalidRPNException.class, () -> {
            RpnCalculator.calculate(input);
        });
        
        String expectedMessage = "Empty string entered error";
        String actualMessage = exception.getMessage();
        
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
