/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author pablo
 */
public class VersionFinal {
    
    
    /*!!!!!!!!!!!!!!!!  FUNCIÓN DE LISTAR TABLERO SEA CUAL SEA EL RESULTADO  !!!!!!!!!!!!!!!!!!!!!!!!!!!*/  
    public static void listarTablero(String[][] tablero){
        for(int i = 0; i < tablero.length ; i++){
            for(int j = 0 ; j< tablero[0].length ; j++){
                System.out.print(tablero[i][j]);
            }
            System.out.println("");
        }
    }
    
    
    /*!!!!!!!!!!!!!!   LLAMAMOS A UNA FUNCIÓN DADO PARA LOS JUGADORES   !!!!!!!!!!!!!!!!!!!!!!!!!!*/
    public static int dado(){
        return (int)(Math.random() * 7); 
    }
    
    
    
    
    
    
    
    public static void main(String[] args)throws SQLException, Exception {
        Scanner sc = new Scanner(System.in); 
        UsuarioRRepositorio usuarios =  new UsuarioRepositorio(); //Nos encargamos de poder registrar los usuarios
        //y que con ayuda del trigger dentro de la BBDD se añadan a la tabla "usuarioI". 
        IUsuarioIRepositorio u  = new UsuarioIRepositorio(); //Necesario para confirmar el registro de los usuarios 
        
        IJugadoresRepositorio<Jugador1>  j1 = new Jugador1Repositorio();  //Ambos jugadores quedan registrados
        IJugadoresRepositorio<Jugador2>  j2 = new Jugador2Repositorio(); 
        
        ICasillasRepositorio cas = new CasillasRepositorio(); //Con esto vamos a añadir y actualizar las casillas disponibles
        
        
        
        
        /*!!!!!!!!!!!!    REGISTRO DE USUARIO   !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/
        /*
        System.out.print("Dime tu nombre: ");
        String nombre1 = sc.nextLine(); 
        System.out.print("Dime tus apellidos: ");
        String apellido1 = sc.nextLine(); 
        System.out.println("Registra un usuario");
        String user1 = sc.nextLine(); 
        System.out.println("Registra una contraseña");
        String pass1 = sc.nextLine(); 
        
        
        System.out.print("Dime tu nombre: ");
        String nombre2 = sc.nextLine(); 
        System.out.print("Dime tus apellidos: ");
        String apellido2 = sc.nextLine();
        System.out.println("Registra un usuario");
        String user2 = sc.nextLine(); 
        System.out.println("Registra una contraseña");
        String pass3 = sc.nextLine(); 
        
        */
        
        /*Se llama a la BBDD para insertar los dos usuarios*/
        /*
        usuarios.insertar(new Usuario(nombre1, apellido1, user1, pass1));
        usuarios.insertar(new Usuario(nombre2, apellido2, user2, pass3));
        */
        /*****************************************************************/
        
        
        
        /*!!!!!!!!!!!!!!!!!!!    INICIO DE SESIÓN DE LOS DOS JUGADORES    !!!!!!!!!!!!!!!!!!!!!!!*/
        /*
        System.out.println("Inicio de sesión, Dime un nombre: ");
        String name1 = sc.nextLine(); 
        System.out.println("Dime la contraseña: ");
        String contra1 = sc.nextLine(); 
        System.out.println("Inicio de sesión, Dime un nombre: ");
        String name2 = sc.nextLine(); 
        System.out.println("Dime la contraseña: ");
        String contra2 = sc.nextLine();
        */
        /*Se llama a la BBDD para iniciar sesión con los dos jugadores*/
        /*
        u.inicioSesion(name1, contra1, 1);
        u.inicioSesion(name2, contra2, 2);
        */
        /**************************************************************************/
        
        
        
        /*!!!!!!!!!!!!!!!!!!!!    ASIGNANDO LOS JUGADORES CON SUS PERFILES !!!!!!!!!!!!!!!!!!!!!!!!*/
        /*
        UsuarioI u1 = u.porUser("Pablongo03"); 
        UsuarioI u2 = u.porUser("rufian"); 
        Long idJ1 = u1.getUI_Id(); //Con esto asignamos el "J1_IdUser" y "J2_IdUser" en la base de datos 
        Long idJ2 = u2.getUI_Id(); 
        
        Jugador1 jug1 = j1.porId(idJ1); //Metemos un objeto jugador el cual buscamos los valores mediante el select 
        Jugador2 jug2 = j2.porId(idJ2); // por "idJ1 y idJ2" para poder tener los datos de los jugadores en físico
        */
        /****************************************************************************/
        
        
        //Tablero t = new Tablero(jug1, jug2); 
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        /*!!!!!!!!!!!!!!!!!!!!    PARTE DEL JUEGO CON EL TABLERO    !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/
        
        String tableroPlantilla[][] = new String[11][11]; //Aquí creamos un array de tablero para poder meter los datos luego en un función 
        String tablero[][] = new String[11][11]; //Este va a ser el tablero donde estén los dos jugadores
        
        for (int i = 0; i < tableroPlantilla.length; i++) {
            for (int j = 0; j < tableroPlantilla[0].length; j++) {
                // Verificar si estamos en el anillo exterior
                if (i == 0 || i == 11 - 1 || j == 0 || j == 11 - 1) {
                    tableroPlantilla[i][j] = " x "; 
                } else {
                    tableroPlantilla[i][j] = "   "; 
                }
            }
        }
         
        
        tableroPlantilla[0][0] = " S "; 
        
        tableroPlantilla[0][1] = " R "; //Rosa
        tableroPlantilla[0][3] = " R "; //Rosa
        
        tableroPlantilla[0][6] = " A "; //Azul Claro
        tableroPlantilla[0][8] = " A "; 
        tableroPlantilla[0][9] = " A "; 
        
        tableroPlantilla[0][10] = " C "; //Carcel
        tableroPlantilla[10][0] = " C "; //Carcel
        
        tableroPlantilla[1][0] = " A "; //Azul Oscuro
        tableroPlantilla[3][0] = " A "; //Azul Oscuro
        
        tableroPlantilla[6][0] = " V "; //Verde
        tableroPlantilla[8][0] = " V "; //Verde
        tableroPlantilla[9][0] = " V "; //Verde
        
        tableroPlantilla[1][10] = " M "; //Morado
        tableroPlantilla[3][10] = " M "; //Morado
        tableroPlantilla[4][10] = " M "; //Morado
        
        tableroPlantilla[6][10] = " N "; //Naranja
        tableroPlantilla[8][10] = " N "; //Naranja
        tableroPlantilla[9][10] = " N "; //Naranja
        
        tableroPlantilla[10][1] = " A "; //Amarillo
        tableroPlantilla[10][3] = " A "; //Amarillo
        tableroPlantilla[10][4] = " A "; //Amarillo
        
        tableroPlantilla[10][6] = " R "; //Rojo
        tableroPlantilla[10][7] = " R "; //Rojo
        tableroPlantilla[10][9] = " R "; //Rojo
        
        
        
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                // Verificar si estamos en el anillo exterior
                if (i == 0 || i == 11 - 1 || j == 0 || j == 11 - 1) {
                    tablero[i][j] = " x "; 
                } else {
                    tablero[i][j] = "   "; 
                }
            }
        }
         
        
        tablero[0][0] = " S "; 
        
        tablero[0][1] = " R "; //Rosa
        tablero[0][3] = " R "; //Rosa
        
        tablero[0][6] = " A "; //Azul Claro
        tablero[0][8] = " A "; 
        tablero[0][9] = " A "; 
        
        tablero[0][10] = " C "; //Carcel
        tablero[10][0] = " C "; //Carcel
        
        tablero[1][0] = " A "; //Azul Oscuro
        tablero[3][0] = " A "; //Azul Oscuro
        
        tablero[6][0] = " V "; //Verde
        tablero[8][0] = " V "; //Verde
        tablero[9][0] = " V "; //Verde
        
        tablero[1][10] = " M "; //Morado
        tablero[3][10] = " M "; //Morado
        tablero[4][10] = " M "; //Morado
        
        tablero[6][10] = " N "; //Naranja
        tablero[8][10] = " N "; //Naranja
        tablero[9][10] = " N "; //Naranja
        
        tablero[10][1] = " A "; //Amarillo
        tablero[10][3] = " A "; //Amarillo
        tablero[10][4] = " A "; //Amarillo
        
        tablero[10][6] = " R "; //Rojo
        tablero[10][7] = " R "; //Rojo
        tablero[10][9] = " R "; //Rojo
        
        
        listarTablero(tablero); // !!!!!!!!!!!!!!PRIMER LISTADO DEL TABLERO ACTUAL 
        
        
        
        
    }
    
}
