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
public class GenericList<T> {
 
    private GenericNode<T> items;
    private GenericNode<T> current;
    
    public void add(T item){
        if(items==null){
            items = new GenericNode(item);
            current = items;
        }
        else{
            current.nextNode = new GenericNode(item);
            current = current.nextNode;
        }
    }
    
    public T getElementAt(int i){
    
        GenericNode<T> temp = items;
        for(int count = 0;count<i;count++){
            temp = temp.nextNode;
        }
        return temp.getData();
    }
    
    public T findMax(){
        
        T max;
        max = items.getData();
        GenericNode<T> temp = items;
        while(temp.nextNode!=null){
            if(((Comparable)temp.getData()).compareTo(max)>0){
                max = temp.getData();
            }
            temp = temp.nextNode;
        }
        return max;
    }
    
    public void printList(){
        
        GenericNode<T> temp = items;
        
        while(temp != null){
            System.out.println(temp.getData());
            temp = temp.nextNode;
        }
    }
     
    public static void main(String[] args){
        
        GenericList<Customer> list = new GenericList<Customer>();
        
        list.add(new Customer("Bob", "Bill", 'T', 1234));
        list.add(new Customer("Chuck", "Smith", 'F', 4585));
        list.add(new Customer("Doug", "Dave", 'G', 8652));
        
        System.out.println(list.getElementAt(1).getStrFirstName());
    }
    
    class GenericNode<T>{
        
        private T data;
        public GenericNode<T> nextNode;
        
        public GenericNode(T item){
            data = item;
            
        }
        public T getData(){
            return data;
        }
    }
    
}
