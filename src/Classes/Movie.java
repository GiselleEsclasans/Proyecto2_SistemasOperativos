/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import DataEstructure.LinkedList;
import DataEstructure.Queue;

/**
 *
 * @author gigie
 */
public class Movie {
    private LinkedList firstPriority;
    private LinkedList secondPriority;
    private LinkedList thirdPriority;
    
    private Queue firstQ = new Queue();
    private Queue secondQ = new Queue();
    private Queue thirdQ = new Queue();
    private Queue bakingQ = new Queue();
    
    
    public Movie(String movie, LinkedList firstP, LinkedList secondP, LinkedList thirdP){
        this.firstPriority = firstP;
        this.secondPriority = secondP;
        this.thirdPriority = thirdP;
    
    }
    
    
    
    public void EnqueueC(CharacterM character) {
       
        switch (character.getPriority()) {
            case 1:
                getFirstQ().enqueue(character);
                break;
            case 2:
                getSecondQ().enqueue(character);
                break;
            case 3:
                getThirdQ().enqueue(character);
                break;
            default:
                System.out.println("Prioridad no válida. El personaje no se encolará.");
                break;
        }
    }


    public void updateQueue1() {
     
        if (!secondQ.isEmpty()) {
            
            CharacterM character = getSecondQ().dequeue();
     
            System.out.println("Updated from secondQ"); 
     
            getFirstQ().enqueue(character);
        } else if (!thirdQ.isEmpty()) {

            CharacterM character = getThirdQ().dequeue();
        
            System.out.println("Updated from thirdQ"); 
       
            getFirstQ().enqueue(character);
        } else {
            System.out.println("No hay personajes en secondQ o thirdQ para mover a firstQ.");
        }
    }

    /**
     * @return the firstPriority
     */
    public LinkedList getFirstPriority() {
        return firstPriority;
    }

    /**
     * @param firstPriority the firstPriority to set
     */
    public void setFirstPriority(LinkedList firstPriority) {
        this.firstPriority = firstPriority;
    }

    /**
     * @return the secondPriority
     */
    public LinkedList getSecondPriority() {
        return secondPriority;
    }

    /**
     * @param secondPriority the secondPriority to set
     */
    public void setSecondPriority(LinkedList secondPriority) {
        this.secondPriority = secondPriority;
    }

    /**
     * @return the thirdPriority
     */
    public LinkedList getThirdPriority() {
        return thirdPriority;
    }

    /**
     * @param thirdPriority the thirdPriority to set
     */
    public void setThirdPriority(LinkedList thirdPriority) {
        this.thirdPriority = thirdPriority;
    }

    /**
     * @return the firstQ
     */
    public Queue getFirstQ() {
        return firstQ;
    }

    /**
     * @param firstQ the firstQ to set
     */
    public void setFirstQ(Queue firstQ) {
        this.firstQ = firstQ;
    }

    /**
     * @return the secondQ
     */
    public Queue getSecondQ() {
        return secondQ;
    }

    /**
     * @param secondQ the secondQ to set
     */
    public void setSecondQ(Queue secondQ) {
        this.secondQ = secondQ;
    }

    /**
     * @return the thirdQ
     */
    public Queue getThirdQ() {
        return thirdQ;
    }

    /**
     * @param thirdQ the thirdQ to set
     */
    public void setThirdQ(Queue thirdQ) {
        this.thirdQ = thirdQ;
    }

    /**
     * @return the bakingQ
     */
    public Queue getBakingQ() {
        return bakingQ;
    }

    /**
     * @param bakingQ the bakingQ to set
     */
    public void setBakingQ(Queue bakingQ) {
        this.bakingQ = bakingQ;
    }

}
