package rpn;

/**
 *
 * @author Caleb Willson
 * @version 1.0
 File: InvalidRPNException.java
 Created: 2/16/23
 
 Exception thrown by RpnCalculator.calculate();
 */
public class InvalidRPNException extends RuntimeException {
    public InvalidRPNException (String err) {
        super(err);
    }
}
