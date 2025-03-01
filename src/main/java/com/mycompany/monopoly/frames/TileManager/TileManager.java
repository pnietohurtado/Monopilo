/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monopoly.frames.TileManager;

import com.mycompany.monopoly.frames.GamePanel;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;

/**
 *
 * @author pablo
 */
public class TileManager {
    GamePanel gp ;  
    Tile[] tile; 
    int mapTileNum[][]; 
    
    public TileManager(GamePanel gp){
        this.gp = gp; 
        tile = new Tile[34]; 
        mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow]; 
        
        getTileImage(); 
        loadMap("/Map/Mapa.txt"); 
    }
    
    
    public void getTileImage(){
        try{
            
            tile[0] = new Tile(); 
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/Tile/Grass1.png")); 
            
            
            tile[1] = new Tile(); 
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/Tile/Grass2.png")); 
            
            tile[2] = new Tile(); 
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/Tile/Grass3.png")); 
            
            tile[3] = new Tile(); 
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/Tile/Carcel.png")); 
            
            tile[4] = new Tile(); 
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/Tile/Salida1.png")); 
            
            tile[5] = new Tile(); 
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/Tile/Salida2.png")); 
            
            tile[6] = new Tile(); 
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/Tile/AvenidaAmerica.png")); 
            
            tile[7] = new Tile(); 
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/Tile/CalleMariaMolina.png")); 
            
            tile[8] = new Tile(); 
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("/Tile/CalleCeaBermudez.png")); 
            
            
            
            
            
            /*Casillas*/
            tile[9] = new Tile(); 
            tile[9].image = ImageIO.read(getClass().getResourceAsStream("/Tile/AzulClaro.png")); 
            
            
            tile[10] = new Tile(); 
            tile[10].image = ImageIO.read(getClass().getResourceAsStream("/Tile/Morado.png")); 
            
            tile[11] = new Tile(); 
            tile[11].image = ImageIO.read(getClass().getResourceAsStream("/Tile/Naranja.png")); 
            
            tile[12] = new Tile(); 
            tile[12].image = ImageIO.read(getClass().getResourceAsStream("/Tile/Rosa.png")); 
            
            tile[13] = new Tile(); 
            tile[13].image = ImageIO.read(getClass().getResourceAsStream("/Tile/AzulClaro.png")); 
            
            tile[14] = new Tile(); 
            tile[14].image = ImageIO.read(getClass().getResourceAsStream("/Tile/Amarillo.png")); 
            
            tile[15] = new Tile(); 
            tile[15].image = ImageIO.read(getClass().getResourceAsStream("/Tile/Verde.png")); 
            
            tile[16] = new Tile(); 
            tile[16].image = ImageIO.read(getClass().getResourceAsStream("/Tile/AzulOscuro.png")); 
            
            tile[17] = new Tile(); 
            tile[17].image = ImageIO.read(getClass().getResourceAsStream("/Tile/Suerte.png"));
            
            tile[18] = new Tile(); 
            tile[18].image = ImageIO.read(getClass().getResourceAsStream("/Tile/Bombilla.png"));
            
            tile[19] = new Tile(); 
            tile[19].image = ImageIO.read(getClass().getResourceAsStream("/Tile/Grifo.png"));
            
            tile[20] = new Tile(); 
            tile[20].image = ImageIO.read(getClass().getResourceAsStream("/Tile/Tren.png"));
            
            tile[21] = new Tile(); 
            tile[21].image = ImageIO.read(getClass().getResourceAsStream("/Tile/Caja.png"));
            
            tile[22] = new Tile(); 
            tile[22].image = ImageIO.read(getClass().getResourceAsStream("/Tile/Anillo.png"));
            
            tile[23] = new Tile(); 
            tile[23].image = ImageIO.read(getClass().getResourceAsStream("/Tile/Ballena.png"));
            
 
            
            /*Monopilo*/
            
            tile[24] = new Tile(); 
            tile[24].image = ImageIO.read(getClass().getResourceAsStream("/Tile/24.png")); 
            
            tile[25] = new Tile(); 
            tile[25].image = ImageIO.read(getClass().getResourceAsStream("/Tile/25.png")); 
            
            tile[26] = new Tile(); 
            tile[26].image = ImageIO.read(getClass().getResourceAsStream("/Tile/26.png")); 
            
            tile[27] = new Tile(); 
            tile[27].image = ImageIO.read(getClass().getResourceAsStream("/Tile/27.png")); 
            
            tile[28] = new Tile(); 
            tile[28].image = ImageIO.read(getClass().getResourceAsStream("/Tile/28.png")); 
            
            tile[29] = new Tile(); 
            tile[29].image = ImageIO.read(getClass().getResourceAsStream("/Tile/29.png")); 
            
            tile[30] = new Tile(); 
            tile[30].image = ImageIO.read(getClass().getResourceAsStream("/Tile/30.png")); 
            
            tile[31] = new Tile(); 
            tile[31].image = ImageIO.read(getClass().getResourceAsStream("/Tile/31.png"));
            
            tile[32] = new Tile(); 
            tile[32].image = ImageIO.read(getClass().getResourceAsStream("/Tile/32.png"));
            
            tile[33] = new Tile(); 
            tile[33].image = ImageIO.read(getClass().getResourceAsStream("/Tile/33.png"));
            

            
            
            
        }catch(IOException e){
            
        }
    }
    
     public void loadMap(String path){
        try{
            
            InputStream is = getClass().getResourceAsStream(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(is)); 
            
            int col = 0; 
            int row = 0; 
            
            while(col < gp.maxScreenCol && row < gp.maxScreenRow ){
                String line = br.readLine(); 
                
                while(col < gp.maxScreenCol ){
                    String numbers[] = line.split(" "); 
                    
                    int num = Integer.parseInt(numbers[col]); 
                    mapTileNum[col][row] = num; 
                    col++; 
                }
                
                if(col == gp.maxScreenCol){
                    col = 0; 
                    row++; 
                }
            }
            
            br.close(); 
        }catch(Exception e){
            
        }
    }
    
     
     
      public void draw(Graphics2D g2)
    {
        int col = 0; 
        int row = 0; 
        int x = 0; 
        int y = 0; 
        
        while(col < gp.maxScreenCol && row < gp.maxScreenRow)
        {
            int tileNum = mapTileNum[col][row]; 
            
            g2.drawImage(tile[tileNum].image, x,y,gp.tileSize,gp.tileSize,null); 
            col++; 
            x += gp.tileSize; 
            
            if(col == gp.maxScreenCol){
                col = 0; 
                x = 0; 
                row++; 
                y += gp.tileSize; 
            }
        }
        
        
    }
    
    
}
