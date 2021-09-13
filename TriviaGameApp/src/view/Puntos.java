/*
 * clase para obtener la tabla de puntos
 */
package view;

import controller.ControladorTrivia;
import java.util.ArrayList;
import model.PuntosVO;

/**
 *
 * @author jose
 */
public class Puntos {
    
    //instanciar controladores
    public static final ControladorTrivia controlador = new ControladorTrivia();
    
    //obtener datos de la base de datos
    private ArrayList<PuntosVO> puntos = controlador.puntosCategoria();
    
    public Integer puntosPregunta (Integer categoria){
        
        return this.puntos.get(categoria).getPuntos();
    }
}
