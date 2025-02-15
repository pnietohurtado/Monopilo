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
public class Jugador2 
        /*Tener en cuenta que en esta clase cuando el juego comience, se van a borrar los datos de los 
        jugadores anteriores para poder comenzar una nueva partida*/
{
     private Long J2_Id; 
    private Long J2_IdUser; 
    private double J2_Dinero; 
    private Long J2_IdCasilla; 
    private UsuarioI user; 
    
    /*En este caso vamos a añadir la posición actual del jugador*/
    private int posI; 
    private int posJ; 
    
    //NO insert, SI select, Si funcionDelete (Inicio del programa), NO/SI update (según avance).  
    public Jugador2(){}
    
    public Jugador2(Long idUser,double dinero, Long casilla){
        this(); 
        this.J2_IdUser = idUser; 
        this.J2_Dinero = dinero; 
        this.J2_IdCasilla = casilla; 
    }
    public Jugador2(Long id, Long idUser, double dinero,Long casilla){
        this(idUser,dinero, casilla); 
        this.J2_Id = id; 
    }

    public Long getJ2_Id() {
        return J2_Id;
    }

    public void setJ2_Id(Long J2_Id) {
        this.J2_Id = J2_Id;
    }

    public Long getJ2_IdUser() {
        return J2_IdUser;
    }

    public void setJ2_IdUser(Long J1_IdUser) {
        this.J2_IdUser = J1_IdUser;
    }

    public Long getJ2_IdCasilla() {
        return J2_IdCasilla;
    }

    public void setJ2_IdCasilla(Long J1_IdCasilla) {
        this.J2_IdCasilla = J1_IdCasilla;
    }

    public double getJ2_Dinero() {
        return J2_Dinero;
    }

    public void setJ2_Dinero(double J2_Dinero) {
        this.J2_Dinero = J2_Dinero;
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
            UsuarioI u1 = u.porId(this.J2_IdUser);
            ICasillasRepositorio c = new CasillasRepositorio();
            StringBuilder sb = new StringBuilder();
            //La idea es que automáticamente se le pasen los valores del usuario en cuestión (Excepto la contraseña)
            sb.append(" Usuario -> ").append(u1.getUI_User()).append(" Casilla -> ").append(c.casillasPropietario(u1.getUI_User())).append(" Dinero -> ").append(this.J2_Dinero)
                    .append(" Posición i -> ").append(this.posI).append(" Posición j -> ").append(this.posJ)
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
