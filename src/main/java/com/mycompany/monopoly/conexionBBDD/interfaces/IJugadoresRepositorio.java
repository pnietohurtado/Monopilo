package com.mycompany.monopoly.conexionBBDD.interfaces;

import java.sql.SQLException;

/**
 *
 * @author pablo
 */
public interface IJugadoresRepositorio<T>  {

    public T porId (Long id) throws SQLException, Exception; 
}
