/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monopoly;

import com.mycompany.monopoly.conexionBBDD.interfaces.UsuarioRRepositorio;
import com.mycompany.monopoly.conexionBBDD.ropositorios.UsuarioRepositorio;
import com.mycompany.monopoly.modelos.Usuario;
import java.sql.SQLException;

/**
 *
 * @author pablo
 */
public class MainDePruebas {
    public static void main(String[] args) throws SQLException, Exception {
        UsuarioRRepositorio u1 = new UsuarioRepositorio(); 
        u1.insertar(new Usuario("Pablo", "Nieto", "julian", "123123"));
        u1.insertar(new Usuario("Pablo", "Nieto", "jose" , "123123"));
    }
}
