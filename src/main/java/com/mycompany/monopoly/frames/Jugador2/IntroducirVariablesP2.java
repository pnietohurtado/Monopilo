/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monopoly.frames.Jugador2;

import com.mycompany.monopoly.frames.JugadorUno.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

/**
 *
 * @author pablo
 */
public class IntroducirVariablesP2 extends JTextField implements FocusListener{
    
    final int originalTileSize = 19; // Lo que significa que cada elemento que encontremos en el juego va a medir 19x19
    final int scale = 3;         
    
    public final int tileSize = originalTileSize * scale;  // 57x57
    public final int maxScreenCol = 2; 
    public final int maxScreenRow = 2; 
    public final int screenWidth = tileSize * maxScreenCol; // 76
    public final int screenHeight = tileSize * maxScreenRow; // 114

    private String placeholder; 
    
    public IntroducirVariablesP2(String placeholder, int columns)
    {
        super(placeholder, columns); 
        this.placeholder = placeholder; 
        addFocusListener(this); 
        this.setPreferredSize(new Dimension(this.screenWidth, this.screenHeight)); 
        this.setMinimumSize(new Dimension(this.screenWidth, this.screenHeight));
        this.setBackground(Color.white); 
        this.setDoubleBuffered(true); 
        this.setFocusable(true); 
        //this.setEditable(false); //Para hacer que el area de texto no sea editable
        this.setText("Escribe..."); 
        
        //this.setText("hola que tal"); 
        
    }
    
    @Override 
    public void focusGained(FocusEvent e){
        if(getText().equals(placeholder)){
            setText(""); 
            
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if(getText().isEmpty()){
            setText(placeholder); 
            
        }
    }
    
    
}
