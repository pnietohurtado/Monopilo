/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monopoly.conexionBBDD.ropositorios;

import com.mycompany.monopoly.conexionBBDD.Conexion;
import com.mycompany.monopoly.conexionBBDD.Excepciones.UsuarioYaExisteException;
import com.mycompany.monopoly.conexionBBDD.interfaces.ICasillaRepositorio;
import com.mycompany.monopoly.conexionBBDD.interfaces.IUsuarioIRepositorio;
import com.mycompany.monopoly.modelos.Casilla;
import com.mycompany.monopoly.modelos.UsuarioI;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pablo
 */
public class CasillasRepositorio implements ICasillaRepositorio{
    public Connection getConnection() throws SQLException{
        return Conexion.getConnection(); 
    }
    
    public static Casilla getCasilla(ResultSet rs) throws SQLException{
        Casilla c = new Casilla(); 
        c.setCAS_Id(rs.getLong("CAS_Id"));
        c.setCAS_Nombre(rs.getString("CAS_Nombre"));
        c.setCAS_Precio(rs.getDouble("CAS_Precio")); 
        c.comprobarDisponibilidad(rs.getInt("CAS_Disponibilidad"));
        c.setCAS_Propietario(rs.getString("CAS_Propietario"));
        c.setCAS_Tipo(rs.getString("CAS_Tipo"));
        c.setCAS_Color(rs.getString("CAS_Color")); 
        return c; 
    }

    @Override
    public List<Casilla> listar() throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Casilla porId(Long id) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Casilla porNombre(String nombre) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Casilla porTipo(String tipo) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Casilla porColor(String color) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Casilla porDisponibilidad() throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Casilla porPropietario(String propietario) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
