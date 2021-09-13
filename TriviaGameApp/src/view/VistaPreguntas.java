
package view;
import controller.ControladorTrivia;
import java.sql.ResultSet;
import model.PreguntasVO;
import util.Conexion;

import model.RespuestasVO;

//Librerías para bases de datos
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Set;
import java.util.Collections;
import java.util.Arrays;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author jose
 */
public class VistaPreguntas extends JFrame  {

    //instanciar controladores
    public static final ControladorTrivia controlador = new ControladorTrivia();

    //obtener datos de la base de datos
    Preguntas preguntas = new Preguntas();
    ArrayList<PreguntasVO> subPreguntas = preguntas.obtenerPreguntas();
    ArrayList<String> preguntasCat = new ArrayList();
    
    // array para las respuestas 
    Respuestas respuestas = new Respuestas();
    ArrayList<String> subRespuestas ;
    
    // para los puntos
    Puntos puntos = new Puntos();
    
    int correctas;
    int puntajeAcum;
    
    //inicar variables
    int result;
    int seconds = 10;
    int catg = 0;
    int pregActual = 0;
    int ronda = 1;
    int indiceElimiado;
    
     //declarar componentes del fram 
    private JFrame frame;
    private JTextArea textarea = new JTextArea();
    private JButton btnContinue;
    private JButton btnA;
    private JButton btnB;
    private JButton btnC;
    private JButton btnD;
    private JLabel answer_labelA = new JLabel();
    private JLabel answer_labelB = new JLabel();
    private JLabel answer_labelC = new JLabel();
    private JLabel answer_labelD = new JLabel();

    
    
    public VistaPreguntas(){
        
        // creamos el frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(650, 650);
        this.getContentPane().setBackground(new Color(50, 50, 50));
        this.setLayout(null);
        this.setResizable(false);
        
        //text area
        this.textarea.setBounds(0, 50, 650, 60);
        this.textarea.setLineWrap(true);
        this.textarea.setWrapStyleWord(true);
        this.textarea.setBackground(new Color(25, 25, 25));
        this.textarea.setForeground(new Color(25, 255, 0));
        this.textarea.setFont(new Font("MV Boli", Font.BOLD, 20));
        this.textarea.setBorder(BorderFactory.createBevelBorder(1));
        this.textarea.setEditable(false);
        this.textarea.setText("Click en siguiente para empezar Ronda #: "+ronda);
        
        btnContinue = new JButton();
        btnContinue.setBounds(535, 530, 120, 25);
        btnContinue.setFont(new Font("MV Boli", Font.BOLD, 15));
        btnContinue.setFocusable(false);
        btnContinue.setHorizontalAlignment(JTextField.CENTER);
        btnContinue.setText("Siguiente");
        
        btnA = new JButton();
        btnA.setBounds(0, 100, 100, 100);
        btnA.setFont(new Font("MV Boli", Font.BOLD, 35));
        btnA.setFocusable(false);
        btnA.setText("A");
        
        
        btnB = new JButton();
        btnB.setBounds(0,200,100,100);
        btnB.setFont(new Font("MV Boli", Font.BOLD, 35));
        btnB.setFocusable(false);
        btnB.setText("B");
        
        btnC = new JButton();
        btnC.setBounds(0,300,100,100);
        btnC.setFont(new Font("MV Boli", Font.BOLD, 35));
        btnC.setFocusable(false);
        btnC.setText("C");
        
        btnD = new JButton();
        btnD.setBounds(0,400,100,100);
        btnD.setFont(new Font("MV Boli", Font.BOLD, 35));
        btnD.setFocusable(false);
        btnD.setText("D");
        
        //LABEL PARA RESPUESTAS
        answer_labelA.setBounds(125, 100, 500, 100);
        answer_labelA.setBackground(new Color(50, 50, 50));
        answer_labelA.setForeground(new Color(25, 255, 0));
        answer_labelA.setFont(new Font("MV Boli", Font.PLAIN, 22));

        answer_labelB.setBounds(125, 200, 500, 100);
        answer_labelB.setBackground(new Color(50, 50, 50));
        answer_labelB.setForeground(new Color(25, 255, 0));
        answer_labelB.setFont(new Font("MV Boli", Font.PLAIN, 22));

        answer_labelC.setBounds(125, 300, 500, 100);
        answer_labelC.setBackground(new Color(50, 50, 50));
        answer_labelC.setForeground(new Color(25, 255, 0));
        answer_labelC.setFont(new Font("MV Boli", Font.PLAIN, 22));

        answer_labelD.setBounds(125, 400, 500, 100);
        answer_labelD.setBackground(new Color(50, 50, 50));
        answer_labelD.setForeground(new Color(25, 255, 0));
        answer_labelD.setFont(new Font("MV Boli", Font.PLAIN, 22));
        
        //AÑADIMOS COMPONENTES AL FRAME
        this.add(this.textarea);
        this.add(this.btnContinue);
        this.add(this.btnA);
        this.add(this.btnB);
        this.add(this.btnC);
        this.add(this.btnD);
        this.add(this.answer_labelA);
        this.add(this.answer_labelB);
        this.add(this.answer_labelC);
        this.add(this.answer_labelD);
        
        btnContinue.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                if (pregActual < 25){
                    if (catg < 5) {
                        Integer puntosRonda = puntos.puntosPregunta(catg);
                        preguntasCat = preguntas.obtenerPregCategoria(subPreguntas, catg+1);
                        int id = idPreg(preguntasCat);
                        
                        String pregunta = preguntasCat.get(id);

                        textarea.setText(pregunta);
                       
                        subRespuestas = respuestas.respuestaPorPreg(pregunta);
                        imprimirRespuestas(subRespuestas);
                        
                        //obtener respuestas
                        int idRespuesta = preguntas.idRespuestaCorrecta(pregunta);
                        String respuestaCorrecta = respuestas.respuestaCorrecta(idRespuesta);
                      
                        // reseteado 
                        preguntasCat.clear();
                        subRespuestas.clear();
                        preguntas.EliminarPregunta(pregunta, subPreguntas);
                        
                        //incrementan variables
                        catg++;
                        pregActual++;
                        
                        //Escuchamos respuestas
                        btnA.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (respuestaCorrecta.equals(answer_labelA.getText())){
                                    correctas++;
                                    puntajeAcum += puntosRonda;
                                    System.out.println(puntajeAcum);
                                    btnContinue.doClick();
                                }
                                else {
                                    System.exit(0);
                                }
                            }

                        });
                        
                        btnB.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (respuestaCorrecta.equals(answer_labelB.getText())) {
                                    correctas++;
                                    puntajeAcum += puntosRonda;
                                    System.out.println(puntajeAcum);
                                    btnContinue.doClick();
                                }
                                else {
                                    System.exit(0);
                                }
                            }

                        });
                        
                        btnC.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (respuestaCorrecta.equals(answer_labelC.getText())){
                                    correctas++;
                                    puntajeAcum += puntosRonda;
                                    System.out.println(puntajeAcum);
                                    btnContinue.doClick();
                                }
                                else {
                                    System.exit(0);
                                }
                                
                                
                            }

                        });
                        
                         btnD.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (respuestaCorrecta.equals(answer_labelD.getText())){
                                    correctas++;
                                    puntajeAcum += puntosRonda;
                                    btnContinue.doClick();
                                }
                                else {
                                    System.exit(0);
                                }
                            }
                            

                        });
                        
                    } else {
                        limpiarRespuestas();
                        ronda++;
                        textarea.setText("Click en siguiente para empezar Ronda #: "+ ronda);
                        //REINICIAMOS CATEGORIA
                        catg = 0;  
                        
                    }

                }
                else{
                    limpiarRespuestas();
                    //REINICIAMOS LISTA DE PREGUNTAS
                    subPreguntas = preguntas.obtenerPreguntas();
                    //mostrar resultado
                    textarea.setText("Puntaje Obtenido: "+puntajeAcum);
                    pregActual = 0;
                    puntajeAcum = 0;
                }
            }

            private Integer idPreg(ArrayList<String> preguntasCategoria) {
                
                return (int)(Math.random()*preguntasCategoria.size());
            }

            private void imprimirRespuestas(ArrayList<String> subRespuestas) {
                
               answer_labelA.setText(subRespuestas.get(0));
               answer_labelB.setText(subRespuestas.get(1));
               answer_labelC.setText(subRespuestas.get(2));
               answer_labelD.setText(subRespuestas.get(3));
               
            }

            private void limpiarRespuestas() {
                answer_labelA.setText("");
                answer_labelB.setText("");
                answer_labelC.setText("");
                answer_labelD.setText("");
            }
        });
        
 
    }
    
}