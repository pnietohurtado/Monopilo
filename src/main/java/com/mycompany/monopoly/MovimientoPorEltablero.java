/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monopoly;

import java.util.Scanner;

/**
 *
 * @author pablo
 */
public class MovimientoPorEltablero {
    
    public static void listarTablero(String[][] tablero){
        for(int i = 0; i < tablero.length ; i++){
            for(int j = 0 ; j< tablero[0].length ; j++){
                System.out.print(tablero[i][j]);
            }
            System.out.println("");
        }
    }
    
    public static void resetearJugador(String[][] tablero){
        for(int i = 0; i < tablero.length ; i++){
            for(int j = 0 ; j< tablero[0].length ; j++){
                if(tablero[i][j].equals(" 1 ")){
                    tablero[i][j] = " x "; 
                    break; 
                }
            }
        }
    }
    public static void resetearJugador2(String[][] tablero){
        for(int i = 0; i < tablero.length ; i++){
            for(int j = 0 ; j< tablero[0].length ; j++){
                if(tablero[i][j].equals(" 2 ")){
                    tablero[i][j] = " x "; 
                    break; 
                }
            }
        }
    }
    
    public static int dado(){
        return (int)(Math.random() * 7); 
    }
    
    public static void main(String[] args) {
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
        
        
        tablero[0][0] = " 1 ";  //Jugador 1
        tablero[0][0] = " 2 "; 
        
        listarTablero(tablero); 
        
        resetearJugador2(tablero);
        tablero[0][dado()] = " 2 ";
        resetearJugador(tablero);
        tablero[0][dado()] = " 1 "; 
        
        for(int i = 0; i < tablero.length ; i++){
            for(int j = 0 ; j< tablero[0].length ; j++){
             
                if(tablero[i][j].equals(" 1 ")){
                    continue; 
                }else {
                    tablero[i][j] = tableroPlantilla[i][j]; 
                }
                
            }
        }
        
        listarTablero(tablero); 
        
        
        
        
    }
}
