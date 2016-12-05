package javacase1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author scherr3143
 */
public class OutOfBounds extends Exception {
    
    public OutOfBounds(){
        System.out.println("Out of bounds exception created.");
    }
    
    public String getMessage(){
        return ("An index was referenced outside the bounds of the array.");
    }
            
}
