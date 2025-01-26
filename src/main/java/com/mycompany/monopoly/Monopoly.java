/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.monopoly;

import com.mycompany.monopoly.conexionBBDD.interfaces.ICasillasRepositorio;
import com.mycompany.monopoly.conexionBBDD.interfaces.IJugadoresRepositorio;
import com.mycompany.monopoly.conexionBBDD.interfaces.IUsuarioIRepositorio;
import com.mycompany.monopoly.conexionBBDD.interfaces.UsuarioRRepositorio;
import com.mycompany.monopoly.conexionBBDD.ropositorios.CasillasRepositorio;
import com.mycompany.monopoly.conexionBBDD.ropositorios.Jugador1Repositorio;
import com.mycompany.monopoly.conexionBBDD.ropositorios.Jugador2Repositorio;
import com.mycompany.monopoly.conexionBBDD.ropositorios.UsuarioIRepositorio;
import com.mycompany.monopoly.conexionBBDD.ropositorios.UsuarioRepositorio;
import com.mycompany.monopoly.modelos.Jugador1;
import com.mycompany.monopoly.modelos.Jugador2;
import com.mycompany.monopoly.modelos.Tablero;
import com.mycompany.monopoly.modelos.Usuario;
import com.mycompany.monopoly.modelos.UsuarioI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author pablo
 */
public class Monopoly {

    public static void main(String[] args)throws SQLException,Exception {
        Scanner sc = new Scanner(System.in); 
        
        UsuarioRRepositorio u1 = new UsuarioRepositorio(); 
        /*
        System.out.println("Registra un usuario");
        String user1 = sc.nextLine(); 
        System.out.println("Registra una contraseña");
        String pass1 = sc.nextLine(); 
        
        System.out.println("Registra un usuario");
        String user2 = sc.nextLine(); 
        System.out.println("Registra una contraseña");
        String pass3 = sc.nextLine(); 
        
        
        
        u1.insertar(new Usuario("Default", "Default", user1, pass1));
        u1.insertar(new Usuario("Default", "Default", user2, pass3));
        */
        
        System.out.println("======Todos los usuarios registrados sin problemas=======");
        IUsuarioIRepositorio u  = new UsuarioIRepositorio(); 
        /*
        System.out.println("Inicio de sesión, Dime un nombre: ");
        String name1 = sc.nextLine(); 
        System.out.println("Dime la contraseña: ");
        String contra1 = sc.nextLine(); 
        System.out.println("Inicio de sesión, Dime un nombre: ");
        String name2 = sc.nextLine(); 
        System.out.println("Dime la contraseña: ");
        String contra2 = sc.nextLine(); */
        /*
        u.inicioSesion("Pablongo03", "123", 1);
        u.inicioSesion("rufian", "123", 2);
        */
        UsuarioI user1 = u.porUser("Pablongo03"); 
        UsuarioI user2 = u.porUser("rufian"); 
        Long idJ1 = user1.getUI_Id(); 
        Long idJ2 = user2.getUI_Id(); 
        
        //System.out.println("id J1 "+ idJ1);
     
        IJugadoresRepositorio<Jugador1>  j1 = new Jugador1Repositorio(); 
        IJugadoresRepositorio<Jugador2>  j2 = new Jugador2Repositorio(); 
        //System.out.println(j1.porId(idJ1));
        
        Jugador1 jug1 = j1.porId(idJ1); 
        Jugador2 jug2 = j2.porId(idJ2); 
        
        Tablero t = new Tablero(jug1, jug2); 
        
        
        System.out.println("Compra el jugador1 la casilla 1");
        t.CargarCasillaJ1(11L, jug1);
        System.out.println("===========");
        System.out.println(t.casillasDisponibles());
        
    }
}
