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
public class Bst {
    
    nNode start;
    //nNode current;
    
    public Bst(){}
    
    public void add(int data){
        if (start==null){
            start = new nNode(data);
            //current = start;
        }
        else{
            addNode(start, data);
        }
    }
    public void addNode(nNode current, int data){
        if(data <= current.getData()){
            if(current.left == null){
                current.left = new nNode(data);
            }
            else
                addNode(current.left, data);
        }
        else{
            if(current.right == null){
                current.right = new nNode(data);
            }
            else
                addNode(current.right, data);
        }
    }
    public void printTree(nNode node){
        if(node.left != null){
            printTree(node.left);
        }
        System.out.println(node.getData());
        if(node.right != null){
            printTree(node.right);
        }   
    }
    public void printTree(){
        printTree(start);
    }
    public static void main(String[] args) {
        Bst bst = new Bst();
        java.util.Random r = new java.util.Random();
        for(int i=0;i<20;i++){
            bst.add(r.nextInt(10000));
        }
        bst.printTree();
    }
}

class nNode{
    
    private int data;
    public nNode left;
    public nNode right;
    
    public nNode(){}
    
    public nNode(int data){
        setData(data);
    }
    public void setData(int data){
        this.data = data;
    }
    public int getData(){
        return data;
    }
}