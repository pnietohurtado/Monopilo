/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monopoly.conexionBBDD.interfaces;

import com.mycompany.monopoly.modelos.Casilla;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author pablo
 */
public interface ICasillasRepositorio {
    public List<Casilla> listar() throws SQLException, Exception;  
    public List<Casilla> casillasPropietario(String propietario) throws SQLException, Exception;
    public List<Casilla> diponibilidad() throws SQLException, Exception;
    public List<Casilla> tipos(String tipo) throws SQLException, Exception;
    public List<Casilla> color(String color) throws SQLException, Exception;
    public Casilla porNombre(String nombre) throws SQLException, Exception;
}
