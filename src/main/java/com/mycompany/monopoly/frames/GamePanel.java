/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monopoly.frames;

import com.mycompany.monopoly.frames.Player.Player;
import com.mycompany.monopoly.frames.TileManager.TileManager;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author pablo
 */
public class GamePanel extends JPanel implements Runnable{
    
    final int originalTileSize = 19; 
    final int scale = 3; 
    
    public final int tileSize = originalTileSize * scale; // 57x57
    public final int maxScreenCol = 15; // Estos son los ajuts de la pantalla NO TOCAR 
    public final int maxScreenRow = 13; // NO TOCAR 
    public final int screenWidth = tileSize * maxScreenCol; // NO TOCAR
    public final int screenHeight = tileSize * maxScreenRow; // NO TOCAR 
    
    // Instanciamos
    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler(); 
    Thread gameThread; 
    public Player player = new Player(this, keyH); 
    
    
    
    int playerX = 100; 
    int playerY = 100; 
    int playerSpeed = 4; 
    
    
    public GamePanel()
    {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight)); 
        this.setBackground(Color.white);
        this.setDoubleBuffered(true); 
        this.addKeyListener(keyH); 
        this.setFocusable(true);

        
    }
    
    
    public void startThread(){
        gameThread = new Thread(this); 
        gameThread.start(); 
    }
    
    public final int FPS = 60; 
    
    @Override 
    public void run(){
        double drawInterval = 1000000000/FPS; 
        double nextDrawInterval = System.nanoTime() + drawInterval; 
        
        while(gameThread != null){
            
            update(); 
            repaint(); 
            System.out.println("Player: "+player.getX() + " "+player.getY());
            try{

                double remainingTime = nextDrawInterval - System.nanoTime(); 
                remainingTime = remainingTime/1000000; 
                
                if(remainingTime < 0){
                    remainingTime = 0; 
                }
                
                Thread.sleep((long) remainingTime); 
                
                nextDrawInterval += drawInterval; 
                
            }catch(InterruptedException e){
                
            }
        }
    }
    
    public void update(){
        player.update(); 
    }
    
    
    public void paintComponent(Graphics g){
    
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D) g; 
  
        tileM.draw(g2); 
        player.draw(g2); 
        
        g2.dispose(); 
    }
    
}
