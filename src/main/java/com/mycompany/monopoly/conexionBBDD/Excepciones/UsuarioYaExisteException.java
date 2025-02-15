/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monopoly.conexionBBDD.Excepciones;

/**
 *
 * @author pablo
 */
public class UsuarioYaExisteException extends RuntimeException{
    public UsuarioYaExisteException(String message) {
        super(message);
    }
    
}
