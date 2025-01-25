/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.monopoly;

import com.mycompany.monopoly.conexionBBDD.interfaces.ICasillasRepositorio;
import com.mycompany.monopoly.conexionBBDD.interfaces.UsuarioRRepositorio;
import com.mycompany.monopoly.conexionBBDD.ropositorios.CasillasRepositorio;
import com.mycompany.monopoly.conexionBBDD.ropositorios.UsuarioRepositorio;
import com.mycompany.monopoly.modelos.Jugador1;
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
        
        ICasillasRepositorio c = new CasillasRepositorio(); 
        Jugador1 j1 = new Jugador1(); 
        j1.setJ1_IdUser(4L);
        System.out.println(j1);
        
        //System.out.println(u.porUser("root3"));
        
        
        
        
        
    }
}
