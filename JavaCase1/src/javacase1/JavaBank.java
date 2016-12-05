/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacase1;

import java.util.Scanner;



/**
 *
 * @author scherr3143
 */
public class JavaBank {
    
    public Scanner input;
    private ArrayManager accounts;
    ArrayManager customers;
    
    public void initData(){

        customers = new ArrayManager(3);
        customers.add(new Customer("Bob", "Smith", 'J', 123));
        customers.add(new Customer("Sue", "Shard", 'S', 234));
        customers.add(new Customer("Pat", "Jones", 'R', 345));
        try{
            accounts = new ArrayManager(4);
            accounts.add(new SavingAccount(111,345.45f,10f,0));

            Object[] accountHolders = {customers.getElementAt(0), customers.getElementAt(2)};
            ((BankAccount)accounts.getElementAt(0)).setCustomer(new ArrayManager(accountHolders));

            accounts.add(new SavingAccount(222,325.55f,10f,0));
            accountHolders = new Customer[1];
            accountHolders[0] = (customers.getElementAt(1));
            ((BankAccount)accounts.getElementAt(1)).setCustomer(new ArrayManager(accountHolders));

            accounts.add(new CheckingAccount(333,700.55f,2.25f,250f));
            accountHolders = new Customer[2];
            accountHolders[0] = customers.getElementAt(0);
            accountHolders[1] = customers.getElementAt(2);
            ((BankAccount)accounts.getElementAt(2)).setCustomer(new ArrayManager(accountHolders));

            accounts.add(new CheckingAccount(444,700.55f,2.25f,1000f));
            accountHolders = new Customer[1];
            accountHolders[0] = customers.getElementAt(1);
            ((BankAccount)accounts.getElementAt(3)).setCustomer(new ArrayManager(accountHolders));
        }
        catch(EmptyArrayManagerException Eame){
            System.out.println(Eame.getMessage());
        }
        catch(OutOfBounds Oob){
            System.out.println(Oob.getMessage());
        }
    }

    public int showActionMenu(){
        
        int intSelection = 0;
        System.out.println("1. Deposit");
        System.out.println("2. Withdrawal");
        System.out.println("3. Transfer");
        System.out.println("4. Add Customer");
        System.out.println("5. Add Account");
        System.out.println("6. Add Customer to Account");
        System.out.print("Enter Selection: ");
        intSelection = input.nextInt();
        return intSelection;
    }
            
    public JavaBank(){
        input = new Scanner(System.in);
    }
    public static void main (String args[]){
        JavaBank jb = new JavaBank();
        jb.initData();
        jb.run();
    }
    public BankAccount getBankAccountByAccountNumber(int accountNumber){
        BankAccount ba = null;
        try{
            for(int i = 0; i < accounts.size(); i++){
                if(((BankAccount)accounts.getElementAt(i)).getIntAccountNo() == accountNumber){
                    ba = (BankAccount)accounts.getElementAt(i);
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return ba;
    }
    
    public Customer getCustomerByID(int id){
        Customer c = null;
        try{
            for(int i = 0; i < customers.size(); i++){
                if(((Customer)customers.getElementAt(i)).getIntCustomerID() == id){
                    c = (Customer)customers.getElementAt(i);
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return c;
    }
    
    public void displayAccountByCustomerID(int customerID){
        try{
            for (int i = 0; i < accounts.size(); i++) {
                ArrayManager c = ((BankAccount)accounts.getElementAt(i)).getCustomer();
                for (int j = 0; j < c.size(); j++) {
                    if (((Customer)c.getElementAt(j)).getIntCustomerID() == customerID) {
                        System.out.println(((BankAccount)accounts.getElementAt(i)).getIntAccountNo());
                    }
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void executeAction(int intAction, BankAccount ba){
        if(intAction == 1){
            System.out.println("Starting Balance: " + ba.getFltBalance());
            System.out.print("Deposit Amount: ");
            float amount = input.nextFloat();
            ba.Deposit(amount);
        }
        if(intAction == 2){ //Withdrawal
            
        }
        if(intAction == 3){ //Transfer
            
        }
        if(intAction == 4){ //Add Customer
            System.out.print("Last Name: ");
            String lastName = input.next();
            System.out.print("First Name: ");
            String firstName = input.next();
            System.out.print("Middle Initial: ");
            char middleName = input.next().charAt(0);
            System.out.print("Customer ID: ");
            int customerID = input.nextInt();
            
            Customer c = new Customer(lastName, firstName, middleName, customerID);
            customers.add(c);
        }
        if(intAction == 5){ //Add Account
            
        }
        if(intAction == 6){ //Add Customer to Account
            System.out.print("Enter Bank Account Number: ");
            int BAnumber = input.nextInt();
            BankAccount BAccount = getBankAccountByAccountNumber(BAnumber);
            if(BAccount != null){
                System.out.print("Enter Customer Number: ");
                int Cnumber = input.nextInt();
                Customer Cust = getCustomerByID(Cnumber);
                if(Cust != null){
                    BAccount.getCustomer().add(Cust);
                }
                else{
                    System.out.println("Customer not found.");
                }
            }
            else{
                System.out.println("Account not found.");
            }
        }
        
    }
    public void run(){
        System.out.print("Enter customer ID: ");
        int intCustID = input.nextInt();
        displayAccountByCustomerID(intCustID);
        System.out.print("Select Account: ");
        int accountID = input.nextInt();
        BankAccount ba = getBankAccountByAccountNumber(accountID);
        int option = showActionMenu();
        executeAction(option, ba);
    }
}
