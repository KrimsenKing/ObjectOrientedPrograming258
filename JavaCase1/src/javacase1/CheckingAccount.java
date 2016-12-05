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
public class CheckingAccount extends BankAccount {
    
    private float fltOverDraftPenalty;
    private float fltOverDraftLimit;

    public CheckingAccount(){}
    public CheckingAccount(int intAccountNo, float fltBalance, float fltOverDraftPenalty, float fltOverDraftLimit){
        super(intAccountNo, fltBalance);
        setFltOverDraftPenalty(fltOverDraftPenalty);
        setFltOverDraftLimit(fltOverDraftLimit);
    }
    
    public void Withdraw(float fltAmount) throws Exception{
        float fee;
        if(fltAmount < getFltBalance()){
            setFltBalance(getFltBalance()-fltAmount);
        }
        else if(fltOverDraftLimit<(getFltBalance()-fltAmount)){
            setFltBalance(getFltBalance()-(fltAmount+fltOverDraftPenalty));
        }
        else{
            throw new Exception();
        }
    }
    
    
    /**
     * @return the fltOverDraftPenalty
     */
    public float getFltOverDraftPenalty() {
        return fltOverDraftPenalty;
    }

    /**
     * @param fltOverDraftPenalty the fltOverDraftPenalty to set
     */
    public void setFltOverDraftPenalty(float fltOverDraftPenalty) {
        this.fltOverDraftPenalty = fltOverDraftPenalty;
    }

    /**
     * @return the fltOverDraftLimit
     */
    public float getFltOverDraftLimit() {
        return fltOverDraftLimit;
    }

    /**
     * @param fltOverDraftLimit the fltOverDraftLimit to set
     */
    public void setFltOverDraftLimit(float fltOverDraftLimit) {
        this.fltOverDraftLimit = fltOverDraftLimit;
    }
}
