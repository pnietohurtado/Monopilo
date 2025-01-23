/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.monopoly;

import com.mycompany.monopoly.conexionBBDD.interfaces.UsuarioRRepositorio;
import com.mycompany.monopoly.conexionBBDD.ropositorios.UsuarioRepositorio;
import com.mycompany.monopoly.modelos.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author pablo
 */
public class Monopoly {

    public static void main(String[] args)throws SQLException,Exception {
        UsuarioRRepositorio u = new UsuarioRepositorio();
        
        u.insertar(new Usuario("Pablo","Nieto","root", "pablongo03"));
        System.out.println(u.listar());
        //System.out.println(u.porUser("root3"));
        
        
        
        
        
    }
}
