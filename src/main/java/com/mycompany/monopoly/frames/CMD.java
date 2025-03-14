/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monopoly.frames;

import com.mycompany.monopoly.conexionBBDD.Conexion;
import com.mycompany.monopoly.frames.JugadorUno.Display;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author pablo
 */
public class CMD extends JPanel implements Runnable{

     private Thread cmdThread; 
    

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
    
    
    JTextArea campo = new JTextArea(); 
    
    private boolean inputReady = false; 
    private String userInput = ""; 
    
    // Contructor de la clase 
    public CMD() 
    {
        this.setPreferredSize(new Dimension(this.screenWidth, this.screenHeight)); 
        this.setBackground(Color.black); 
        this.setDoubleBuffered(true); 
        this.setFocusable(true); 
        this.setLayout(null); 
        
        campo.setFocusable(true);
        campo.setDoubleBuffered(true); 
        campo.setLineWrap(true);
        campo.setWrapStyleWord(true);
        
        campo.setBackground(Color.black);
        campo.setForeground(Color.green);
        
        campo.setBounds(20, 20, 300, 350);
        this.add(campo); 

        campo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    e.consume(); // Evitar doble salto de línea

                    // Obtener el texto completo y dividirlo en líneas
                    String[] lineas = campo.getText().split("\n");
                    userInput = lineas[lineas.length - 1]; // Última línea escrita

                    synchronized (CMD.this) { 
                        inputReady = true;
                        CMD.this.notify(); 
                    }

                    campo.append("\n"); // Agregar nueva línea manualmente
                    campo.append("root@monopolyMaster>");
                    campo.setCaretPosition(campo.getDocument().getLength());
                }
            }
        });
        
        
    }
    
    public synchronized String getUserInput() {
        inputReady = false;
        while (!inputReady) {
            try {
                wait(); // Esperar hasta que el usuario introduzca algo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return userInput;
    }
    
    
    
    final int FPS = 60; 
    
    //TileManager tileManager = new TileManager(this); 
    
    
    public void setupGame(){
           gameState = titleState; 
    }
    
    public void startGameThread()
    {
        cmdThread = new Thread(this); 
        cmdThread.start(); 
    }
    
    
    private Connection getConnection() throws SQLException{
        return Conexion.getConnection(); 
    }
    
    @Override
    public void run() {
        while(true) {
             
            String comando = this.getUserInput(); 
            System.out.println(comando);
            try{
                switch(comando){
                    case "root@monopolyMaster>clear": {
                        campo.setText("");
                        break; 
                    }
                    
                    case "root@monopolyMaster>stillmoney 100": {
                        PreparedStatement pt = getConnection().prepareStatement("UPDATE jugador1 SET J1_Dinero = 100 WHERE J1_Id = 1"); 
                        pt.executeUpdate(); 
                        break; 
                    }
                }
                
            }catch(SQLException e) {
                e.printStackTrace();
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
