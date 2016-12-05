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
public class LinkedList {
    Node items;
    Node current;
    public void start(){
        current = items;
    }
    public void advance() throws OutOfBounds{
        if(current.next==null){
            throw new OutOfBounds();
        }
        else{
            current = current.next;
        }
    }
    public Object current(){
        return current.getData();
    }
    public void add(Object o){
        if(items==null){
            items = new Node(o);
            current = items;
        }
        else{
            Node temp = new Node(o);
            current.next = temp;
            current = temp;
        }
    }
    public void addAfter(Object o){
        if(items==null){
            items = new Node(0);
            current = items;
        }
        else{
            Node temp = new Node(0);
            temp.next = current.next;
            current.next = temp;
            current = temp;
        }
    }
    public void addBefore(Object o){
        
        //1. temp = items
        Node temp = items;
        //   advance temp so temp.next = current
        while(temp.next != current)
            temp=temp.next;
        //2. create node for Object o
        Node newNode = new Node(o);
        //3. point o.next to current
        newNode.next = current;
        //4. point temp.next to current
        temp.next = newNode;
        //5. point current to o
        current = newNode;
    }
    public void removeCurrent(){
        if(current==items){
            items=items.next;
            current=items;
            System.out.println("This was current");
        }
        else{
            Node temp = items;
            while(temp.next!=current)
                temp = temp.next;
        
        
            //temp.next = current.next;
            temp.next = temp.next.next;
            current = temp;
        }
    }
    public Object getElementAt(int i){
    
        Node temp = items;
        for(int count = 0;count<i;count++){
            temp = temp.next;
        }
        return temp.getData();
    }
    public Node getNodeAt(int i){
   
        Node temp = items;
        for(int count = 0;count<i;count++){
            temp = temp.next;
        }
        return temp;
    }
    public Object findMax() throws Exception{
        
        Object max;
        max = items.getData();
        Node temp = items;
        while(temp.next!=null){
            try{
                if(((Comparable)temp.getData()).compareTo(max)>0){
                    max = temp.getData();
                }
            }
            catch(Exception e){
                
            }
            temp = temp.next;
        }
        return max;
    }
    public void printList(){
        
        Node temp = items;
        
        while(temp != null){
            System.out.println(temp.getData());
            temp = temp.next;
        }
    }
    public void removeRange(int start, int end){
        
        Node temp =  getNodeAt(start-1);
        Node temp2 = getNodeAt(end);
        
        temp.next = temp2.next;
    }
    public void insertAt(int pos, Object o){
        current =  getNodeAt(pos-1);
        Node temp = current.next;
        
        current.next = new Node(o);
        current.next.next = temp;
        
    }
    public static void main (String args[]){
        
        try{
            LinkedList list = new LinkedList();
            list.add(7);
            list.add(6);
            list.add(5);
            list.add(4);
            list.add(3);
            list.add(2);

            list.printList();
            // System.out.println("Max is " + list.findMax());
            //list.start();
            //list.advance();
            //list.advance();
            System.out.println("*****");
            //list.addAfter(99);
            //list.printList();
            //list.removeCurrent();
            list.insertAt(2, 99);
            list.printList();
            
            
        }
       // catch(OutOfBounds oob){
          //  System.out.println("Invalid advance.....");
       // }
        catch(Exception e){
            System.out.println("Invalid cast.....");
            e.printStackTrace();
        }
    }
}
