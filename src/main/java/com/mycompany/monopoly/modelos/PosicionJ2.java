/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monopoly.modelos;

/**
 *
 * @author pablo
 */
public class PosicionJ2 extends Posicion{
    
    public PosicionJ2(){}
    public PosicionJ2(Long id, int posi, int posj){
        this.Pos_IdUser = id; 
        this.Pos_PosI = posi; 
        this.Pos_PosJ = posj; 
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder(); 
        sb.append(" Posicion x: ").append(this.Pos_PosI).append(" Posición y: ").append(this.Pos_PosJ).append("\n"); 
        return sb.toString(); 
    }
}
