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
public class ArrayManager {
    
    private Object[] data;
    private int count;
    
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
    
    public static void main(String args[]){
        
        Object[] testData= {1,2,3,4,5};
        ArrayManager am = new ArrayManager(testData);
        try{
            am.delete(2);
            am.add(6);
            am.add(6);
            am.addAt(6,5);
            
            am.printArray();
            am.removeRange(2, 4);
            
        }
        catch(EmptyArrayManagerException Eame){
            System.out.println(Eame.getMessage());
        }
        catch(OutOfBounds Oob){
            System.out.println(Oob.getMessage());
        }
        System.out.println("**********");
        am.printArray();
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
    
}
