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
public class EmptyArrayManagerException extends OutOfBounds{
    
    public String operation;
    
    public EmptyArrayManagerException(){
        System.out.println("Empty Array Exception created.");
    }
    
    public EmptyArrayManagerException(String operation){
        this.operation = operation;
        System.out.println("Empty Array Exception created.");
    }
    
    public String getMessage(){
        return super.getMessage() + " Your Array Manager is empty. Can't " + operation;
    }
}
