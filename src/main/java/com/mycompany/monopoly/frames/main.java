/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monopoly.frames;

import javax.swing.JFrame;

/**
 *
 * @author pablo
 */
public class main {
    public static void main(String[] args) {
        JFrame window = new JFrame(); 
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        window.setResizable(false);
        window.setTitle("Mopóly"); 
        
        GamePanel gamePanel = new GamePanel(); 
        window.add(gamePanel); 
        
        window.pack(); 
        
        window.setLocationRelativeTo(null); 
        window.setVisible(true); 
        
        gamePanel.startGameThread(); 
    
    
    }
}
