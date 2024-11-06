/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataEstructure;

import Classes.CharacterM;

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
    
    public void enqueue(CharacterM c) {
        Node newNode = new Node(c);
        if (isEmpty()) { // If the queue is empty
            front = newNode;
        } else {
            last.setpNextN(newNode); // Link the new node at the end
           
        }
        last = newNode;
        size++;
    }
    
    public CharacterM dequeue() {
        CharacterM c = null;
        if (!isEmpty()) {
        // Asignar el elemento frontal a c
        c = this.front.getC(); // Suponiendo que 'front' es un nodo que tiene un método 'getData()'
        
        // Mover el puntero 'front' al siguiente nodo
        this.front = this.front.getpNextN(); // Suponiendo que 'front' tiene un método 'getNext()'
        
        // Decrementar el tamaño de la cola
        size--;
        }
        return c; // Retornar el personaje desencolado
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
