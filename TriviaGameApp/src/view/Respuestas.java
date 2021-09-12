
package view;

import controller.ControladorTrivia;
import java.util.ArrayList;
import java.util.stream.Collectors;
import model.RespuestasVO;

/**
 *
 * @author jose
 */
public class Respuestas {
    
    
    //instanciar controladores
    public static final ControladorTrivia controlador = new ControladorTrivia();
    
    //obtener datos de la base de datos
    private ArrayList<RespuestasVO> respuestasTrivia = controlador.listarRespuestas();
    
    /**
     * Método para obtener las opciones de respuesta de una pregunta
     * @param pregunta
     * @return Arraylist<String> de las respuestas de la pregunta 
     */
    public ArrayList<String> respuestaPorPreg (String pregunta){
        ArrayList<String> respuestas = new ArrayList();
        
        for (int i=0; i<this.respuestasTrivia.size(); i++){
            if (pregunta.equals(this.respuestasTrivia.get(i).getPregunta())){
                respuestas.add(this.respuestasTrivia.get(i).getRespuesta());
            }
        }
        return respuestas;
    }
    
    /**
     * Método para obtener la respuesta correcta de una pregunta según si id
     * @param id
     * @return String con la respuesta correcta
     */
    public String respuestaCorrecta (Integer id){
       return this.respuestasTrivia.get(id).getRespuesta();
    }
}
