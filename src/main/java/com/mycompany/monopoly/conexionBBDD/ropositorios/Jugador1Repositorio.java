package com.mycompany.monopoly.conexionBBDD.ropositorios;

import com.mycompany.monopoly.conexionBBDD.Conexion;
import com.mycompany.monopoly.conexionBBDD.interfaces.IJugadoresRepositorio;
import com.mycompany.monopoly.modelos.Jugador1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pablo
 */
public class Jugador1Repositorio implements IJugadoresRepositorio<Jugador1> {
    public Connection getConnection() throws SQLException{
        return Conexion.getConnection(); 
    }
    
    public static Jugador1 getJugador(ResultSet rs) throws SQLException{
        Jugador1 j1 = new Jugador1(); 
        j1.setJ1_Id(rs.getLong("J1_Id"));
        j1.setJ1_IdUser(rs.getLong("J1_IdUser"));
        j1.setJ1_Dinero(rs.getDouble("J1_Dinero"));
        j1.setJ1_IdCasilla(rs.getLong("J1_IdCasilla")); 
        return j1; 
    }

    @Override
    public Jugador1 porId(Long id) throws SQLException, Exception {
        Jugador1 j1 = new Jugador1(); 
        String sql = "select * from jugador1 where J1_IdUser = ?"; 
        PreparedStatement pt = getConnection().prepareStatement(sql); 
        pt.setLong(1, id);
        ResultSet rs = pt.executeQuery(); 
        if(rs.next()){
            j1 = getJugador(rs); 
        }
        return j1; 
    }

    @Override //Esto esta mal
    public void casillas() throws SQLException, Exception {
        String sql = "select * from jugador1 group by J1_IdCasilla"; 
        PreparedStatement pt = getConnection().prepareStatement(sql); 
        pt.executeQuery(); 
    }

    @Override
    public double getSaldo() throws SQLException, Exception {
        Jugador1 j1 = null; 
        double saldo  = 0.0d; 
        PreparedStatement pt = getConnection().prepareStatement("select * from jugador1 order by J1_Dinero asc limit 1"); 
        ResultSet rs = pt.executeQuery(); 
        if(rs.next()){
            j1 = getJugador(rs);
            saldo = j1.getJ1_Dinero(); 
        }
        return saldo; 
        
    }
    
    
    
    
    
    
}
