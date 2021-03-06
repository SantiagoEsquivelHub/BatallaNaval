package myProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static java.awt.Color.*;

/**
 * This class is used for ...
 * @autor Paola-J Rodriguez-C paola.rodriguez@correounivalle.edu.co
 * @version v.1.0.0 date:21/11/2021
 */
public class GUI extends JFrame {

    private Header headerProject;
    private Rival rival;
    private Escucha escucha;
    private EscuchaDestructores escuchaDestructores;
    private EscuchaFragatas escuchaFragatas;
    private EscuchaSubmarinos escuchaSubmarinos;
    private EscuchaPortaavion escuchaPortaavion;
    private EscuchaEmpezarJuego escuchaEmpezarJuego;
    private EscuchaCeldasEnemigas escuchaCeldasEnemigas;
    private ModelBatalla modelBatalla;
    private ImageIcon imagenBienvenida, imagenColores;
    private JLabel bienvenida, imagen, guiaColores;
    private JPanel panelBienvenido, tableroPosicion, tableroPrincipal, tableroAparte;
    private Celda[][] matrizCelda = new Celda[10][10];
    private Celda[][] matrizCeldaRival = new Celda[10][10];
    private JButton guiaJuego, jugar, fragatasBtn, destructoresBtn, submarinosBtn, portaavionesBtn, empezarJuego, tableroAparteBtn;
    private Barco fragata01, fragata02, fragata03, fragata04,submarino01,submarino02,portaavion01,destructor01, destructor02, destructor03;

    private ArrayList<Barco> fragatas, destructores, submarinos;
    private ArrayList<Celda> fragatasAnteriores, destructoresAnteriores, submarinosAnteriores, celdasDest01, celdasDest02, celdasDest03, celdasSub01, celdasSub02, celditasPortaavion;
    private static final String MENSAJE_GUIA = "Bienvenida a esta aventura jugador, cuando empieces a jugar debes ubicar tu flota que consta de 1 portaaviones, 2 submarinos,\n " +
            "3 destructores y 4 fratatas que vas a ubicar dando click en las celdas, empieza a dar click en el campo enemigo para intentar hundir la flota contraria.\n" +
            "Si dice un casillero que est?? vac??o deber?? decir \"agua\", si acierta dir?? \"hundido\" y si acierta a algun barco completamente deber?? decir \"hundido\". \n" +
            "Juega uno por vez, el que quede con los barcos a flote resultar?? ganador.";


    /**
     * Constructor of GUI class
     */
    public GUI(){
        initGUI();

        //Default JFrame configuration
        this.setTitle("Batalla Naval");
        this.setSize(1000,700);
        this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */
    private void initGUI() {

        //Set up JFrame Container's Layout
        //Create Listener Object and Control Object
        escucha = new Escucha();
        rival = new Rival();
        escuchaDestructores = new EscuchaDestructores();
        escuchaFragatas = new EscuchaFragatas();
        escuchaSubmarinos = new EscuchaSubmarinos();
        escuchaPortaavion = new EscuchaPortaavion();
        escuchaEmpezarJuego = new EscuchaEmpezarJuego();
        escuchaCeldasEnemigas = new EscuchaCeldasEnemigas();
        fragatasAnteriores = new ArrayList<Celda>();
        destructoresAnteriores = new ArrayList<Celda>();
        submarinosAnteriores = new ArrayList<Celda>();
        celdasDest01 = new ArrayList<Celda>();
        celdasDest02 = new ArrayList<Celda>();
        celdasDest03 = new ArrayList<Celda>();
        celdasSub01 = new ArrayList<Celda>();
        celdasSub02 = new ArrayList<Celda>();
        celditasPortaavion = new ArrayList<Celda>();
        modelBatalla = new ModelBatalla();
        portaavion01 = new Barco(0);
        submarino01 = new Barco(0);
        submarino02 = new Barco(0);
        submarinos = new ArrayList<Barco>();
        submarinos.add(submarino01);
        submarinos.add(submarino02);
        destructor01 = new Barco(0);
        destructor02 = new Barco(0);
        destructor03 = new Barco(0);
        destructores= new ArrayList<Barco>();
        destructores.add(destructor01);
        destructores.add(destructor02);
        destructores.add(destructor03);
        fragata01 = new Barco(1);
        fragata02 = new Barco(2);
        fragata03 = new Barco(3);
        fragata04 = new Barco(4);
        fragatas= new ArrayList<Barco>();
        fragatas.add(fragata01);
        fragatas.add(fragata02);
        fragatas.add(fragata03);
        fragatas.add(fragata04);

        //Set up JComponents
        headerProject = new Header("Batalla Naval", Color.BLACK);
        this.add(headerProject,BorderLayout.NORTH); //Change this line if you change JFrame Container's Layout

        tableroAparte = new JPanel();
        tableroAparte.setBorder(BorderFactory.createTitledBorder("??Tablero del rival!"));
        tableroAparte.setPreferredSize(new Dimension(500,500));
        tableroAparte.setLayout(new GridLayout(11,11));

        panelBienvenido = new JPanel();
        panelBienvenido.setBorder(BorderFactory.createTitledBorder("??Bienvenido!"));
        panelBienvenido.setLayout(new GridBagLayout());
        panelBienvenido.setPreferredSize(new Dimension(600,300));
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10,10,10,10);
        this.add(panelBienvenido, BorderLayout.PAGE_START);

        bienvenida = new JLabel();
        bienvenida.setText("Bienvenido Jugador");
        constraints.gridx=1;
        constraints.gridy=0;
        constraints.gridwidth = 3;
        panelBienvenido.add(bienvenida, constraints);

        jugar = new JButton("    Jugar    ");
        jugar.addActionListener(escucha);
        constraints.gridx=1;
        constraints.gridy=2;
        constraints.gridwidth = 1;
        panelBienvenido.add(jugar, constraints);

        empezarJuego = new JButton("Empezar juego");
        empezarJuego.addActionListener(escuchaEmpezarJuego);
        empezarJuego.setVisible(false);
        constraints.gridx=1;
        constraints.gridy=2;
        constraints.gridwidth = 1;
        panelBienvenido.add(empezarJuego, constraints);

        tableroAparteBtn = new JButton("Tablero del rival");
        tableroAparteBtn.addActionListener(escuchaEmpezarJuego);
        tableroAparteBtn.setVisible(false);
        constraints.gridx=1;
        constraints.gridy=2;
        constraints.gridwidth = 1;
        panelBienvenido.add(tableroAparteBtn, constraints);


        guiaJuego = new JButton("Guia de juego");
        guiaJuego.addActionListener(escucha);
        constraints.gridx=1;
        constraints.gridy=1;
        constraints.gridwidth = 1;
        panelBienvenido.add(guiaJuego, constraints);

        fragatasBtn = new JButton("Fragatas");
        fragatasBtn.addActionListener(escuchaFragatas);
        fragatasBtn.setVisible(false);
        constraints.gridx=0;
        constraints.gridy=3;
        constraints.gridwidth = 1;
        panelBienvenido.add(fragatasBtn, constraints);

        destructoresBtn = new JButton("Destructores");
        destructoresBtn.addActionListener(escuchaDestructores);
        destructoresBtn.setVisible(false);
        constraints.gridx=1;
        constraints.gridy=3;
        constraints.gridwidth = 1;
        panelBienvenido.add(destructoresBtn, constraints);

        submarinosBtn = new JButton("Submarinos");
        submarinosBtn.addActionListener(escuchaSubmarinos);
        submarinosBtn.setVisible(false);
        constraints.gridx=2;
        constraints.gridy=3;
        constraints.gridwidth = 1;
        panelBienvenido.add(submarinosBtn, constraints);

        portaavionesBtn = new JButton("Portaaviones");
        portaavionesBtn.addActionListener(escuchaPortaavion);
        portaavionesBtn.setVisible(false);
        constraints.gridx=1;
        constraints.gridy=4;
        constraints.gridwidth = 1;
        panelBienvenido.add(portaavionesBtn, constraints);

        imagen = new JLabel();
        imagenBienvenida = new ImageIcon(getClass().getResource("/recursos/guia.PNG"));
        imagen.setIcon(imagenBienvenida);
        imagen.setVisible(false);
        constraints.gridx=2;
        constraints.gridy=3;
        constraints.gridwidth = 3;
        panelBienvenido.add(imagen, constraints);


        tableroPosicion = new JPanel();
        tableroPosicion.setBorder(BorderFactory.createTitledBorder("??Tablero posicionl!"));
        tableroPosicion.setPreferredSize(new Dimension(500,500));
        tableroPosicion.setLayout(new GridLayout(11,11));
        this.add(tableroPosicion, BorderLayout.WEST);

        tableroPrincipal= new JPanel();
        tableroPrincipal.setBorder(BorderFactory.createTitledBorder("??Tablero principal!"));
        tableroPrincipal.setPreferredSize(new Dimension(500,500));
        tableroPrincipal.setLayout(new GridLayout(11,11));
        //tableroPrincipal.setVisible(false);
        this.add(tableroPrincipal, BorderLayout.EAST);

        guiaColores = new JLabel();
        imagenColores = new ImageIcon(getClass().getResource("/recursos/intro.png"));
        guiaColores.setIcon(imagenColores);
        guiaColores.setVisible(false);
        constraints.gridx=1;
        constraints.gridy=3;
        constraints.gridwidth = 3;
        panelBienvenido.add(guiaColores, constraints);

        for(int i = 0; i < 10; i++){

            for(int j = 0; j < 10; j++){
                matrizCelda[i][j] = new Celda(i,j);


                tableroPosicion.add(matrizCelda[i][j]);
            }
        }

        for(int i = 0; i < 10; i++){

            for(int j = 0; j < 10; j++){

                rival.getMatrizCeldaRival()[i][j] = new Celda(i,j);
                tableroPrincipal.add(rival.getMatrizCeldaRival()[i][j]);
                rival.getMatrizCeldaRival()[i][j].cambiarFondo();
            }
        }



    }

    /**
     * Main process of the Java program
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            GUI miProjectGUI = new GUI();
        });
    }

    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class Escucha implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {


            if (e.getSource() == guiaJuego) {

               JOptionPane.showMessageDialog(null,
                        MENSAJE_GUIA,

                        "PopUp Dialog",
                        JOptionPane.INFORMATION_MESSAGE);

            } else if (e.getSource() == jugar) {

                fragatasBtn.setVisible(true);
                destructoresBtn.setVisible(true);
                submarinosBtn.setVisible(true);
                portaavionesBtn.setVisible(true);
                destructoresBtn.setEnabled(false);
                submarinosBtn.setEnabled(false);
                portaavionesBtn.setEnabled(false);
                jugar.setVisible(false);
                imagen.setVisible(false);
                JOptionPane.showMessageDialog(null,
                        "Selecciona el bot??n habilitado en la parte de arriba"
                               ,

                        "PopUp Dialog",
                        JOptionPane.INFORMATION_MESSAGE);

                for (int i = 0; i < 10; i++) {

                    for (int j = 0; j < 10; j++) {
                        matrizCelda[i][j].addActionListener(escucha);
                    }
                }

            }else if (e.getSource() == empezarJuego) {



                for (int i = 0; i < 10; i++) {

                    for (int j = 0; j < 10; j++) {
                        matrizCeldaRival[i][j].restaurarFondo();
                    }
                }

                JOptionPane.showMessageDialog(null,
                        "Trata de derribar la flota rival para ganar el juego,\n"+
                                "antes que nos derriben la nuestra\n"+
                                "??MUCHA SUERTE!",

                        "PopUp Dialog",
                        JOptionPane.INFORMATION_MESSAGE);

            }

        }
    }

    private class EscuchaFragatas implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {


            if(e.getSource() == fragatasBtn){
                fragatasBtn.setEnabled(false);
                for (int i = 0; i < 10; i++) {

                    for (int j = 0; j < 10; j++) {
                        matrizCelda[i][j].addActionListener(escuchaFragatas);

                    }
                }
                JOptionPane.showMessageDialog(null,
                        "Selecciona 4 fragatas de 1 casilla cada una,\n",

                        "PopUp Dialog",
                        JOptionPane.INFORMATION_MESSAGE);


            }else{
                Celda celdaSeleccionada = (Celda)e.getSource();
                int fila = celdaSeleccionada.getFila() + 1;
                int columna = celdaSeleccionada.getColumna() + 1;




                if (fragata01.getContador() == 1) {
                    modelBatalla.fragatas(fragatas, fila, columna, fragata01.getContador());
                    fragata01.setContador(0);celdaSeleccionada.setBackground(Color.ORANGE);
                    fragatasAnteriores.add(celdaSeleccionada);
                    celdaSeleccionada.removeActionListener(escuchaFragatas);
                    celdaSeleccionada.setEstado(true);
                    celdaSeleccionada.setFragata(true);
                    //celdaSeleccionada.removeActionListener(escuchaPortaavion);
                    //System.out.println("fragata01Contador="+fragata01.getContador()+"");
                } else if (fragata02.getContador() == 2) {
                    modelBatalla.fragatas(fragatas, fila, columna, fragata02.getContador());
                    fragata02.setContador(0);celdaSeleccionada.setBackground(Color.ORANGE);
                    fragatasAnteriores.add(celdaSeleccionada);
                    celdaSeleccionada.removeActionListener(escuchaFragatas);
                    celdaSeleccionada.setEstado(true);
                    celdaSeleccionada.setFragata(true);
                    //System.out.println("fragata02Contador="+fragata02.getContador()+"");
                } else if (fragata03.getContador() == 3) {
                    modelBatalla.fragatas(fragatas, fila, columna, fragata03.getContador());
                    fragata03.setContador(0);celdaSeleccionada.setBackground(Color.ORANGE);
                    fragatasAnteriores.add(celdaSeleccionada);
                    celdaSeleccionada.removeActionListener(escuchaFragatas);
                    celdaSeleccionada.setEstado(true);
                    celdaSeleccionada.setFragata(true);
                    //celdaSeleccionada.removeActionListener(escuchaPortaavion);
                    //System.out.println("fragata03Contador="+fragata03.getContador()+"");
                } else if (fragata04.getContador() == 4) {
                    modelBatalla.fragatas(fragatas, fila, columna, fragata04.getContador());
                    fragata04.setContador(0);celdaSeleccionada.setBackground(Color.ORANGE);
                    fragatasAnteriores.add(celdaSeleccionada);
                    celdaSeleccionada.removeActionListener(escuchaFragatas);
                    celdaSeleccionada.setEstado(true);
                    celdaSeleccionada.setFragata(true);
                    //celdaSeleccionada.removeActionListener(escuchaPortaavion);

                    destructor01.setContador(1);
                    destructor02.setContador(1);


                    //System.out.println("fragata04Contador="+fragata04.getContador()+"");

                    fragatasBtn.setEnabled(false);
                    destructoresBtn.setEnabled(true);

                    JOptionPane.showMessageDialog(null,
                            "4 fragatas seleccionadas correctamente\n"+
                            "presiona el boton correspondiente de arriba",

                            "PopUp Dialog",
                            JOptionPane.INFORMATION_MESSAGE);


                }
            }





            }

        }


        private class EscuchaDestructores implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {

                if(e.getSource() == destructoresBtn){
                    destructoresBtn.setEnabled(false);
                    JOptionPane.showMessageDialog(null,
                            "Selecciona 3 destructores de 2 casillas cada una,\n"+
                            "DEBEN estar seguidas",

                            "PopUp Dialog",
                            JOptionPane.INFORMATION_MESSAGE);

                    for (int i = 0; i < 10; i++) {

                        for (int j = 0; j < 10; j++) {
                            matrizCelda[i][j].addActionListener(escuchaDestructores);
                            modelBatalla.eliminarEscuchasAnteriores(matrizCelda,fragatasAnteriores,escuchaDestructores);

                        }
                    }

                }else{

                        Celda celdaSeleccionada = (Celda) e.getSource();
                        int fila = celdaSeleccionada.getFila() + 1;
                        int columna = celdaSeleccionada.getColumna() + 1;



                        switch (destructor01.getContador()){
                            case 1:
                                celdaSeleccionada.setEstado(true);
                                celdaSeleccionada.setDestructor(true);
                                //System.out.println("destructor01Contador=" + destructor01.getContador() + "");
                                rival.getArrayGanarAux().add(celdaSeleccionada);
                                celdasDest01.add(celdaSeleccionada);
                                destructoresAnteriores.add(celdaSeleccionada);
                                celdaSeleccionada.removeActionListener(escuchaDestructores);
                                //System.out.println("celdasDest01="+celdasDest01.size()+"");

                                modelBatalla.destructores(destructores, fila, columna, destructor01.getContador());
                                celdaSeleccionada.setBackground(Color.GREEN);

                                destructor01.setContador(2);
                                //System.out.println("destructor01Contador=" + destructor01.getContador() + "");


                                break;
                            case 2:
                                celdaSeleccionada.setEstado(true);
                                celdaSeleccionada.setDestructor(true);
                                //System.out.println("destructor01ContadorDEBESER2=" + destructor01.getContador() + "");
                                //System.out.println("CASO 22222222222");
                                rival.getArrayGanarAux().add(celdaSeleccionada);
                                celdasDest01.add(celdaSeleccionada);
                                destructoresAnteriores.add(celdaSeleccionada);
                                celdaSeleccionada.removeActionListener(escuchaDestructores);

                                modelBatalla.destructores(destructores, fila, columna, destructor01.getContador());
                                celdaSeleccionada.setBackground(Color.GREEN);
                                //System.out.println("destructor01ContadorDEBESER2=" + destructor01.getContador() + "");



                                //System.out.println("celdasDest01="+celdasDest01.size()+"");


                                boolean comparadorIgualdadFilas = modelBatalla.comparadorIgualdad(fila, destructor01.getFilasArray());
                                boolean comparadorSeguidosFilas = modelBatalla.comparadorSeguidos(destructor01.getFilasArray());
                                boolean comparadorIgualdadColumnas = modelBatalla.comparadorIgualdad(columna, destructor01.getColumnasArray());
                                boolean comparadorSeguidosColumnas = modelBatalla.comparadorSeguidos(destructor01.getColumnasArray());

                                //System.out.println("CONTADOR ANTES DE ERROR="+destructor01.getContador()+"");
                                if(modelBatalla.comparador(comparadorIgualdadFilas, comparadorSeguidosColumnas, comparadorIgualdadColumnas, comparadorSeguidosFilas, matrizCelda, celdasDest01, escuchaDestructores)){
                                    destructor01.setContador(3);
                                    //System.out.println("CONTADOR EN 3");
                                    break;

                                }else{
                                    destructor01.setContador(1);
                                    celdasDest01.clear();
                                    destructor01.getFilasArray().clear();
                                    destructor01.getColumnasArray().clear();
                                    //System.out.println("CONTADOR EN 2");
                                    //System.out.println("SIZEEEEEEEEEceldasDest01="+celdasDest01.size()+"");
                                    //System.out.println("CONTADOR DE DESPUES DE ERROR="+destructor01.getContador()+"");
                                    break;
                                }

                            case 3:
                                //System.out.println("destructor01Contador=" + destructor01.getContador() + "");
                                rival.getArrayGanarAux().add(celdaSeleccionada);
                                //System.out.println("AQUI ESTOYYYYYYYYYYYYYYYYYYY");

                                celdasDest02.add(celdaSeleccionada);
                                destructoresAnteriores.add(celdaSeleccionada);
                                celdaSeleccionada.removeActionListener(escuchaDestructores);
                                //System.out.println("celdasDest02="+celdasDest02.size()+"");

                                modelBatalla.destructores(destructores, fila, columna, destructor01.getContador());
                                celdaSeleccionada.setBackground(Color.GREEN);

                                destructor01.setContador(4);
                                //System.out.println("destructor01111111111111111111Contador=" + destructor01.getContador() + "");
                                celdaSeleccionada.setEstado(true);
                                celdaSeleccionada.setDestructor(true);

                                break;
                            case 4:
                                celdaSeleccionada.setEstado(true);
                                celdaSeleccionada.setDestructor(true);
                                //System.out.println("destructor01Contador=" + destructor01.getContador() + "");
                                rival.getArrayGanarAux().add(celdaSeleccionada);
                                celdasDest02.add(celdaSeleccionada);
                                destructoresAnteriores.add(celdaSeleccionada);
                                celdaSeleccionada.removeActionListener(escuchaDestructores);
                                //System.out.println("celdasDest02="+celdasDest02.size()+"");



                                //System.out.println("SEBASSSSSSSSSSSSSSSSSSSSSSSS");

                                modelBatalla.destructores(destructores, fila, columna, destructor01.getContador());
                                boolean comparadorIgualdadFilas2 = modelBatalla.comparadorIgualdad(fila, destructor02.getFilasArray());
                                boolean comparadorSeguidosFilas2 = modelBatalla.comparadorSeguidos(destructor02.getFilasArray());
                                boolean comparadorIgualdadColumnas2 = modelBatalla.comparadorIgualdad(columna, destructor02.getColumnasArray());
                                boolean comparadorSeguidosColumnas2 = modelBatalla.comparadorSeguidos(destructor02.getColumnasArray());


                                celdaSeleccionada.setBackground(Color.GREEN);

                                if(modelBatalla.comparador(comparadorIgualdadFilas2, comparadorSeguidosColumnas2, comparadorIgualdadColumnas2, comparadorSeguidosFilas2, matrizCelda, celdasDest02, escuchaDestructores)){
                                    destructor01.setContador(5);
                                    break;
                                }else{
                                    destructor01.setContador(3);
                                    celdasDest02.clear();
                                    destructor02.getFilasArray().clear();
                                    destructor02.getColumnasArray().clear();
                                    break;
                                }

                            case 5:
                                celdaSeleccionada.setEstado(true);
                                celdaSeleccionada.setDestructor(true);
                                //System.out.println("destructor01Contador=" + destructor01.getContador() + "");
                                rival.getArrayGanarAux().add(celdaSeleccionada);
                                //System.out.println("caso 5");

                                celdasDest03.add(celdaSeleccionada);
                                destructoresAnteriores.add(celdaSeleccionada);
                                celdaSeleccionada.removeActionListener(escuchaDestructores);
                                //System.out.println("celdasDest03="+celdasDest03.size()+"");

                                modelBatalla.destructores(destructores, fila, columna, destructor01.getContador());
                                celdaSeleccionada.setBackground(Color.GREEN);

                                destructor01.setContador(6);
                                //System.out.println("destructor01111111111111111111Contador=" + destructor01.getContador() + "");


                                break;
                            case 6:
                                celdaSeleccionada.setEstado(true);
                                celdaSeleccionada.setDestructor(true);
                                //System.out.println("destructor01Contador=" + destructor01.getContador() + "");
                                rival.getArrayGanarAux().add(celdaSeleccionada);
                                //System.out.println("caso 6");

                                celdasDest03.add(celdaSeleccionada);
                                destructoresAnteriores.add(celdaSeleccionada);
                                celdaSeleccionada.removeActionListener(escuchaDestructores);


                                //System.out.println("celdasDest03="+celdasDest03.size()+"");

                                modelBatalla.destructores(destructores, fila, columna, destructor01.getContador());
                                boolean comparadorIgualdadFilas3 = modelBatalla.comparadorIgualdad(fila, destructor03.getFilasArray());
                                boolean comparadorSeguidosFilas3 = modelBatalla.comparadorSeguidos(destructor03.getFilasArray());
                                boolean comparadorIgualdadColumnas3 = modelBatalla.comparadorIgualdad(columna, destructor03.getColumnasArray());
                                boolean comparadorSeguidosColumnas3 = modelBatalla.comparadorSeguidos(destructor03.getColumnasArray());


                                celdaSeleccionada.setBackground(Color.GREEN);

                                if(modelBatalla.comparador(comparadorIgualdadFilas3, comparadorSeguidosColumnas3, comparadorIgualdadColumnas3, comparadorSeguidosFilas3, matrizCelda, celdasDest03, escuchaDestructores)){
                                    destructor01.setContador(0);
                                    destructoresBtn.setEnabled(false);
                                    submarinosBtn.setEnabled(true);
                                    submarino01.setContador(1);
                                    JOptionPane.showMessageDialog(null,
                                            "3 destructores seleccionadas correctamente\n"+
                                                    "presiona el boton correspondiente de arriba",

                                            "PopUp Dialog",
                                            JOptionPane.INFORMATION_MESSAGE);
                                    break;
                                }else{
                                    destructor01.setContador(5);
                                    celdasDest03.clear();
                                    destructor03.getFilasArray().clear();
                                    destructor03.getColumnasArray().clear();
                                    break;
                                }






                        }

                }
            }
        }

    private class EscuchaSubmarinos implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getSource() == submarinosBtn){
                submarinosBtn.setEnabled(false);
                JOptionPane.showMessageDialog(null,
                        "Selecciona 2 submarinos de 3 casillas cada una,\n"+
                                "DEBEN estar seguidas",

                        "PopUp Dialog",
                        JOptionPane.INFORMATION_MESSAGE);
                for (int i = 0; i < 10; i++) {

                    for (int j = 0; j < 10; j++) {
                        matrizCelda[i][j].addActionListener(escuchaSubmarinos);
                        modelBatalla.eliminarEscuchasAnteriores(matrizCelda,destructoresAnteriores,escuchaSubmarinos);
                        modelBatalla.eliminarEscuchasAnteriores(matrizCelda,fragatasAnteriores,escuchaSubmarinos);

                    }
                }
            }else{

                Celda celdaSeleccionada = (Celda) e.getSource();
                int fila = celdaSeleccionada.getFila() + 1;
                int columna = celdaSeleccionada.getColumna() + 1;

               //System.out.println("destructor01Contador=" + destructor01.getContador() + "");



                switch (submarino01.getContador()){
                    case 1:
                        //System.out.println("submarino01Contador=" + submarino01.getContador() + "");
                        celdaSeleccionada.setEstado(true);

                        celdaSeleccionada.setSubmarino(true);
                        celdasSub01.add(celdaSeleccionada);
                        submarinosAnteriores.add(celdaSeleccionada);
                        celdaSeleccionada.removeActionListener(escuchaSubmarinos);
                        //System.out.println("celdasSub01="+celdasSub01.size()+"");

                        modelBatalla.submarinos(submarinos, fila, columna, submarino01.getContador());
                        celdaSeleccionada.setBackground(Color.PINK);

                        submarino01.setContador(2);
                        //System.out.println("submarino01Contador=" + submarino01.getContador() + "");
                        break;
                    case 2:
                        //System.out.println("submarino01Contador=" + submarino01.getContador() + "");
                        celdaSeleccionada.setEstado(true);

                        celdaSeleccionada.setSubmarino(true);
                        celdasSub01.add(celdaSeleccionada);
                        submarinosAnteriores.add(celdaSeleccionada);
                        celdaSeleccionada.removeActionListener(escuchaSubmarinos);
                        //System.out.println("celdasSub01="+celdasSub01.size()+"");

                        modelBatalla.submarinos(submarinos, fila, columna, submarino01.getContador());
                        celdaSeleccionada.setBackground(Color.PINK);

                        submarino01.setContador(3);
                        //System.out.println("submarino01Contador=" + submarino01.getContador() + "");
                        break;
                    case 3:
                        //System.out.println("submarino01Contador=" + submarino01.getContador() + "");
                        //System.out.println("CASO 22222222222");
                        celdaSeleccionada.setEstado(true);

                        celdaSeleccionada.setSubmarino(true);
                        celdasSub01.add(celdaSeleccionada);
                        submarinosAnteriores.add(celdaSeleccionada);
                        celdaSeleccionada.removeActionListener(escuchaSubmarinos);
                        //System.out.println("celdasSub01="+celdasSub01.size()+"");

                        modelBatalla.submarinos(submarinos, fila, columna, submarino01.getContador());

                        boolean comparadorIgualdadFilas = modelBatalla.comparadorIgualdad(fila, submarino01.getFilasArray());
                        boolean comparadorSeguidosFilas = modelBatalla.comparadorSeguidos(submarino01.getFilasArray());
                        boolean comparadorIgualdadColumnas = modelBatalla.comparadorIgualdad(columna, submarino01.getColumnasArray());
                        boolean comparadorSeguidosColumnas = modelBatalla.comparadorSeguidos(submarino01.getColumnasArray());

                        celdaSeleccionada.setBackground(Color.PINK);

                        if(modelBatalla.comparador(comparadorIgualdadFilas, comparadorSeguidosColumnas, comparadorIgualdadColumnas, comparadorSeguidosFilas, matrizCelda, celdasSub01, escuchaSubmarinos)){
                        submarino01.setContador(4);
                             break;
                    }else{
                            submarino01.setContador(1);
                            celdasSub01.clear();
                            submarino01.getFilasArray().clear();
                            submarino01.getColumnasArray().clear();
                        break;
                    }


                    case 4:
                        //System.out.println("submarino01Contador=" + submarino01.getContador() + "");
                        celdaSeleccionada.setEstado(true);

                        celdaSeleccionada.setSubmarino(true);
                        celdasSub02.add(celdaSeleccionada);
                        submarinosAnteriores.add(celdaSeleccionada);
                        celdaSeleccionada.removeActionListener(escuchaSubmarinos);
                        //System.out.println("celdasSub02="+celdasSub02.size()+"");

                        modelBatalla.submarinos(submarinos, fila, columna, submarino01.getContador());
                        celdaSeleccionada.setBackground(Color.PINK);

                        submarino01.setContador(5);
                        //System.out.println("submarino01Contador=" + submarino01.getContador() + "");
                        break;
                    case 5:
                        //System.out.println("submarino01Contador=" + submarino01.getContador() + "");
                        celdaSeleccionada.setEstado(true);

                        celdaSeleccionada.setSubmarino(true);
                        celdasSub02.add(celdaSeleccionada);
                        submarinosAnteriores.add(celdaSeleccionada);
                        celdaSeleccionada.removeActionListener(escuchaSubmarinos);
                        //System.out.println("celdasSub02="+celdasSub02.size()+"");

                        modelBatalla.submarinos(submarinos, fila, columna, submarino01.getContador());
                      /*  boolean comparadorIgualdadFilas2 = modelBatalla.comparadorIgualdad(fila, submarino02.getFilasArray());
                        boolean comparadorSeguidosFilas2 = modelBatalla.comparadorSeguidos(submarino02.getFilasArray());
                        boolean comparadorIgualdadColumnas2 = modelBatalla.comparadorIgualdad(columna, submarino02.getColumnasArray());
                        boolean comparadorSeguidosColumnas2 = modelBatalla.comparadorSeguidos(submarino02.getColumnasArray());*/


                        celdaSeleccionada.setBackground(Color.PINK);
                        submarino01.setContador(6);
                        //modelBatalla.comparador(comparadorIgualdadFilas2, comparadorSeguidosColumnas2, comparadorIgualdadColumnas2, comparadorSeguidosFilas2, matrizCelda, submarino01, celditasPortaavion, escuchaSubmarinos);
                        //System.out.println("submarino02Contador=" + submarino01.getContador() + "");
                        break;
                    case 6:
                        //System.out.println("submarino01Contador=" + submarino01.getContador() + "");
                        celdaSeleccionada.setEstado(true);

                        celdaSeleccionada.setSubmarino(true);
                        //System.out.println("SEBASSSSSSSSSSSSSSSSSSSSSSSS");

                        celdasSub02.add(celdaSeleccionada);
                        submarinosAnteriores.add(celdaSeleccionada);
                        celdaSeleccionada.removeActionListener(escuchaSubmarinos);

                        modelBatalla.submarinos(submarinos, fila, columna, submarino01.getContador());
                        boolean comparadorIgualdadFilas3 = modelBatalla.comparadorIgualdad(fila, submarino02.getFilasArray());
                        boolean comparadorSeguidosFilas3 = modelBatalla.comparadorSeguidos(submarino02.getFilasArray());
                        boolean comparadorIgualdadColumnas3 = modelBatalla.comparadorIgualdad(columna, submarino02.getColumnasArray());
                        boolean comparadorSeguidosColumnas3 = modelBatalla.comparadorSeguidos(submarino02.getColumnasArray());


                        celdaSeleccionada.setBackground(Color.PINK);

                        if(modelBatalla.comparador(comparadorIgualdadFilas3, comparadorSeguidosColumnas3, comparadorIgualdadColumnas3, comparadorSeguidosFilas3, matrizCelda, celdasSub02, escuchaSubmarinos)) {

                            submarino01.setContador(0);
                            portaavionesBtn.setEnabled(true);

                            JOptionPane.showMessageDialog(null,
                                    "2 submarinos seleccionadas correctamente\n" +
                                            "presiona el boton correspondiente de arriba",

                                    "PopUp Dialog",
                                    JOptionPane.INFORMATION_MESSAGE);
                            break;
                        }else{
                            submarino01.setContador(4);
                            celdasSub02.clear();
                            submarino02.getFilasArray().clear();
                            submarino02.getColumnasArray().clear();
                            break;
                        }


                }

            }
        }
    }

    private class EscuchaPortaavion implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == portaavionesBtn) {
                portaavionesBtn.setEnabled(false);
                JOptionPane.showMessageDialog(null,
                        "Selecciona 1 portaavion de 4 casillas,\n" +
                                "DEBEN estar seguidas",

                        "PopUp Dialog",
                        JOptionPane.INFORMATION_MESSAGE);

                for (int i = 0; i < 10; i++) {

                    for (int j = 0; j < 10; j++) {
                        matrizCelda[i][j].addActionListener(escuchaPortaavion);
                        modelBatalla.eliminarEscuchasAnteriores(matrizCelda,destructoresAnteriores,escuchaPortaavion);
                        modelBatalla.eliminarEscuchasAnteriores(matrizCelda,fragatasAnteriores,escuchaPortaavion);
                        modelBatalla.eliminarEscuchasAnteriores(matrizCelda,submarinosAnteriores,escuchaPortaavion);

                    }
                }
            }else {

                Celda celdaSeleccionada1 = (Celda) e.getSource();
                celdaSeleccionada1.setBackground(Color.MAGENTA);
                celdaSeleccionada1.removeActionListener(escucha);


                int fila = celdaSeleccionada1.getFila() + 1;
                int columna = celdaSeleccionada1.getColumna() + 1;
                celdaSeleccionada1.setEstado(true);

                celdaSeleccionada1.setPortaavion(true);
                celditasPortaavion.add(celdaSeleccionada1);
                //System.out.println("CeldasPortaaviones="+celditasPortaavion.size()+"");
                celdaSeleccionada1.removeActionListener(escuchaPortaavion);

                portaavion01.setFilasArray(fila);
                //System.out.println(fila);

                portaavion01.setColumnasArray(columna);


                if (portaavion01.getContador() == 4) {

                    boolean comparadorIgualdadFilas = modelBatalla.comparadorIgualdad(fila, portaavion01.getFilasArray());
                    boolean comparadorSeguidosFilas = modelBatalla.comparadorSeguidos(portaavion01.getFilasArray());
                    boolean comparadorIgualdadColumnas = modelBatalla.comparadorIgualdad(columna, portaavion01.getColumnasArray());
                    boolean comparadorSeguidosColumnas = modelBatalla.comparadorSeguidos(portaavion01.getColumnasArray());


                    if(modelBatalla.comparador(comparadorIgualdadFilas, comparadorSeguidosColumnas, comparadorIgualdadColumnas, comparadorSeguidosFilas, matrizCelda, celditasPortaavion, escuchaPortaavion)){
                        //System.out.println("COMPLETADOOOO");

                        fragatasBtn.setVisible(false);
                        destructoresBtn.setVisible(false);
                        submarinosBtn.setVisible(false);
                        portaavionesBtn.setVisible(false);
                        empezarJuego.setVisible(true);
                        guiaColores.setVisible(true);
                        imagen.setVisible(true);



                        JOptionPane.showMessageDialog(null,
                                "1 portaavion seleccionado correctamente\n"+
                                        "presiona el boton correspondiente de arriba\n"+
                                "para EMPEZAR EL JUEGO",

                                "PopUp Dialog",
                                JOptionPane.INFORMATION_MESSAGE);

                        for (int i = 0; i < 10; i++) {

                            for (int j = 0; j < 10; j++) {
                                matrizCelda[i][j].removeActionListener(escucha);
                                matrizCelda[i][j].removeActionListener(escuchaPortaavion);
                            }
                        }

                    }else{
                        portaavion01.setContador(0);
                    }

                }
            }

        }


    }



    private class EscuchaEmpezarJuego implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            for(int i = 0; i < 10; i++){

                for(int j = 0; j < 10; j++){
                    //matrizCelda[i][j].addActionListener(escucha);
                    rival.getMatrizCeldaRival()[i][j].addActionListener(escuchaCeldasEnemigas);
                }
            }

            if (e.getSource() == empezarJuego) {
                empezarJuego.setVisible(false);
                tableroAparteBtn.setVisible(true);


                for (int i = 0; i < 10; i++) {

                    for (int j = 0; j < 10; j++) {
                        //matrizCeldaRival[i][j].restaurarFondo();
                        //rival.getMatrizCeldaRival()[i][j].restaurarFondo();
                    }
                }

                Celda[][] matrizPostFragatas = modelBatalla.fragatasAleatorias(rival.getMatrizCeldaRival(), rival.getCeldasRival(), escuchaCeldasEnemigas);
                Celda[][] matrizPostFragatas2 = modelBatalla.fragatasAleatorias(matrizPostFragatas, rival.getCeldasRival(), escuchaCeldasEnemigas);
                Celda[][] matrizPostFragatas3 = modelBatalla.fragatasAleatorias(matrizPostFragatas2, rival.getCeldasRival(), escuchaCeldasEnemigas);
                Celda[][] matrizPostFragatas4 = modelBatalla.fragatasAleatorias(matrizPostFragatas3, rival.getCeldasRival(), escuchaCeldasEnemigas);
                Celda[][] matrizPostDestructores = modelBatalla.creacionDestructoresJuntos(matrizPostFragatas4,2, rival.getCeldasRival(), escuchaCeldasEnemigas);
                Celda[][] matrizPostDestructores2 = modelBatalla.creacionDestructoresJuntos(matrizPostDestructores,2, rival.getCeldasRival(), escuchaCeldasEnemigas);
                Celda[][] matrizPostDestructores3 = modelBatalla.creacionDestructoresJuntos(matrizPostDestructores2 ,2, rival.getCeldasRival(), escuchaCeldasEnemigas);
                Celda[][] matrizPostSubmarinos = modelBatalla.creacionSubmarinosJuntos(matrizPostDestructores3,3, rival.getCeldasRival(), escuchaCeldasEnemigas);
                Celda[][] matrizPostSubmarinos2 = modelBatalla.creacionSubmarinosJuntos(matrizPostSubmarinos,3, rival.getCeldasRival(), escuchaCeldasEnemigas);
                 modelBatalla.creacionPortaavionJunto(matrizPostSubmarinos2 ,4, rival.getCeldasRival(), escuchaCeldasEnemigas);

                //System.out.println("sizeCelditas="+rival.getCeldasRival().size()+"");

                for (int i = 0; i < 10; i++) {

                    for (int j = 0; j < 10; j++) {
                        //matrizCeldaRival[i][j].restaurarFondo();
                        rival.getMatrizCeldaRival()[i][j].restaurarFondo();
                    }
                }

                for(int i = 0; i < 10; i++){

                    for(int j = 0; j < 10; j++){

                        rival.getMatrizCeldaRival()[i][j] = new Celda(i,j);
                        tableroAparte.add(rival.getMatrizCeldaRival()[i][j]);

                    }
                }

                for(int i = 0; i < rival.getCeldasRival().size(); i++) {

                    if(rival.getCeldasRival().get(i).getColor() != CYAN){

                        int fila = rival.getCeldasRival().get(i).getFila();
                        int columna = rival.getCeldasRival().get(i).getColumna();

                        //System.out.println("intento"+i+"");
                        rival.getMatrizCeldaRival()[fila][columna].setBackground(rival.getCeldasRival().get(i).getColor());
                        rival.getMatrizCeldaRival()[fila][columna].setColor(rival.getCeldasRival().get(i).getColor());

                    }

                }

                JOptionPane.showMessageDialog(null,
                        "Trata de derribar la flota rival para ganar el juego,\n"+
                                "antes que nos derriben la nuestra\n"+
                                "??MUCHA SUERTE!",

                        "PopUp Dialog",
                        JOptionPane.INFORMATION_MESSAGE);

            }else if(e.getSource() == tableroAparteBtn){


                JFrame frame = new JFrame();
                frame.getContentPane().setBackground(getBackground());
                frame.setLocationRelativeTo(null);
                frame.setSize(500,500);
                //this.pack();
                frame.setTitle("Tablero del rival");
                frame.add(tableroAparte);
                frame.setVisible(true);
            }

            }






        }


    private class EscuchaCeldasEnemigas implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (rival.getContadorTurno() % 2 == 0) {


                modelBatalla.turno(matrizCelda,celdasDest01,celdasDest02,celdasDest03,celdasSub01, celdasSub02);


            }else{
                Celda celdaSeleccionada1 = (Celda) e.getSource();



                if(celdaSeleccionada1.getEstado() && celdaSeleccionada1.isFragata()){

                    celdaSeleccionada1.setBackground(RED);
                    rival.setContadorPerder();
                    //rival.setContadorTurno();
                    //JOptionPane.showMessageDialog(null, "TURNO DEL RIVAL");
                    modelBatalla.turno(matrizCelda,celdasDest01,celdasDest02,celdasDest03, celdasSub01, celdasSub02);
                }else if(celdaSeleccionada1.getEstado() && celdaSeleccionada1.isDestructor()){

                    destructor01.setEstado();
                    celdaSeleccionada1.setGolpes();
                    rival.getDestructoresRivalAux().add(celdaSeleccionada1);
                    celdaSeleccionada1.setBackground(BLACK);
                    rival.setContadorPerder();
                   // rival.setContadorTurno();
                    System.out.println(rival.getDestructoresRivalAux().size());

                    if(rival.getDestructoresRivalAux().size() == 2 ){
                        if(rival.getDestructoresRivalAux().get(0).getGolpes() == 1 && rival.getDestructoresRivalAux().get(1).getGolpes() == 1){


                            rival.getDestructoresRivalAux().get(0).setBackground(RED);
                            rival.getDestructoresRivalAux().get(1).setBackground(RED);
                            rival.getDestructoresRivalAux().clear();

                        }
                    }
                    //JOptionPane.showMessageDialog(null, "TURNO DEL RIVAL");
                    modelBatalla.turno(matrizCelda,celdasDest01,celdasDest02,celdasDest03, celdasSub01, celdasSub02);
                }else if(celdaSeleccionada1.getEstado() && celdaSeleccionada1.isSubmarino()){


                    celdaSeleccionada1.setGolpes();
                    rival.getDestructoresRivalAux().add(celdaSeleccionada1);
                    celdaSeleccionada1.setBackground(BLACK);
                    rival.setContadorPerder();
                    //rival.setContadorTurno();
                    System.out.println(rival.getDestructoresRivalAux().size());

                    if(rival.getDestructoresRivalAux().size() == 3){
                        if(rival.getDestructoresRivalAux().get(0).getGolpes() == 1 && rival.getDestructoresRivalAux().get(1).getGolpes() == 1 && rival.getDestructoresRivalAux().get(2).getGolpes() == 1){


                            rival.getDestructoresRivalAux().get(0).setBackground(RED);
                            rival.getDestructoresRivalAux().get(1).setBackground(RED);
                            rival.getDestructoresRivalAux().get(2).setBackground(RED);
                            rival.getDestructoresRivalAux().clear();

                        }
                    }
                    //JOptionPane.showMessageDialog(null, "TURNO DEL RIVAL");
                    modelBatalla.turno(matrizCelda,celdasDest01,celdasDest02,celdasDest03, celdasSub01, celdasSub02);
                }else if(celdaSeleccionada1.getEstado() && celdaSeleccionada1.isPortaavion()){


                    celdaSeleccionada1.setGolpes();
                    rival.getDestructoresRivalAux().add(celdaSeleccionada1);
                    celdaSeleccionada1.setBackground(BLACK);
                    rival.setContadorPerder();
                    //rival.setContadorTurno();
                    System.out.println(rival.getDestructoresRivalAux().size());

                    if(rival.getDestructoresRivalAux().size() == 4){
                        if(rival.getDestructoresRivalAux().get(0).getGolpes() == 1 && rival.getDestructoresRivalAux().get(1).getGolpes() == 1 && rival.getDestructoresRivalAux().get(2).getGolpes() == 1 && rival.getDestructoresRivalAux().get(3).getGolpes() == 1){


                            rival.getDestructoresRivalAux().get(0).setBackground(RED);
                            rival.getDestructoresRivalAux().get(1).setBackground(RED);
                            rival.getDestructoresRivalAux().get(2).setBackground(RED);
                            rival.getDestructoresRivalAux().get(3).setBackground(RED);
                            rival.getDestructoresRivalAux().clear();

                        }
                    }
                    //JOptionPane.showMessageDialog(null, "TURNO DEL RIVAL");
                    modelBatalla.turno(matrizCelda,celdasDest01,celdasDest02,celdasDest03, celdasSub01, celdasSub02);
                }else if(celdaSeleccionada1.getEstado()){

                    System.out.println("SIZEEE="+rival.getFragatasRival().size()+"");
                    //celdaSeleccionada1.setBackground(BLACK);
                    rival.setContadorPerder();
                    //rival.setContadorTurno();
                    System.out.println("CONTADORGANAR="+rival.getContadorPerder()+"");
                    //JOptionPane.showMessageDialog(null, "TURNO DEL RIVAL");
                    modelBatalla.turno(matrizCelda,celdasDest01,celdasDest02,celdasDest03, celdasSub01, celdasSub02);
                }else{
                    //rival.setContadorTurno();
                    celdaSeleccionada1.setBackground(BLUE);
                    celdaSeleccionada1.removeActionListener(escuchaCeldasEnemigas);
                    //JOptionPane.showMessageDialog(null, "TURNO DEL RIVAL");
                    modelBatalla.turno(matrizCelda,celdasDest01,celdasDest02,celdasDest03, celdasSub01, celdasSub02);
                }

                if(rival.getContadorPerder() == 20){
                    JOptionPane.showMessageDialog(null,

                            "??GANASTE!",

                            "PopUp Dialog",
                            JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }

            }


        }
    }




    }




