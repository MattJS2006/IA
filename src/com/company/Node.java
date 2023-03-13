package com.company;

public class Node {
    private int value;
    private Node next;

    public Node(int v){
        value = v;
        next = null;
    }

    public Node getNext(){return next;}

    public int getValue(){return value;}

    public void setNext(Node n){
        next = n;
    }

    public void setValue(int v){
        value = v;
    }

    public void display(){
        System.out.println(value);
    }
}
