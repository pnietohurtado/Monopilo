package com.mycompany.monopoly.conexionBBDD.ropositorios;

import com.mycompany.monopoly.conexionBBDD.Conexion;
import com.mycompany.monopoly.conexionBBDD.interfaces.IJugadoresRepositorio;
import static com.mycompany.monopoly.conexionBBDD.ropositorios.Jugador1Repositorio.getJugador;
import com.mycompany.monopoly.modelos.Jugador1;
import com.mycompany.monopoly.modelos.Jugador2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pablo
 */
public class Jugador2Repositorio implements IJugadoresRepositorio<Jugador2>{
    public Connection getConnection() throws SQLException{
        return Conexion.getConnection(); 
    }
    
    public static Jugador2 getJugador(ResultSet rs) throws SQLException{
        Jugador2 j2 = new Jugador2(); 
        j2.setJ2_Id(rs.getLong("J2_Id"));
        j2.setJ2_IdUser(rs.getLong("J2_IdUser"));
        j2.setJ2_Dinero(rs.getDouble("J2_Dinero"));
        j2.setJ2_IdCasilla(rs.getLong("J2_IdCasilla")); 
        return j2; 
    }

    @Override
    public Jugador2 porId(Long id) throws SQLException, Exception {
        Jugador2 j2 = new Jugador2(); 
        String sql = "select * from jugador2 where J2_IdUser = ?"; 
        PreparedStatement pt = getConnection().prepareStatement(sql); 
        pt.setLong(1, id);
        ResultSet rs = pt.executeQuery(); 
        if(rs.next()){
            j2 = getJugador(rs); 
        }
        return j2; 
    }

    @Override //Esto está mal
    public void casillas() throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public double getSaldo() throws SQLException, Exception {
        Jugador2 j2 = null; 
        double saldo  = 0.0d; 
        PreparedStatement pt = getConnection().prepareStatement("select * from jugador2 order by J2_Dinero asc limit 1"); 
        ResultSet rs = pt.executeQuery(); 
        if(rs.next()){
            j2 = getJugador(rs);
            saldo = j2.getJ2_Dinero(); 
        }
        return saldo; 
        
    }
    
    
}
