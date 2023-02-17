package rpn;

import java.util.*;

/**
 *
 * @author Caleb Willson
 */
public class RpnCalculator {
    public static double calculate(String input) throws InvalidRPNString {
        //if (input.isEmpty()) {
        //    throw new InvalidRPNString("Empty string entered error");
        //}
        
        Scanner scanner = new Scanner(input);
        Stack<Double> stack = new Stack<>();
        
        while (scanner.hasNext()) {
            if (scanner.hasNextDouble()) {
                stack.push(scanner.nextDouble());
            } 
            else {
                String symbol = scanner.next();
                
                if (!("+".equals(symbol) || "-".equals(symbol) ||
                    "*".equals(symbol) || "/".equals(symbol))) {
                    scanner.close();
                    throw new InvalidRPNString("Invalid symbol entered");
                }
                
                double a = 0.0;
                double b = 0.0;
                
                try {
                    b = stack.pop();
                }
                catch (EmptyStackException e) {
                    scanner.close();
                    throw new InvalidRPNString("Ran out of doubles");
                }
                
                try {
                    a = stack.pop();
                }
                catch (EmptyStackException e) {
                    scanner.close();
                    throw new InvalidRPNString("Ran out of doubles");
                }
                
                if ("+".equals(symbol)) {
                    stack.push(a + b);
                }
                else if ("-".equals(symbol)) {
                    stack.push(a - b);
                }
                else if ("*".equals(symbol)) {
                    stack.push(a * b);
                }
                else if ("/".equals(symbol)) {
                    if (b == 0) {
                        scanner.close();
                        throw new InvalidRPNString("Division by zero error");
                    }
                    else {
                        stack.push(a / b);
                    }
                }
            }
        }

        scanner.close();
        if (stack.size() > 1) {
            throw new InvalidRPNString("Ran out of operators");
        }
        
        double result = 0.0;
        try {
            result = stack.pop();
        }
        catch (EmptyStackException e) {
            throw new InvalidRPNString("Empty string entered error");
        }
        
        return result;
    }
}
