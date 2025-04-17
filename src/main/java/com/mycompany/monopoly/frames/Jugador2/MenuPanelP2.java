/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monopoly.frames.Jugador2;


import static com.mycompany.monopoly.Player1.listarTablero;
import com.mycompany.monopoly.conexionBBDD.Conexion;
import com.mycompany.monopoly.conexionBBDD.interfaces.ICasillasRepositorio;
import com.mycompany.monopoly.conexionBBDD.interfaces.IJugadoresRepositorio;
import com.mycompany.monopoly.conexionBBDD.interfaces.IPosicionRepositorio;
import com.mycompany.monopoly.conexionBBDD.interfaces.IUsuarioRepositorio;
import com.mycompany.monopoly.conexionBBDD.ropositorios.CasillasRepositorio;
import com.mycompany.monopoly.conexionBBDD.ropositorios.Jugador2Repositorio;
import com.mycompany.monopoly.conexionBBDD.ropositorios.PosicionJ1Repositorio;
import com.mycompany.monopoly.conexionBBDD.ropositorios.PosicionJ2Repositorio;
import com.mycompany.monopoly.conexionBBDD.ropositorios.UsuarioIRepositorio;
import com.mycompany.monopoly.frames.GamePanel;
import com.mycompany.monopoly.modelos.Casilla;
import com.mycompany.monopoly.modelos.Jugador2;
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
public class MenuPanelP2 extends JPanel implements Runnable 

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
        
        static IJugadoresRepositorio<Jugador2>  j2 = new Jugador2Repositorio(); 
        
        static ICasillasRepositorio cas = new CasillasRepositorio(); //Con esto vamos a añadir y actualizar las casillas disponibles
        
        
        static IPosicionRepositorio<PosicionJ1> posJ1 = new PosicionJ1Repositorio(); 
        static IPosicionRepositorio<PosicionJ2> posJ2 = new PosicionJ2Repositorio(); 
   
    
    
    
    
    
    
    /*Creo que la idea sería inicializar todos los contenidos de nuestro JPanel
    una vez que lo hemos inicializado podemos ajustar la información que va en cada uno de ellos
    ES DECIR, voy a tratar esta clase como una especie de lienzo para poder poner TODA la lógica 
    de el programa final. */
    
    private GamePanel gp; 
        
    // Contructor de la clase 
    public MenuPanelP2(GamePanel gp) 
    {
        this.gp = gp; 
                
        this.setPreferredSize(new Dimension(this.screenWidth, this.screenHeight)); 
        this.setBackground(Color.black); 
        this.setDoubleBuffered(true); 
        this.setFocusable(true); 
        this.setLayout(null); 
        
      
        
    }
  
    
    
    Thread comprobarP2; // Declaramos la comprobación de nuestro turno desde un Thread externo y lo declaramos a la vez con el menu
    ClaseComunP2 cls = new ClaseComunP2(); 
    ComprobarP2 comprueba = new ComprobarP2(cls); 
    
    public void startMenuThread()
    {
        menuThread = new Thread(this); 
        comprobarP2 = new Thread(comprueba); 
        menuThread.start(); 
        comprobarP2.start(); 
    }
    


    @Override
    public void run() {
        
        try{
          

                                /*!!!!!!!!!!!!    REGISTRO DE USUARIO   !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/
                     /*
                   

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

                     usuarios.insertar(new Usuario(nombre2, apellido2, user2, pass3));
                     */
                     /*****************************************************************/



                     /*!!!!!!!!!!!!!!!!!!!    INICIO DE SESIÓN DE LOS DOS JUGADORES    !!!!!!!!!!!!!!!!!!!!!!!*/


                    

                     /*Se llama a la BBDD para iniciar sesión con los dos jugadores*/


                     //u.inicioSesion(name2, contra2, 2);


                     
                     /**************************************************************************/

                     //En base a "usuario1 y usuario2" vamos a obtener los id necesarios para poder 
                     //realizar las cuatro consultas básicas de nuestro servidor. 

                        //Esta un poco más abajo donde instanciamos el "Tablero" 


                     /**************************************************************************/



                     /*!!!!!!!!!!!!!!!!!!!!    ASIGNANDO LOS JUGADORES CON SUS PERFILES !!!!!!!!!!!!!!!!!!!!!!!!*/
                     gp.confirmar = false; 

                     UsuarioI u2 = u.porUser(gp.playerName); 

                     Long idJ2 = u2.getUI_Id(); 
                     //System.out.println("id "+ idJ1);


                     Jugador2 jug2 = j2.porId(idJ2); // por "idJ1 y idJ2" para poder tener los datos de los jugadores en físico

                     /****************************************************************************/

                     
                     Tablero t = new Tablero( null, jug2); 
                     
                     t.inicioPartida(u2.getUI_Id(),2); //Borra todos los datos de la partida anterior
                     



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
                    String respuesta = "";

                    int vueltaJ2 = 0; // jugador 1 y jugador 2





                    /*Cargar las casillas disponibles*/
                    cas.cargarCasillasCasilla(t);




                    int carcelJ2 = 0; 
                    
                    do 
                            /*A partir de aquí empieza el tablero del juego donde los jugadores van
                            a ir turnandose entre ellos para ir tirando el dado */

                    {

                        
                            
                            synchronized(cls){
                                try{
                            
                                    System.out.println("\nEsperando al jugador1...");
                                    cls.setESTADO_DE_TURNO(0);
                                    cls.wait(); 
                                    gp.confirmar = false; 
                                    gp.menuSelection = 0; 
                                }catch(InterruptedException e4){
                                                
                                }
                                            
                                            
                            }
                        cls.setESTADO_DE_TURNO(1);
                        /*
                        display.setText(""); 
                        display.append("\n======================");
                        display.append("\n¿Seguir jugando? (no para salir): ");
                        respuesta = this.getUserInput();
                        display.append(" "+respuesta); 
                        
                        if (respuesta.equalsIgnoreCase("no")) {
                            break;
                        }
                        */


                        // Para controlar el menú del jugador vamos a hacer lo siguiente 
                        
                        if(gp.confirmar == true){
                            gp.confirmar = false; 
                            gp.gameState = gp.playState; 
                        }else {
                            menuJugador(); 
                        }




                        /*=====================================================================*/
                        /*=====================================================================*/
                        /*A partir de aquí juega el jugador 2 ---------------------------------*/
                        /*=====================================================================*/
                        /*=====================================================================*/


                        
                        
                        System.out.println("\n==============Jugador 2==================");


                        System.out.println("\nTira el dado...");
                        int pasos2 = dado();
                        System.out.println("\nEl dado mostró: " + pasos2);

                        // Actualizar la posición del jugador en sentido de las agujas del reloj 

                        
                        
                        do{
                            
                            
                            System.out.println("\n==============Jugador 2==================");
                            
                            while(gp.confirmar == false){
                                if(carcelJ2 == 0){
                                    switch(gp.menuSelection){

                                        case 1: {

                                            pasos2 = gp.dado; 

                                            for (int i = 0; i < pasos2; i++) {
                                                if (x2 == 0 && y2 < 10) { // Va hacia la derecha
                                                    y2++;
                                                    if(tablero[x2][y2].equals(" S ")){
                                                        System.out.println("\nvueltaaaaaaaa");
                                                        t.vueltaCompletada(idJ2, jug2,2);

                                                        ++vueltaJ2; 
                                                    }
                                                } else if (y2 == 10 && x2 < 10) { // Baja
                                                    x2++;
                                                } else if (x2 == 10 && y2 > 0) { // Va hacia la izquierda
                                                    y2--;
                                                } else if (y2 == 0 && x2 > 0) { // Sube
                                                    x2--;
                                                    if(tablero[x2][y2].equals(" S ")){
                                                        System.out.println("\nvueltaaaaaaaa");
                                                        t.vueltaCompletada(idJ2, jug2,2);
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


                                            tablero[posJ1.obtenerX()][posJ1.obtenerY()] = " 1 "; 

                                            listarTablero(tablero);


                                            System.out.println("\nPosicion J2 "+posJ2.obtenerX() + " "+posJ2.obtenerY());
                                            System.out.println("\nPosicion J1 "+posJ1.obtenerX() + " "+posJ1.obtenerY());


                                            /*!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/


                                            /*En caso de que caiga en la carcel*/
                                            if(tablero[0][10].equals(" 2 ")||tablero[10][0].equals(" 2 ")){

                                                System.out.println("\nEntra a la carcel...");
                                                carcelJ2 = 2; 
                                                PreparedStatement pt = getConnection().prepareStatement("UPDATE turno SET J_Turno = 0 WHERE J_Turno = 1; "); 
                                                pt.executeUpdate(); 

                                                break; 
                                            }

                                            /*!!!!!!!!En caso de que caiga en una casilla comprable!!!!!!!!!!!!!!*/

                                            Long id2 = cas.obtenerIdCasilla(x2, y2); 
                                            System.out.println("\nid "+id2);
                                            //System.out.println("jug1 "+ jug1);
                                            if(id2 != null){
                                                Casilla casilla = cas.porId(id2); 
                                                t.actualizarSaldoJ2(id2, jug2,4);
                                                System.out.println("\nDinero disponible -> "+ jug2.getJ2_Dinero());


                                                if(casilla.getCAS_Propietario() == null){
                                                    if(casilla.getCAS_Tipo().equals("Propiedad")){
                                                        int valor = JOptionPane.showConfirmDialog(null, "\nQuiere comprar la propiedad "+ cas.porId(id2)+ " [Y/N]","Advertencia", JOptionPane.YES_NO_OPTION );


                                                        if(valor == JOptionPane.YES_OPTION){
                                                            casilla.setCAS_Disponibilidad(1);
                                                            t.CargarCasillaJ2(id2, jug2); // Esta es la función que se encarga de cambiar el dinero del jugador 

                                                        }
                                                    }else if(casilla.getCAS_Tipo().equals("Suerte")){
                                                        t.suerte2(jug2); 
                                                    }
                                                }else if(casilla.getCAS_Propietario().equals("jugador1")|| casilla.getCAS_Propietario().equals("jugador2")){
                                                    //System.out.println("dentro de comprobacion");
                                                    t.actualizarSaldoJ2(id2, jug2,1);

                                                }
                                                //System.out.println("Cuanto dinero le queda"+ jug1.getJ1_Dinero());
                                            }

                                            break; //Muy necesario ya que si no salta al siguiente "case" 
                                        }

                                        case 2: 
                                                /*Se encarga de mostrar las casillas que quedan disponibles para comprar
                                            para los dos jugadores, es decir, aquellas que no tienen dueño aún.*/
                                        {
                                            t.ActualizarCasillasDisponibles();
                                            cas.cargarCasillasCasilla(t);
                                            System.out.println(t.casillasDisponibles().toString() + "\n");


                                            break; 
                                        }

                                        case 3: {
                                            t.limiparCasillasJugador2();
                                            System.out.println(t.addCasillasJugador2().toString()); 

                                            break; 
                                        }

                                        case 4: {
                                            t.actualizarSaldoJ2(100L, jug2,4);
                                            System.out.println("\nDinero Actual -> "+ jug2.getJ2_Dinero());

                                            break; 
                                        }

                                        

                                        case 6 : {
                                            System.exit(0); 
                                        }

                                    }
                                }else{

                                    System.out.println("\nNo puede hacer nada, está en la carcel!!!!!!!!!");
                                    carcelJ2--; 
                                    /*
                                    PreparedStatement pt = getConnection().prepareStatement("UPDATE turno SET J_Turno = 0 WHERE J_Turno = 1; "); 
                                    pt.executeUpdate(); 
                                    */
                                }
                            
                           
                            }
                            ganador(jug2); 
                        
                            if(gp.menuSelection == 1){
                                PreparedStatement pt = getConnection().prepareStatement("UPDATE turno SET J_Turno = 0 WHERE J_Turno = 1; "); 
                                pt.executeUpdate(); 
                            }
                            
                        }while(gp.menuSelection != 1) ; 
                          
                        
                        
                    } while (!respuesta.equalsIgnoreCase("no"));



                    System.exit(0); 
            
            
            
            
            
            
        }catch(SQLException e){
            
        }catch(InterruptedException e2){
            
        }catch(Exception e3){
            
        }
        
        
    }
    
    
    /*Funciones del player1*/
    
    public  void menuJugador(){
        
        gp.gameState = gp.ingameState; 
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
    
    
    
    public static void ganador( Jugador2 jug2) throws SQLException, Exception{
        String ganador = ""; 
        PreparedStatement pt = getConnection().prepareStatement("CALL ganador()"); 
        ResultSet rs = pt.executeQuery(); 
        if(rs.next()){
            ganador = rs.getString("resultado"); 
        }
        
        
        if(!(ganador.equals("Se Bugeo"))){
            System.exit(0); 
            System.out.println("El ganador es "+ganador);
            pt.close(); 
            rs.close(); 
        }
    }
    
    
}
