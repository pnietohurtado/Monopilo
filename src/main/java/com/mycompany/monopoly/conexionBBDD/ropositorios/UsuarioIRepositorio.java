/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monopoly.conexionBBDD.ropositorios;

import com.mycompany.monopoly.conexionBBDD.Conexion;
import com.mycompany.monopoly.conexionBBDD.Excepciones.UsuarioYaExisteException;
import com.mycompany.monopoly.conexionBBDD.interfaces.IUsuarioIRepositorio;
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
public class UsuarioIRepositorio implements IUsuarioIRepositorio{
    public Connection getConnection() throws SQLException{
        return Conexion.getConnection(); 
    }
    
    public static UsuarioI getUsuario(ResultSet rs) throws SQLException{
        UsuarioI u = new UsuarioI(); 
        u.setUI_Id(rs.getLong("UI_Id")); 
        u.setUI_IdUr(rs.getLong("UI_IdUi")); 
        u.setUI_User(rs.getString("UI_User")); 
        u.setUI_Pass(rs.getString("UI_Pass")); 
        
        return u; 
    }
    
    @Override
    public List<UsuarioI> listar() throws SQLException, Exception {
        List<UsuarioI> usuarios  = new ArrayList<>(); 
        String sql = "select * from usuarioI"; 
        PreparedStatement pt = getConnection().prepareStatement(sql) ; 
        ResultSet rs = pt.executeQuery(); 
        while(rs.next()){
            UsuarioI u = getUsuario(rs); 
            usuarios.add(u); 
        }
        return usuarios; 
    }

    @Override
    public UsuarioI porId(Long id) throws SQLException, Exception {
        UsuarioI u = null; 
        PreparedStatement pt = getConnection().prepareStatement("select * from usuarioI where UI_Id = ?"); 
        pt.setLong(1, id);
        ResultSet rs = pt.executeQuery(); 
        if(rs.next()){
            u = getUsuario(rs); 
        }
        return u; 
    }

    @Override
    public UsuarioI porUser(String user) throws SQLException, Exception {
        UsuarioI u = null; 
        PreparedStatement pt = getConnection().prepareStatement("select * from usuarioI where UI_User = ?"); 
        pt.setString(1, user);
        ResultSet rs = pt.executeQuery(); 
        if(rs.next()){
            u = getUsuario(rs); 
        }
        return u;
    }

    @Override
    public void ActualizaNombre(Long id, String user) throws SQLException, Exception {
        String sql = "update dieta_usuario set UI_User = ? where UI_Id = ? ";
        PreparedStatement pt = getConnection().prepareStatement(sql); 
        pt.setString(1, user); 
        pt.setLong(2,id); 
        pt.executeUpdate(); 
    }

    @Override
    public void ActualizaCalorias(Long id, String pass) throws SQLException, Exception {
        String sql = "update dieta_usuario set UI_Pass = ? where UI_Id = ? ";
        PreparedStatement pt = getConnection().prepareStatement(sql); 
        pt.setString(1, pass); 
        pt.setLong(2,id); 
        pt.executeUpdate();
    }
    
    

    
   
    
}
