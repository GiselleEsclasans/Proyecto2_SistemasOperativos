/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;

import DataEstructure.Queue;

/**
 *
 * @author gigie
 */
public class ControlInterfaz {
    private static final Home home = new Home();
    
    public static Home getHome() {
        return home;
    }
    
    public static void updateUIQueue( String movie,Queue queue1, Queue queue2, Queue queue3, Queue queue4) {
        if (movie.equalsIgnoreCase("STAR WARS")) {
            home.updateUIQueueSW(queue1, queue2, queue3, queue4);
        } else {
            home.updateUIQueueST(queue1, queue2, queue3, queue4);
        }
        
    }
    
    
    
}
