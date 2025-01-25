/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monopoly.modelos;

/**
 *
 * @author pablo
 */
public class UsuarioI {
    
    private Long UI_Id; 
    private Long UI_IdUr; 
    private String UI_User; 
    private String UI_Pass; 
    
    public UsuarioI(){}
    
    public UsuarioI(Long idui, String user, String pass){
        this(); 
        this.UI_IdUr = idui; 
        this.UI_User = user; 
        this.UI_Pass = pass; 
    }
    
    public UsuarioI(Long id, Long idui, String user, String pass){
        this(idui,  user, pass); 
        this.UI_Id = id; 
    }

    public Long getUI_Id() {
        return UI_Id;
    }

    public void setUI_Id(Long UI_Id) {
        this.UI_Id = UI_Id;
    }

    public Long getUI_IdUr() {
        return UI_IdUr;
    }

    public void setUI_IdUr(Long UI_IdUr) {
        this.UI_IdUr = UI_IdUr;
    }

    public String getUI_User() {
        return UI_User;
    }

    public void setUI_User(String UI_User) {
        this.UI_User = UI_User;
    }

    public String getUI_Pass() {
        return UI_Pass;
    }

    public void setUI_Pass(String UI_Pass) {
        this.UI_Pass = UI_Pass;
    }
    
    @Override 
    public String toString(){
        StringBuilder sb = new StringBuilder(); 
        sb.append("Id del inicio de sesión -> ").append(this.UI_Id).append(" Id del registro usuario -> ").append(this.UI_IdUr)
                .append(" Usuario -> ").append(this.UI_User).append("\n"); 
        return sb.toString(); 
    }
}
