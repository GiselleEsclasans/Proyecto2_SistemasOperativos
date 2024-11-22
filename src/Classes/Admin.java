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
import Interfaz.ControlInterfaz;
import java.util.logging.Logger;
import java.util.logging.Level;


public class Admin extends Thread {
    private final Semaphore mutex;
    private IA ia;
    private final Movie starWars;
    private final Movie starTrek;
    private int cycle = 0;

    public Admin(IA ia, Semaphore mutex, LinkedList fPriority1, LinkedList sPriority1, LinkedList tPriority1, LinkedList fPriority2, LinkedList sPriority2, LinkedList tPriority2) {
        this.ia = ia;
        this.mutex = mutex;
        this.starWars = new Movie("STAR WARS", fPriority1, sPriority1, tPriority1);
        this.starTrek = new Movie("STAR TREK", fPriority2, sPriority2, tPriority2);
    }
    
    public void startSimulation() {
        
        
        ControlInterfaz.getHome().updateUIQueueSW(getStarWars().getFirstQ(), getStarWars().getSecondQ(), getStarWars().getThirdQ(), getStarWars().getBakingQ());
        ControlInterfaz.getHome().updateUIQueueST(getStarTrek().getFirstQ(), getStarTrek().getSecondQ(), getStarTrek().getThirdQ(), getStarTrek().getBakingQ());
        
        
        ControlInterfaz.getHome().setVisible(true);
        
        
        
         try {
            mutex.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }

    
    this.start();
    this.getIa().start(); 
}

    

    @Override
    public void run() {
       
        while (true) {
            try {
                int battleDuration = ControlInterfaz.getHome().getBattleDuration().getValue();
                ia.setTime(battleDuration);

                //this.starTrek.printQueues();
                //this.starWars.printQueues();
                
                updatebakingQ(this.starWars);
                updatebakingQ(this.starTrek);
                

                if (cycle >= 2) { 
                    createCharactersP();
                    cycle = 0; 
                }

                CharacterM sWCharacter = chooseCharacter(this.getStarWars());
                CharacterM sTCharacter = chooseCharacter(this.getStarTrek());

         
                this.ia.setStarWarsC(sWCharacter);
                this.ia.setStarTrekC(sTCharacter);
                
                //Atualizar las colas en la interfaz
                updateUIqueue();
                
                mutex.release();
                Thread.sleep(100);
                mutex.acquire();
                
                
                risePriority(this.getStarWars());
                risePriority(this.getStarTrek());
                

                cycle++; 
                
                //Atualizar las colas en la interfaz
                updateUIqueue();
                
                
               

            } catch (InterruptedException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, "Admin run interrupted", ex);
           
        }
    }}
    
    
    public void updatebakingQ(Movie movie){
         if (!(movie.getBakingQ().isEmpty())) {
            double randomNum = Math.random();

            if (randomNum <= 0.4) {
                
                CharacterM character = movie.getBakingQ().dequeue();
                character.setCounter(0);
                movie.getFirstQ().enqueue(character);
            }else {
            CharacterM character = movie.getBakingQ().dequeue();
            movie.getBakingQ().enqueue(character);
            }
        }
    }

   

    public void addWinner(CharacterM winner) {
        if (winner.getMovie().equals("STAR WARS")) {
            starWars.getWinners().insert(winner); 
        } else if (winner.getMovie().equals("STAR TREK")) {
            starTrek.getWinners().insert(winner);
        }
        //System.out.println("Winner: " + winner.toString());
    }

    public void removeCharacter(CharacterM character) {
        if (character.getMovie().equals("STAR WARS")) {
            starTrek.getFirstQ().dequeue();
        } else if (character.getMovie().equals("STAR TREK")) {
            starWars.getFirstQ().dequeue();
        }
        //System.out.println("Eliminado: " + character.toString());
    }

    public void reinsertToQueue1(CharacterM character) {
       
         if (character.getMovie().equals("STAR WARS")) {
            starWars.getFirstQ().enqueue(character);
        } else if (character.getMovie().equals("STAR TREK")) {
            starTrek.getFirstQ().enqueue(character);
        }
        //System.out.println("LLevado a la cola 1 de último: " + character.toString());
    }

    public void sendToReinforcement(CharacterM character) {
         if (character.getMovie().equals("STAR WARS")) {
            starWars.getBakingQ().enqueue(character);
        } else if (character.getMovie().equals("STAR TREK")) {
            starTrek.getBakingQ().enqueue(character);
        }
        //System.out.println("LLevado a la cola de refuerzo: " + character.toString());
    }

    private void risePriority(Movie movie) {
      
        riseQueue(movie.getSecondQ(), movie.getFirstQ());
        riseQueue(movie.getThirdQ(), movie.getSecondQ());
    }

    private void riseQueue(Queue currentLevel, Queue nextLevel) {
        int len = currentLevel.getSize();
       
        for (int i = 0; i < len; i++) {
            CharacterM c = currentLevel.dequeue();
            c.setCounter(c.getCounter() + 1);
           

            if (c.getCounter() >= 8) {
                
                c.setCounter(0);
                nextLevel.enqueue(c);
                
            } else {
                currentLevel.enqueue(c);
            }
        }
    }

    private CharacterM chooseCharacter(Movie movie) {
        if (movie.getFirstQ().isEmpty()) {
            movie.updateQueue1();
            this.updateUIqueue();
        }
        
   
        CharacterM fighter = movie.getFirstQ().dequeue();
        fighter.setCounter(0);
        return fighter;
    }

    
    private void createCharactersP() {
        
        double randomNum = Math.random();
        if (randomNum <= 0.8) {
            this.getStarWars().createCharacter();
            this.getStarTrek().createCharacter();
        }
    }
    
    public void updateUIqueue() {
        ControlInterfaz.updateUIQueue("STAR WARS",
                this.getStarWars().getFirstQ(),
                this.getStarWars().getSecondQ(),
                this.getStarWars().getThirdQ(),
                this.getStarWars().getBakingQ());
        ControlInterfaz.updateUIQueue("STARTREK",
                this.getStarTrek().getFirstQ(),
                this.getStarTrek().getSecondQ(),
                this.getStarTrek().getThirdQ(),
                this.getStarTrek().getBakingQ());
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

    /**
     * @return the ia
     */
    public IA getIa() {
        return ia;
    }

    /**
     * @param ia the ia to set
     */
    public void setIa(IA ia) {
        this.ia = ia;
    }

    /**
     * @return the cycle
     */
    public int getCycle() {
        return cycle;
    }

    /**
     * @param cycle the cycle to set
     */
    public void setCycle(int cycle) {
        this.cycle = cycle;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
