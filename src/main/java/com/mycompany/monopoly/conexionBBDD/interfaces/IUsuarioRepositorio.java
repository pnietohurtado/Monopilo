/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monopoly.conexionBBDD.interfaces;

import com.mycompany.monopoly.conexionBBDD.Excepciones.UsuarioNoEncontrado;
import com.mycompany.monopoly.conexionBBDD.Excepciones.UsuarioYaExisteException;
import com.mycompany.monopoly.modelos.Usuario;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author pablo
 */
public interface IUsuarioRepositorio <T> {
    public List<T> listar() throws SQLException, Exception; 
    public T porId(Long id) throws SQLException, Exception; 
    public T porUser(String user) throws SQLException, Exception; 
 
}
