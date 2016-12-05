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
public class FunwithRecursion {
    
    public static int addEmUp(int num){
        
        if(num == 1){
            return num;
        }
        else{
            return num + addEmUp(num-1);
        }
    }
    
    public static int factorial(int fact){
        if(fact == 1){
            return fact;
        }
        else{
            return fact * factorial(fact-1);
        }
    }
    
    public static String indentoTron(int indent){
        
        if(indent==0){
            return "";
        }
        else{
            return "This was written by call number " + (indent) + "." + indentoTron(indent-1) + "This ALSO written by call number " + (indent) + ".";
        }
   }
    
    public static int myPow (int a, int b){
        if(b==1){
            return a;
        }
        else{
            return a * myPow(a,b-1);
        }
    }
    
    //public static boolean isPalindrome (String s, int start, int end){
        
        
    //}
    
    //public static void PrintList(node temp){
        
    //}
    
    public static void main(String args[]){
        
        System.out.println(indentoTron(4));
    }
    
}
