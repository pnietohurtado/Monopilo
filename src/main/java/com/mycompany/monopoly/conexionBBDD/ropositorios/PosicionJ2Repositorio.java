/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monopoly.conexionBBDD.ropositorios;

import com.mycompany.monopoly.conexionBBDD.Conexion;
import com.mycompany.monopoly.conexionBBDD.interfaces.IPosicionRepositorio;
import com.mycompany.monopoly.modelos.PosicionJ1;
import com.mycompany.monopoly.modelos.PosicionJ2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pablo
 */
public class PosicionJ2Repositorio implements IPosicionRepositorio<PosicionJ2>{
 public Connection getConnection() throws SQLException{
        return Conexion.getConnection(); 
    }
    
    public PosicionJ2 getPosicion(ResultSet rs) throws SQLException{
        PosicionJ2 p = new PosicionJ2(); 
        p.setPos_IdUser(rs.getLong("Pos_IdUser"));
        p.setPos_PosI(rs.getInt("Pos_PosI")); 
        p.setPos_PosJ(rs.getInt("Pos_PosJ"));
        return p; 
    }
    
    
    @Override
    public void obtenerPosActual(Long id , int x1, int y1) throws SQLException, Exception 
            /*Básicamente se va a encargar de llamar a una función que vaya actualizando la
            posición de los jugadores cada vez que se tira el dado. */
    {
        PreparedStatement pt = getConnection().prepareStatement("call posicion2(?,?,?)"); 
        pt.setLong(1, id); 
        pt.setInt(2, x1);
        pt.setInt(3, y1); 
        pt.executeUpdate(); 
    }

    @Override
    public int obtenerX() throws SQLException, Exception {
        PosicionJ2 j2 = null; 
        int x = 0; 
        String sql = "select * from posJ2"; 
        PreparedStatement pt = getConnection().prepareStatement(sql); 
        ResultSet rs = pt.executeQuery(); 
        if(rs.next()){
            j2 = getPosicion(rs); 
            x = j2.getPos_PosI(); 
            //System.out.println("x -> "+x);
        }
        return x; 
    }

    @Override
    public int obtenerY() throws SQLException, Exception {
        PosicionJ2 j2 = null; 
        int y = 0; 
        String sql = "select * from posJ2"; 
        PreparedStatement pt = getConnection().prepareStatement(sql); 
        ResultSet rs = pt.executeQuery(); 
        if(rs.next()){
            j2 = getPosicion(rs); 
            y = j2.getPos_PosJ(); 
        }
        return y; 
    }
    
}
