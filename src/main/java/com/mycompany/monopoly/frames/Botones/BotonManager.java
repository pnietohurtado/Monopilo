/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monopoly.frames.Botones;

import com.mycompany.monopoly.frames.GamePanel;
import java.awt.Graphics2D;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author pablo
 */
public class BotonManager extends Boton{
    
    GamePanel gp; 
    public Boton[] boton; 
    
    public BotonManager(GamePanel gp){
        this.gp = gp; 
        boton = new Boton[30]; 
        
        getBotonImage(); 
    }
    
    public void getBotonImage(){
        try{
            
            boton[0] = new Boton(); 
            boton[0].image = ImageIO.read(getClass().getResourceAsStream("/Botones/Pass.png")); 
            
            boton[1] = new Boton(); 
            boton[1].image = ImageIO.read(getClass().getResourceAsStream("/Botones/Name.png")); 
            
            boton[2] = new Boton(); 
            boton[2].image = ImageIO.read(getClass().getResourceAsStream("/Botones/Surname.png")); 
            
            boton[3] = new Boton(); 
            boton[3].image = ImageIO.read(getClass().getResourceAsStream("/Botones/User.png")); 
            
            boton[4] = new Boton(); 
            boton[4].image = ImageIO.read(getClass().getResourceAsStream("/Botones/Register.png")); 
            
            boton[5] = new Boton(); 
            boton[5].image = ImageIO.read(getClass().getResourceAsStream("/Botones/Arrow.png")); 
            
            // Botones en Azul 
            
            boton[6] = new Boton(); 
            boton[6].image = ImageIO.read(getClass().getResourceAsStream("/Botones/Arrow2.png")); 
            
            boton[7] = new Boton(); 
            boton[7].image = ImageIO.read(getClass().getResourceAsStream("/Botones/Surname2.png")); 
            
            boton[8] = new Boton(); 
            boton[8].image = ImageIO.read(getClass().getResourceAsStream("/Botones/Name2.png")); 
            
            boton[9] = new Boton(); 
            boton[9].image = ImageIO.read(getClass().getResourceAsStream("/Botones/User2.png")); 
            
            boton[10] = new Boton(); 
            boton[10].image = ImageIO.read(getClass().getResourceAsStream("/Botones/Pass2.png")); 
            
            
        }catch(IOException e){
            
        }
    }
}
