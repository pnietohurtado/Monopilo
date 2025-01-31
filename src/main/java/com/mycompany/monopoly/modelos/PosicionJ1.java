/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monopoly.modelos;

/**
 *
 * @author pablo
 */
public class PosicionJ1 {
    private Long Pos_IdUser; 
    private int Pos_PosI; 
    private int Pos_PosJ ; 
    
    public PosicionJ1(){}
    public PosicionJ1(Long id, int posi, int posj){
        this.Pos_IdUser = id; 
        this.Pos_PosI = posi; 
        this.Pos_PosJ = posj; 
    }

    public Long getPos_IdUser() {
        return Pos_IdUser;
    }

    public void setPos_IdUser(Long Pos_IdUser) {
        this.Pos_IdUser = Pos_IdUser;
    }

    public int getPos_PosI() {
        return Pos_PosI;
    }

    public void setPos_PosI(int Pos_PosI) {
        this.Pos_PosI = Pos_PosI;
    }

    public int getPos_PosJ() {
        return Pos_PosJ;
    }

    public void setPos_PosJ(int Pos_PosJ) {
        this.Pos_PosJ = Pos_PosJ;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder(); 
        sb.append(" Posicion x: ").append(this.Pos_PosI).append(" Posición y: ").append(this.Pos_PosJ).append("\n"); 
        return sb.toString(); 
    }
}
