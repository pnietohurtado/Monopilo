/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monopoly.conexionBBDD;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author pablo
 */
public class Conexion {
    private static String url ="jdbc:mysql://database.c1qy2c4wwbk2.eu-north-1.rds.amazonaws.com:3306/monopoly?serverTimezone=UTC" ; 
    private static String pass; //Contraseña de conexion a la BBDD
    private static String key; //Clave para poder desencriptar la contraseña de los datos del usuarios para la BBDD
    private static String user = "root"; 
    private static Connection con; 
    
    public static Connection getConnection()throws SQLException{
        if(con == null){
            try{
                leer("Encriptado.txt"); 
                String clave = desencriptar(pass,key); 
                con = DriverManager.getConnection(url,user,clave ); 
                
                
            }catch(Exception e){}
        }
        return con; 
    }
    
    private static String encriptar(String pass, String key) throws Exception{
        SecretKeySpec sk = new SecretKeySpec(key.getBytes(), "AES"); /*Lo primero que me pide 
        es la cantidad de bytes de la contraseña para encriptar y el tipo de encriptación*/
        Cipher cp = Cipher.getInstance("AES"); 
        cp.init(Cipher.ENCRYPT_MODE, sk); /*En este apartado estamos usando la clase de encriptación de datos 
        "Cipher" para luego llamarla y nos pide que estamos haciendo si "Encriptar o Desencriptar" y el segundo
        parámetro es el "SecretKeySpec" con la contraseña (de acceso, es decir, "key") ya cifrada. */
        byte[] bytesEncriptados = cp.doFinal(pass.getBytes()); /*En este caso cogemos los valores de los bytes 
        de la contraseña a la base de datos para poder */
        return Base64.getEncoder().encodeToString(bytesEncriptados); 
    }
    
    public static String desencriptar(String pass, String key) throws Exception{
        SecretKeySpec sks = new SecretKeySpec(key.getBytes(), "AES"); 
        Cipher cp = Cipher.getInstance("AES"); 
        cp.init(Cipher.DECRYPT_MODE, sks);
        byte[] decodificar = Base64.getDecoder().decode(pass); 
        byte[] original = cp.doFinal(decodificar); 
        return new String(original); 
    }
    
    public static String leer(String url)throws IOException, Exception{
        BufferedReader file = new BufferedReader(new FileReader("Encriptado.txt")); 
        String linea; 
        while((linea = file.readLine()) != null){
            String partes[] = linea.split(" "); 
            String contra = partes[0]; 
            String llave = partes[1]; 
            
            key = llave; 
            pass = encriptar(contra, key); 
        }
        return pass; 
    }
    
    public static void main(String[] args) throws Exception {
        try{
           
            System.out.println(leer("Encriptado.txt"));
        }catch(IOException e){}
    }



}   

