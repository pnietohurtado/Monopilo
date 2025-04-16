/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monopoly.frames;

import com.mycompany.monopoly.frames.Botones.BotonManager;
import com.mycompany.monopoly.frames.Jugador2.Player2.Player3;
import com.mycompany.monopoly.frames.Jugador2.Player2.PlayerP2;
import com.mycompany.monopoly.frames.JugadorUno.Player1.Player;
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
public class GamePanel extends JPanel implements Runnable{
    
    final int originalTileSize = 19; 
    final int scale = 3; 
    
    public final int tileSize = originalTileSize * scale; // 57x57
    public final int maxScreenCol = 15; // Estos son los ajuts de la pantalla NO TOCAR 
    public final int maxScreenRow = 13; // NO TOCAR 
    public final int screenWidth = tileSize * maxScreenCol; // NO TOCAR
    public final int screenHeight = tileSize * maxScreenRow; // NO TOCAR 
    
    // Instanciamos
    TileManager tileManager = new TileManager(this);
    BotonManager botonManager = new BotonManager(this); 
    public KeyHandler keyH = new KeyHandler(this); 
    public Player player = new Player(this, keyH); 
    public PlayerP2 player2 = new PlayerP2(this, keyH); 
    public Sound sound = new Sound(); 
    Thread gameThread; 
    public CollisionChecker cH = new CollisionChecker(this); 
    public UI ui = new UI(this); 
    
    public Player3 zapato = new Player3(this, keyH); 
    
    // Parámetros de inicio de sesión necesario para cargar el juego.
    public String playerName = ""; 
    public String playerPass = ""; 
    public String playerNombre = ""; 
    public String playerApellido = ""; 
    public String eleccionJ1 = ""; 
    
    
    // Empezar el juego 
    public boolean confirmar = false; 
    public int menuSelection = 0; 
    
    
    // Dado 
    public int dado = dado(); 
    
    
    // Las distintas pantallas del juego 
    public int gameState; 
    public final int titleState = 0; // 0 : title 1 : Pre-jugar 2 : Inicio de Sesion 3 : Registro 
    public final int playState = 1; 
    public final int pauseState = 2; 
    public final int ingameState = 3; // Carga la pantalla del menú
    public final int dialogueState = 4; 
    
    
    public final int maxWorldCol = 168; 
    public final int maxWorldRow = 500; 
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeigth = tileSize * maxWorldRow;
    
    
    int playerX = 100; 
    int playerY = 100; 
    int playerSpeed = 4; 
    
    public int jugador = 0; 
    
    public GamePanel()
    {
        
        this.setPreferredSize(new Dimension(screenWidth, screenHeight)); 
        this.setBackground(Color.white);
        this.setDoubleBuffered(true); 
        this.addKeyListener(keyH); 
        this.setFocusable(true);
        this.setLayout(null); 
        
        
        
    }
    
    public void setUpGame()
            
    {
        gameState = titleState; 
    }
    
    public void startThread(){
        gameThread = new Thread(this); 
        gameThread.start(); 
    }
    
    public final int FPS = 60; 
    
    @Override 
    public void run(){
        double drawInterval = 1000000000/FPS;  
        double delta = 0; 
        long lastTime = System.nanoTime(); 
        long currentTime; 
        
       
        long timer = 0; 
        int drawCount = 0; 
        
       
        while(gameThread != null) 
        {
            
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
                if(keyH.showFPS == true){
                    //System.out.println("FPS:"+drawCount);
                }
                drawCount = 0; 
                timer = 0; 
            }
            
        }
    }
    
    public void update(){
        
        if(gameState == playState){
            
            player.update(); 
            player2.update(); // Peón (Movimiento del jugador1) 
            zapato.update(); // Zapato (Movimiento del jugador2) 
            
        }else if(gameState == pauseState){
            // El juego se queda pausado
        }
        
    }
    
    
    public void paintComponent(Graphics g){
    
        // NO TOCAR 
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g; 
        // ---------
        
        if(gameState == titleState){
            ui.draw(g2); 
        }else if(gameState == ingameState){
            ui.draw(g2); 
        }else{
            
            tileManager.draw(g2); 
            player.draw(g2); 
            player2.draw(g2);
            zapato.draw(g2);
            ui.draw(g2); 
            
        }
  
        g2.dispose(); 
    }
    
    
    public void playMusic(int i){
        sound.setFile(i); 
        System.out.println(sound.clip);
        sound.play(); 
        sound.loop();
    }
    
    public void stopMusic(){
        sound.stop(); 
    }
    
    public void playSE(int i){
        sound.setFile(i); 
        sound.play(); 
    }
    
    
    public static int dado() {
        return (int) (Math.random() * 6) + 1;
    }
    
    public void volverJuego(){
        this.gameState = this.playState; 
    }
}
