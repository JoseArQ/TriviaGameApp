/*
 * Modelo de datos para los punto por categoria
 */
package model;

/**
 *
 * @author jose
 */
public class PuntosVO {
    private Integer puntos;

    public PuntosVO() {
    }

    public PuntosVO(Integer puntos) {
        this.puntos = puntos;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }
    
}
