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
        System.out.println("Calculate \"23.3 5 16.2 + 8 * -\"");
        String input = "23.3 5 16.2 + 8 * -";
        //String input = " ";
        
        double expected = -146.29999999999998;
        double output = RpnCalculator.calculate(input);
        System.out.println("The output is " + output);
        assertEquals(expected, output);
    }
    
    @Test
    public void testInvalidSymbolException() {
        System.out.println("Calculate \"23.3 12 abc *\"");
        String input = "23.3 12 abc *";
        
        Exception exception = assertThrows(InvalidRPNException.class, () -> {
            RpnCalculator.calculate(input);
        });
        
        String expectedMessage = "Invalid symbol entered";
        String actualMessage = exception.getMessage();
        
        assertTrue(actualMessage.contains(expectedMessage));
    }
    
    @Test
    public void testRanOutDoubleException() {
        System.out.println("Calculate \"24.5 *\"");
        String input = "24.5 *";
        
        Exception exception = assertThrows(InvalidRPNException.class, () -> {
            RpnCalculator.calculate(input);
        });
        
        String expectedMessage = "Ran out of doubles";
        String actualMessage = exception.getMessage();
        
        assertTrue(actualMessage.contains(expectedMessage));
    }
    
    @Test
    public void testRanOutOperatorException() {
        System.out.println("Calculate \"24.5 16 5.3 -\"");
        String input = "24.5 16 5.3 -";
        
        Exception exception = assertThrows(InvalidRPNException.class, () -> {
            RpnCalculator.calculate(input);
        });
        
        String expectedMessage = "Ran out of operators";
        String actualMessage = exception.getMessage();
        
        assertTrue(actualMessage.contains(expectedMessage));
    }
    
    @Test
    public void testDivideByZeroException() {
        System.out.println("Calculate \"24.5 0 /\"");
        String input = "24.5 0 /";
        
        Exception exception = assertThrows(InvalidRPNException.class, () -> {
            RpnCalculator.calculate(input);
        });
        
        String expectedMessage = "Division by zero error";
        String actualMessage = exception.getMessage();
        
        assertTrue(actualMessage.contains(expectedMessage));
    }
    
    @Test
    public void testEmptyStringException() {
        System.out.println("Calculate \"\"");
        String input = "";
        
        Exception exception = assertThrows(InvalidRPNException.class, () -> {
            RpnCalculator.calculate(input);
        });
        
        String expectedMessage = "Empty string entered error";
        String actualMessage = exception.getMessage();
        
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
