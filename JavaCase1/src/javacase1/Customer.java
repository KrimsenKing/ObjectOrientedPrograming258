/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacase1;

/**
 *
 * @author scherr3143
 */
public class Customer extends Person implements Comparable{
    
    private int intCustomerID;

    public int compareTo(Object o){
        if(getIntCustomerID()<((Customer)o).getIntCustomerID()){
            return -1;
        }
        else if(getIntCustomerID()>((Customer)o).getIntCustomerID()){
            return +1;
        }
        else{
            return 0;
        }
    }
    public Customer(){}
    public Customer(String strFirstName, String strLastName, char chrMiddleInitial, int intCustomerID){
        super(strFirstName, strLastName, chrMiddleInitial);
        setIntCustomerID(intCustomerID);
    }
    /**
     * @return the intCustomerID
     */
    public int getIntCustomerID() {
        return intCustomerID;
    }

    /**
     * @param intCustomerID the intCustomerID to set
     */
    public void setIntCustomerID(int intCustomerID) {
        this.intCustomerID = intCustomerID;
    }
    
    
            
    
}
