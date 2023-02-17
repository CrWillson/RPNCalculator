/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rpn;

/**
 *
 * @author Caleb Willson
 */
public class InvalidRPNString extends RuntimeException {
    public InvalidRPNString (String err) {
        super(err);
    }
}
