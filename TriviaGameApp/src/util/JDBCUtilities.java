package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jose
 */
public class JDBCUtilities {
    
    // atributos para gestión de la conexion con la base de datos
    private static final String UBICACION_BD = "TriviaGameDB.db";
    
    public static Connection getConnection() throws SQLException {
        
        String url = "jdb:sqlit:" + UBICACION_BD;
        return DriverManager.getConnection(url);
    }
    
}
