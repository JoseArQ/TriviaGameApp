/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
//Librerias SQL
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Set;
import util.Conexion;


/**
 *
 * @author jose
 */
public class PuntosDao {
    
    public ArrayList<PuntosVO> puntosCategoria (){
        ArrayList<PuntosVO> puntos = new ArrayList();
        Conexion objConexion = new Conexion();
        
        try{
            ResultSet resultado = objConexion.consultarRegistros("SELECT points FROM Category;");
            while (resultado.next()){
                PuntosVO objPuntos = new PuntosVO();
                objPuntos.setPuntos(resultado.getInt("points"));
                puntos.add(objPuntos);
                
            }
        } catch (Exception e){
            System.out.println(e);
        }
        return puntos;
    }
}
