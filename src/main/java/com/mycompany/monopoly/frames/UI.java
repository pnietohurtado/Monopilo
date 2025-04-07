/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monopoly.frames;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JTextField;

/**
 *
 * @author pablo
 */
public class UI {

    GamePanel gp; 
    Font arial_40; 
    Graphics2D g2; 
    BufferedImage pokeImage; 
    public boolean messageOn = false; 
    public String message = ""; 
    int messageCounter = 0; 
    public int commandNumber = 0; 
    
    
    public int titleScreenState = 0; // 0 : First Screen 
    
    public UI(GamePanel gp){
        this.gp = gp; 
        
        arial_40 = new Font("Arial", Font.PLAIN, 40); 
     
    }
    
    public void showMessage(String text){
        message = text; 
        messageOn = true; 
    }
    
    
    public void draw(Graphics2D g2){
        this.g2 = g2; 
        
        g2.setFont(arial_40);
        g2.setColor(Color.white); 

        if(gp.gameState == gp.playState){
            
        }else if(gp.gameState == gp.pauseState){
            drawPauseScreen(); 
        }else if(gp.gameState == gp.titleState){
            drawTitleScreen(); 
        }
    }
    
    public void drawPauseScreen(){
        String text = "PAUSED"; 
        int x = getXForCenteredText(text); 
        int y = gp.screenHeight /2; 
        
        g2.drawString(text, x, y);
    }
    
    
    public int getXForCenteredText(String text){
         
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth/2 - length/2; 
        return x; 
    }
    
    public void drawTitleScreen(){
        
        if(titleScreenState == 0){

            g2.setColor(Color.black);  // Cambiar el color del fondo
            g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 56F));
            String text = "MONOPILO"; 
            int x = getXForCenteredText(text); 
            int y = gp.tileSize * 3; 

            g2.setColor(Color.white); 
            g2.drawString(text,x+2,y+2); 
            g2.setColor(Color.red); // Set the text color 
            g2.drawString(text,x,y); 



            x = gp.screenWidth/2 - (gp.tileSize*2)/2 ; 
            y += gp.tileSize*2; 
            g2.drawImage(gp.player.f1, x, y, gp.tileSize*2, gp.tileSize * 2, null); 


            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 48F));

            g2.setColor(Color.white);
            text = "LOAD GAME"; 
            x = getXForCenteredText(text); 
            y = gp.tileSize * 8; 
            g2.drawString(text, x, y); 
            if(commandNumber == 0){
                g2.drawString(">",x - gp.tileSize,y); 
            }

            text = "CRÉDITOS"; 
            x = getXForCenteredText(text); 
            y = gp.tileSize * 9; 
            g2.drawString(text, x, y); 
            if(commandNumber == 1){
                g2.drawString(">",x - gp.tileSize,y); 
            }

            text = "QUIT GAME"; 
            x = getXForCenteredText(text); 
            y = gp.tileSize * 10; 
            g2.drawString(text, x, y); 
            if(commandNumber == 2){
                g2.drawString(">",x - gp.tileSize,y); 
            }
        
        
        }else if(titleScreenState == 1){
            
            g2.setColor(Color.black);  // Cambiar el color del fondo
            g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
            
            g2.setColor(Color.red); 
            g2.setFont(g2.getFont().deriveFont(42F));
            
           
            String text = "Select your class!"; 
            int x = getXForCenteredText(text); 
            int y = gp.tileSize * 3; 
            g2.drawString(text,x,y); 
            
            g2.drawString(text,x+2,y+2); 
            g2.setColor(Color.red); // Set the text color 
            g2.drawString(text,x,y); 
            
            text = "INICIAR SESIÓN"; 
            x = getXForCenteredText(text); 
            y += gp.tileSize * 3; 
            g2.drawString(text,x,y); 
            if(commandNumber == 0){
                g2.drawString(">", x - gp.tileSize, y); 
            }
            
            
            text = "REGISTRARSE"; 
            x = getXForCenteredText(text); 
            y += gp.tileSize  ; 
            g2.drawString(text,x,y); 
            if(commandNumber == 1){
                g2.drawString(">", x - gp.tileSize, y); 
            }
            
            
            
            text = "GO BACK"; 
            x = getXForCenteredText(text); 
            y += gp.tileSize; 
            g2.drawString(text,x,y); 
            if(commandNumber == 2){
                g2.drawString(">", x - gp.tileSize, y); 
            }
          
            
        }else if(titleScreenState == 2){
            
            g2.setColor(Color.black);  // Cambiar el color del fondo
            g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
            
            g2.setColor(Color.red); 
            g2.setFont(g2.getFont().deriveFont(42F));
            
           
            String text = "Select your class!"; 
            int x = getXForCenteredText(text); 
            int y = gp.tileSize * 3; 
            g2.drawString(text,x,y); 
            
            g2.drawString(text,x+2,y+2); 
            g2.setColor(Color.red); // Poner el color de la fuente  
            g2.drawString(text,x,y); 
            
            g2.setColor(Color.WHITE); // Color para las opciones
            
            
            
            text = "NOMBRE"; 
            x = getXForCenteredText(text); 
            y += gp.tileSize * 3; 
            g2.drawString(text,x,y); 
            if(commandNumber == 0){
                g2.drawString(">", x - gp.tileSize, y); 
            }
            
            
            /* De momento voy a dejarlo así hasta que se me ocurra algo
            JTextField textField = new JTextField("Hola que tal estamos"); 
            textField.setBounds(getXForCenteredText(textField.getText()), gp.tileSize * 4, 25,25);
            //textField.setSize(150,25); 
            textField.paint(g2); 
            */
            //gp.playerName = "Pepe"; 
  
            
            
            
            
            
            text = "CONTRASEÑA"; 
            x = getXForCenteredText(text); 
            y += gp.tileSize  ; 
            g2.drawString(text,x,y); 
            if(commandNumber == 1){
                g2.drawString(">", x - gp.tileSize, y); 
            }
            
            /*
            JTextField textField2 = new JTextField("Hola que tal estamos"); 
            textField2.setSize(150,25); 
            textField2.setLocation(getXForCenteredText(textField.getText()), gp.tileSize * 4);
            textField2.paint(g2); 
            */
            
            
            text = "GO BACK"; 
            x = getXForCenteredText(text); 
            y += gp.tileSize; 
            g2.drawString(text,x,y); 
            if(commandNumber == 2){
                g2.drawString(">", x - gp.tileSize, y); 
            }
        }
        
    }
    
}
