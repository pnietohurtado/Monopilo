/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monopoly;

import com.mycompany.monopoly.conexionBBDD.interfaces.UsuarioRRepositorio;
import com.mycompany.monopoly.conexionBBDD.ropositorios.UsuarioRepositorio;
import com.mycompany.monopoly.modelos.Usuario;
import java.sql.SQLException;

/**
 *
 * @author pablo
 */
public class MainDePruebas {
    static boolean condicion = false; 
    
    public static class Hilo extends Thread{

        @Override
        public void run() {
            if(condicion == true)
                System.out.println("Hola a a a a a a a");
        }
        
        
        
    }
    
    public static void main(String[] args) throws SQLException, Exception {
        
        Hilo h = new Hilo(); 
        h.start();
        
        for(int i = 0; i <= 100 ; i++ ){
            Thread.sleep(1000); 
            System.out.println(i);
            if(i == 50){
                condicion = true; 
            }
        }
        
    }
}
