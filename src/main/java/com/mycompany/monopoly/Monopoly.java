/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.monopoly;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author pablo
 */
public class Monopoly {

    public static void main(String[] args)throws SQLException {
        String url = "jdbc:mysql://database.c1qy2c4wwbk2.eu-north-1.rds.amazonaws.com:3306/bibliasql?serverTimezone=UTC"; 
        String user = "default"; 
        String pass = ""; 
        
        Connection con = DriverManager.getConnection(url,user,pass);
        
        
        
    }
}
