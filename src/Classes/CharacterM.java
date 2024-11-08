/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author gigie
 */
public class CharacterM {
    private String id;
    private String movie;
    
    private String skill;
    private int life;
    private int strength;
    private int agility;
    
    private String status;
     private int counter = 0;
     
     private int priority;
     private String quality;
    
    public CharacterM(String id, int priority, String quality,  String skill, int life, int strength, int agility, String movie){
        this.id = id;
        this.priority = priority;
        this.quality = quality;
        this.skill = skill; 
        this.life = life;
        this.strength = strength;
        this.agility = agility;
        this.movie = movie;
    }
    
    
    @Override
    public String toString() {
        return  "Priority: " + getPriority() + ", Name: " + getId() + ", Quality: " + getQuality() + ", Skill: " + getSkill() + 
           ", Life: " + getLife() + ", Strength: " + getStrength() + ", Agility: " + getAgility();
    }
    
    public String toString2() {
        return  "" + getId();
    }
    
    
    
    public void addCount(){
        this.setCounter(this.getCounter() + 1);
    }
    
    
    
    
    

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
   

    /**
     * @return the skill
     */
    public String getSkill() {
        return skill;
    }

    /**
     * @param skill the skill to set
     */
    public void setSkill(String skill) {
        this.skill = skill;
    }

    /**
     * @return the life
     */
    public int getLife() {
        return life;
    }

    /**
     * @param life the life to set
     */
    public void setLife(int life) {
        this.life = life;
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
    public int getAgility() {
        return agility;
    }

    /**
     * @param agility the agility to set
     */
    public void setAgility(int agility) {
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

    /**
     * @return the counter
     */
    public int getCounter() {
        return counter;
    }

    /**
     * @param counter the counter to set
     */
    public void setCounter(int counter) {
        this.counter = counter;
    }

    /**
     * @return the quality
     */
    public String getQuality() {
        return quality;
    }

    /**
     * @param quality the quality to set
     */
    public void setQuality(String quality) {
        this.quality = quality;
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
