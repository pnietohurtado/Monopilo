/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monopoly.frames;


import com.mycompany.monopoly.frames.JugadorUno.Player1.Entity;
import java.awt.Rectangle;

/**
 *
 * @author pablo
 */
public class CollisionChecker {

    public GamePanel gp; 
    
    public CollisionChecker(GamePanel gp){
        this.gp = gp; 
    }
    
    
    public void checkTile(Entity entity){
        int entityLeftWorldX = entity.worldX + entity.solidArea.x; 
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width; 
        int entityTopWorldY = entity.worldY + entity.solidArea.y; 
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height; 
        
        int entityLeftCol = entityLeftWorldX/gp.tileSize; 
        int entityRightCol = entityRightWorldX/gp.tileSize; 
        int entityTopRow = entityTopWorldY/gp.tileSize; 
        int entityBottomRow = entityBottomWorldY/gp.tileSize; 
        
        int tileNum1, tileNum2; 
        
        switch(entity.direction){
            case "up": 
                entityTopRow = (entityTopWorldY - entity.speed) / gp.tileSize; 
                tileNum1 = gp.tileManager.mapTileNum[entityLeftCol][entityTopRow]; 
                tileNum2 = gp.tileManager.mapTileNum[entityRightCol][entityTopRow]; 
                if(gp.tileManager.tile[tileNum1].collision == true ||gp.tileManager.tile[tileNum2].collision == true){
                    entity.collision = true; 
                }
                break; 
            case "down": 
                entityBottomRow = (entityBottomWorldY + entity.speed) / gp.tileSize; 
                tileNum1 = gp.tileManager.mapTileNum[entityLeftCol][entityBottomRow]; 
                tileNum2 = gp.tileManager.mapTileNum[entityRightCol][entityBottomRow]; 
                if(gp.tileManager.tile[tileNum1].collision == true ||gp.tileManager.tile[tileNum2].collision == true){
                    entity.collision = true; 
                }
                break;
            case "left": 
                entityLeftCol = (entityLeftWorldX - entity.speed) / gp.tileSize; 
                tileNum1 = gp.tileManager.mapTileNum[entityLeftCol][entityTopRow]; 
                tileNum2 = gp.tileManager.mapTileNum[entityLeftCol][entityBottomRow]; 
                if(gp.tileManager.tile[tileNum1].collision == true ||gp.tileManager.tile[tileNum2].collision == true){
                    entity.collision = true; 
                }
                break; 
            case "right": 
                entityRightCol = (entityRightWorldX + entity.speed) / gp.tileSize; 
                tileNum1 = gp.tileManager.mapTileNum[entityRightCol][entityTopRow]; 
                tileNum2 = gp.tileManager.mapTileNum[entityRightCol][entityBottomRow]; 
                if(gp.tileManager.tile[tileNum1].collision == true ||gp.tileManager.tile[tileNum2].collision == true){
                    entity.collision = true; 
                }
                break; 
        }
    }
    

}
