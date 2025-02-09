/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monopoly.JFrame;
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 
/**
 *
 * @author pablo
 */
public class tabla extends JFrame{
    JLabel c0, c1, c2; // Declaramos las casillas que van a ser "JLabel" 
    Color casillas, jugador; 
    public tabla(){
        super("Monopoly"); 
        this.setSize(755, 502); 
        this.setLocationRelativeTo(null); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        objetos(); 
        this.setVisible(true); 
        
    }
    
    public void objetos(){
        casillas = new Color(0,152,70); 
        jugador = new Color(0,0,0); 
        c0 = new JLabel(""); 
        c1 = new JLabel(""); 
        c2 = new JLabel(""); 
        
        this.setLayout(null); 
        c0.setBounds(10, 10, 50, 50);
        c1.setBounds(70, 10, 50, 50);
        c2.setBounds(130, 10, 50, 50);
        
        this.add(c0); 
        this.add(c1); 
        this.add(c2); 
    }
    
}
