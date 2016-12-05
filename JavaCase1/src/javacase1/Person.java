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
public abstract class Person {
    
    private String strFirstName;
    private String strLastName;
    private char chrMiddleInitial;
    
    public Person(){}
    
    public Person(String strFirstName, String strLastName, char chrMiddleInitial){
        setStrFirstName(strFirstName);
        setStrFirstName(strLastName);
        setChrMiddleInitial(chrMiddleInitial);
    }

    /**
     * @return the strFirstName
     */
    public String getStrFirstName() {
        return strFirstName;
    }

    /**
     * @param strFirstName the strFirstName to set
     */
    public void setStrFirstName(String strFirstName) {
        this.strFirstName = strFirstName;
    }

    /**
     * @return the strLastName
     */
    public String getStrLastName() {
        return strLastName;
    }

    /**
     * @param strLastName the strLastName to set
     */
    public void setStrLastName(String strLastName) {
        this.strLastName = strLastName;
    }

    /**
     * @return the chrMiddleInitial
     */
    public char getChrMiddleInitial() {
        return chrMiddleInitial;
    }

    /**
     * @param chrMiddleInitial the chrMiddleInitial to set
     */
    public void setChrMiddleInitial(char chrMiddleInitial) {
        this.chrMiddleInitial = chrMiddleInitial;
    }
    
    
    
}
