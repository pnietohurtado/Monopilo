   /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monopoly.frames;

import com.mycompany.monopoly.frames.JugadorUno.ClaseComun;
import com.mycompany.monopoly.frames.JugadorUno.MenuPanel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author pablo
 */
public class main {
    
    
  
        
        public static void cerrar(JFrame w) {
            try {
                w.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                w.addWindowListener(new WindowAdapter() { 
                    @Override
                    public void windowClosing(WindowEvent e) {
                        confirmarSalida();
                    }
                });
            } catch (Exception r) {
                r.printStackTrace();
            }
        }
        
        
        public static void confirmarSalida(){
            int valor = JOptionPane.showConfirmDialog(null, "¿Estás seguro que quieres cerrar el juego?","Advertencia", JOptionPane.YES_NO_OPTION ); 
            if(valor==JOptionPane.YES_OPTION){
                
                System.exit(0);
            }
        }
        
        //----------

        
    public static void main(String[] args) throws IOException{
        
        
        ClaseComun c = new ClaseComun(); 
        
        //Primera Ventana 
        JFrame window = new JFrame(); 
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        window.setResizable(false);
        window.setTitle("Monopilo"); 
        
        window.setIconImage(ImageIO.read(main.class.getResource("/Tile/Logo.png")));
        
        GamePanel gamePanel = new GamePanel(); 
        window.add(gamePanel); 
        
        cerrar(window);  // Verificación de cierre de ventana
        
        window.pack(); 
        
        window.setLocationRelativeTo(null); 
        window.setVisible(true); 
       
        //-----------
        
        MenuPanel mp = new MenuPanel(gamePanel); 
        
        
        gamePanel.setUpGame();
        gamePanel.startThread(); 
        mp.startMenuThread();
     
       
        
        
        
    
    }
}
