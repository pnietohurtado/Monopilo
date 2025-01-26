/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monopoly.modelos;

import com.mycompany.monopoly.conexionBBDD.Conexion;
import static com.mycompany.monopoly.conexionBBDD.Conexion.getConnection;
import com.mycompany.monopoly.conexionBBDD.interfaces.ICasillasRepositorio;
import com.mycompany.monopoly.conexionBBDD.ropositorios.CasillasRepositorio;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author pablo
 */
public class Tablero {
    private Jugador1 j1; 
    private Jugador2 j2; 
    private List<Casilla> casillasJ1; 
    private List<Casilla> casillasJ2; 
    private List<Casilla> casillasDisponibles; 
    
    ICasillasRepositorio cas = new CasillasRepositorio(); 
    
    
    public Connection getConnectio() throws SQLException{
        return Conexion.getConnection(); 
    }
    
    public Tablero() throws SQLException, Exception{
        this.casillasJ1 = new ArrayList<>(); 
        this.casillasJ2 = new ArrayList<>();
        this.casillasDisponibles = new ArrayList<>();
        cas.cargarCasillasCasilla(this);
    }
    
    public Tablero(Jugador1 j1, Jugador2 j2) throws SQLException, Exception{
        this(); 
        this.j1 = j1; 
        this.j2 = j2; 
    }
    
    public void CargarCasillaJ1(Long id, Jugador1 j) throws SQLException,Exception{
        Casilla c = porId(id); 
        casillasJ1.add(c); 
        EliminarCasillaDisponible(id); 
        
        PreparedStatement pt = getConnection().prepareStatement("update casilla set CAS_Disponibilidad = 1, CAS_IdPropietario = ?, CAS_Propietario = ? where CAS_Id = ?"); 
        pt.setLong(1, j.getJ1_IdUser());
        pt.setString(2, "jugador1"); 
        pt.setLong(3, id); 
        pt.executeUpdate(); 
        
        /*De esta forma cada vez que un jugador compre alguna de las casillas no solo se va a actualizar en 
        nuestro programa sino que también se va a ir actualizando en nuestra base de datos. */
        String sql = "call actualizaJ1()"; 
        PreparedStatement pt2 = getConnection().prepareStatement(sql); 
        pt2.executeUpdate(); 
    }
    
    public void CargarCasillaJ2(Long id, Jugador2 j) throws SQLException,Exception{
        Casilla c = porId(id); 
        casillasJ2.add(c); 
        EliminarCasillaDisponible(id); 
    }
    
    public Casilla porId(Long id) throws SQLException,Exception{
        
        Iterator<Casilla> it = casillasDisponibles.iterator(); 
        while(it.hasNext()){
            Casilla c = it.next(); 
            if(c.getCAS_Id().equals(id)){
                return  c; 
            }
        }
        return null; 
    }
    
    public void EliminarCasillaDisponible(Long id) throws SQLException,Exception{
        Casilla c = porId(id); 
        casillasDisponibles.remove(c); 
    }
    
    public void CargarCasillasJuego(Casilla c) throws SQLException,Exception
               /*Esta función va a ser la encargada de añadir todos los datos de las casillas a 
            nuestro programa de java desde la Base de Datos, haciendo los datos aún más manejables*/
    {
        casillasDisponibles.add(c); 
    }
    
    
    public List<Casilla> casillasJugador2() throws SQLException,Exception{
        return this.casillasJ2; 
    }
    
    public List<Casilla> casillasJugador1() throws SQLException,Exception{
        return this.casillasJ1; 
    }
    
    public List<Casilla> casillasDisponibles() throws SQLException,Exception{
        return this.casillasDisponibles; 
    }
    
    
    @Override 
    public String toString(){
        StringBuilder sb = new StringBuilder(); 
        sb.append(" Jugador 1 { ").append(this.j1).append(" } Jugador 2 { ").append(this.j2).append(" }").append("\n"); 
        return sb.toString(); 
    }
}
