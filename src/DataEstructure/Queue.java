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
        if (isEmpty()) { 
            front = newNode;
        } else {
            last.setpNextN(newNode); 
           
        }
        last = newNode;
        size++;
    }
    
    public CharacterM dequeue() {
        CharacterM c = null;
        if (!isEmpty()) {
        
        c = this.front.getC(); 
        
     
        this.front = this.front.getpNextN();
        
      
        size--;
        }
        return c; 
    }
    
    public Queue cloneQueue() {
        Queue newQueue = new Queue();

        Node node = this.getFront();
        for (int i = 0; i < this.getSize(); i++) {
            CharacterM character = node.getC();

            CharacterM newCharacter = new CharacterM(
                    character.getId(),
                    character.getPriority(),
                    character.getQuality(),
                    character.getSkill(),
                    character.getLife(),
                    character.getStrength(),
                    character.getAgility(),
                    character.getMovie(),
                    character.getUrlIMG());

            newQueue.enqueue(newCharacter);
            node = node.getpNextN();
        }
        return newQueue;
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
