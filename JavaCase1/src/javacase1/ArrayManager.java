/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacase1;

import java.util.Arrays;

/**
 *
 * @author scherr3143
 */
public class ArrayManager {
    
    private Object[] data;
    private int count;
    
    public static void main(String args[]){
        
        Object[] testData= {1,2,3,4,5,12,85,46,485,2136,8,45,5,847,16,95,145587,6932,128};
        ArrayManager am = new ArrayManager(testData);
        
        java.util.Random r = new java.util.Random();
        for(int i=0;i<500;i++){
            am.add(r.nextInt(10000));
        }
        try{
            am.delete(2);
            am.sort();
            am.printArray();
            int spot = am.binarySearch(0, am.size(), 85, 0);
            am.linearSearch(85);
        }
        catch(EmptyArrayManagerException Eame){
            System.out.println(Eame.getMessage());
        }
        catch(OutOfBounds Oob){
            System.out.println(Oob.getMessage());
        }
    }
    public ArrayManager(){
        data = new Object[10];
        count = 0;
    } 
    public ArrayManager(int intInitialSize){
        data = new Object[intInitialSize];
        count = 0;
    }
    public ArrayManager(Object[] data){
        this.data = data;
        count = data.length;
    }
    public void printArray(){
        for(int i=0;i<count;i++){
            System.out.println(data[i]+" Pos: "+i);
        }
    }
    public void delete(int position) throws OutOfBounds{
        
        if(count==0){
            throw new EmptyArrayManagerException("delete.");
        }
        if(position > count || position < 0){
            throw new OutOfBounds();
        }
        for(int i=position;i<count-1;i++){
            data[i]=data[i+1];
        }
        count--;
    }
    public void add(Object o){
        
        if(count>=data.length){
            Object[] temp = new Object[data.length+1];
            System.arraycopy(data, 0, temp, 0, data.length);
            data=temp;
        }
        data[count]=o;
        count++;
    }
    public void addAt(Object o, int position) throws OutOfBounds{
        
        if(position > count || position < 0){
            throw new OutOfBounds();
        }
        if(count>=data.length){
            Object[] temp = new Object[data.length+10];
            System.arraycopy(data, 0, temp, 0, data.length);
            data=temp;
        }
        for(int i=count; i>position; i--){
                data[i]=data[i-1];
            }
        data[position]=o;
        count++;
    }
    public int size(){
        return count;
    }
    public boolean isEmpty(){
        return count==0;
    }
    public Object getElementAt (int position) throws OutOfBounds{
        if(position > count || position < 0){
            throw new OutOfBounds();
        }
        return data[position];
    }
    public void removeRange(int start, int end) throws OutOfBounds{
        if(start<0 || end>count){
            throw new OutOfBounds();
        }
        else{
            for(int i=start;i<=end;i++){
                delete(start);
            }
        }
    }
    public int countOccurances(Object o){
        int totes=0;
        for(int i=0;i<size();i++){
            if(data[i].equals(o)){
                totes++;
            }
        }
        return totes;
    }
    public void sort(){
        trim();
        Arrays.sort(data);
    }
    public void trim(){
        if(data.length >= count){
            Object[] temp = new Object[count];
            System.arraycopy(data, 0, temp, 0, temp.length);
            data = temp;
        }
    }
    public int binarySearch(int start, int end, int target, int checks){
        checks++;
        int middle = (start+end)/2;
        
        if(data[middle].equals(target)){
            System.out.println("Took " + checks + " checks to find in Binary Search.");
            return middle;
        }
        else if(start>=end){
            System.out.println("Took " + checks + " checks to find in Binary Search.");
            return -1;
        }
        else if(((Comparable)data[middle]).compareTo(target)>0){
            return binarySearch(start,middle,target,checks);
        }
        else{
            return binarySearch(middle,end,target,checks);
        }
    }
    public int linearSearch(int target){
        int checks=0;
        int spot=-1;
        
        for(int i=0;i<count;i++){
            if(data[i].equals(target)){
                spot=i;
            }
            else if(spot==-1){
                checks++;
            }
        }
        System.out.println("Took " + checks + " checks to find in Linear Search.");
        return spot;
    }
}
