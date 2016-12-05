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
public class SavingAccount extends BankAccount{
    
    private float fltMinBalance;
    private int intWithdrawCount;
    
    private final static float fltActivityPenalty = 5f;
    private final static int intActivityLimit = 10;
    
    public SavingAccount() {}
    
    public SavingAccount(int intAccountNo, float fltBalance, float fltMinBalance, int intWithdrawCount){
        super(intAccountNo, fltBalance);
        setFltMinBalance(fltMinBalance);
        setIntWithdrawCount(intWithdrawCount);
    }
    
    
    public void Withdraw(float fltAmount) throws Exception{
        
        float fee=0;
        if(getFltBalance()<fltMinBalance && intWithdrawCount>intActivityLimit){
            fee=fltActivityPenalty;
        }
        if(getFltBalance() >= (fltAmount+fee)){
            setFltBalance(getFltBalance()-(fltAmount+fee));
            setIntWithdrawCount(intWithdrawCount++);
        }
        else{
            throw new Exception();
        }
    }
    
    /**
     * @return the fltMinBalance
     */
    public float getFltMinBalance() {
        return fltMinBalance;
    }

    /**
     * @param fltMinBalance the fltMinBalance to set
     */
    public void setFltMinBalance(float fltMinBalance) {
        this.fltMinBalance = fltMinBalance;
    }

    /**
     * @return the intWithdrawCount
     */
    public int getIntWithdrawCount() {
        return intWithdrawCount;
    }

    /**
     * @param intWithdrawCount the intWithdrawCount to set
     */
    public void setIntWithdrawCount(int intWithdrawCount) {
        this.intWithdrawCount = intWithdrawCount;
    }
}
