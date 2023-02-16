/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rpn;

/**
 *
 * @author Caleb Willson
 */
public class InvalidRPNException extends RuntimeException {
    public InvalidRPNException (String err) {
        super(err);
    }
}
