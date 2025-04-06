/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monopoly.frames.JugadorUno.Player1;

import com.mycompany.monopoly.frames.JugadorUno.Player1.*;
import com.mycompany.monopoly.conexionBBDD.Conexion;
import com.mycompany.monopoly.frames.GamePanel;
import com.mycompany.monopoly.frames.KeyHandler;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;


/**
 *
 * @author pablo
 */
public class Player extends Entity{
    GamePanel gamePanel; 
    KeyHandler keyHandler; 
    
    public Player(GamePanel gp, KeyHandler kh){
        this.gamePanel = gp; 
        this.keyHandler = kh; 
        
        setDefaultValues(); 
        getPlayerImage(); 
    }
    
    public Connection getConnection() throws SQLException{
        return Conexion.getConnection(); 
    }
    
    public void setDefaultValues()
            /*Debemos tener en cuenta que cada casilla en el mapa son 48 píxeles por 48 píxeles 
            por lo que situarnos en el (0,0) no  va a poner en la esquina superior izquierda y en caso
            de que pongamos (0,48) nos vamos a situar en la misma posición, pero una casilla más abajo.*/
            
    {
        
        worldX = 117 ; // Cuidado con este
        worldY = 57; 
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
        /*
        if(keyHandler.upPressed == true || keyHandler.downPressed == true ||
                keyHandler.leftPressed == true || keyHandler.rightPressed == true ){
            
            if(keyHandler.upPressed == true)
            {
                direction = "up"; 
                y -= speed; 
            }
            else if(keyHandler.downPressed == true)
            {
                direction = "down"; 
                y += speed; 
            }
            else if(keyHandler.leftPressed == true)
            {
                direction="left"; 
                x -= speed;
            }
            else if(keyHandler.rightPressed == true)
            {
                direction="right";     
                x += speed; 
            }


            spriteCounter++; 
            if(spriteCounter > 12){
                if(spriteNum == 1){
                    spriteNum = 2;
                }else if(spriteNum == 2){
                    spriteNum = 1; 
                }
                spriteCounter = 0; 
            }
        }
        */
        
        
        try{
            PreparedStatement pt = getConnection().prepareStatement("SELECT * FROM posJ1"); 
            ResultSet rs = pt.executeQuery(); 
            
            if(rs.next()){
                worldX = ((rs.getInt("Pos_PosJ")) * 57)+114; 
                worldY = ((rs.getInt("Pos_PosI")) * 57)+57; 
            }
        }catch(SQLException e){
           
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
        
            g2.drawImage(image,worldX,worldY,gamePanel.tileSize, gamePanel.tileSize,null); 
    }
    
    
    
    public int getX ( ){return this.worldX; }
    public int getY ( ){return this.worldY; }
    
}
