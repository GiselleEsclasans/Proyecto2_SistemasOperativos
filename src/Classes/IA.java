/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyecto2_sistemasoperativos.App;

public class IA extends Thread {
    private Admin admin;
    private CharacterM starWarsC;
    private CharacterM starTrekC;
    private final Semaphore mutex;

    private long time = 10; 

    public IA() {
        
        this.admin = App.getApp().getAdmin();
        this.mutex = App.getApp().getMutex();
    }
    

    @Override 
    public void run() {
        while (true) {
            try {
                this.mutex.acquire();
            
                //Thread.sleep((long) (this.getTime() * 1000 * 0.7));
                // Procesar la batalla
                
                
                
                String result = processBattle(this.getStarWarsC(), this.getStarTrekC());
                
                System.out.println(result);
                
                
                
                Thread.sleep((long) ((getTime() * 1000 * 0.3) * 0.4));
                this.mutex.release();
                Thread.sleep(100);

            } catch (InterruptedException ex) {
                Logger.getLogger(IA.class.getName()).log(Level.SEVERE, "Sleep interrupted", ex);
            
            }
        }
    }

    private String processBattle(CharacterM starWarsC, CharacterM starTrekC) throws InterruptedException {
      

        Random random = new Random();
        int outcome = random.nextInt(100); 

        if (outcome < 40) { 
            return declareWinner(starWarsC, starTrekC);
        } else if (outcome < 67) { 
            return declareDraw(starWarsC, starTrekC);
        } else { 
            return declareNoFight(starWarsC, starTrekC);
        }
    }

    private String declareWinner(CharacterM winner, CharacterM loser) {
     
        admin.addWinner(winner);
        //return "Winner: " + winner.toString() + ", Loser: " + loser.toString();
        return "gano";
    }

    private String declareDraw(CharacterM char1, CharacterM char2) {
        admin.reinsertToQueue1(char1);
        admin.reinsertToQueue1(char2);
        //return "Draw between " + char1.toString() + " and " + char2.toString();
        return "empate";
    }

    private String declareNoFight(CharacterM char1, CharacterM char2) {
        admin.sendToReinforcement(char1);
        admin.sendToReinforcement(char2);
        //return "No fight possible for " + char1.toString() + " and " + char2.toString();
        return "no hubo pelea";
    }

    
    
    /**
     * @return the admin
     */
    public Admin getAdmin() {
        return admin;
    }

    /**
     * @param admin the admin to set
     */
    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    /**
     * @return the starWarsC
     */
    public CharacterM getStarWarsC() {
        return starWarsC;
    }

    /**
     * @param starWarsC the starWarsC to set
     */
    public void setStarWarsC(CharacterM starWarsC) {
     
        this.starWarsC = starWarsC;
    }

    /**
     * @return the starTreckC
     */
    public CharacterM getStarTreckC() {
        return getStarTrekC();
    }

    /**
     * @param starTreckC the starTreckC to set
     */
    public void setStarTrekC(CharacterM starTreckC) {
        this.starTrekC = starTreckC;
    }

    /**
     * @return the mutex
     */
    public Semaphore getMutex() {
        return mutex;
    }

    

    /**
     * @return the time
     */
    public long getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(long time) {
        this.time = time;
    }

    /**
     * @return the starTrekC
     */
    public CharacterM getStarTrekC() {
        return starTrekC;
    }
    
    
}
