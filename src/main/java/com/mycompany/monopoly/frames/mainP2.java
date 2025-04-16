/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monopoly.frames;

import com.mycompany.monopoly.frames.JugadorUno.ClaseComun;
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
public class mainP2 {
    
    
        // ¿QUÉ ES UN POP UP?
        
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
        
        window.setIconImage(ImageIO.read(mainP2.class.getResource("/Tile/Logo.png")));
        
        GamePanel gamePanel = new GamePanel(); 
        gamePanel.jugador = 2; 
        window.add(gamePanel); 
        
        cerrar(window);  // Verificación de cierre de ventana
        
        window.pack(); 
        
        window.setLocationRelativeTo(null); 
        window.setVisible(true); 
        
        //----------
        
        //Segunda Ventana
        JFrame windowMenu = new JFrame(); 
        windowMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        windowMenu.setResizable(false);
        windowMenu.setTitle("Menú");
        
        
        windowMenu.setIconImage(ImageIO.read(mainP2.class.getResource("/Tile/Logo.png")));
        

     
        
        //-----------
        
     
        //m.startMenuThread();
        //Activar el Thread de Comprobación sobre el turno
        gamePanel.startThread(); 
        
        
        
        /*
        Player1.ClaseComun cls = new Player1.ClaseComun(); 
        Thread t = new Thread(new Player1.HiloJugador1(cls)); 
        Thread t2 = new Thread(new Player1.Comprobar(cls)); 
        
        t.start();
        t2.start();
        */
    
        
        
        
    
    }
}
