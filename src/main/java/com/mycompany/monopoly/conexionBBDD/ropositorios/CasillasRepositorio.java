/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monopoly.conexionBBDD.ropositorios;

import com.mycompany.monopoly.conexionBBDD.Conexion;
import com.mycompany.monopoly.conexionBBDD.Excepciones.UsuarioYaExisteException;
import com.mycompany.monopoly.conexionBBDD.interfaces.ICasillasRepositorio;
import com.mycompany.monopoly.conexionBBDD.interfaces.IUsuarioIRepositorio;
import com.mycompany.monopoly.modelos.Casilla;
import com.mycompany.monopoly.modelos.Tablero;
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
public class CasillasRepositorio implements ICasillasRepositorio{
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
    
    private static Casilla getCasillaPos(ResultSet rs) throws SQLException{
        Casilla c = new Casilla(); 
        c.setCAS_Id(rs.getLong("CAS_Id"));
        c.setCAS_Nombre(rs.getString("CAS_Nombre"));
        c.setCAS_Precio(rs.getDouble("CAS_Precio")); 
        c.comprobarDisponibilidad(rs.getInt("CAS_Disponibilidad"));
        c.setCAS_Propietario(rs.getString("CAS_Propietario"));
        c.setCAS_Tipo(rs.getString("CAS_Tipo"));
        c.setCAS_Color(rs.getString("CAS_Color")); 
        c.setPosicionI(rs.getInt("posicionI"));
        c.setPosicionJ(rs.getInt("posicionJ"));
        return c; 
    }
    

    @Override
    public List<Casilla> listar() throws SQLException, Exception {
        List<Casilla> casillas = new ArrayList<>(); 
        String sql = "select * from casilla"; 
        PreparedStatement pt = getConnection().prepareStatement(sql); 
        ResultSet rs = pt.executeQuery(); 
        while(rs.next()){
            Casilla c = getCasilla(rs); 
            casillas.add(c); 
        }
        return casillas; 
    }

    @Override
    public List<Casilla> casillasPropietario(String propietario) throws SQLException, Exception 
            /*Esta función va a tener una pequeña particularidad y es que vamos a tener que enlazarlo con el usuario
            que está jugando la partida de alguna forma*/
    
    {
        List<Casilla> casillas = new ArrayList<>(); 
        String sql = "select * from casilla where CAS_Propietario = ?"; 
        PreparedStatement pt = getConnection().prepareStatement(sql); 
        pt.setString(1, propietario); 
        ResultSet rs = pt.executeQuery(); 
        while(rs.next()){
            Casilla c = getCasilla(rs); 
            casillas.add(c); 
        }
        return casillas; 
    }

    @Override
    public List<Casilla> diponibilidad() throws SQLException, Exception {
        List<Casilla> casillas = new ArrayList<>(); 
        String sql = "select * from casilla where CAS_Disponibilidad = 1"; 
        PreparedStatement pt = getConnection().prepareStatement(sql); 
        ResultSet rs = pt.executeQuery(); 
        while(rs.next()){
            Casilla c = getCasilla(rs); 
            casillas.add(c); 
        }
        return casillas; 
    }

    @Override
    public List<Casilla> tipos(String tipo) throws SQLException, Exception {
        List<Casilla> casillas = new ArrayList<>(); 
        String sql = "select * from casilla where CAS_Tipo = ?"; 
        PreparedStatement pt = getConnection().prepareStatement(sql); 
        pt.setString(1, tipo); 
        ResultSet rs = pt.executeQuery(); 
        while(rs.next()){
            Casilla c = getCasilla(rs); 
            casillas.add(c); 
        }
        return casillas; 
    }

    @Override
    public List<Casilla> color(String color) throws SQLException, Exception {
        List<Casilla> casillas = new ArrayList<>(); 
        String sql = "select * from casilla where CAS_Color = ? "; 
        PreparedStatement pt = getConnection().prepareStatement(sql); 
        pt.setString(1, color); 
        ResultSet rs = pt.executeQuery(); 
        while(rs.next()){
            Casilla c = getCasilla(rs); 
            casillas.add(c); 
        }
        return casillas; 
    }

    @Override
    public Casilla porNombre(String nombre) throws SQLException, Exception {
        Casilla c = null;  
        String sql = "select * from casilla where CAS_Nombre = ?"; 
        PreparedStatement pt = getConnection().prepareStatement(sql);
        pt.setString(1, nombre);
        ResultSet rs = pt.executeQuery(); 
        while(rs.next()){
            c =  getCasilla(rs); 
        }
        return c; 
    }

    @Override
    public void cargarCasillasCasilla(Tablero t) throws SQLException, Exception {
        Casilla c = null; 
        String sql = "select * from casilla where CAS_Id != 100 and CAS_Disponibilidad != 1"; 
        PreparedStatement pt = getConnection().prepareStatement(sql); 
        ResultSet rs = pt.executeQuery(); 
        while(rs.next()){
            c = getCasillaPos(rs ); 
            t.CargarCasillasJuego(c);
           
        }
    }

    @Override
    public Long obtenerIdCasilla(int x, int y) throws SQLException, Exception 
               /*Usamos esta función para poder averiguar el id de la casilla en función 
            de la posición en la que esté tanto la casilla como el usuario */
    {
        Long id = null; 
        Casilla c = null; 
        PreparedStatement pt = getConnection().prepareStatement("select * from casilla where posicionI = ? and posicionJ = ? and CAS_Tipo = ?"); 
        pt.setInt(1, x);
        pt.setInt(2, y);
        pt.setString(3, "Propiedad");
        ResultSet rs = pt.executeQuery(); 
        if(rs.next()){
            c = getCasilla(rs); 
            id = c.getCAS_Id(); 
        }
        return id; 
    }

    @Override
    public Casilla porId(Long id) throws SQLException, Exception {
        Casilla c = null; 
        PreparedStatement pt = getConnection().prepareStatement("select * from casilla where CAS_Id = ?"); 
        pt.setLong(1, id); 
        ResultSet rs = pt.executeQuery(); 
        if(rs.next()){
            c = getCasilla(rs); 
            
        }
        return c; 
    }

    
    
    
    
    
    
   
    
}
