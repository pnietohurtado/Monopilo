/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monopoly.frames;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


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
    public int ingameScreenState = 0; 
    
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
        }else if(gp.gameState == gp.ingameState){
            drawInGameState(); 
        }else if(gp.gameState == gp.dialogueState){
            drawDialogueScreen(); 
        }
    }
    
    
    // ----------------------------------------- Ventanas de dialogo 
    
    public void drawDialogueScreen(){
        int x = gp.tileSize * 2; 
        int y = gp.tileSize / 2; 
        int width = gp.screenWidth - (gp.tileSize * 4); 
        int height = gp.tileSize * 4; 
        
        drawSubWindow(x,y,width, height); 
        
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 32F)); 
        x += gp.tileSize; 
        y += gp.tileSize; 
        g2.drawString(String.valueOf(gp.dado), x, y); 
    }
    
    public void drawSubWindow(int x, int y, int width, int height){
        
        Color c = new Color(0,0,0,210); // 220 Nos va a mostrar la opacidad de la ventana  
        g2.setColor(c); 
        g2.fillRoundRect(x,y,width,height,35,35); 
        
        c = new Color(255,255,255); 
        g2.setColor(c); 
        g2.setStroke(new BasicStroke(5)); 
        g2.drawRoundRect(x+5, y+5, width-10, height-10 , 25, 25);
        
    }
    
    // -----------------------------------------------------------
    
    
    
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
    
    public int getXForCenteredImage(BufferedImage image){
         
        int imageWidth = image.getWidth();
        int x = gp.screenWidth / 2 - imageWidth / 2;
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
            
           
            String text = "INICIO DE SESIÓN!"; 
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
            
  
            
            
            
            
            text = "CONTRASEÑA"; 
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
        }else if(titleScreenState == 3){
            
            
            g2.setColor(Color.black);  // Cambiar el color del fondo
            g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
            
            g2.setColor(Color.red); 
            g2.setFont(g2.getFont().deriveFont(42F));
            
           
            String text = "Registro!"; 
            int x = getXForCenteredText(text); 
            int y = gp.tileSize ; 
            g2.drawImage(gp.botonManager.boton[4].image,  x - (gp.tileSize * 2), y , gp.tileSize*7, gp.tileSize, null); 
            //g2.drawString(text,x,y); 
            
           
            g2.setColor(Color.WHITE); // Color para las opciones
            
            
            
            text = "NOMBRE"; 
            x = getXForCenteredImage(gp.botonManager.boton[1].image); 
            y += gp.tileSize * 2; 
            g2.drawImage(gp.botonManager.boton[1].image,  x - (gp.tileSize * 2), y, gp.tileSize*5, gp.tileSize, null); 
            //g2.drawString(text,x,y); 
            if(commandNumber == 0){
                g2.drawImage(gp.botonManager.boton[8].image,  x - (gp.tileSize * 2), y, gp.tileSize*5, gp.tileSize, null); 
            }
            
            text = "APELLIDO"; 
            x = getXForCenteredImage(gp.botonManager.boton[2].image); 
            y += gp.tileSize  ; 
            g2.drawImage(gp.botonManager.boton[2].image, x - (gp.tileSize * 2), y + gp.tileSize, gp.tileSize*5, gp.tileSize, null); 
            //g2.drawString(text,x,y); 
            if(commandNumber == 1){
                g2.drawImage(gp.botonManager.boton[7].image, x - (gp.tileSize * 2), y + gp.tileSize, gp.tileSize*5, gp.tileSize, null); 
            }
            
            text = "USUARIO"; 
            x =  getXForCenteredImage(gp.botonManager.boton[3].image);  
            y += gp.tileSize *1; 
            g2.drawImage(gp.botonManager.boton[3].image,  x - (gp.tileSize * 2), y + (gp.tileSize * 2), gp.tileSize*5, gp.tileSize, null); 
            //g2.drawString(text,x,y); 
            if(commandNumber == 2){
                g2.drawImage(gp.botonManager.boton[9].image,  x - (gp.tileSize * 2), y + (gp.tileSize * 2), gp.tileSize*5, gp.tileSize, null); 
            }
            
            
            text = "CONTRASEÑA"; 
            x =  getXForCenteredImage(gp.botonManager.boton[0].image); 
            y += gp.tileSize ; 
            g2.drawImage(gp.botonManager.boton[0].image,  x - (gp.tileSize * 2), y + (gp.tileSize * 3) , gp.tileSize*5, gp.tileSize, null); 
            //g2.drawString(text,x,y); 
            if(commandNumber == 3){
                g2.drawImage(gp.botonManager.boton[10].image,  x - (gp.tileSize * 2), y + (gp.tileSize * 3) , gp.tileSize*5, gp.tileSize, null); 
            }
            
            text = "CONTRASEÑA"; 
            x =  getXForCenteredImage(gp.botonManager.boton[14].image); 
            y += gp.tileSize ; 
            g2.drawImage(gp.botonManager.boton[14].image,  x - (gp.tileSize * 2), y + (gp.tileSize * 4) , gp.tileSize*5, gp.tileSize, null); 
            //g2.drawString(text,x,y); 
            if(commandNumber == 4){
                g2.drawImage(gp.botonManager.boton[13].image,  x - (gp.tileSize * 2), y + (gp.tileSize * 4) , gp.tileSize*5, gp.tileSize, null); 
            }
            
            //g2.setColor(Color.BLUE); 
            
            text = "ARROW"; 
            x =  gp.tileSize * 14; 
            y = 0 ; 
            g2.drawImage(gp.botonManager.boton[5].image,  x , y , gp.tileSize, gp.tileSize, null); 
            //g2.drawString(text,x,y); 
            if(commandNumber == 5){
                g2.drawImage(gp.botonManager.boton[6].image,  x , y , gp.tileSize, gp.tileSize, null); 
            }
            
            
        }
        
    }
    
    
    
    
    public void drawInGameState(){
        
        if(ingameScreenState == 0){ // Se va a encargar de seleccionar el menú

            g2.setColor(Color.black);  // Cambiar el color del fondo
            g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
            
            g2.setColor(Color.red); 
            g2.setFont(g2.getFont().deriveFont(42F));
            
           
            String text = "Registro!"; 
            int x = getXForCenteredText(text); 
            int y = gp.tileSize ; 
            g2.drawImage(gp.botonManager.boton[4].image,  x - (gp.tileSize * 2), y , gp.tileSize*7, gp.tileSize, null); 
            //g2.drawString(text,x,y); 
            
           
            g2.setColor(Color.WHITE); // Color para las opciones
            
            
            
            text = "DADO"; 
            x = getXForCenteredImage(gp.botonManager.boton[11].image); 
            y += gp.tileSize * 2; 
            g2.drawImage(gp.botonManager.boton[11].image,  x - (gp.tileSize * 2), y, gp.tileSize*5, gp.tileSize, null); 
            //g2.drawString(text,x,y); 
            if(commandNumber == 0){
                g2.drawImage(gp.botonManager.boton[12].image,  x - (gp.tileSize * 2), y, gp.tileSize*5, gp.tileSize, null); 
                
            }
            
            text = "APELLIDO"; 
            x = getXForCenteredImage(gp.botonManager.boton[15].image); 
            y += gp.tileSize  ; 
            g2.drawImage(gp.botonManager.boton[15].image, x - (gp.tileSize * 2), y + gp.tileSize, gp.tileSize*5, gp.tileSize, null); 
            //g2.drawString(text,x,y); 
            if(commandNumber == 1){
                g2.drawImage(gp.botonManager.boton[16].image, x - (gp.tileSize * 2), y + gp.tileSize, gp.tileSize*5, gp.tileSize, null); 
            }
            
            text = "USUARIO"; 
            x =  getXForCenteredImage(gp.botonManager.boton[17].image);  
            y += gp.tileSize *1; 
            g2.drawImage(gp.botonManager.boton[17].image,  x - (gp.tileSize * 2), y + (gp.tileSize * 2), gp.tileSize*5, gp.tileSize, null); 
            //g2.drawString(text,x,y); 
            if(commandNumber == 2){
                g2.drawImage(gp.botonManager.boton[18].image,  x - (gp.tileSize * 2), y + (gp.tileSize * 2), gp.tileSize*5, gp.tileSize, null); 
            }
            
            
            text = "CONTRASEÑA"; 
            x =  getXForCenteredImage(gp.botonManager.boton[19].image); 
            y += gp.tileSize ; 
            g2.drawImage(gp.botonManager.boton[19].image,  x - (gp.tileSize * 2), y + (gp.tileSize * 3) , gp.tileSize*5, gp.tileSize, null); 
            //g2.drawString(text,x,y); 
            if(commandNumber == 3){
                g2.drawImage(gp.botonManager.boton[20].image,  x - (gp.tileSize * 2), y + (gp.tileSize * 3) , gp.tileSize*5, gp.tileSize, null); 
            }
            
            text = "CONTRASEÑA"; 
            x =  getXForCenteredImage(gp.botonManager.boton[14].image); 
            y += gp.tileSize ; 
            g2.drawImage(gp.botonManager.boton[14].image,  x - (gp.tileSize * 2), y + (gp.tileSize * 4) , gp.tileSize*5, gp.tileSize, null); 
            //g2.drawString(text,x,y); 
            if(commandNumber == 4){
                g2.drawImage(gp.botonManager.boton[13].image,  x - (gp.tileSize * 2), y + (gp.tileSize * 4) , gp.tileSize*5, gp.tileSize, null); 
            }
            
            //g2.setColor(Color.BLUE); 
            
            text = "ARROW"; 
            x =  gp.tileSize * 14; 
            y = 0 ; 
            g2.drawImage(gp.botonManager.boton[5].image,  x , y , gp.tileSize, gp.tileSize, null); 
            //g2.drawString(text,x,y); 
            if(commandNumber == 5){
                g2.drawImage(gp.botonManager.boton[6].image,  x , y , gp.tileSize, gp.tileSize, null); 
            }
            
        
        }
    }
    
}
