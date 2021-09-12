package model;

/**
 *
 * @author jose
 */
public class RespuestasVO {

  
    private String pregunta;
    private String respuesta;

    public RespuestasVO() {
    }

    public RespuestasVO(String pregunta, String respuesta) {
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
     
     
}
