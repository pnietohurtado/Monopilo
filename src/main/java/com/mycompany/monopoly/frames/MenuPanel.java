/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monopoly.frames;

import com.mycompany.monopoly.frames.TileManager.TileManager;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author pablo
 */
public class MenuPanel extends JPanel implements Runnable 

{
    
    
    private Thread menuThread; 
    

    final int originalTileSize = 19; // Lo que significa que cada elemento que encontremos en el juego va a medir 19x19
    final int scale = 3;         
    
    public final int tileSize = originalTileSize * scale;  
    public final int maxScreenCol = 6; 
    public final int maxScreenRow = 9; 
    public final int screenWidth = tileSize * maxScreenCol; 
    public final int screenHeight = tileSize * maxScreenRow; 
    
    
    /*Estados del juego*/
    public int gameState; 
    private final int titleState = 0; 
    
    
    
    // Contructor de la clase 
    public MenuPanel() 
    {
        this.setPreferredSize(new Dimension(this.screenWidth, this.screenHeight)); 
        this.setBackground(Color.black); 
        this.setDoubleBuffered(true); 
        this.setFocusable(true); 
    }
    
    final int FPS = 60; 
    
    //TileManager tileManager = new TileManager(this); 
    
    
    public void setupGame(){
           gameState = titleState; 
    }
    
    public void startGameThread()
    {
        menuThread = new Thread(this); 
        menuThread.start(); 
    }

    @Override
    public void run() {
        
    }
    
    
    
    public void update()
    {
        
    }
   
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g); 
        
        Graphics2D g2 = (Graphics2D)g; 
        
        // Titilo de la pantalla 
        if(gameState == titleState ){
           // ui.draw(g2); 
        }
         
        // Otros 
        else {
            
        }
        
        
        //tileManager.draw(g2);
        g2.dispose(); 
    }
    
    
    
    
    
}
