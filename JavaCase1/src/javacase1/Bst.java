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
    public Bst() {
    }
    public void add(Comparable data) {
        if (start == null) {
            start = new nNode(data);
        } else {
            addNode(start, data);
        }
    }
    public void addNode(nNode current, Comparable data) {
        if (data.compareTo(current.getData())<=0) {
            if (current.left == null) {
                current.left = new nNode(data);
            } else {
                addNode(current.left, data);
            }
        } else if (current.right == null) {
            current.right = new nNode(data);
        } else {
            addNode(current.right, data);
        }
    }
    public void delete(Comparable target){
        
        delete(start,target);
    }
    public void delete(nNode current, Comparable target){
        
        boolean isRight = false;
        nNode nodeToDelete = null;
        
        if(current.getData().compareTo(target)>0 && current.left!=null){
            if(current.left.getData().compareTo(target)==0){
                System.out.println("Parent found "+current.getData());
                nodeToDelete = current.left;
            }
            else{
                delete(current.left,target);
            }
        }
        else if(current.getData().compareTo(target)<0 && current.right!=null){
            if(current.right.getData().compareTo(target)==0){
                System.out.println("Parent found "+current.getData());
                isRight=true;
                nodeToDelete=current.right;
            }
            else{
                delete(current.right, target);
            }
        }
        else{
            System.out.println("node found " + current.getData());
        }
        if (nodeToDelete != null){
            if(nodeToDelete.left==null && nodeToDelete.right==null){
                if(isRight)
                    current.right = null;
                else
                    current.left = null;
            }
            else if(nodeToDelete.right==null){
                if(isRight)
                    current.right = nodeToDelete.left;
                else
                    current.left = nodeToDelete.left;
            }
            else if(nodeToDelete.right.left==null){
                nodeToDelete.right.left = nodeToDelete.left;
                current.right = nodeToDelete.right;
            }
            else if(nodeToDelete.right.left!=null){
                nNode leftMost=findTheLeftMostNode(nodeToDelete.right);
                leftMost.right = nodeToDelete.right;
                current.left = leftMost;
                deleteTheLeftMostNode(nodeToDelete.right);
            }
        }
    }
    
    public nNode findTheLeftMostNode(nNode node){
        if(node.left==null)
            return node;
        else
            return findTheLeftMostNode(node.left);
    }
    public nNode findTheRightMostNode(nNode node){
        if(node.right==null)
            return node;
        else
            return findTheRightMostNode(node.right);
    }
    public void deleteTheLeftMostNode(nNode node){
        if(node.left.left==null)
            node.left = null;
        else
            deleteTheLeftMostNode(node.left);
    }
    public void printTree(nNode node) {
        if (node.left != null) {
            printTree(node.left);
        }
        System.out.println(node.getData());
        if (node.right != null) {
            printTree(node.right);
        }
    }
    public void printTree() {
        printTree(start);
    }
    public boolean searchTree(int data) {
        return searchTree(start, data);
    }
    public boolean searchTree(nNode current, Comparable data) {

        if (current.getData().compareTo(data) == 0) {
            return true;
        } else if (data.compareTo(current.getData())<0 && current.left != null) {
            return searchTree(current.left, data);
        } else if (data.compareTo(current.getData())>0 && current.right != null) {
            return searchTree(current.right, data);
        } else {
            return false;
        }
    }
    public static void main(String[] args) {
        Bst bst = new Bst();
        //java.util.Random r = new java.util.Random();
        //for (int i = 0; i < 20; i++) {
        //    bst.add(r.nextInt(100));
        //}
        
        bst.add(50);
        bst.add(25);
        bst.add(75);
        bst.add(13);
        bst.add(35);
        bst.add(66);
        bst.add(85);
        bst.add(17);
        bst.add(63);
        bst.add(90);
        bst.add(15);
        bst.add(18);
        
        bst.printTree();
        bst.delete(50);
        System.out.println("******");
        bst.printTree();
    }
}

class nNode {
    private Comparable data;
    public nNode left;
    public nNode right;
    public nNode() {
    }
    public nNode(Comparable data) {
        setData(data);
    }
    public void setData(Comparable data) {
        this.data = data;
    }
    public Comparable getData() {
        return data;
    }
}
