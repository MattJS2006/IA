package com.company;

public class LinkedList {
    private Node head;
    private int numNodes;
    private boolean checked;

    // Initialises the Linked List if given a list of int value
    public LinkedList(int[] values) {
        head = new Node(values[0]);
        Node adding;
        Node current = head;
        for(int i=1; i<values.length; i++){
            adding = new Node(values[i]);
            current.setNext(adding);
            current = adding;
        }
        numNodes = values.length;
        checked = false;
    }

    // Initialises the Linked List if nothing is provided
    public LinkedList(){
        head = null;
        numNodes = 0;
        checked = false;
    }

    // Displays the Linked List on one line
    public void display(){
        // print all elements on the same line
        Node current = head;
        while(current != null){
            System.out.print(current.getValue() + ", ");
            current = current.getNext();
        }
        System.out.println();
    }

    // Adds a new Node to the end of the Linked List
    public void addNode(int v){
        Node newNode = new Node(v);
        Node current = head;
        while(current.getNext() != null){
            current = current.getNext();
        }
        current.setNext(newNode);
        numNodes++;
    }

    // Overloading
    // Returns the size of the list if a beginning count is provided
    public int size(int count){
        Node current = head;
        while(current != null){
            count++;
            current = current.getNext();
        }
        checked = true;
        numNodes = count;
        return count;
    }

    // Overloading
    // Returns the size of the Linked List
    public int size(){
        if(checked == true){
            return numNodes;
        } else {
            // uses the other method of size to find out the size
            return size(0);
        }
    }

    // Adds a new Node to the beginning of the Linked List
    public void addFirst(int n){
        Node newNode = new Node(n);
        newNode.setNext(head);
        head = newNode;
        numNodes++;
    }

    // Adds a new Node at a specified index
    public void add(int index, int n){
        Node newNode = new Node(n);
        Node current = head;
        for(int i=1; i != index; i++){
            current = current.getNext();
        }
        Node next = current.getNext();
        current.setNext(newNode);
        newNode.setNext(next);
        numNodes++;
    }

    // Clears the Linked List
    public void clear(){
        head = null;
        numNodes = 0;
    }

    // Returns the first value in the Linked List
    public int getFirst(){
        return head.getValue();
    }

    // Returns the last value in the Linked List
    public int getLast(){
        Node current = head;
        while(current.getNext() != null){
            current = current.getNext();
        }
        return current.getValue();
    }

    // Returns the value of the Node at a specified index
    public int get(int index){
        Node current = head;
        for(int i=0; i != index; i++){
            current = current.getNext();
        }
        return current.getValue();
    }

    // Sets the value of a Node at a specified index
    public void set(int index, int n){
        Node current = head;
        for(int i=0; i != index; i++){
            current = current.getNext();
        }
        current.setValue(n);
    }

    // Returns if an item is in the Linked List
    public boolean contains(int n){
        Node current = head;
        while(current != null){
            if(current.getValue() == n){
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    // Returns the index of a Node at a specified index
    public int indexOf(int n){
        Node current = head;
        int count = 0;
        while(current != null){
            if(current.getValue() == n){
                return count;
            }
            count++;
            current = current.getNext();
        }
        return -1;
    }

    // Overloading
    // Removes an item at a specified index
    public Node remove(int index){
        Node current = head;
        Node prev = head;
        for(int i = 0; i != index; i++){
            prev = current;
            current = current.getNext();
        }
        prev.setNext(current.getNext());
        numNodes = numNodes -1;
        return current;
    }

    // Overloading
    // Removes the first value in the Linked List
    public Node remove(){
        head = head.getNext();
        return head;
    }
}
