package com.mycompany.monopoly.conexionBBDD.ropositorios;

import com.mycompany.monopoly.conexionBBDD.Conexion;
import com.mycompany.monopoly.conexionBBDD.Excepciones.UsuarioNoEncontrado;
import com.mycompany.monopoly.conexionBBDD.Excepciones.UsuarioYaExisteException;
import com.mycompany.monopoly.conexionBBDD.interfaces.IUsuarioRepositorio;
import com.mycompany.monopoly.modelos.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pablo
 */
public class UsuarioRepositorio implements IUsuarioRepositorio<Usuario>{
    public Connection getConnection()throws SQLException{
        return Conexion.getConnection(); 
    }
    
    private static Usuario getUsuario(ResultSet rs) throws SQLException{
        Usuario u = new Usuario(); 
        u.setUR_Id(rs.getLong("UR_Id"));
        u.setUR_Nombre(rs.getString("UR_Nombre")); 
        u.setUR_Apellido(rs.getString("UR_Apellidos")); 
        u.setUR_User(rs.getString("UR_User")); 
        u.setUR_Pass(rs.getString("UR_Pass")); 
        return u; 
    }

    @Override
    public List<Usuario> listar() throws SQLException, Exception {
        List<Usuario> usuarios = new ArrayList<>(); 
        String sql = "select * from usuarioR"; 
        PreparedStatement pt = getConnection().prepareStatement(sql); 
        ResultSet rs = pt.executeQuery(); 
        while(rs.next()){
            Usuario u = getUsuario(rs); 
            usuarios.add(u); 
        }
        return usuarios; 
    }

    @Override
    public Usuario porId(Long id) throws SQLException, Exception {
        Usuario u = null; 
        String sql = "select * from usuarioR where UR_Id = ?"; 
        PreparedStatement pt = getConnection().prepareStatement(sql); 
        pt.setLong(1, id);
        ResultSet rs = pt.executeQuery(); 
        while(rs.next()){
            u = getUsuario(rs); 
        }
        return u; 
    }
    int i = 0; 
    @Override
    public Usuario porUser(String user) throws SQLException, Exception {
        Usuario u = null; 
        String  sql = "select * from usuarioR where UR_User = ?"; 
        PreparedStatement pt = getConnection().prepareStatement(sql); 
        pt.setString(1, user);
        ResultSet rs = pt.executeQuery(); 
        while(rs.next()){
            i++;
            u = getUsuario(rs); 
        }
        return u; 
    }


    public void insertar(Usuario u) throws UsuarioYaExisteException,SQLException,Exception {
        
        porUser(u.getUR_User()); 
        
        if(i == 0){
            System.out.println("Valor de i "+i);
            String sql = "insert into usuarioR(UR_Nombre, UR_Apellidos , UR_User, UR_Pass) values (?,?,?,?)"; 
            PreparedStatement pt = getConnection().prepareStatement(sql); 
            pt.setString(1, u.getUR_Nombre()); 
            pt.setString(2, u.getUR_Apellido()); 
            pt.setString(3, u.getUR_User()); 
            pt.setString(4, u.getUR_Pass()); 
            pt.executeUpdate(); 
        }else{
            
            throw new UsuarioYaExisteException("El usuario que acaba de introducir ya exixste!!!"); 
        }
    }

   
    
    
    
    
    
    
    

    
}
