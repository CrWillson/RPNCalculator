package rpn;

/**
 *
 * @author Caleb Willson
 * @version 1.0
 * File: InvalidRPNString.java
 * Created: 2/16/23
 * 
 * Exception thrown by RpnCalculator.calculate();
 */
public class InvalidRPNString extends RuntimeException {
    public InvalidRPNString (String err) {
        super(err);
    }
}
