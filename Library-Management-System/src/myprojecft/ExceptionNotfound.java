/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myprojecft;

/**
 *
 * @author all in one
 */
public class ExceptionNotfound extends Exception {
    
    public ExceptionNotfound()
    {
        super("Invalid Publication");
    }
    public ExceptionNotfound(String s)
    {
        super(s);
    }
}
