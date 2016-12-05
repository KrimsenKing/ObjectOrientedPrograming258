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
public abstract class BankAccount {
    
    private int intAccountNo;
    private float fltBalance;

    private ArrayManager customers;
    
    public BankAccount (){
        customers = new ArrayManager();
    }
    
    public BankAccount (int intAccountNo, float fltBalance){
        setIntAccountNo(intAccountNo);
        setFltBalance(fltBalance);
    }
    
    public BankAccount (int intAccountNo, float fltBalance, ArrayManager customers){
        
        setIntAccountNo(intAccountNo);
        setFltBalance(fltBalance);
        setCustomer(customers);
    }
    
     public void setCustomer(ArrayManager customers){
        this.customers=customers;
    }
    
    public ArrayManager getCustomer(){
        return customers;
    }
    
    public void Deposit(float fltAmount){
        this.fltBalance = this.fltBalance + fltAmount;
    }
    
    
    public abstract void Withdraw(float fltAmount) throws Exception;
    
    public void Transfer(BankAccount bAccount, float fltAmount) throws Exception{
        
        float bal = bAccount.getFltBalance();
        bAccount.Withdraw(fltAmount);
        if(bal != bAccount.getFltBalance()){
            Deposit(fltAmount);
        }
        else{
            throw new Exception();
        }
    }
       
    /**
     * @return the intAccountNo
     */
    public int getIntAccountNo() {
        return intAccountNo;
    }

    /**
     * @param intAccountNo the intAccountNo to set
     */
    public void setIntAccountNo(int intAccountNo) {
        this.intAccountNo = intAccountNo;
    }

    /**
     * @return the fltBalance
     */
    public float getFltBalance() {
        return fltBalance;
    }

    /**
     * @param fltBalance the fltBalance to set
     */
    public void setFltBalance(float fltBalance) {
        this.fltBalance = fltBalance;
    }
    
}
