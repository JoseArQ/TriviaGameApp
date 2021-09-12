package model;
// Estructura de datos
import java.util.ArrayList;

//Librerias SQL
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Set;

// calse para conexión
import util.JDBCUtilities;
import util.Conexion;

//Encapsulamiento de los datos

/**
 *
 * @author jose
 */
public class PreguntasDao {
    
    public ArrayList<PreguntasVO> preguntasTrivia() {
        
        ArrayList<PreguntasVO> preguntasLista= new ArrayList<>();
        Conexion objConexion = new Conexion();
        try {
            ResultSet resultado = objConexion.consultarRegistros("SELECT * FROM Question;");
            while (resultado.next()){
                
                PreguntasVO preguntas = new PreguntasVO();
                preguntas.setPregunta(resultado.getString("question"));
                preguntas.setIdPregunta(resultado.getInt("id_question"));
                preguntas.setCategoria(resultado.getInt("idCategory"));
                preguntas.setRespuesta(resultado.getInt("idAnswer"));
                preguntasLista.add(preguntas);
                
            }
            
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println(preguntasLista);
        return preguntasLista;
    }
}
    

