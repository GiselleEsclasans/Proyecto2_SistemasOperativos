/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author gigie
 */

import java.util.concurrent.Semaphore;
import DataEstructure.LinkedList;
import DataEstructure.Queue;
import java.util.logging.Logger;
import java.util.logging.Level;


public class Admin extends Thread{
    private final Semaphore mutex;
    private final Movie starWars;
    private final Movie starTrek;
    private int cycle = 0;
    
    public Admin(Semaphore mutex, LinkedList fPriority1, LinkedList sPriority1, LinkedList tPriority1, LinkedList fPriority2, LinkedList sPriority2, LinkedList tPriority2){
        
        this.mutex = mutex;
        this.starWars = new Movie("Star Wars",fPriority1, sPriority1, tPriority1);
        this.starTrek = new Movie("Star Trek",fPriority2, sPriority2, tPriority2);
    }
    
    public void start(){
    
        try {
            getMutex().acquire();
        } catch (InterruptedException ex){
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.start();
    }
    
    
    
    
    @Override
    public void run(){
        while (true){
            try{
               int battleDuration = 10; 
               
               if (cycle == 2){
                   createCharactersP();
                   cycle = 0;
                   
               }
               //Se eligen los personajes
               CharacterM sWCharacter = chooseCharacter(this.getStarWars());
               CharacterM sTCharacter = chooseCharacter(this.getStarTrek());
                       
                       
               //Ia obtiene los personajes
               
               //Actualizar colas
                getMutex().release();
               Thread.sleep(100);
                getMutex().acquire();
                
                this.cycle++;
               
               risePriority(this.starWars);
               risePriority(this.starTrek);
               //Actualizar colas 
               
            
            
            } catch(InterruptedException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
    
    }
    
    private void risePriority(Movie movie){
        riseQueue(movie.getSecondQ(), movie.getFirstQ());
        riseQueue(movie.getSecondQ(), movie.getThirdQ());
    }
    
    private void riseQueue(Queue currentLevel, Queue nextLevel){
        int len = currentLevel.getSize();
        
       

        
        
    }
    
    
    private CharacterM chooseCharacter(Movie movie){
        if (movie.getFirstQ().isEmpty()){
            movie.updateQueue1();
            
        }
        
        CharacterM fighter = movie.getFirstQ().dequeue();
        return fighter;
    }
    
    
    
    //Probabilidad 80% de crear un personaje
    
    private void createCharactersP() {
        double randomNum = Math.random();

        if (randomNum <= 0.8) {
            //this.getStarWars().createCharacter();
            //this.getStarTrek().createCharacter();
        }
    }

    /**
     * @return the mutex
     */
    public Semaphore getMutex() {
        return mutex;
    }

    /**
     * @return the starWars
     */
    public Movie getStarWars() {
        return starWars;
    }

    /**
     * @return the starTrek
     */
    public Movie getStarTrek() {
        return starTrek;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
