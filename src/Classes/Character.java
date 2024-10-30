/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author gigie
 */
public class Character {
    private int cId;
    private String name;
    private String hability;
    private int lifePoints;
    private int strength;
    private String agility;
    private String status;
    
     private int priority;
    
    public Character(int cId, String name, String hability, int life, int strength, String agility){
        this.cId = cId;
        this.name = name;
        this.hability = hability; 
        this.lifePoints = life;
        this.strength = strength;
        this.agility = agility;
        
    
    }

    /**
     * @return the cId
     */
    public int getcId() {
        return cId;
    }

    /**
     * @param cId the cId to set
     */
    public void setcId(int cId) {
        this.cId = cId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the hability
     */
    public String getHability() {
        return hability;
    }

    /**
     * @param hability the hability to set
     */
    public void setHability(String hability) {
        this.hability = hability;
    }

    /**
     * @return the lifePoints
     */
    public int getLifePoints() {
        return lifePoints;
    }

    /**
     * @param lifePoints the lifePoints to set
     */
    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    /**
     * @return the strength
     */
    public int getStrength() {
        return strength;
    }

    /**
     * @param strength the strength to set
     */
    public void setStrength(int strength) {
        this.strength = strength;
    }

    /**
     * @return the agility
     */
    public String getAgility() {
        return agility;
    }

    /**
     * @param agility the agility to set
     */
    public void setAgility(String agility) {
        this.agility = agility;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the priority
     */
    public int getPriority() {
        return priority;
    }

    /**
     * @param priority the priority to set
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }
    
    
    
    
}
