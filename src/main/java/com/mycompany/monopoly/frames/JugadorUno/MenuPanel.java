/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monopoly.frames.JugadorUno;

import static com.mycompany.monopoly.Player1.listarTablero;
import com.mycompany.monopoly.conexionBBDD.Conexion;
import com.mycompany.monopoly.conexionBBDD.interfaces.ICasillasRepositorio;
import com.mycompany.monopoly.conexionBBDD.interfaces.IJugadoresRepositorio;
import com.mycompany.monopoly.conexionBBDD.interfaces.IPosicionRepositorio;
import com.mycompany.monopoly.conexionBBDD.interfaces.IUsuarioRepositorio;
import com.mycompany.monopoly.conexionBBDD.ropositorios.CasillasRepositorio;
import com.mycompany.monopoly.conexionBBDD.ropositorios.Jugador1Repositorio;
import com.mycompany.monopoly.conexionBBDD.ropositorios.PosicionJ1Repositorio;
import com.mycompany.monopoly.conexionBBDD.ropositorios.PosicionJ2Repositorio;
import com.mycompany.monopoly.conexionBBDD.ropositorios.UsuarioIRepositorio;
import com.mycompany.monopoly.frames.GamePanel;
import com.mycompany.monopoly.modelos.Casilla;
import com.mycompany.monopoly.modelos.Jugador1;
import com.mycompany.monopoly.modelos.PosicionJ1;
import com.mycompany.monopoly.modelos.PosicionJ2;
import com.mycompany.monopoly.modelos.Tablero;
import com.mycompany.monopoly.modelos.UsuarioI;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 *
 * @author pablo
 */
public class MenuPanel extends JPanel implements Runnable 

{
    final int originalTileSize = 19; // Lo que significa que cada elemento que encontremos en el juego va a medir 19x19
    final int scale = 3;         
    
    public final int tileSize = originalTileSize * scale;  // 57x57
    public final int maxScreenCol = 6; 
    public final int maxScreenRow = 9; 
    public final int screenWidth = tileSize * maxScreenCol; // 342
    public final int screenHeight = tileSize * maxScreenRow; // 513
    
    
    public static  Connection getConnection() throws SQLException{
            return Conexion.getConnection(); 
    }

    Thread menuThread; 
    
    /*------------------------Instanciaciones necesarias para que el programa funcione correctamente------------------------------------*/
        static Scanner sc = new Scanner(System.in); 
        //static IUsuarioRepositorio usuarios =  new UsuarioRepositorio(); //Nos encargamos de poder registrar los usuarios
        //y que con ayuda del trigger dentro de la BBDD se añadan a la tabla "usuarioI". 
        static IUsuarioRepositorio<UsuarioI> u  = new UsuarioIRepositorio(); //Necesario para confirmar el registro de los usuarios 
        
        static IJugadoresRepositorio<Jugador1>  j1 = new Jugador1Repositorio();  //Ambos jugadores quedan registrados
        
        static ICasillasRepositorio cas = new CasillasRepositorio(); //Con esto vamos a añadir y actualizar las casillas disponibles
        
        
        static IPosicionRepositorio<PosicionJ1> posJ1 = new PosicionJ1Repositorio(); 
        static IPosicionRepositorio<PosicionJ2> posJ2 = new PosicionJ2Repositorio(); 
    
    
    
    
    
    
    /*Creo que la idea sería inicializar todos los contenidos de nuestro JPanel
    una vez que lo hemos inicializado podemos ajustar la información que va en cada uno de ellos
    ES DECIR, voy a tratar esta clase como una especie de lienzo para poder poner TODA la lógica 
    de el programa final. */
    

    private boolean inputReady = false; 
    private String userInput = ""; 
    
    // Tenemos que declarar una variable "GamePanel", para poder acceder a los elementos que pidamos por el juego 
    GamePanel gp = new GamePanel(); 
    
    // Contructor de la clase 
    public MenuPanel(GamePanel gp) 
    {
        this.gp = gp;         
        
        this.setPreferredSize(new Dimension(this.screenWidth, this.screenHeight)); 
        this.setBackground(Color.black); 
        this.setDoubleBuffered(true); 
        this.setFocusable(true); 
        this.setLayout(null); 
        
       
    }
 
  
    
    
    Thread comprobar; // Declaramos la comprobación de nuestro turno desde un Thread externo y lo declaramos a la vez con el menu
    ClaseComun cls = new ClaseComun(); 
    Comprobar comprueba = new Comprobar(cls); 
    
    public void startMenuThread()
    {
        menuThread = new Thread(this); 
        comprobar = new Thread(comprueba); 
        menuThread.start(); 
        comprobar.start(); 
        
    }
    
    public void stopThread()
            // Me gustaría que parase el hilo cuando uno de los dos usuarios se quede en 0 euros 
    {
        
        
    }
    


    @Override
    public void run() {
        
        try{
            
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


                    

                    */

                    /*Se llama a la BBDD para insertar los dos usuarios*/
                    /*
                    usuarios.insertar(new Usuario(nombre1, apellido1, user1, pass1));
                    
                    */
                    /*****************************************************************/



                    /*!!!!!!!!!!!!!!!!!!!    INICIO DE SESIÓN DE LOS DOS JUGADORES    !!!!!!!!!!!!!!!!!!!!!!!*/
                    
                    /*  Pequeña prueba para comprobar si puedo cambiar el curso de la partida mientras este se está ejecutando 
                    Thread.sleep(30000); 
                    gp.gameState = gp.pauseState; 
                    
                    */
                    

                    /**************************************************************************/

                    //En base a "usuario1 y usuario2" vamos a obtener los id necesarios para poder 
                    //realizar las cuatro consultas básicas de nuestro servidor. 

                       //Esta un poco más abajo donde instanciamos el "Tablero" 


                    /**************************************************************************/

                    gp.confirmar = false; 

                    /*!!!!!!!!!!!!!!!!!!!!    ASIGNANDO LOS JUGADORES CON SUS PERFILES !!!!!!!!!!!!!!!!!!!!!!!!*/
                    
                    UsuarioI u1 = u.porUser(gp.playerName); 
                    System.out.println(u1);
                    Long idJ1 = u1.getUI_Id(); //Con esto asignamos el "J1_IdUser" y "J2_IdUser" en la base de datos 

                    //System.out.println("id "+ idJ1);

                    Jugador1 jug1 = j1.porId(idJ1); //Metemos un objeto jugador el cual buscamos los valores mediante el select 

                    //System.out.println("jug 1 "+jug1);
                    /****************************************************************************/


                    Tablero t = new Tablero(jug1,null); 

                    t.inicioPartida(u1.getUI_Id(),1); //Borra todos los datos de la partida anterior

                    System.out.println("Todo borrado!!!!");
            
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
                    String respuesta = "";

                    int vueltaJ1 = 0; //Ambos atributos van a contar las respectivas vueltas de los jugadores 





                    /*Cargar las casillas disponibles*/
                    cas.cargarCasillasCasilla(t);




                    int carcelJ1 = 0; 
                    String text = ""; 
                    do 
                            /*A partir de aquí empieza el tablero del juego donde los jugadores van
                            a ir turnandose entre ellos para ir tirando el dado */

                    {

                        
                                    
                                    /*    
                                    display.append("\n¿Seguir jugando? (no para salir): ");
                                    respuesta = this.getUserInput();
                                    display.append(" "+ respuesta); 
                                    
                                    if (respuesta.equalsIgnoreCase("no")) {
                                        System.exit(0); 
                                        //break;
                                    }
                                    */


                                    /*En esta parte juega el jugador 1-------------------*/


                                    
                                    do{
                                        
                                        if(gp.confirmar == true){
                                            
                                            gp.confirmar = false; 
                                            gp.gameState = gp.playState; // Por esto el mensaje del dado dura tan poco, pero cuando esté terminado la parte Player2 no debería de ser un problema 
                                            
                                        }else {
                                            
                                            menuJugador(); 
                                        }
                                        
                                        //System.out.println(gp.gameState + "  " + gp.keyH.confirmar + " "+ gp.menuSelection);
                                        
                                        
                                        
                                        while(gp.confirmar == false){
                                            
                                            System.out.println(gp.menuSelection);
                                            
                                            //System.out.println(gp.gameState + "  " + gp.confirmar + " "+ gp.menuSelection);
                                            if(carcelJ1 == 0){
                                                

                                                switch(gp.menuSelection){
                                                    
                                                    case 1: {
                                                        
                                                        listarTablero(tablero);

                                                        System.out.println("\n==============Jugador 1=============");

                                              

                                                        int pasos = gp.dado;
                                                        System.out.println("\nEl dado mostró: " + pasos);

                                                        // Actualizar la posición del jugador en sentido horario
                                                        resetearJugador(tablero);

                                                        for (int i = 0; i < pasos; i++) {
                                                            if (x1 == 0 && y1 < 10) { // Va hacia la derecha

                                                                y1++;
                                                                if(tablero[x1][y1].equals(" S ")){
                                                                    System.out.println("\nvueltaaaaaaaa");
                                                                    t.vueltaCompletada(idJ1, jug1,1);
                                                                    ++vueltaJ1; 
                                                                }
                                                            } else if (y1 == 10 && x1 < 10) { // Baja
                                                                x1++;

                                                            } else if (x1 == 10 && y1 > 0) { // Va hacia la izquierda
                                                                y1--;

                                                            } else if (y1 == 0 && x1 > 0) { // Sube
                                                                x1--;
                                                                if(tablero[x1][y1].equals(" S ")){
                                                                    System.out.println("\nvueltaaaaaaaa");
                                                                    t.vueltaCompletada(idJ1, jug1,1);
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
                                                        //posJ2.obtenerPosActual(idJ2, x2, y2);


                                                        //Prueba sobre la posición del jugador2 en el tablero de jugador1 
                                                        tablero[posJ2.obtenerX()][posJ2.obtenerY()] = " 2 "; 

                                                        listarTablero(tablero);


                                                        /*!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/


                                                        /*En caso de que caiga en la carcel*/
                                                        if(tablero[0][10].equals(" 1 ")||tablero[10][0].equals(" 1 ")){
                                                            System.out.println("\nA la carcellll");
                                                            carcelJ1 = 2; 
                                                            PreparedStatement pt = getConnection().prepareStatement("UPDATE turno SET J_Turno = 1 WHERE J_Turno = 0; "); 
                                                            pt.executeUpdate(); 
                                                            break; 
                                                        }   


                                                        /*!!!!!!!!En caso de que caiga en una casilla comprable!!!!!!!!!!!!!!*/

                                                        Long id = cas.obtenerIdCasilla(x1, y1); 



                                                        if(id != null){
                                                            //gp.keyH.confirmar = true; 
                                                            Casilla casilla = cas.porId(id); 
                                                            t.actualizarSaldoJ1(id, jug1,4); // Actualizamos el dinero que tiene disponible 
                                                            System.out.println("\nDinero disponible -> "+ jug1.getJ1_Dinero());
                                                            System.out.println("\npropietario de la casilla" + casilla.getCAS_Propietario()+ " Disponibilidad "+casilla.isCAS_Disponibilidad() );

                                                            if(casilla.getCAS_Propietario() == null){
                                                                if(casilla.getCAS_Tipo().equals("Propiedad")){
                                                                    int valor = JOptionPane.showConfirmDialog(null, "\nQuiere comprar la propiedad "+ cas.porId(id)+ " [Y/N]","Advertencia", JOptionPane.YES_NO_OPTION );
                                                                   
                                                                    if(valor == JOptionPane.YES_OPTION){
                                                                        casilla.setCAS_Disponibilidad(1);
                                                                        t.CargarCasillaJ1(id, jug1); // Esta es la función que se encarga de cambiar el dinero del jugador 

                                                                    }
                                                                }else if(casilla.getCAS_Tipo().equals("Suerte")){
                                                                    t.suerte1(jug1); 
                                                                }
                                                            }else if(casilla.getCAS_Propietario().equals("jugador1")|| casilla.getCAS_Propietario().equals("jugador2") ){

                                                                t.actualizarSaldoJ1(id, jug1,1);

                                                            }

                                                        }
                                                        
                                                        //gp.keyH.confirmar = false; // Para que vuelva a saltar el menú de opciones 
                                                        //gp.menuSelection = 0; 
                                                        /*!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/
                                                        break; 
                                                    }

                                                    case 2: 
                                                            /*Vamos a mostrar las casillas que quedan disponibles sin 
                                                        propietario en el tablero*/
                                                    {
                                                        t.ActualizarCasillasDisponibles(); // Borra todas las casillas dentro del Array "casillasDisponibles"
                                                        cas.cargarCasillasCasilla(t);
                                                        System.out.println(t.casillasDisponibles().toString() + "\n");
                                                        System.out.println("\nPulsa 'Enter' para salir..."); 
                                                        
                                                        break; 
                                                    }


                                                    case 3: {
                                                        t.limiparCasillasJugador1();
                                                        System.out.println(t.addCasillasJugador1().toString()); 
                                                        System.out.println("\nPulsa 'Enter' para salir..."); 
                                                       
                                                        break; 
                                                    }


                                                    case 4: {
                                                        t.actualizarSaldoJ1(100L, jug1,4); //Este método respecto a conseguir el valor de nuestro jugador si funciona
                                                        System.out.println("\nDinero Actual -> "+ jug1.getJ1_Dinero());
                                                        System.out.println("\nPulsa 'Enter' para salir..."); 
                                                        
                                                        break; 
                                                    }


                                                    case 5: {
                                                        synchronized(cls){
                                                            while(true){
                                                                try{

                                                                    cls.wait();

                                                                }catch(InterruptedException e3){

                                                                }
                                                            }
                                                        }
                                                    }




                                                    case 6 : {
                                                        try {
                                                            // Esperar un tiempo antes de iniciar el segundo proyecto (opcional)
                                                            Thread.sleep(2000); 

                                                            // Ejecutar el segundo proyecto
                                                            Process proceso = Runtime.getRuntime().exec("java -jar G:/PrimerJuego2D/target/PrimerJuego2D-1.0-SNAPSHOT.jar");
                                                            proceso.waitFor(); // Espera a que el segundo proyecto termine antes de continuar
                                                        } catch (Exception e) {
                                                            e.printStackTrace();
                                                        }
                                                    }
                                                    
                                                    default: {
                                                        //System.out.println("Hola desde el default!"); 
                                                        break; 
                                                    }

                                                }
                                            }else {
                                                System.out.println("\nNo puede hacer nada, está en la carcel!!!");
                                                carcelJ1--; 
                                                /*  (En caso de que vuelva a dar error la carcel quitar el comentario de estas líneas)
                                                PreparedStatement pt = getConnection().prepareStatement("UPDATE turno SET J_Turno = 1 WHERE J_Turno = 0; "); 
                                                pt.executeUpdate(); 
                                                */
                                            }

                                        }
                                        ganador(jug1); 
                                        
                                        
                                        
                                        
                                        if(gp.menuSelection == 1){
                                            cls.setESTADO_DE_TURNO(1); 
                                            
                                            synchronized(cls){
                                                try{
                                                    PreparedStatement pt = getConnection().prepareStatement("UPDATE turno SET J_Turno = 1 WHERE J_Turno = 0; "); 
                                                    pt.executeUpdate(); 
                                                    System.out.println("Estado de turno -> " +cls.getESTADO_DE_TURNO());
                                                    
                                                    System.out.println("\nEsperando al jugador 2...");
                                                    cls.wait();  // Aquí se queda congelado el programa 
                                                    
                                                    gp.confirmar = false; 
                                                    gp.menuSelection = 0; 
                                                }catch(InterruptedException e4){

                                                }


                                            }
                                        }
                                        
                                        
                                        cls.setESTADO_DE_TURNO(0);
                                        
                                    }while(gp.menuSelection != 1); 
                                    
                                    //System.out.println("Fuera");
                               

                    } while (!respuesta.equalsIgnoreCase("no"));


                    System.exit(0); 
            
            
            
            
            
            
        }catch(SQLException e){
            
        }catch(InterruptedException e2){
            
        }catch(Exception e3){
            
        }
        
        
    }
  
    
    public  void menuJugador(){
        
        
        gp.gameState = gp.ingameState; 
        
        //String opcion; 
        /*
        
        System.out.println("\n [4] Mostrar dinero. ");
        System.out.println("\n [6] RENDIRSE. ");
        System.out.println("\n Elección -> ");
        opcion = this.getUserInput(); 
        
        //sc.close(); 
        return opcion; 
        */
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

    
    
    
    
    public void ganador(Jugador1 jug1) throws SQLException, Exception{
        String ganador = ""; 
        PreparedStatement pt = getConnection().prepareStatement("CALL ganador()"); 
        ResultSet rs = pt.executeQuery(); 
        if(rs.next()){
            ganador = rs.getString("resultado"); 
        }
        
        
        if(!(ganador.equals("Se Bugeo"))){
            System.out.println("\nEl ganador es "+ganador);
            pt.close(); 
            rs.close(); 
            System.exit(0); 
        }
        
    }
    
    
}
