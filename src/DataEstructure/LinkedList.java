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
public class LinkedList {
    private Node pFirst;
    private int size;
    
    public LinkedList() {
        this.pFirst = null;
        this.size = 0;
    }
    
    public void insert(CharacterM c) {
    Node newNode = new Node(c);
    
    if (getpFirst() == null) { 
            setpFirst(newNode);
    } else {
        Node current = getpFirst();
        while (current.getpNextN() != null) { 
            current = current.getpNextN();
        }
        current.setpNextN(newNode); 
    }
        setSize(getSize() + 1);
    }
    
    
    public CharacterM get(int i) {
    // Verifica si el índice está dentro de los límites de la lista
    if (i < 0 || i >= size) {
        throw new IndexOutOfBoundsException("Índice fuera de los límites: " + i);
    }

    Node current = pFirst; // Comienza desde el primer nodo
    for (int index = 0; index < i; index++) {
        current = current.getpNextN(); // Avanza al siguiente nodo
    }

        return current.getC(); 
    }
    
    
    
    

    /**
     * @return the pFirst
     */
    public Node getpFirst() {
        return pFirst;
    }

    /**
     * @param pFirst the pFirst to set
     */
    public void setpFirst(Node pFirst) {
        this.pFirst = pFirst;
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
    
    
}
