/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2_sistemasoperativos;

import Data.FileMovies;
import java.io.File;

/**
 *
 * @author gigie
 */
public class App {
    private static String data = "test//data.txt";
    private static File file = new File(data);
    
   
    
    public void start() {
        
        
        
        FileMovies fileProcessor = new FileMovies();
        fileProcessor.read(file);
        fileProcessor.printCharacters(); 
    }
}
