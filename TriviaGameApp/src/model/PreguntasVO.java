
package model;

/**
 *
 * @author jose
 */
public class PreguntasVO {
    
    private Integer idPregunta;
    private String pregunta;
    private Integer puntos;
    private Integer respuesta;
    private Integer categoria;
    
    public PreguntasVO(){
        
    }

    public PreguntasVO(Integer idPregunta, String pregunta, Integer puntos, Integer respuesta, Integer categoria) {
        this.idPregunta = idPregunta;
        this.pregunta = pregunta;
        this.puntos = puntos;
        this.respuesta = respuesta;
        this.categoria = categoria;
    }

    public Integer getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(Integer idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    public Integer getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Integer respuesta) {
        this.respuesta = respuesta;
    }

    public Integer getCategoria() {
        return categoria;
    }

    public void setCategoria(Integer categoria) {
        this.categoria = categoria;
    }
    
    
    
}
