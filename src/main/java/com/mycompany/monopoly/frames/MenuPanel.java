/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monopoly.frames;

import com.mycompany.monopoly.frames.TileManager.TileManager;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

/**
 *
 * @author pablo
 */
public class MenuPanel extends JPanel implements Runnable 

{
    
    
    private Thread menuThread; 
    

    final int originalTileSize = 19; // Lo que significa que cada elemento que encontremos en el juego va a medir 19x19
    final int scale = 3;         
    
    public final int tileSize = originalTileSize * scale;  // 57x57
    public final int maxScreenCol = 6; 
    public final int maxScreenRow = 9; 
    public final int screenWidth = tileSize * maxScreenCol; // 342
    public final int screenHeight = tileSize * maxScreenRow; // 513
    
    
    /*Estados del juego*/
    public int gameState; 
    private final int titleState = 0; 
    
    
    
    
    /*Creo que la idea sería inicializar todos los contenidos de nuestro JPanel
    una vez que lo hemos inicializado podemos ajustar la información que va en cada uno de ellos
    ES DECIR, voy a tratar esta clase como una especie de lienzo para poder poner TODA la lógica 
    de el programa final. */
    
    Display display = new Display(); 
    Boton boton = new Boton(); 
    JScrollPane scrollPane = new JScrollPane(display); 
    
    // Contructor de la clase 
    public MenuPanel() 
    {
        this.setPreferredSize(new Dimension(this.screenWidth, this.screenHeight)); 
        this.setBackground(Color.black); 
        this.setDoubleBuffered(true); 
        this.setFocusable(true); 
        this.setLayout(new FlowLayout()); 
        
        scrollPane.setBorder(new LineBorder(Color.RED, 2));
        scrollPane.setPreferredSize(new Dimension(50,50));
        
        this.add(scrollPane); 
        
        /*
        display.append("String holas ");
        this.add(display); 
        display.setVisible(true);
        */
        
        /*
        boton.setText("Enviar");
        this.add(boton); 
        */
    }
    
    final int FPS = 60; 
    
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
        
        g.setColor(Color.red);
        //g.drawString("Hola que tal", FPS, FPS);
        
        
        
        //tileManager.draw(g2);
        g2.dispose(); 
    }
    
    
    
    
    
}
