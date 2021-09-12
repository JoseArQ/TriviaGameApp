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
    //private static final String UBICACION_BD = "TriviaGameDB";
    private static final String UBICACION_BD = "/home/jose/NetBeansProjects/TriviaGameApp/TriviaGameDB";
    
    public static Connection getConnection() throws SQLException {
        
        String url = "jdbc:sqlite:" + UBICACION_BD;
        return DriverManager.getConnection(url);
    }
    
}
