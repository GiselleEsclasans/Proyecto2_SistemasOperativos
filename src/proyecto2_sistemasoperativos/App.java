/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2_sistemasoperativos;

import Classes.Admin;
import Classes.IA;
import Data.FileMovies;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 *
 * @author gigie
 */
public class App {
    private static String data = "test//data.txt";
    private static File file = new File(data);
    
    private static Semaphore mutex = new Semaphore(1);
    private static int battleDuration = 10;
  
    private static Admin admin;
    private static IA ia;
    
    private static App app;
          
    public static synchronized App getInstance() {
        if (getApp() == null) {
            setApp(new App());
        }
        return getApp();
    }
    
    
   
    
    public void start() throws IOException {
        FileMovies fileProcessor = new FileMovies();
        fileProcessor.read(getFile());
        //fileProcessor.printCharacters();
        
        
      
        this.ia = new IA();
        
        Admin admin = new Admin(this.ia, this.mutex, fileProcessor.getFirstStarWars(), fileProcessor.getSecondStarWars(), fileProcessor.getThirdStarWars(), fileProcessor.getFirstStarTrek(), fileProcessor.getSecondStarTrek(), fileProcessor.getThirdStarTrek());
    
        this.admin = admin;
        this.admin.getIa().setAdmin(admin);

        this.admin.startSimulation();
       
       
       
       /*FileWriter fichero = new FileWriter("test//data.txt", false);

        // Personajes de Star Wars
        fichero.write("<STAR WARS>");
        fichero.write("\n");
        String[] starWarsNames = {"Luke Skywalker", "Darth Vader", "Yoda", "Princess Leia", "Han Solo", "Obi-Wan Kenobi", "Anakin Skywalker", "Mace Windu", "Qui-Gon Jinn", "Padmé Amidala", "C-3PO", "R2-D2", "Chewbacca", "Lando Calrissian", "Boba Fett", "Jabba the Hutt", "Emperor Palpatine", "Darth Maul", "Grand Moff Tarkin", "Mon Mothma"};
        for (int i = 0; i < 20; i++) {
            String name = starWarsNames[i % starWarsNames.length];
            String skill = getSkill();
            int life = getLife();
            int strength = getStrength();
            int agility = getAgility();
            
            
            int priority = getPriority(skill, life, strength, agility);
            String type = getType(priority);
            String moviez = "STAR WARS";
            
            fichero.write(name + "," + priority + "," + type + "," + skill + "," + life + "," + strength + "," + agility + "," + moviez + "\n");
        }
            fichero.write("\n");
        fichero.write("<STAR TREK>");
            fichero.write("\n");
        // Personajes de Star Trek
        String[] starTrekNames = {"James T. Kirk", "Spock", "Leonard McCoy", "Jean-Luc Picard", "Data", "William Riker", "Deanna Troi", "Geordi La Forge", "Worf", "Beverly Crusher", "Montgomery Scott", "Hikaru Sulu", "Nyota Uhura", "Pavel Chekov", "Leonard Nimoy", "Patrick Stewart", "Jonathan Frakes", "Marina Sirtis", "Brent Spiner", "Gates McFadden"};
        for (int i = 0; i < 20; i++) {
            String name = starTrekNames[i % starTrekNames.length];
            String skill = getSkill();
            int life = getLife();
            int strength = getStrength();
            int agility = getAgility();
            
            int priority = getPriority(skill, life, strength, agility);
            String type = getType(priority);
            String moviez = "STAR TREK";

            fichero.write(name + "," + priority + "," + type + "," + skill + "," + life + "," + strength + "," + agility + "," + moviez +"\n");
        }

        fichero.close();
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
    }*/
    }

    /**
     * @return the data
     */
    public static String getData() {
        return data;
    }

    /**
     * @param aData the data to set
     */
    public static void setData(String aData) {
        data = aData;
    }

    /**
     * @return the file
     */
    public static File getFile() {
        return file;
    }

    /**
     * @param aFile the file to set
     */
    public static void setFile(File aFile) {
        file = aFile;
    }

    /**
     * @return the mutex
     */
    public static Semaphore getMutex() {
        return mutex;
    }

    /**
     * @param aMutex the mutex to set
     */
    public static void setMutex(Semaphore aMutex) {
        mutex = aMutex;
    }

    /**
     * @return the battleDuration
     */
    public static int getBattleDuration() {
        return battleDuration;
    }

    /**
     * @param aBattleDuration the battleDuration to set
     */
    public static void setBattleDuration(int aBattleDuration) {
        battleDuration = aBattleDuration;
    }

    /**
     * @return the admin
     */
    public static Admin getAdmin() {
        return admin;
    }

    /**
     * @param aAdmin the admin to set
     */
    public static void setAdmin(Admin aAdmin) {
        admin = aAdmin;
    }

    /**
     * @return the ia
     */
    public static IA getIa() {
        return ia;
    }

    /**
     * @param aIa the ia to set
     */
    public static void setIa(IA aIa) {
        ia = aIa;
    }

    /**
     * @return the app
     */
    public static App getApp() {
        return app;
    }

    /**
     * @param aApp the app to set
     */
    public static void setApp(App aApp) {
        app = aApp;
    }
    
    
    
}
