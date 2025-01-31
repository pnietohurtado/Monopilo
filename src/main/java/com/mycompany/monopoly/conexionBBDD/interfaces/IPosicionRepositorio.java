/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monopoly.conexionBBDD.interfaces;

import java.sql.SQLException;

/**
 *
 * @author pablo
 */
public interface IPosicionRepositorio<T>  {
    public void obtenerPosActual(Long id, int x, int y) throws SQLException, Exception; 
    public int obtenerX() throws SQLException, Exception; 
    public int obtenerY() throws SQLException,Exception; 
}
