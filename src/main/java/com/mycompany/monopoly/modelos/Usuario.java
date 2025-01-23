package com.mycompany.monopoly.modelos;

/**
 *
 * @author pablo
 */
public class Usuario {
    private Long UR_Id; 
    private String UR_Nombre; 
    private String UR_Apellido; 
    private String UR_User; 
    private String UR_Pass; 
    
    public Usuario(){}
    
    public Usuario(String nombre, String apellido, String user , String pass){
        this(); 
        this.UR_Nombre = nombre; 
        this.UR_Apellido = apellido; 
        this.UR_User = user; 
        this.UR_Pass = pass; 
    }
    
    public Usuario(Long id, String nombre, String apellido, String user , String pass){
        this(nombre, apellido, user, pass); 
        this.UR_Id = id; 
    }

    public Long getUR_Id() {
        return UR_Id;
    }

    public void setUR_Id(Long UR_Id) {
        this.UR_Id = UR_Id;
    }

    public String getUR_Nombre() {
        return UR_Nombre;
    }

    public void setUR_Nombre(String UR_Nombre) {
        this.UR_Nombre = UR_Nombre;
    }

    public String getUR_Apellido() {
        return UR_Apellido;
    }

    public void setUR_Apellido(String UR_Apellido) {
        this.UR_Apellido = UR_Apellido;
    }

    public String getUR_User() {
        return UR_User;
    }

    public void setUR_User(String UR_User) {
        this.UR_User = UR_User;
    }

    public String getUR_Pass() {
        return UR_Pass;
    }

    public void setUR_Pass(String UR_Pass) {
        this.UR_Pass = UR_Pass;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder(); 
        sb.append(" ID Usuario -> ").append(this.UR_Id).append(" Nombre Usuario -> ").append(this.UR_Nombre)
                .append(" Apellido Usuario -> ").append(this.UR_Apellido).append(" User Usuario -> ").append(this.UR_User)
                .append("\n"); 
        return sb.toString(); 
    }
}
