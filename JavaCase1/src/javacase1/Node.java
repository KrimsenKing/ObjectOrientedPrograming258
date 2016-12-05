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
public class Node {
    private Object Data;
    
    public Node next;

    public Node(){}
    
    public Node (Object Data){
        setData(Data);
    }
    /**
     * @return the Data
     */
    public Object getData() {
        return Data;
    }

    /**
     * @param Data the Data to set
     */
    public void setData(Object Data) {
        this.Data = Data;
    }
    
    public static void main(String args[]){
        
        Node a = new Node(7);
        Node b = new Node(6);
        Node c = new Node(5);
        Node d = new Node(4);
        Node e = new Node(3);
        
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        //e.next = a;
        
        Node list = a;
        
        while(list!=null){
            System.out.println(list.getData());
            list = list.next;
        }
        
        Node f = new Node(99);
        f.next = c;
        b.next = f;
        
        System.out.println("*************************");
        
        list = a;
        
        while(list!=null){
            System.out.println(list.getData());
            list = list.next;
        }
        
        f.next = d;
        
    }
}
