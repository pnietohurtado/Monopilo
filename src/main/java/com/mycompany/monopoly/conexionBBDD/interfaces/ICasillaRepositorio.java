package com.mycompany.monopoly.conexionBBDD.interfaces;

import com.mycompany.monopoly.modelos.Casilla;
import com.mycompany.monopoly.modelos.UsuarioI;
import java.util.List;
import java.sql.SQLException;  

/**
 *
 * @author pablo
 */
public interface ICasillaRepositorio {
    public List<Casilla> listar() throws SQLException, Exception; 
    public Casilla porId(Long id) throws SQLException, Exception; 
    public Casilla porNombre(String nombre) throws SQLException, Exception; 
    public Casilla porTipo(String tipo) throws SQLException, Exception;
    public Casilla porColor(String color) throws SQLException, Exception;
    public Casilla porDisponibilidad() throws SQLException, Exception;
    public Casilla porPropietario(String propietario)throws SQLException, Exception;
    
}
