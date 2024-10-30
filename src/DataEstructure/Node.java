/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataEstructure;

/**
 *
 * @author gigie
 */


public class Node {
    private Node pNextN;
    private Character c;
    private int id;

    public Node(Character c) {
        this.pNextN = null;
        this.c = c;
    }
    
    public Node() {
        this.pNextN = null;
        this.c = null;
    }

    
    
    /**
     * @return the pNextN
     */
    public Node getpNextN() {
        return pNextN;
    }

    /**
     * @param pNextN the pNextN to set
     */
    public void setpNextN(Node pNextN) {
        this.pNextN = pNextN;
    }

    /**
     * @return the c
     */
    public Character getC() {
        return c;
    }

    /**
     * @param c the c to set
     */
    public void setC(Character c) {
        this.c = c;
    }

    /**
     * @return the id
     */
   
    
    
}
