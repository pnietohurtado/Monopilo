package com.mycompany.monopoly.modelos;

import com.mycompany.monopoly.conexionBBDD.interfaces.IUsuarioIRepositorio;
import com.mycompany.monopoly.conexionBBDD.ropositorios.UsuarioIRepositorio;
import java.sql.SQLException;

/**
 *
 * @author pablo
 */
public class Jugador2 {
     private Long J2_Id; 
    private Long J2_IdUser; 
    private Long J2_IdCasilla; 
    private UsuarioI user; 
    
    //NO insert, SI select, Si funcionDelete (Inicio del programa), NO/SI update (según avance).  
    
    public Jugador2(Long idUser, Long casilla){
        this.J2_IdUser = idUser; 
        this.J2_IdCasilla = casilla; 
    }
    public Jugador2(Long id, Long idUser, Long casilla){
        this(idUser, casilla); 
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
    
    @Override
    public String toString() {
        try{
            IUsuarioIRepositorio u = new UsuarioIRepositorio(); 
            UsuarioI u1 = u.porId(this.J2_IdUser); 
            StringBuilder sb = new StringBuilder(); 
            //La idea es que automáticamente se le pasen los valores del usuario en cuestión (Excepto la contraseña) 
            sb.append(" Usuario -> ").append(u1.getUI_User()).append(" Casilla -> ").append(this.J2_IdCasilla).append("\n"); 
            return sb.toString(); 
        }catch(SQLException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        return null; 
    }
}
