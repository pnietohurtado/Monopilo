/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monopoly.frames.JugadorUno;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;

/**
 *
 * @author pablo
 */
public class Boton extends JButton{
    
    final int originalTileSize = 19; // Lo que significa que cada elemento que encontremos en el juego va a medir 19x19
    final int scale = 3;         
    
    public final int tileSize = originalTileSize * scale;  // 57x57
    public final int maxScreenCol = 2; 
    public final int maxScreenRow = 2; 
    public final int screenWidth = tileSize * maxScreenCol; // 76
    public final int screenHeight = tileSize * maxScreenRow; // 114
    
    public Boton()
    {
        this.setPreferredSize(new Dimension(this.screenWidth, this.screenHeight)); 
        this.setBackground(Color.white); 
        this.setDoubleBuffered(true); 
        this.setFocusable(true); 
    }
    
}
