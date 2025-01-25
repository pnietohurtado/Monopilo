/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monopoly.conexionBBDD.interfaces;

import com.mycompany.monopoly.conexionBBDD.Excepciones.UsuarioNoEncontrado;
import com.mycompany.monopoly.conexionBBDD.Excepciones.UsuarioYaExisteException;
import com.mycompany.monopoly.modelos.Jugador1;
import com.mycompany.monopoly.modelos.Jugador2;
import com.mycompany.monopoly.modelos.UsuarioI;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author pablo
 */
public interface IUsuarioIRepositorio {
    public List<UsuarioI> listar() throws SQLException, Exception; 
    public UsuarioI porId(Long id) throws SQLException, Exception; 
    public UsuarioI porUser(String user) throws SQLException, Exception; 

    public void inicioSesion(String user, String pass, int i) throws SQLException, UsuarioNoEncontrado ,Exception; 
    
    /*-----------Actualizar los datos--------------*/
    
    
    public void ActualizaNombre(Long id, String user) throws SQLException, Exception;
    public void ActualizaCalorias(Long id, String pass) throws SQLException, Exception;

    
}
