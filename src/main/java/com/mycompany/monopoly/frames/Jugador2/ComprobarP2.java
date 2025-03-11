/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monopoly.frames.Jugador2;

import com.mycompany.monopoly.frames.JugadorUno.*;
import com.mycompany.monopoly.Player1;
import static com.mycompany.monopoly.Player1.ESTADO_DE_TURNO;
import static com.mycompany.monopoly.Player1.getConnection;
import com.mycompany.monopoly.Player2;
import static com.mycompany.monopoly.Player2.ESTADO_DE_TURNO;
import static com.mycompany.monopoly.Player2.getConnection;
import com.mycompany.monopoly.conexionBBDD.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pablo
 */
public class ComprobarP2 implements Runnable{
        private final ClaseComunP2 c; 
        private int ESTADO_DE_TURNO ; 
        
        private Connection getConnection() throws SQLException, Exception{
            return Conexion.getConnection(); 
        }
        
        public ComprobarP2(ClaseComunP2 c){
            this.c = c; 
            this.ESTADO_DE_TURNO = c.getESTADO_DE_TURNO(); 
        }
        public int getESTADO_DE_TURNO(){return this.ESTADO_DE_TURNO;}
        public void setESTADO_DE_TURNO(int e){this.ESTADO_DE_TURNO = e; }
        
        @Override
        public void run() {
            
            try{
                while(true){
                    Thread.sleep(10000); 
                    System.out.println("Estado de turno -> "+ this.ESTADO_DE_TURNO);
                    if(c.getESTADO_DE_TURNO() == 0){
                        //ClaseComun c = new ClaseComun(); 
                        System.out.println("\nCompruebo...");
                        PreparedStatement pt = getConnection().prepareStatement("SELECT * FROM turno"); 
                        ResultSet rs = pt.executeQuery(); 
                        if(rs.next()){
                            c.setESTADO_DE_TURNO(rs.getInt("J_Turno"));
                            this.ESTADO_DE_TURNO = c.getESTADO_DE_TURNO(); 
                        }
                        
                        if(c.getESTADO_DE_TURNO() == 1){
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
