package com.mycompany.monopoly.conexionBBDD.interfaces;

import com.mycompany.monopoly.conexionBBDD.Excepciones.UsuarioYaExisteException;
import com.mycompany.monopoly.modelos.Usuario;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author pablo
 */
public interface UsuarioRRepositorio {
    public List<Usuario> listar() throws SQLException, Exception; 
    public Usuario porId(Long id) throws SQLException, Exception; 
    public Usuario porUser(String user) throws SQLException, Exception; 
    
    
    //Inserts 
    public void insertar(Usuario u)  throws UsuarioYaExisteException, SQLException, Exception;
    
}
