/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataEstructure;

/**
 *
 * @author gigie
 */
public class Queue {
    private int size;
    private Node front;
    private Node last; //
    
 
    public Queue() {
        this.front = this.last = null;
        this.size = 0;
    }
    
    
    public Node next(Node n){
        return n.getpNextN();
    }
    
    public boolean isEmpty(){
        return front == null;
    }
    
    public void enqueue(Character c) {
        Node newNode = new Node(c);
        if (isEmpty()) { // If the queue is empty
            front = newNode;
        } else {
            last.setpNextN(newNode); // Link the new node at the end
           
        }
        last = newNode;
        size++;
    }
    
    public Character dequeue() {
        Character c = null;
        if (!isEmpty()) {
           // c = front.();                 OJO
            this.front = next(front);
            size--;
        }
        return c;
    }
    
    
    
    
    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * @return the front
     */
    public Node getFront() {
        return front;
    }

    /**
     * @param front the front to set
     */
    public void setFront(Node front) {
        this.front = front;
    }

    /**
     * @return the last
     */
    public Node getLast() {
        return last;
    }
    
    
}
