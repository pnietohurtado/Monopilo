/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monopoly.frames.Player;

import com.mycompany.monopoly.frames.GamePanel;
import com.mycompany.monopoly.frames.KeyHandler;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;


/**
 *
 * @author pablo
 */
public class Player extends Entity{
    GamePanel gamePanel; 
    KeyHandler keyHandler; 
    
    public final int screenX;
    public final int screenY; 
    
    public Player(GamePanel gp, KeyHandler kh){
        this.gamePanel = gp; 
        this.keyHandler = kh; 
        
        screenX = gamePanel.screenWidth/2 - (gamePanel.tileSize / 2); 
        screenY = gamePanel.screenHeight/2 - (gamePanel.tileSize /2); 
        
        solidArea = new Rectangle();
        solidArea.x = 8; 
        solidArea.y = 16; 
        solidArea.width = 32; 
        solidArea.height = 32; 
        
        setDefaultValues(); 
        getPlayerImage(); 
    }
    
    public void setDefaultValues()
    {
        worldX = gamePanel.tileSize * 2 ; 
        worldY = gamePanel.tileSize * 3 ; 
        speed = 4; 
        direction = "down"; 
    }
    
    public void getPlayerImage()
    {
        try{
            f1 = ImageIO.read(getClass().getResourceAsStream("/Player/Front1.png"));
            f2 = ImageIO.read(getClass().getResourceAsStream("/Player/Front2.png"));
            r1 = ImageIO.read(getClass().getResourceAsStream("/Player/Rigth1.png"));
            r2 = ImageIO.read(getClass().getResourceAsStream("/Player/Rigth2.png"));
            l1 = ImageIO.read(getClass().getResourceAsStream("/Player/Left1.png"));
            l2 = ImageIO.read(getClass().getResourceAsStream("/Player/Left2.png"));
            b1 = ImageIO.read(getClass().getResourceAsStream("/Player/Up1.png"));
            b2 = ImageIO.read(getClass().getResourceAsStream("/Player/Up2.png"));
        }catch(IOException e){
            e.printStackTrace(); 
        }
    }
    
    public void update()
    {
        if(keyHandler.upPressed == true || keyHandler.downPressed == true ||
                keyHandler.leftPressed == true || keyHandler.rightPressed == true ){
            
            if(keyHandler.upPressed == true)
            {
                direction = "up"; 
            }
            else if(keyHandler.downPressed == true)
            {
                direction = "down";               
            }
            else if(keyHandler.leftPressed == true)
            {
                direction="left";                
            }
            else if(keyHandler.rightPressed == true)
            {
                direction="right";                
            }

            // Check tile collision 
            collision = false; 
            gamePanel.cH.checkTile(this);
            
            
            // If collision is false, player can't move 
            if(collision == false){
                switch(direction ){
                    case "up": 
                        worldY -= speed;  
                        break; 
                    case "down": 
                        worldY += speed; 
                        break; 
                    case "left": 
                        worldX -= speed;
                        break; 
                    case "right": 
                        worldX += speed; 
                        break; 
                }
            }
            
            spriteCounter++; 
            if(spriteCounter > 12){
                if(spriteNum == 1){
                    spriteNum = 2; 
                }else if (spriteNum == 2){
                    spriteNum = 1; 
                }
                spriteCounter = 0; 
            }    
            
        }
    }
    
    public void draw(Graphics2D g2) 
    {
        /*
        g2.setColor(Color.white); 
        g2.fillRect(this.x, this.y, gamePanel.tileSize, gamePanel.tileSize);  
        */
        
        BufferedImage image = null; 
        switch(direction) {
            case "up": 
                if(spriteNum == 1) {
                    image = b1; 
                }else if(spriteNum == 2){
                    image = b2; 
                }
                break;
            case "down": 
                if(spriteNum == 1) {
                    image = f1; 
                }else if(spriteNum == 2){
                    image = f2; 
                }
                break;
            case "left": 
                if(spriteNum == 1) {
                    image = l1; 
                }else if(spriteNum == 2){
                    image = l2; 
                }
                break;
            case "right": 
                if(spriteNum == 1) {
                    image = r1; 
                }else if(spriteNum == 2){
                    image = r2; 
                }
                break;
        }
        
            g2.drawImage(image,screenX,screenY,gamePanel.tileSize, gamePanel.tileSize,null); 
    }
    
}
