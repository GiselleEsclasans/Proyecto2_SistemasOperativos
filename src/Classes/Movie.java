/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import DataEstructure.LinkedList;
import DataEstructure.Node;
import DataEstructure.Queue;
import java.util.Random;

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
    private LinkedList winners;
    private String movie;
    private int count = 0;
    
    
    public Movie(String movie, LinkedList firstP, LinkedList secondP, LinkedList thirdP){
        this.movie = movie;
        this.firstPriority = firstP;
        this.secondPriority = secondP;
        this.thirdPriority = thirdP;
        this.winners = new LinkedList(); 
        transferCharactersToQueues();
    
    }
    
    public void transferCharactersToQueues() {
        for (int i = 0; i < getFirstPriority().getSize(); i++) {
            CharacterM character = getFirstPriority().get(i); 
            getFirstQ().enqueue(character);
        }

        for (int i = 0; i < getSecondPriority().getSize(); i++) {
            CharacterM character = getSecondPriority().get(i);
            getSecondQ().enqueue(character);
        }

        for (int i = 0; i < getThirdPriority().getSize(); i++) {
            CharacterM character = getThirdPriority().get(i);
            getThirdQ().enqueue(character);
        }


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
     
     
            getFirstQ().enqueue(character);
        } else if (!thirdQ.isEmpty()) {

            CharacterM character = getThirdQ().dequeue();
        
       
            getFirstQ().enqueue(character);
        } else {
            //System.out.println("No hay personajes en secondQ o thirdQ para mover a firstQ.");
        }
    }
    
    public void printQueues() {
        System.out.println("\n" + this.getMovie());
        System.out.print("1: ");
        printQueue(firstQ);

        System.out.print("2: ");
        printQueue(secondQ);

        System.out.print("3: ");
        printQueue(thirdQ);
        System.out.print("4: ");
        printQueue(bakingQ);
    }
    
    private void printQueue(Queue queue) {
        if (queue.isEmpty()) {
            //System.out.println("Queue is empty.");
            System.out.println("0");
            return;
        }

       
        System.out.println(queue.getSize());
    }
    
    
    
    
    
    
    
    
    
    public void createCharacter(){
        if (this.count == 19){
            this.count = 0 ;
        }
        
       
        if(this.getMovie() == "STAR WARS"){
            String[] starWarsNames = {"Luke Skywalker", "Darth Vader", "Yoda", "Princess Leia", "Han Solo", "Obi-Wan Kenobi", "Anakin Skywalker", "Mace Windu", "Qui-Gon Jinn", "Padmé Amidala", "C-3PO", "R2-D2", "Chewbacca", "Lando Calrissian", "Boba Fett", "Jabba the Hutt", "Emperor Palpatine", "Darth Maul", "Grand Moff Tarkin", "Mon Mothma"};
            String name = starWarsNames[this.count % starWarsNames.length];
            String skill = getSkill();
            int life = getLife();
            int strength = getStrength();
            int agility = getAgility();
            
            
            int priority = getPriority(skill, life, strength, agility);
            String type = getType(priority);
            String movie = "STAR WARS"; 
            
            CharacterM character = new CharacterM(name, priority, type, skill, life, strength, agility, movie);
            EnqueueC(character);
            //System.out.println("Se añadió a STAR WARS" + priority );
            
        }
         
        // Personajes de Star Trek
        if(this.getMovie() == "STAR TREK"){
        String[] starTrekNames = {"James T. Kirk", "Spock", "Leonard McCoy", "Jean-Luc Picard", "Data", "William Riker", "Deanna Troi", "Geordi La Forge", "Worf", "Beverly Crusher", "Montgomery Scott", "Hikaru Sulu", "Nyota Uhura", "Pavel Chekov", "Leonard Nimoy", "Patrick Stewart", "Jonathan Frakes", "Marina Sirtis", "Brent Spiner", "Gates McFadden"};
        
            String name = starTrekNames[this.count % starTrekNames.length];
            
            String skill = getSkill();
            int life = getLife();
            int strength = getStrength();
            int agility = getAgility();
            
            int priority = getPriority(skill, life, strength, agility);
            String type = getType(priority);
            
            String movie = "STAR TREK";
            
            CharacterM character = new CharacterM(name, priority, type, skill, life, strength, agility, movie);
            EnqueueC(character);
            //System.out.println("Se añadió a STAR TREK" + priority);
        }
        this.count ++;
        
        
    }
    
    private static int getPriority(String skill, int life, int strength, int agility) {
        int aux = 0;
        
        if ("Fuerza".equals(skill) || "Diplomacia".equals(skill) || "Medicina".equals(skill) || "Liderazgo".equals(skill)){ aux ++;}
        if (life >= 120 ){ aux ++;}
        if (strength >= 120 ){aux ++;}
        if (agility >= 120 ){aux ++;}
        
        
        if (aux < 2){return 3;} 
        if (aux == 2){return 2;} else{return 1;}
    }

    private static String getType(int priority) {
        if (priority == 1) {
            return "Excepcional";
        } else if (priority == 2) {
            return "Promedio";
        } else {
            return "Deficiente";
        }
    }

    private static String getSkill() {
    Random random = new Random();
    
    if (random.nextInt(100) < 60) {
        
        String[] qualitySkills = {"Fuerza", "Diplomacia", "Medicina", "Liderazgo"};
        return qualitySkills[random.nextInt(qualitySkills.length)];
    } else {
     
        String[] normalSkills = {"Aguante", "Piloto", "Logica", "Analisis"};
        return normalSkills[random.nextInt(normalSkills.length)];
    }
}

    private static int getLife() {
        Random random = new Random();

        if (random.nextInt(100) < 70) { 
            return random.nextInt(81) + 120; 
        } else {
            return random.nextInt(40) + 80; 
        }
        
    }

    private static int getStrength() {
        Random random = new Random();
    
        if (random.nextInt(100) < 50) { 
            return random.nextInt(81) + 120; 
        } else {
            return random.nextInt(40) + 80;
        }
       
    }

    private static int getAgility() {
         Random random = new Random();
    // 40% de probabilidad de que la agilidad sea de calidad (120-200)
    if (random.nextInt(100) < 40) { // 40% de probabilidad
        return random.nextInt(81) + 120; // Genera un número entre 120 y 200
    } else {
        return random.nextInt(40) + 80; // Genera un número entre 80 y 119
    }}

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

    /**
     * @return the winners
     */
    public LinkedList getWinners() {
        return winners;
    }

    /**
     * @param winners the winners to set
     */
    public void setWinners(LinkedList winners) {
        this.winners = winners;
    }

    /**
     * @return the movie
     */
    public String getMovie() {
        return movie;
    }

    /**
     * @param movie the movie to set
     */
    public void setMovie(String movie) {
        this.movie = movie;
    }

}
