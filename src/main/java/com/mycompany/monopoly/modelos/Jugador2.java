package com.mycompany.monopoly.modelos;

import com.mycompany.monopoly.conexionBBDD.interfaces.ICasillasRepositorio;
import com.mycompany.monopoly.conexionBBDD.interfaces.IUsuarioRepositorio;
import com.mycompany.monopoly.conexionBBDD.ropositorios.CasillasRepositorio;
import com.mycompany.monopoly.conexionBBDD.ropositorios.UsuarioIRepositorio;
import java.sql.SQLException;

/**
 *
 * @author pablo
 */
public class Jugador2 extends Jugadores
        /*Tener en cuenta que en esta clase cuando el juego comience, se van a borrar los datos de los 
        jugadores anteriores para poder comenzar una nueva partida*/
{
    
    /*En este caso vamos a añadir la posición actual del jugador*/
    private int posI; 
    private int posJ; 
    
    //NO insert, SI select, Si funcionDelete (Inicio del programa), NO/SI update (según avance).  
    public Jugador2(){super();}
    
    public Jugador2(Long idUser,double dinero, Long casilla){
        this(); 
        J_IdUser = idUser; 
        J_Dinero = dinero; 
        J_IdCasilla = casilla; 
    }
    public Jugador2(Long id, Long idUser, double dinero,Long casilla){
        this(idUser,dinero, casilla); 
        J_Id = id; 
    }

    public Long getJ2_Id() {
        return J_Id;
    }

    public void setJ2_Id(Long J2_Id) {
        J_Id = J2_Id;
    }

    public Long getJ2_IdUser() {
        return J_IdUser;
    }

    public void setJ2_IdUser(Long J1_IdUser) {
        J_IdUser = J1_IdUser;
    }

    public Long getJ2_IdCasilla() {
        return J_IdCasilla;
    }

    public void setJ2_IdCasilla(Long J1_IdCasilla) {
        J_IdCasilla = J1_IdCasilla;
    }

    public double getJ2_Dinero() {
        return J_Dinero;
    }

    public void setJ2_Dinero(double J2_Dinero) {
        this.J_Dinero = J2_Dinero;
    }
    
    

    
    /***********************************************************************/
    public int getPosI() {
        return posI; 
    }

    public void setPosI(int posI) {
        this.posI = posI;
    }

    public int getPosJ() {
        return posJ;
    }

    /***********************************************************************/
    
    
    /*Hacemos un setter y un getter de la posición del usuario */
    public void setPosJ(int posJ) {
        this.posJ = posJ;
    }

    /***********************************************************************/
    @Override
    public String toString() {
        try{
            IUsuarioRepositorio<UsuarioI> u = new UsuarioIRepositorio();
            UsuarioI u1 = u.porId(this.J_IdUser);
            ICasillasRepositorio c = new CasillasRepositorio();
            StringBuilder sb = new StringBuilder();
            //La idea es que automáticamente se le pasen los valores del usuario en cuestión (Excepto la contraseña)
            sb.append(" Usuario -> ").append(u1.getUI_User()).append(" Casilla -> ").append(c.casillasPropietario(u1.getUI_User())).append(" Dinero -> ").append(this.J_Dinero)
                    .append(" Posición i -> ").append(this.posI).append(" Posición j -> ").append(this.posJ)
                    .append("\n");
            return sb.toString(); 
        }catch(SQLException e){
        }catch(Exception e){
        }
        return null; 
    }
}
