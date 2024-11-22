/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import Interfaz.ControlInterfaz;
import java.awt.Image;
import java.net.URL;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import proyecto2_sistemasoperativos.App;

public class IA extends Thread {
    private Admin admin;
    private CharacterM starWarsC;
    private CharacterM starTrekC;
    private final Semaphore mutex;

    private long time; 
    private int winnersStarWars = 0;
    private int winnersStarTrek = 0;
    private int round;

    public IA() {
        
        this.admin = App.getApp().getAdmin();
        this.mutex = App.getApp().getMutex();
        this.time = App.getApp().getBattleDuration();
        this.round = 0;
    }
    

    @Override 
    public void run() {
        while (true) {
            try {
                this.mutex.acquire();
                this.round ++;
                ControlInterfaz.getHome().getbattleStatus().setText("");
                ControlInterfaz.getHome().getround().setText(String.valueOf(round));

                ControlInterfaz.getHome().getiaState().setText("Procesando combate");
                //Actualizar personaje en pelea
                updateCharactersUI(this.getStarWarsC(), this.getStarTrekC());
                
                
                 Thread.sleep((long) (this.getTime() * 1000 * 0.7));
                
                processBattle(this.getStarWarsC(), this.getStarTrekC());
                
                ControlInterfaz.getHome().getiaState().setText("Se finalizó la desición");
                
            
                ControlInterfaz.getHome().getiaState().setText("Esperando jugadores");
                
                
                Thread.sleep((long) ((getTime() * 1000 * 0.3) * 0.4));
                this.mutex.release();
                Thread.sleep(100);

            } catch (InterruptedException ex) {
                Logger.getLogger(IA.class.getName()).log(Level.SEVERE, "Sleep interrupted", ex);
            
            }
        }
    }

    private void processBattle(CharacterM starWarsC, CharacterM starTrekC) throws InterruptedException {
      
        
        Random random = new Random();
        int outcome = random.nextInt(100); 

        if (outcome < 40) { 
            declareWinner(starWarsC, starTrekC);
            Thread.sleep((long) ((getTime() * 1000 * 0.3) * 0.6));
        } else if (outcome < 67) { 
            Thread.sleep((long) ((getTime() * 1000 * 0.3) * 0.6));
            declareDraw(starWarsC, starTrekC);
            
        } else { 
            Thread.sleep((long) ((getTime() * 1000 * 0.3) * 0.6));
            declareNoFight(starWarsC, starTrekC);
            
        }
    }

    private void declareWinner(CharacterM cSW, CharacterM cST) {
        
        int lifeSW = starWarsC.getLife();
        int lifeST = starTrekC.getLife();
        
        while (starWarsC.getLife() > 0 && starTrekC.getLife() > 0) {
            int damageToST = (starWarsC.getStrength() + starWarsC.getAgility())/10;
            lifeST = lifeST - damageToST;
            if(lifeST >= 0){
            ControlInterfaz.getHome().getcSTL().setText(String.valueOf(lifeST));
            } else {
                ControlInterfaz.getHome().getcSTL().setText(String.valueOf(0));
            }
            
            ControlInterfaz.getHome().getBattleS().setText("Star Wars inflige " + damageToST);
                // Esto dará 1000 milisegundos

            // Verificar si Star Trek ha sido derrotado
            if (lifeST <= 0) {
                admin.addWinner(cSW);
                starWarsC.setLife(lifeSW);
                winnersStarWars++;
        
                ControlInterfaz.getHome().getwinStarWars().setText(String.valueOf(winnersStarWars));
                ControlInterfaz.getHome().getbattleStatus().setText("Ha ganado StarWars");
                return;
            }

            // Star Trek ataca
            int damageToSW = (starTrekC.getStrength() + starTrekC.getAgility())/10;
            lifeSW = lifeSW - damageToSW;
            
            if(lifeSW >= 0){
            ControlInterfaz.getHome().getcSWL().setText(String.valueOf(lifeSW));}
             else {
                ControlInterfaz.getHome().getcSWL().setText(String.valueOf(0));
            }
            ControlInterfaz.getHome().getBattleS().setText("Star Trek inflige " + damageToSW);
           

            // Verificar si Star Wars ha sido derrotado
            if (lifeSW <= 0) {
                admin.addWinner(cST);
                starTrekC.setLife(lifeST);
                winnersStarTrek++;
        
                ControlInterfaz.getHome().getwinStarTrek().setText(String.valueOf(winnersStarTrek));
                ControlInterfaz.getHome().getbattleStatus().setText("Ha ganado StarTrek");
                return;
            }

            
        }
        ControlInterfaz.getHome().getBattleS().setText("");
    }

    private String declareDraw(CharacterM char1, CharacterM char2) {
        admin.reinsertToQueue1(char1);
        admin.reinsertToQueue1(char2);
        ControlInterfaz.getHome().getbattleStatus().setText("Ha ocurrido un empate");
        //return "Draw between " + char1.toString() + " and " + char2.toString();
        return "empate";
    }

    private String declareNoFight(CharacterM char1, CharacterM char2) {
        admin.sendToReinforcement(char1);
        admin.sendToReinforcement(char2);
        ControlInterfaz.getHome().getbattleStatus().setText("No se ha podido realizar el combate");
        //return "No fight possible for " + char1.toString() + " and " + char2.toString();
        return "no hubo pelea";
    }
    
    
    
    
    
    
    
    
    
    
    private void updateCharactersUI(CharacterM charSW, CharacterM charST){
       

        
        ControlInterfaz.getHome().setIMGLabelSW(charSW.getUrlIMG());
        ControlInterfaz.getHome().getcStarWars().setText(charSW.getId());
        ControlInterfaz.getHome().getcSWH().setText(charSW.getSkill());
        ControlInterfaz.getHome().getcSWL().setText(String.valueOf(charSW.getLife()));
        ControlInterfaz.getHome().getcSWS().setText(String.valueOf(charSW.getStrength()));
        ControlInterfaz.getHome().getcSWA().setText(String.valueOf(charSW.getAgility()));
        ControlInterfaz.getHome().getcSWT().setText(charSW.getQuality());
        
        ControlInterfaz.getHome().setIMGLabelST(charST.getUrlIMG());
        ControlInterfaz.getHome().getcStarTrek().setText(charST.getId());
        ControlInterfaz.getHome().getcSTH().setText(charST.getSkill());
        ControlInterfaz.getHome().getcSTL().setText(String.valueOf(charST.getLife()));
        ControlInterfaz.getHome().getcSTS().setText(String.valueOf(charST.getStrength()));
        ControlInterfaz.getHome().getcSTA().setText(String.valueOf(charST.getAgility()));
        ControlInterfaz.getHome().getcSTT().setText(charST.getQuality());
        
        
    
    
    }
    
    public ImageIcon loadScaledImage(String path, int width, int height) {
        URL imgUrl = getClass().getResource(path);
        if (imgUrl != null) {
            ImageIcon originalIcon = new ImageIcon(imgUrl);
            Image scaledImage = originalIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(scaledImage);
        } else {
            System.err.println("No se pudo encontrar el recurso: " + path);
            return null;
        }
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
