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
public class tabla extends JFrame implements ActionListener{
    JLabel c0, c1, c2; // Declaramos las casillas que van a ser "JLabel" 
    Color casillas, jugador, fondo; 
    int dado, player; 
    JButton movimiento; 
    private javax.swing.JPanel panel; 
    
    
    public tabla(){
        super("Monopoly"); 
        this.setSize(755, 502); // Tamaño del framework 
        setIconImage(new javax.swing.ImageIcon(System.getProperty("user.dir")+ "\\src\\main\\java\\com\\mycompany\\monopoly\\JFrame\\icons\\Icono.png").getImage()); //LOGOTIPO DEL FRAME
        this.setLocationRelativeTo(null); //Para que se ponga en medio de la pantalla
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Si se cierra la ventana se sale del programa
        
        JPanelImage p = new JPanelImage(panel, "\\src\\main\\java\\com\\mycompany\\monopoly\\JFrame\\icons\\momopoly.png"); 
        panel.add(p).repaint();
        objetos(); 
       
        //El color de fondo debe estar después de "objetos()" 
        
        /*
        this.getContentPane().setBackground(fondo); // Nos deja añadir un color de fondo de nuestra ventana (No va a ser necesario en mi caso) 
        JPanelImage p = new JPanelImage(, "\\src\\main\\java\\com\\mycompany\\monopoly\\JFrame\\icons\\momopoly.png"); 
        this.add(p).repaint();
        */

        this.setVisible(true); 
        
    }
    
    public void objetos(){
        casillas = new Color(0,152,70); 
        jugador = new Color(0,0,0);
        fondo = new Color(232, 232, 2); 
        c0 = new JLabel(""); 
        c1 = new JLabel(""); 
        c2 = new JLabel(""); 
        
        movimiento = new JButton("Dado"); 
        
        this.setLayout(null); 
        
        c0.setBounds(10, 10, 50, 50);
        c1.setBounds(70, 10, 50, 50);
        c2.setBounds(130, 10, 50, 50);
        
        movimiento.setBounds(200, 200, 100, 100);
        
        c0.setOpaque(true); //Esta propiedad es muy importante ya que sin ella no se puede ver 
        c1.setOpaque(true); //Esta propiedad es muy importante ya que sin ella no se puede ver 
        c2.setOpaque(true); //Esta propiedad es muy importante ya que sin ella no se puede ver 
        
        c0.setBackground(jugador); 
        c1.setBackground(casillas); 
        c2.setBackground(casillas); 
        
        this.add(c0); 
        this.add(c1); 
        this.add(c2); 
        this.add(movimiento); 
        movimiento.addActionListener(this); 
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == movimiento){
            dado = (int)(Math.random()* 5)+1;
            JOptionPane.showMessageDialog(null, dado); 
            player = player + 1; 
            switch(player){
                case 0: 
                    c0.setBackground(jugador); 
                    break; 
                
                case 1: 
                    c1.setBackground(jugador); 
                    break; 
                    
                case 2: 
                    c2.setBackground(jugador); 
                    break; 
                    
                default: 
                    break; 
            }
        }
    }
    
    
    
}
