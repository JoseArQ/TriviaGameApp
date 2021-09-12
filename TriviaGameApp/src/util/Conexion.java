
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author jose
 */
public class Conexion {
    
    String strConexionDB = "jdbc:sqlite:/home/jose/NetBeansProjects/TriviaGameApp/TriviaGameDB";
    Connection conn = null;

    public Conexion() {
        try{
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(strConexionDB);
            System.out.println("conexión exitosa");
            
        } catch (Exception e){
            System.out.println("Error de conexion"+e);
        }
    }
    
    public ResultSet consultarRegistros (String sentencia){
        try{
            PreparedStatement pstm = conn.prepareStatement(sentencia);
            ResultSet respuesta = pstm.executeQuery();
            return respuesta;
            
        } catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
}
