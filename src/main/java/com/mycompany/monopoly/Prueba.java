/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monopoly;

import static com.mycompany.monopoly.VersionFinal.dado;
import static com.mycompany.monopoly.VersionFinal.listarTablero;
import com.mycompany.monopoly.conexionBBDD.interfaces.IJugadoresRepositorio;
import com.mycompany.monopoly.conexionBBDD.ropositorios.Jugador1Repositorio;
import com.mycompany.monopoly.modelos.Jugador1;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author pablo
 */
public class Prueba {
    
    public static void resetearJugador(String[][] tablero){
        for(int i = 0; i < tablero.length ; i++){
            for(int j = 0 ; j< tablero[0].length ; j++){
                if(tablero[i][j].equals(" 1 ")){
                    tablero[i][j] = " @ "; 
                    break; 
                }
            }
        }
    }
    
    public static int dado(){
        return (int)(Math.random() * 6) + 1;
    }
    
    public static void listarTablero(String[][] tablero){
        for(int i = 0; i < tablero.length ; i++){
            for(int j = 0 ; j< tablero[0].length ; j++){
                System.out.print(tablero[i][j]);
            }
            System.out.println("");
        }
    }
    
    public static void main(String[] args)throws SQLException, Exception {
        
        IJugadoresRepositorio<Jugador1> j1 = new Jugador1Repositorio(); 
        System.out.println(j1.getSaldo()); //Prueba para poder obtener el saldo del jugador en cada momento
        
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
        
        
        String tablero[][] = new String[11][11]; 
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
        
        String respuesta =""; 
        
        int x1 = 0; 
        int y1 = 0; 
        
        int yC = y1; 
        
        tablero[x1][y1] = " 1 ";
        Scanner sc = new Scanner(System.in); 
        do{
            yC = y1;
            System.out.println("======================");
            System.out.print("Seguir jugando : ");
            respuesta = sc.nextLine(); 
            
        
            listarTablero(tablero); // !!!!!!!!!!!!!!PRIMER LISTADO DEL TABLERO ACTUAL 
           
            System.out.println("Tira el dado primero "); //Empieza el jugador 1
            
            resetearJugador(tablero); 
            int dado = dado();
            System.out.println("dado "+ dado);
            try{
                if(x1 != 0){
                    dado  = dado - (10 - x1); 
                }
               System.out.println("1"); // x1 : 0 y1 : 9 dado 3      x1 : 0 y1 : 10 dado 2
                if(!(tablero[x1][y1+ dado].equals("   ")) && x1 == 0 ){
                    tablero[x1][y1 + dado] = " 1 "; 
                    y1 += dado; 
                }else{
                    throw new ArrayIndexOutOfBoundsException();
                }
            }catch(ArrayIndexOutOfBoundsException e){
                try{
                    
                    dado = dado -(10 - y1); // dado 2   3-(10-9) 2
                    if(x1 != 10){
                        y1 = 10; 
                    }
                    
                    System.out.println("2");
                    if(!(tablero[x1 + dado][y1].equals("   ")) && y1 == 10 ){
                        System.out.println("dentro");
                        tablero[x1 + dado][10] = " 1 "; //3 10
                        x1 += dado; 
                    }else{
                        throw new ArrayIndexOutOfBoundsException(); 
                    } 
                }catch(ArrayIndexOutOfBoundsException e2){
                    try{
                        dado = dado -(10 - x1); // x1 : 10 y1: 4 dado 7        dado: 3 x1: 10  y1: 9       1   1-(10 - 10)     
                        if(dado <0 ){
                            dado = -(dado); 
                        }
                        //System.out.println("dado "+dado+ " x1 "+x1);
                        if(y1 <= 10){
                            x1 = 10;
                        }
                         
                        //System.out.println("dado "+dado+ " x1 "+x1+" 3");
                        if(!(tablero[x1][y1-dado].equals("   ")) && x1 == 10){
                          //  System.out.println("antes "+ y1);//10
                            tablero[x1][y1 - dado] = " 1 "; 
                          // System.out.println("despues "+ y1);//10
                            //y1 = yC - dado;
                            y1 -= dado; 
                            //y1 = 9 - 1       8      y1 = 8 - 2    6
                            //System.out.println("after "+ y1);//9
                        }else{
                               throw new ArrayIndexOutOfBoundsException(); 
                        } 
                    }catch(ArrayIndexOutOfBoundsException e3){
                        try{
                        dado = dado();
                        dado = dado -(10 - x1); // dado -3
                        if(dado <0 ){
                            dado = -(dado); 
                        }
                            System.out.println(" x1 "+x1+ " dado "+ dado);
                        if(x1 < 11){
                            y1 = 0;
                        }
                        System.out.println("4 dado "+dado + " x1 "+ x1);
                        if(!(tablero[x1- dado][y1].equals("   ")) && y1 == 0){
                            tablero[x1 - dado][y1] = " 1 "; 
                            x1 -= dado; 
                        }else{
                                   throw new ArrayIndexOutOfBoundsException(); 
                        } 
                        }catch(ArrayIndexOutOfBoundsException e5){
                            
                        }
                        
                    }
                }
            }
            for(int i = 0; i < tablero.length ; i++){
                for(int j = 0 ; j< tablero[0].length ; j++){
             
                    if(tablero[i][j].equals(" 1 ") ||tablero[i][j].equals(" 2 ")){
                        continue; 
                    }else {
                        tablero[i][j] = tableroPlantilla[i][j]; 
                    }
                
                }
            }
          
        
            listarTablero(tablero); 
            System.out.println("x "+ x1);
            System.out.println("y "+ y1);
            System.out.println("valor yC "+yC);
            
            
        }while(!(respuesta.equals("no"))); 
        
    }
    
}
