package controller;

import java.util.ArrayList;

import model.PreguntasDao;
import model.PreguntasVO;
import model.RespuestasDao;
import model.RespuestasVO;

//Librerías para bases de datos
import java.sql.SQLException;
import model.PuntosDao;
import model.PuntosVO;


/**
 *
 * @author jose
 */
public class ControladorTrivia {
    
    private final PreguntasDao preguntasDao;
    private final RespuestasDao respuestasDao;
    private final PuntosDao puntosDao;

    public ControladorTrivia() {
        this.preguntasDao = new PreguntasDao();
        this.respuestasDao = new RespuestasDao();
        this.puntosDao = new PuntosDao();
    }
    
    public ArrayList<PreguntasVO> listarPreguntas()  {
        
        return this.preguntasDao.preguntasTrivia();
    }
    
    
    public ArrayList<RespuestasVO> listarRespuestas () {
        return this.respuestasDao.RespuestasPreg();
    }
    
    public ArrayList<PuntosVO> puntosCategoria (){
        return this.puntosDao.puntosCategoria();
    }
}
