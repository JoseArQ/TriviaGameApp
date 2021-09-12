
package model;

// calse para conexión
import util.Conexion;

import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author jose
 */
public class RespuestasDao {
    
    
    
    public ArrayList<RespuestasVO> RespuestasPreg(){//añadir parametro indicie
       ArrayList<RespuestasVO> respuestasM = new ArrayList();
       Conexion objConexion = new Conexion();
       
       try{
          ResultSet resultado = objConexion.consultarRegistros("SELECT q.question, a.Answer FROM Answer a\n" +
                                                                "INNER JOIN Question q \n" +
                                                                "ON a.idQuestion = q.id_question;");
          
          while (resultado.next()){
              RespuestasVO respuestaObj = new RespuestasVO();
              respuestaObj.setPregunta(resultado.getString("question"));
              respuestaObj.setRespuesta(resultado.getString("answer"));
              
              respuestasM.add(respuestaObj);
          }
       
       } catch(Exception e){
            System.out.println(e);
       }
       
       return respuestasM;
    }
    
}
