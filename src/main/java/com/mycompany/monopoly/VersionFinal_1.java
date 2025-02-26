/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monopoly;

import com.mycompany.monopoly.conexionBBDD.interfaces.ICasillasRepositorio;
import com.mycompany.monopoly.conexionBBDD.interfaces.IJugadoresRepositorio;
import com.mycompany.monopoly.conexionBBDD.interfaces.IPosicionRepositorio;
import com.mycompany.monopoly.conexionBBDD.interfaces.IUsuarioRepositorio;
import com.mycompany.monopoly.conexionBBDD.ropositorios.CasillasRepositorio;
import com.mycompany.monopoly.conexionBBDD.ropositorios.Jugador1Repositorio;
import com.mycompany.monopoly.conexionBBDD.ropositorios.Jugador2Repositorio;
import com.mycompany.monopoly.conexionBBDD.ropositorios.PosicionJ1Repositorio;
import com.mycompany.monopoly.conexionBBDD.ropositorios.PosicionJ2Repositorio;
import com.mycompany.monopoly.conexionBBDD.ropositorios.UsuarioIRepositorio;
import com.mycompany.monopoly.conexionBBDD.ropositorios.UsuarioRepositorio;
import com.mycompany.monopoly.modelos.Casilla;
import com.mycompany.monopoly.modelos.Jugador1;
import com.mycompany.monopoly.modelos.Jugador2;
import com.mycompany.monopoly.modelos.PosicionJ1;
import com.mycompany.monopoly.modelos.PosicionJ2;
import com.mycompany.monopoly.modelos.Tablero;
import com.mycompany.monopoly.modelos.UsuarioI;
//import static com.mycompany.monopoly.pruebas.dado;
//import static com.mycompany.monopoly.pruebas.listarTablero;
//import static com.mycompany.monopoly.pruebas.resetearJugador;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author pablo
 */
public class VersionFinal_1 {
    
    public static String menuJugador(){
        
        Scanner sc = new Scanner(System.in); 
        String opcion = ""; 
        System.out.println(" [1] Tirar el dado. ");
        System.out.println(" [2] Mostrar casillas disponibles. ");
        System.out.println(" [3] Mostrar casillas en propiedad. ");
        System.out.println(" [4] Mostrar dinero. ");
        System.out.println(" [5] RENDIRSE. ");
        System.out.print("Elección -> ");
        opcion = sc.nextLine(); 
        //sc.close(); 
        return opcion; 
    }
    
    
   public static void resetearJugador(String[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (tablero[i][j].equals(" 1 ") || tablero[i][j].equals(" 2 ")) {
                    tablero[i][j] = "   ";
                }
            }
        }
    }

    public static int dado() {
        return (int) (Math.random() * 6) + 1;
    }

    public static void listarTablero(String[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                System.out.print(tablero[i][j]);
            }
            System.out.println("");
        }
    }
    
    /*Función que mire si los usuarios están en banca rota o no*/
    
    public static void ganador(Jugador1 jug1, Jugador2 jug2) throws SQLException, Exception{
        IJugadoresRepositorio<Jugador1> jugador1 = new Jugador1Repositorio(); 
        IJugadoresRepositorio<Jugador2> jugador2 = new Jugador2Repositorio(); 
        if(jugador1.getSaldo() <= 0){
            System.out.println("El ganador es "+jug2.getJ2_IdUser());
            System.exit(0); 
        }else if(jugador2.getSaldo() <= 0){
            System.out.println("El ganador es "+jug1.getJ1_IdUser());
            System.exit(0); 
        }
    }
   
    
    
    public static void main(String[] args)throws SQLException, Exception {
        Scanner sc = new Scanner(System.in); 
        IUsuarioRepositorio usuarios =  new UsuarioRepositorio(); //Nos encargamos de poder registrar los usuarios
        //y que con ayuda del trigger dentro de la BBDD se añadan a la tabla "usuarioI". 
        IUsuarioRepositorio u  = new UsuarioIRepositorio(); //Necesario para confirmar el registro de los usuarios 
        
        IJugadoresRepositorio<Jugador1>  j1 = new Jugador1Repositorio();  //Ambos jugadores quedan registrados
        IJugadoresRepositorio<Jugador2>  j2 = new Jugador2Repositorio(); 
        
        ICasillasRepositorio cas = new CasillasRepositorio(); //Con esto vamos a añadir y actualizar las casillas disponibles
        
        
        IPosicionRepositorio<PosicionJ1> posJ1 = new PosicionJ1Repositorio(); 
        IPosicionRepositorio<PosicionJ2> posJ2 = new PosicionJ2Repositorio(); 
        
        
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
        
        System.out.println("Inicio de sesión, Dime un nombre: ");
        String name1 = sc.nextLine(); 
        System.out.println("Dime la contraseña: ");
        String contra1 = sc.nextLine(); 
        System.out.println("Inicio de sesión, Dime un nombre: ");
        String name2 = sc.nextLine(); 
        System.out.println("Dime la contraseña: ");
        String contra2 = sc.nextLine();
        
        /*Se llama a la BBDD para iniciar sesión con los dos jugadores*/
        
        //u.inicioSesion(name1, contra1, 1);
        //u.inicioSesion(name2, contra2, 2);
        
        UsuarioI usuario1 = (UsuarioI) u.porUser(name1); //Estoy obetiendo los valores de ambos usuarios 
        UsuarioI usuario2 = (UsuarioI) u.porUser(name2); 
        /**************************************************************************/
        
        //En base a "usuario1 y usuario2" vamos a obtener los id necesarios para poder 
        //realizar las cuatro consultas básicas de nuestro servidor. 
        
           //Esta un poco más abajo donde instanciamos el "Tablero" 
        
        
        /**************************************************************************/
        
        
        
        /*!!!!!!!!!!!!!!!!!!!!    ASIGNANDO LOS JUGADORES CON SUS PERFILES !!!!!!!!!!!!!!!!!!!!!!!!*/
        
        UsuarioI u1 = (UsuarioI) u.porUser("pablongo03"); 
        UsuarioI u2 = (UsuarioI) u.porUser("rufian"); 
        Long idJ1 = u1.getUI_Id(); //Con esto asignamos el "J1_IdUser" y "J2_IdUser" en la base de datos 
        Long idJ2 = u2.getUI_Id(); 
        //System.out.println("id "+ idJ1);
        
        Jugador1 jug1 = j1.porId(idJ1); //Metemos un objeto jugador el cual buscamos los valores mediante el select 
        Jugador2 jug2 = j2.porId(idJ2); // por "idJ1 y idJ2" para poder tener los datos de los jugadores en físico
        System.out.println("jug 1 "+jug1);
        /****************************************************************************/
        
        
        Tablero t = new Tablero(jug1, jug2); 
        
        //t.inicioPartida(usuario1.getUI_Id(), usuario2.getUI_Id()); //Borra todos los datos de la partida anterior
        
        System.out.println(jug1);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        /*!!!!!!!!!!!!!!!!!!!!    PARTE DEL JUEGO CON EL TABLERO    !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/
        
        String[][] tableroPlantilla = new String[11][11]; 
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
        
        
        
        
        String[][] tablero = new String[11][11];

        // Inicializar tablero con bordes y espacios
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (i == 0 || i == 10 || j == 0 || j == 10) {
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
        
        

        // Posición inicial del jugador
        int x1 = 0;
        int y1 = 0;
        int x2 = 0; 
        int y2 = 0; 
        tablero[x1][y1] = " 1 ";
        tablero[x2][y2] = " 2 ";
        String respuesta;
        
        int vueltaJ1 = 0; //Ambos atributos van a contar las respectivas vueltas de los jugadores 
        int vueltaJ2 = 0; // jugador 1 y jugador 2

        
        
        
        
        /*Cargar las casillas disponibles*/
        cas.cargarCasillasCasilla(t);
        
        
        
        
        int carcelJ1 = 0; 
        int carcelJ2 = 0; 
        
        do 
                /*A partir de aquí empieza el tablero del juego donde los jugadores van
                a ir turnandose entre ellos para ir tirando el dado */
        
        {
            
            
            
            System.out.println("======================");
            System.out.print("¿Seguir jugando? (no para salir): ");
            respuesta = sc.nextLine();

            if (respuesta.equalsIgnoreCase("no")) {
                break;
            }
            
            
            
            /*En esta parte juega el jugador 1-------------------*/
            
            
            String eleccionJ1; 
            do{
            System.out.println("==============Jugador 1=============");
            eleccionJ1 = menuJugador(); 
            //System.out.println("eleccion "+eleccion);
            
                if(carcelJ1 == 0){
                    switch(eleccionJ1){
                        case "1" ->  {
                            listarTablero(tablero);
                            System.out.println("==============Jugador 1=============");
                            System.out.println("Tira el dado...");
                            int pasos = dado();
                            System.out.println("El dado mostró: " + pasos);

                            // Actualizar la posición del jugador en sentido horario
                            resetearJugador(tablero);

                            for (int i = 0; i < pasos; i++) {
                                if (x1 == 0 && y1 < 10) { // Va hacia la derecha

                                    y1++;
                                    if(tablero[x1][y1].equals(" S ")){
                                        System.out.println("vueltaaaaaaaa");
                                        t.vueltaCompletada1(idJ1, jug1);
                                        ++vueltaJ1; 
                                    }
                                } else if (y1 == 10 && x1 < 10) { // Baja
                                    x1++;

                                } else if (x1 == 10 && y1 > 0) { // Va hacia la izquierda
                                    y1--;

                                } else if (y1 == 0 && x1 > 0) { // Sube
                                    x1--;
                                    if(tablero[x1][y1].equals(" S ")){
                                        System.out.println("vueltaaaaaaaa");
                                        t.vueltaCompletada1(idJ1, jug1);
                                        ++vueltaJ1; 
                                    }
                                }
                            }

                            


                            tablero[x1][y1] = " 1 ";

                            for(int i = 0; i < tablero.length ; i++){
                                for(int j = 0 ; j< tablero[0].length ; j++){

                                    if(tablero[i][j].equals(" 1 ") ||tablero[i][j].equals(" 2 ")){
                                        //continue; 
                                    }else {
                                        tablero[i][j] = tableroPlantilla[i][j]; 
                                    }

                                }
                            }

                            /*!!!!!!!!!Enviamos las posiciones de el Jugador1!!!!!!!!!*/
                            posJ1.obtenerPosActual(idJ1,x1,y1); 
                            posJ2.obtenerPosActual(idJ2, x2, y2);
                            
                            
                            //Prueba sobre la posición del jugador2 en el tablero de jugador1 
                            tablero[posJ2.obtenerX()][posJ2.obtenerY()] = " 2 "; 
                            
                            listarTablero(tablero);
                           
                            
                            System.out.println("Posicion J1 "+posJ1.obtenerX() + " "+posJ1.obtenerY());
                            System.out.println("Posicion J2 "+posJ2.obtenerX() + " "+posJ2.obtenerY());
                            /*!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/

                            
                            /*En caso de que caiga en la carcel*/
                            if(tablero[0][10].equals(" 1 ")||tablero[10][0].equals(" 1 ")){
                                System.out.println("A la carcellll");
                                carcelJ1 = 2; 
                            }


                            /*!!!!!!!!En caso de que caiga en una casilla comprable!!!!!!!!!!!!!!*/

                            Long id = cas.obtenerIdCasilla(x1, y1); 
                            System.out.println("id "+id);
                            //System.out.println("jug1 "+ jug1);
                            //System.out.println("jug1 "+ jug1);
                            
                            if(id != null){
                                Casilla casilla = cas.porId(id); 
                                System.out.println("Dinero disponible -> "+ jug1.getJ1_Dinero());
                                System.out.println("propietario de la casilla" + casilla.getCAS_Propietario()+ " Disponibilidad "+casilla.isCAS_Disponibilidad() );
                                    
                                if(casilla.getCAS_Propietario() == null){
                                    if(casilla.getCAS_Tipo().equals("Propiedad")){
                                        System.out.println("Quiere comprar la propiedad "+ cas.porId(id)+ " [Y/N]");
                                        String respuesta2 = sc.nextLine(); 
                                        if(respuesta2.equalsIgnoreCase("y")){
                                            casilla.setCAS_Disponibilidad(1);
                                            t.CargarCasillaJ1(id, jug1); //11
                                            //System.out.println(t.casillasJugador1());

                                        }
                                    }else if(casilla.getCAS_Tipo().equals("Suerte")){
                                        t.suerte1(jug1); 
                                    }
                                }else if(casilla.getCAS_Propietario().equals("jugador1")|| casilla.getCAS_Propietario().equals("jugador2") ){
                                    //System.out.println("dentro de comprobacion");
                                    t.actualizarSaldoJ1(id, jug1);
                                
                                }
                                //System.out.println("Cuanto dinero le queda"+ jug1.getJ1_Dinero());
                            }
                        /*!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/ 
                        }

                        case "2" ->                                 /*Vamos a mostrar las casillas que quedan disponibles sin 
                            propietario en el tablero*/
                        {
                            t.ActualizarCasillasDisponibles();
                            cas.cargarCasillasCasilla(t);
                            System.out.println(t.casillasDisponibles());

                        }


                        case "3" ->  {
                            System.out.println(t.casillasJugador1());
                        }


                        case "4" ->  {
                            t.actualizarSaldoJ1(100L, jug1);
                            System.out.println("Dinero Actual -> "+ jug1.getJ1_Dinero());
                        }

                    }
                }else {
                    System.out.println("No puede hacer nada, está en la carcel!!!");
                    carcelJ1--; 
                    
                    break; 
                }
            
                ganador(jug1, jug2); 
            }while(!(eleccionJ1.equals("1"))); 
            
            
            
            
            
            
            /*=====================================================================*/
            /*=====================================================================*/
            /*A partir de aquí juega el jugador 2 ---------------------------------*/
            /*=====================================================================*/
            /*=====================================================================*/
            
            
            
            
            System.out.println("==============Jugador 2==================");
            

            System.out.println("Tira el dado...");
            int pasos2 = dado();
            System.out.println("El dado mostró: " + pasos2);

            // Actualizar la posición del jugador en sentido de las agujas del reloj 
            
            String eleccionJ2; 
            do{
                System.out.println("==============Jugador 2==================");
                eleccionJ2 = menuJugador(); 
                System.out.println("carcel "+carcelJ2);
                if(carcelJ2 == 0){
                    switch(eleccionJ2){

                        case "1" ->  {
                            for (int i = 0; i < pasos2; i++) {
                                if (x2 == 0 && y2 < 10) { // Va hacia la derecha
                                    y2++;
                                    if(tablero[x2][y2].equals(" S ")){
                                        System.out.println("vueltaaaaaaaa");
                                        t.vueltaCompletada2(idJ2, jug2);

                                        ++vueltaJ2; 
                                    }
                                } else if (y2 == 10 && x2 < 10) { // Baja
                                    x2++;
                                } else if (x2 == 10 && y2 > 0) { // Va hacia la izquierda
                                    y2--;
                                } else if (y2 == 0 && x2 > 0) { // Sube
                                    x2--;
                                    if(tablero[x2][y2].equals(" S ")){
                                        System.out.println("vueltaaaaaaaa");
                                        t.vueltaCompletada2(idJ2, jug2);
                                        ++vueltaJ2; 
                                    }
                                }
                            }

                            resetearJugador(tablero);
                            
                            
                            tablero[x2][y2] = " 2 "; // x2 = posI del jugador2 , y2 = posJ del jugador2 

                            

                            for(int i = 0; i < tablero.length ; i++){
                                for(int j = 0 ; j< tablero[0].length ; j++){

                                    if(tablero[i][j].equals(" 1 ") ||tablero[i][j].equals(" 2 ")){
                                        //continue; 
                                    }else {
                                        tablero[i][j] = tableroPlantilla[i][j]; 
                                    }

                                }
                            }
                            /*!!!!!!!!!Enviamos las posiciones de el Jugador1!!!!!!!!!*/
                            posJ2.obtenerPosActual(idJ2,x2,y2); 
                            posJ1.obtenerPosActual(idJ1, x1, y1);
                            
                            tablero[posJ1.obtenerX()][posJ1.obtenerY()] = " 1 "; 
                            
                            listarTablero(tablero);
                           
                            
                            System.out.println("Posicion J2 "+posJ2.obtenerX() + " "+posJ2.obtenerY());
                            System.out.println("Posicion J1 "+posJ1.obtenerX() + " "+posJ1.obtenerY());

                            
                            /*!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/

                            
                            /*En caso de que caiga en la carcel*/
                            if(tablero[0][10].equals(" 2 ")||tablero[10][0].equals(" 2 ")){
                                System.out.println("A la carcellll");
                                carcelJ2 = 2; 
                            }

                            /*!!!!!!!!En caso de que caiga en una casilla comprable!!!!!!!!!!!!!!*/

                            Long id2 = cas.obtenerIdCasilla(x2, y2); 
                            System.out.println("id "+id2);
                            //System.out.println("jug1 "+ jug1);
                            if(id2 != null){
                                Casilla casilla = cas.porId(id2); 
                                System.out.println("Dinero disponible -> "+ jug2.getJ2_Dinero());
                                
                                    
                                if(casilla.getCAS_Propietario() == null){
                                    if(casilla.getCAS_Tipo().equals("Propiedad")){
                                        System.out.println("Quiere comprar la propiedad "+ cas.porId(id2)+ " [Y/N]");
                                        String respuesta2 = sc.nextLine(); 
                                        if(respuesta2.equalsIgnoreCase("y")){
                                            casilla.setCAS_Disponibilidad(1);
                                            t.CargarCasillaJ2(id2, jug2); //11
                                            //System.out.println(t.casillasJugador2());
                                            //casilla.setCAS_Disponibilidad(1);
                                        }
                                    }else if(casilla.getCAS_Tipo().equals("Suerte")){
                                        t.suerte2(jug2); 
                                    }
                                }else if(casilla.getCAS_Propietario().equals("jugador1")|| casilla.getCAS_Propietario().equals("jugador2")){
                                    //System.out.println("dentro de comprobacion");
                                    t.actualizarSaldoJ2(id2, jug2);
                                
                                }
                                //System.out.println("Cuanto dinero le queda"+ jug1.getJ1_Dinero());
                            }
                            //Muy necesario ya que si no salta al siguiente "case"

                        }

                        case "2" ->                                 /*Se encarga de mostrar las casillas que quedan disponibles para comprar
                            para los dos jugadores, es decir, aquellas que no tienen dueño aún.*/
                        {
                            t.ActualizarCasillasDisponibles();
                            cas.cargarCasillasCasilla(t);
                            System.out.println(t.casillasDisponibles());

                        }

                        case "3" ->  {
                            System.out.println(t.casillasJugador2());
                        }

                        case "4" ->  {
                            t.actualizarSaldoJ2(100L, jug2);
                            System.out.println("Dinero Actual -> "+ jug2.getJ2_Dinero());
                        }

                    }
                }else{
                    System.out.println("No puede hacer nada, está en la carcel!!!!!!!!!");
                    carcelJ2--; 
                    break;
                }
            }while(!(eleccionJ2.equals("1"))); 

        } while (!respuesta.equalsIgnoreCase("no"));
        
        
        
    }
    
}
