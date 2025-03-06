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
    public final int maxScreenRow = 13; 
    public final int screenWidth = tileSize * maxScreenCol; 
    public final int screenHeight = tileSize * maxScreenRow; 
    
    // Contructor de la clase 
    public GamePanel() 
    {
        this.setPreferredSize(new Dimension(this.screenWidth, this.screenHeight)); 
        this.setBackground(Color.black); 
        this.setDoubleBuffered(true); 
        this.addKeyListener(keyHandler);
        this.setFocusable(true); 
    }
    
    final int FPS = 60; 
    
    public final int maxWorldCol = 13; 
    public final int maxWorldRow = 15; 
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeigth = tileSize * maxWorldRow;
    
    TileManager tileManager = new TileManager(this); 
    
    KeyHandler keyHandler = new KeyHandler(); 
    
    public Player player = new Player(this, keyHandler); 
    
    public CollisionChecker cH = new CollisionChecker(this);
    
    public void startGameThread()
    {
        gameThread = new Thread(this); 
        gameThread.start(); 
    }
    
    
    @Override
    public void run() 
               /*Puedo usar este método del hilo para ir consultando a la base de 
            datos donde está el jugador e ir actualizando su posición desde aquí. De otra 
            manera, este método no vale para absolutamente NADA. */
    {
        
       
        // Here we will be initializing our game loop
        while(gameThread != null) // Will execute until we close the gamePanel. 
        {
            
                update(); 
                repaint();  
            
            
            
        }
    }
    
    
    public void update()
    {
        player.update();
    }
   
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g); 
        
        Graphics2D g2 = (Graphics2D)g; 
        
        tileManager.draw(g2);
        player.draw(g2);
        
        g2.dispose(); 
    }
    
}
