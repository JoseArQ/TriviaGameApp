
package view;

import controller.ControladorTrivia;
import model.PreguntasVO;
import java.util.ArrayList;
import java.util.Objects;
import static view.VistaPreguntas.controlador;

/**
 *
 * @author jose
 */
public class Preguntas {
    //instanciar controladores
    public static final ControladorTrivia controlador = new ControladorTrivia();
    
    //obtener datos de la base de datos
    private ArrayList<PreguntasVO> preguntasTrivia = controlador.listarPreguntas();

    public Preguntas() {
        
    }
    
    /**
     * Método para obtener todas las preguntas en una lista
     * @return ArrayList<> listado de todas las preguntas
     */
    public ArrayList<PreguntasVO> obtenerPreguntas(){
        ArrayList<PreguntasVO> preguntas = new ArrayList();
        for (int i=0; i<this.preguntasTrivia.size(); i++){
            preguntas.add(this.preguntasTrivia.get(i));
        }
        
        return preguntas;
    }
    
    /**
     * Método para obtener preguntas según su categoria presentes en una lista de preguntas
     * @param preguntasLista
     * @param catg
     * @return 
     */
    public ArrayList<String> obtenerPregCategoria (ArrayList<PreguntasVO> preguntasLista, Integer catg){
        ArrayList<String> pregCateg = new ArrayList();
        
        for (int i=0; i<preguntasLista.size(); i++){
            if (preguntasLista.get(i).getCategoria() == catg){
              
                pregCateg.add(preguntasLista.get(i).getPregunta());
            }
        }
        return pregCateg;
    }
    
    /**
     * Método para eliminiar una pregunta del la lista de preguntas pasada
     * @param pregunta
     * @param preguntasLista 
     */
    public void EliminarPregunta(String pregunta, ArrayList<PreguntasVO> preguntasLista){
        
        for (int i=0; i<preguntasLista.size(); i++){
            if (preguntasLista.get(i).getPregunta() == pregunta){
                
                preguntasLista.remove(i);
            }
        }
    }
    
    /**
     * Método para obtener el id de la respuesta correcta
     * @param pregunta
     * @return 
     */
    public int idRespuestaCorrecta (String pregunta) {
        int resp = 0;
        try {
            
            for (int i = 0; i < this.preguntasTrivia.size(); i++) {
                if (this.preguntasTrivia.get(i).getPregunta().equals(pregunta)) {
                    resp = this.preguntasTrivia.get(i).getRespuesta();
                }
            }
        
        }catch(Exception e){
            System.err.print("respuestas no encontrada"+ e);
        }
     return resp-1;  
    }
}
