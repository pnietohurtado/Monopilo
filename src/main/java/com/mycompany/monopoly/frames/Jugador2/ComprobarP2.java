/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monopoly.frames.Jugador2;

import com.mycompany.monopoly.frames.JugadorUno.*;
import com.mycompany.monopoly.Player1;
import static com.mycompany.monopoly.Player1.ESTADO_DE_TURNO;
import static com.mycompany.monopoly.Player1.getConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pablo
 */
public class ComprobarP2 implements Runnable{
        private final Player1.ClaseComun c; 
        
        
        
        public ComprobarP2(Player1.ClaseComun c){
            this.c = c; 
        }
        
        @Override
        public void run() {
            try{
                while(true){
                    Thread.sleep(10000); 
                    if(ESTADO_DE_TURNO == 1){
                        System.out.println("Dentro");

                        //ClaseComun c = new ClaseComun(); 
                        System.out.println("\nCompruebo...");
                        PreparedStatement pt = getConnection().prepareStatement("SELECT * FROM turno"); 
                        ResultSet rs = pt.executeQuery(); 
                        if(rs.next()){
                            c.setJ_Turno(rs.getInt("J_Turno"));
                        }

                        if(c.getJ_Turno() == 0){
                            synchronized(c){
                                c.notifyAll();
                            }
                        }
                    }
                }
                
            }catch(InterruptedException e){
                
            }catch(SQLException e2){
                
            }catch(Exception e3){
                
            }
        }
       
        
    
}
