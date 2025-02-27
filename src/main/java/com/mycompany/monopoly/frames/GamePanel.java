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
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author pablo
 */
public class GamePanel extends JPanel implements Runnable 
        /*En un principio en esta clase voy a tener metido el códifo para el jugador 1, por lo que voy a tener que duplicar tanto el main 
        como el "GamePanel" para el segundo jugador*/
{
    private Thread gameThread; 
    

    final int originalTileSize = 19; // Lo que significa que cada elemento que encontremos en el juego va a medir 19x19
    final int scale = 3;         
    
    public final int tileSize = originalTileSize * scale;  
    public final int maxScreenCol = 15; 
    public final int maxScreenRow = 12; 
    public final int screenWidth = tileSize * maxScreenCol; 
    public final int screenHeight = tileSize * maxScreenRow; 
    
    // Contructor de la clase 
    public GamePanel() 
    {
        this.setPreferredSize(new Dimension(this.screenWidth, this.screenHeight)); 
        this.setBackground(Color.black); 
        this.setDoubleBuffered(true); 
        this.setFocusable(true); 
    }
    
    final int FPS = 60; 
    
    TileManager tileManager = new TileManager(this); 
    
    public void startGameThread()
    {
        gameThread = new Thread(this); 
        gameThread.start(); 
    }
    
    
    @Override
    public void run() {
        double drawInterval = 1000000000/FPS;  // 0.01666 seconds prints 
        double delta = 0; 
        long lastTime = System.nanoTime(); 
        long currentTime; 
        
        // Variable to count the frame per second to ensure it is 60. 
        long timer = 0; 
        int drawCount = 0; 
        
        // Here we will be initializing our game loop
        while(gameThread != null) // Will execute until we close the gamePanel. 
        {
            // System.out.println("Nano time: "+ System.nanoTime()); It returns the time of each nano time of the game running. 
            currentTime = System.nanoTime(); 
            
            delta += (currentTime - lastTime) / drawInterval; 
            timer += (currentTime - lastTime); 
            lastTime = currentTime; 
            
            if(delta >= 1){
                update(); 
                repaint();  
                delta--; 
                drawCount++; 
            }
            
            if(timer >= 1000000000){
                System.out.println("FPS:"+drawCount);
                drawCount = 0; 
                timer = 0; 
            }
            
        }
    }
    
    
    public void update()
    {
        
    }
   
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g); 
        
        Graphics2D g2 = (Graphics2D)g; 
        
        tileManager.draw(g2);
        g2.dispose(); 
    }
    
}
