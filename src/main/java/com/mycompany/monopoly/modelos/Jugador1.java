/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monopoly.modelos;

import com.mycompany.monopoly.conexionBBDD.interfaces.ICasillasRepositorio;
import com.mycompany.monopoly.conexionBBDD.interfaces.IUsuarioIRepositorio;
import com.mycompany.monopoly.conexionBBDD.ropositorios.CasillasRepositorio;
import com.mycompany.monopoly.conexionBBDD.ropositorios.UsuarioIRepositorio;
import java.sql.SQLException;


/**
 *
 * @author pablo
 */
public class Jugador1 {
    private Long J1_Id; 
    private Long J1_IdUser; 
    private double J1_Dinero; 
    private Long J1_IdCasilla; 
    private UsuarioI user; 
    
    /*En este caso vamos a añadir la posición actual del jugador*/
    private int posI; 
    private int posJ; 
    
    //NO insert, SI select, Si funcionDelete (Inicio del programa), NO/SI update (según avance).  
    
    public Jugador1(){}
    
    public Jugador1(Long idUser,double dinero, Long casilla){
        this(); 
        this.J1_IdUser = idUser; 
        this.J1_Dinero = dinero; 
        this.J1_IdCasilla = casilla; 
    }
    public Jugador1(Long id, Long idUser,double dinero, Long casilla){
        this(idUser, dinero, casilla); 
        this.J1_Id = id; 
    }

    public Long getJ1_Id() {
        return J1_Id;
    }

    public void setJ1_Id(Long J1_Id) {
        this.J1_Id = J1_Id;
    }

    public Long getJ1_IdUser() {
        return J1_IdUser;
    }

    public void setJ1_IdUser(Long J1_IdUser) {
        this.J1_IdUser = J1_IdUser;
    }

    public Long getJ1_IdCasilla() {
        return J1_IdCasilla;
    }

    public void setJ1_IdCasilla(Long J1_IdCasilla) {
        this.J1_IdCasilla = J1_IdCasilla;
    }

    public double getJ1_Dinero() {
        return J1_Dinero;
    }

    public void setJ1_Dinero(double J1_Dinero) {
        this.J1_Dinero = J1_Dinero;
    }
    
    
    
    
    
    public int getPosI() {
        return posI; 
    }

    public void setPosI(int posI) {
        this.posI = posI;
    }

    public int getPosJ() {
        return posJ;
    }

    /*Hacemos un setter y un getter de la posición del usuario */
    public void setPosJ(int posJ) {
        this.posJ = posJ;
    }
    
    @Override
    public String toString() {
        try{
            IUsuarioIRepositorio u = new UsuarioIRepositorio(); 
            UsuarioI u1 = u.porId(this.J1_IdUser); 
            ICasillasRepositorio c = new CasillasRepositorio(); 
            StringBuilder sb = new StringBuilder(); 
            //La idea es que automáticamente se le pasen los valores del usuario en cuestión (Excepto la contraseña) 
            sb.append(" Usuario -> ").append(u1.getUI_User()).append(" Casilla -> ").append(c.casillasPropietario(u1.getUI_User())).append(" Dinero -> ").append(this.J1_Dinero).append(" Posición i -> ").append(this.posI).append(" Posición j -> ").append(this.posJ)
                    .append("\n"); 
            return sb.toString(); 
        }catch(SQLException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        return null; 
    }
    
}
