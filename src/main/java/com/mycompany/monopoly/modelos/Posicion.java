/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monopoly.modelos;

/**
 *
 * @author pablo
 */
public abstract class Posicion {
    protected Long Pos_IdUser; 
    protected int Pos_PosI; 
    protected int Pos_PosJ ; 
    
    public Posicion(){}

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
    
    
}
