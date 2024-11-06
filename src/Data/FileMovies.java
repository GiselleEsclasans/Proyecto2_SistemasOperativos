/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import Classes.CharacterM;
import DataEstructure.LinkedList;
import java.io.BufferedReader;  // Para leer el archivo línea por línea
import java.io.File;            // Para trabajar con archivos
import java.io.FileReader;      // Para leer archivos
import java.io.IOException;  

/**
 *
 * @author gigie
 */
public class FileMovies {
    private LinkedList firstStarWars = new LinkedList();
    private LinkedList secondStarWars = new LinkedList();
    private LinkedList thirdStarWars = new LinkedList();
    
    private LinkedList firstStarTrek = new LinkedList();
    private LinkedList secondStarTrek = new LinkedList();
    private LinkedList thirdStarTrek = new LinkedList();
    
    
    public void read(File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            String currentSeries = "";

            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.equals("<STAR WARS>")) {
                    currentSeries = "STAR WARS";
                } else if (line.equals("<STAR TRECK>")) {
                    currentSeries = "STAR TREK";
                } else if (!line.isEmpty()) {
                    String[] parts = line.split(",");
                    if (parts.length == 7) {
                        String id = parts[0];
                        int priority = Integer.parseInt(parts[1]);
                        String quality = parts[2];
                        String skill = parts[3];
                        int life = Integer.parseInt(parts[4]);
                        int strength = Integer.parseInt(parts[5]);
                        int agility = Integer.parseInt(parts[6]);

                        CharacterM character = new CharacterM(id, priority, quality, skill, life, strength, agility);

                        // Insertar en la lista correspondiente
                        if (currentSeries.equals("STAR WARS")) {
                            switch (priority) {
                                case 1:
                                    getFirstStarWars().insert(character);
                                    break;
                                case 2:
                                    getSecondStarWars().insert(character);
                                    break;
                                case 3:
                                    getThirdStarWars().insert(character);
                                    break;
                            }
                        } else if (currentSeries.equals("STAR TREK")) {
                            switch (priority) {
                                case 1:
                                    getFirstStarTrek().insert(character);
                                    break;
                                case 2:
                                    getSecondStarTrek().insert(character);
                                    break;
                                case 3:
                                    getThirdStarTrek().insert(character);
                                    break;
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public void printCharacters() {
    System.out.println("Star Wars Characters:");
    printCharacterList(getFirstStarWars());
    printCharacterList(getSecondStarWars());
    printCharacterList(getThirdStarWars());
    
    System.out.println("Star Trek Characters:");
    printCharacterList(getFirstStarTrek());
    printCharacterList(getSecondStarTrek());
    printCharacterList(getThirdStarTrek());
}

    private void printCharacterList(LinkedList list) {
       
        for (int i = 0; i < list.getSize(); i++) {
            CharacterM character = list.get(i); 
            System.out.println(character); 
        }
    }
    
    
    
    
    
    
     /*
        Insertar en el .txt ----------------------------------------------------------------
        
       FileWriter fichero = new FileWriter("test//data.txt", false);

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
            
            fichero.write(name + "," + priority + "," + type + "," + skill + "," + life + "," + strength + "," + agility + ";\n");
        }
            fichero.write("\n");
        fichero.write("<STAR TRECK>");
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

            fichero.write(name + "," + priority + "," + type + "," + skill + "," + life + "," + strength + "," + agility + "\n");
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
    }
    
    */

    /**
     * @return the firstStarWars
     */
    public LinkedList getFirstStarWars() {
        return firstStarWars;
    }

    /**
     * @param firstStarWars the firstStarWars to set
     */
    public void setFirstStarWars(LinkedList firstStarWars) {
        this.firstStarWars = firstStarWars;
    }

    /**
     * @return the secondStarWars
     */
    public LinkedList getSecondStarWars() {
        return secondStarWars;
    }

    /**
     * @param secondStarWars the secondStarWars to set
     */
    public void setSecondStarWars(LinkedList secondStarWars) {
        this.secondStarWars = secondStarWars;
    }

    /**
     * @return the thirdStarWars
     */
    public LinkedList getThirdStarWars() {
        return thirdStarWars;
    }

    /**
     * @param thirdStarWars the thirdStarWars to set
     */
    public void setThirdStarWars(LinkedList thirdStarWars) {
        this.thirdStarWars = thirdStarWars;
    }

    /**
     * @return the firstStarTrek
     */
    public LinkedList getFirstStarTrek() {
        return firstStarTrek;
    }

    /**
     * @param firstStarTrek the firstStarTrek to set
     */
    public void setFirstStarTrek(LinkedList firstStarTrek) {
        this.firstStarTrek = firstStarTrek;
    }

    /**
     * @return the secondStarTrek
     */
    public LinkedList getSecondStarTrek() {
        return secondStarTrek;
    }

    /**
     * @param secondStarTrek the secondStarTrek to set
     */
    public void setSecondStarTrek(LinkedList secondStarTrek) {
        this.secondStarTrek = secondStarTrek;
    }

    /**
     * @return the thirdStarTrek
     */
    public LinkedList getThirdStarTrek() {
        return thirdStarTrek;
    }

    /**
     * @param thirdStarTrek the thirdStarTrek to set
     */
    public void setThirdStarTrek(LinkedList thirdStarTrek) {
        this.thirdStarTrek = thirdStarTrek;
    }
    
}
