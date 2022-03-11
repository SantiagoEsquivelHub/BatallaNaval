package myProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * This class is used for ...
 * @autor Paola-J Rodriguez-C paola.rodriguez@correounivalle.edu.co
 * @version v.1.0.0 date:21/11/2021
 */
public class GUI extends JFrame {

    private Header headerProject;
    private Escucha escucha;
    private EscuchaDestructores escuchaDestructores;
    private EscuchaFragatas escuchaFragatas;
    private EscuchaSubmarinos escuchaSubmarinos;
    private EscuchaPortaavion escuchaPortaavion;
    private ModelBatalla modelBatalla;
    private ImageIcon imagenBienvenida;
    private JLabel bienvenida, imagen;
    private JPanel panelBienvenido, tableroPosicion, tableroPrincipal;
    private Celda[][] matrizCelda = new Celda[10][10];
    private JButton guiaJuego, jugar, fragatasBtn, destructoresBtn, submarinosBtn, portaavionesBtn, empezarJuego;

    private Barco fragata01, fragata02, fragata03, fragata04,submarino01,submarino02,portaavion01,destructor01, destructor02, destructor03;
    private ArrayList<Barco> fragatas, destructores, submarinos;
    private ArrayList<Celda> celdasSeleccionadas;
    private static final String MENSAJE_GUIA = "Bienvenida a esta aventura jugador, cuando empieces a jugar debes ubicar tu flota que consta de 1 portaaviones, 2 submarinos,\n " +
            "3 destructores y 4 fratatas que vas a ubicar dando click en las celdas, empieza a dar click en el campo enemigo para intentar hundir la flota contraria.\n" +
            "Si dice un casillero que está vacío deberá decir \"agua\", si acierta dirá \"hundido\" y si acierta a algun barco completamente deberá decir \"hundido\". \n" +
            "Juega uno por vez, el que quede con los barcos a flote resultará ganador.";

    private static final String GUIA_PORTAAVIONES = "Debes seleccionar 4 casillas del tablero, DEBEN estar seguidas,\n" +
            " ya sea horizontal o verticalmente";

    private static final String GUIA_SUBMARINOS = "";

    private static final String GUIA_DESTRUCTORES = "";

    private static final String GUIA_FRAGATAS = "";
    private Object Celda;


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
        escuchaDestructores = new EscuchaDestructores();
        escuchaFragatas = new EscuchaFragatas();
        escuchaSubmarinos = new EscuchaSubmarinos();
        escuchaPortaavion = new EscuchaPortaavion();
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


        panelBienvenido = new JPanel();
        panelBienvenido.setBorder(BorderFactory.createTitledBorder("¡Bienvenido!"));
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
        //empezarJuego.addActionListener(escucha);
        empezarJuego.setVisible(false);
        constraints.gridx=1;
        constraints.gridy=2;
        constraints.gridwidth = 1;
        panelBienvenido.add(empezarJuego, constraints);

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
        imagenBienvenida = new ImageIcon(getClass().getResource("/recursos/intro.jpg"));
        imagen.setIcon(imagenBienvenida);
        constraints.gridx=1;
        constraints.gridy=3;
        constraints.gridwidth = 3;
        //panelBienvenido.add(imagen, constraints);


        tableroPosicion = new JPanel();
        tableroPosicion.setLayout(new GridLayout(11,11));
        tableroPosicion.setVisible(false);
        this.add(tableroPosicion);

        tableroPrincipal= new JPanel();
        tableroPrincipal.setBorder(BorderFactory.createTitledBorder("¡Tablero principal!"));
        tableroPrincipal.setPreferredSize(new Dimension(500,500));
        tableroPrincipal.setLayout(new GridLayout(11,11));
        this.add(tableroPrincipal);



        for(int i = 0; i < 10; i++){

            for(int j = 0; j < 10; j++){
                matrizCelda[i][j] = new Celda(i,j);

                System.out.println(matrizCelda[i][j].columna);
                System.out.println(matrizCelda[i][j].fila);
                //matrizCelda[i][j].addActionListener(escucha);
                tableroPrincipal.add(matrizCelda[i][j]);
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
                        "Selecciona el botón habilitado en la parte de arriba\n" +
                                "DEBES SELECCIONAR DE IZQUIERDA -> DERECHA",

                        "PopUp Dialog",
                        JOptionPane.INFORMATION_MESSAGE);

                for (int i = 0; i < 10; i++) {

                    for (int j = 0; j < 10; j++) {
                        matrizCelda[i][j].addActionListener(escucha);
                        //matrizCelda[i][j].addActionListener(escuchaFragatas);
                        //matrizCelda[i][j].addActionListener(escuchaDestructores);
                    }
                }

            }

            /*else if(e.getSource() == portaavion){
                Celda celdaSeleccionada1 = (Celda)e.getSource();
                celdaSeleccionada1.setBackground(Color.YELLOW);
                celdaSeleccionada1.removeActionListener(escucha);

                portaavion.setVisible(true);

                int fila = celdaSeleccionada1.getFila()+1;
                int columna = celdaSeleccionada1.getColumna()+1;

                portaavion01.setFilasArray(fila);
                System.out.println(fila);

                portaavion01.setColumnasArray(columna);



                if(portaavion01.getContador() == 4) {

                    boolean comparadorIgualdadFilas = modelBatalla.comparadorIgualdad(fila,portaavion01.getFilasArray());
                    boolean comparadorSeguidosFilas = modelBatalla.comparadorSeguidos(portaavion01.getFilasArray());
                    boolean comparadorIgualdadColumnas = modelBatalla.comparadorIgualdad(columna,portaavion01.getColumnasArray());
                    boolean comparadorSeguidosColumnas = modelBatalla.comparadorSeguidos(portaavion01.getColumnasArray());

                    if((comparadorIgualdadFilas && comparadorSeguidosColumnas) || (comparadorIgualdadColumnas && comparadorSeguidosFilas) ){
                        System.out.println("4 celdas seleccionadas");
                        JOptionPane.showMessageDialog(null,
                                "Posiciones del portaaviones registrada,\n" +
                                        "ahora elige las posiciones de los 2 submarinos.",

                                "PopUp Dialog",
                                JOptionPane.INFORMATION_MESSAGE);

                        submarino.addActionListener(escucha);


                    }else{
                        JOptionPane.showMessageDialog(null,
                                "Repite la seleccion del portaaviones",

                                "PopUp Dialog",
                                JOptionPane.INFORMATION_MESSAGE);

                        //Se reinicia el color de todas las celdas del tablero principal.

                        for(int i = 0; i < 10; i++){

                            for(int j = 0; j < 10; j++){
                                matrizCelda[i][j].setBackground(Color.CYAN);
                                matrizCelda[i][j].addActionListener(escucha);
                            }

                        }
                        celdaSeleccionada1.setBackground(Color.CYAN);

                    }




                }


            }*/

        }
    }

    private class EscuchaFragatas implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {


            if(e.getSource() == fragatasBtn){
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


                celdaSeleccionada.removeActionListener(escucha);
                celdaSeleccionada.removeActionListener(escuchaFragatas);
                celdaSeleccionada.removeActionListener(escuchaDestructores);

                if (fragata01.getContador() == 1) {
                    modelBatalla.fragatas(fragatas, fila, columna, fragata01.getContador());
                    fragata01.setContador(0);celdaSeleccionada.setBackground(Color.RED);
                    //System.out.println("fragata01Contador="+fragata01.getContador()+"");
                } else if (fragata02.getContador() == 2) {
                    modelBatalla.fragatas(fragatas, fila, columna, fragata02.getContador());
                    fragata02.setContador(0);celdaSeleccionada.setBackground(Color.RED);
                    //System.out.println("fragata02Contador="+fragata02.getContador()+"");
                } else if (fragata03.getContador() == 3) {
                    modelBatalla.fragatas(fragatas, fila, columna, fragata03.getContador());
                    fragata03.setContador(0);celdaSeleccionada.setBackground(Color.RED);
                    //System.out.println("fragata03Contador="+fragata03.getContador()+"");
                } else if (fragata04.getContador() == 4) {
                    modelBatalla.fragatas(fragatas, fila, columna, fragata04.getContador());
                    fragata04.setContador(0);celdaSeleccionada.setBackground(Color.RED);

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
                    JOptionPane.showMessageDialog(null,
                            "Selecciona 3 destructores de 2 casillas cada una,\n"+
                            "DEBEN estar seguidas",

                            "PopUp Dialog",
                            JOptionPane.INFORMATION_MESSAGE);

                    for (int i = 0; i < 10; i++) {

                        for (int j = 0; j < 10; j++) {
                            matrizCelda[i][j].addActionListener(escuchaDestructores);
                        }
                    }

                }else{

                        Celda celdaSeleccionada = (Celda) e.getSource();
                        int fila = celdaSeleccionada.getFila() + 1;
                        int columna = celdaSeleccionada.getColumna() + 1;



                        switch (destructor01.getContador()){
                            case 1:
                                System.out.println("destructor01Contador=" + destructor01.getContador() + "");

                                modelBatalla.destructores(destructores, fila, columna, destructor01.getContador());
                                celdaSeleccionada.setBackground(Color.GREEN);

                                destructor01.setContador(2);
                                System.out.println("destructor01Contador=" + destructor01.getContador() + "");
                                break;
                            case 2:
                                System.out.println("destructor01Contador=" + destructor01.getContador() + "");
                                System.out.println("CASO 22222222222");
                                modelBatalla.destructores(destructores, fila, columna, destructor01.getContador());

                                boolean comparadorIgualdadFilas = modelBatalla.comparadorIgualdad(fila, destructor01.getFilasArray());
                                boolean comparadorSeguidosFilas = modelBatalla.comparadorSeguidos(destructor01.getFilasArray());
                                boolean comparadorIgualdadColumnas = modelBatalla.comparadorIgualdad(columna, destructor01.getColumnasArray());
                                boolean comparadorSeguidosColumnas = modelBatalla.comparadorSeguidos(destructor01.getColumnasArray());

                                destructor01.setContador(3);
                                modelBatalla.c2(comparadorIgualdadFilas, comparadorSeguidosColumnas, comparadorIgualdadColumnas, comparadorSeguidosFilas, matrizCelda, destructor01);
                                celdaSeleccionada.setBackground(Color.GREEN);
                                break;
                            case 3:
                                System.out.println("destructor01Contador=" + destructor01.getContador() + "");

                                System.out.println("AQUI ESTOYYYYYYYYYYYYYYYYYYY");

                                modelBatalla.destructores(destructores, fila, columna, destructor01.getContador());
                                celdaSeleccionada.setBackground(Color.GREEN);

                                destructor01.setContador(4);
                                System.out.println("destructor01111111111111111111Contador=" + destructor01.getContador() + "");
                                break;
                            case 4:
                                System.out.println("destructor01Contador=" + destructor01.getContador() + "");

                                System.out.println("SEBASSSSSSSSSSSSSSSSSSSSSSSS");

                                modelBatalla.destructores(destructores, fila, columna, destructor01.getContador());
                                boolean comparadorIgualdadFilas2 = modelBatalla.comparadorIgualdad(fila, destructor02.getFilasArray());
                                boolean comparadorSeguidosFilas2 = modelBatalla.comparadorSeguidos(destructor02.getFilasArray());
                                boolean comparadorIgualdadColumnas2 = modelBatalla.comparadorIgualdad(columna, destructor02.getColumnasArray());
                                boolean comparadorSeguidosColumnas2 = modelBatalla.comparadorSeguidos(destructor02.getColumnasArray());


                                celdaSeleccionada.setBackground(Color.GREEN);
                                destructor01.setContador(5);
                                modelBatalla.c2(comparadorIgualdadFilas2, comparadorSeguidosColumnas2, comparadorIgualdadColumnas2, comparadorSeguidosFilas2, matrizCelda, destructor01);
                                System.out.println("destructor02Contador=" + destructor01.getContador() + "");
                                break;
                            case 5:
                                System.out.println("destructor01Contador=" + destructor01.getContador() + "");

                                System.out.println("caso 5");

                                modelBatalla.destructores(destructores, fila, columna, destructor01.getContador());
                                celdaSeleccionada.setBackground(Color.GREEN);

                                destructor01.setContador(6);
                                System.out.println("destructor01111111111111111111Contador=" + destructor01.getContador() + "");
                                break;
                            case 6:
                                System.out.println("destructor01Contador=" + destructor01.getContador() + "");

                                System.out.println("caso 6");

                                modelBatalla.destructores(destructores, fila, columna, destructor01.getContador());
                                boolean comparadorIgualdadFilas3 = modelBatalla.comparadorIgualdad(fila, destructor03.getFilasArray());
                                boolean comparadorSeguidosFilas3 = modelBatalla.comparadorSeguidos(destructor03.getFilasArray());
                                boolean comparadorIgualdadColumnas3 = modelBatalla.comparadorIgualdad(columna, destructor03.getColumnasArray());
                                boolean comparadorSeguidosColumnas3 = modelBatalla.comparadorSeguidos(destructor03.getColumnasArray());


                                celdaSeleccionada.setBackground(Color.GREEN);
                                destructor01.setContador(0);
                                modelBatalla.c2(comparadorIgualdadFilas3, comparadorSeguidosColumnas3, comparadorIgualdadColumnas3, comparadorSeguidosFilas3, matrizCelda, destructor01);
                                System.out.println("destructor02Contador=" + destructor01.getContador() + "");

                                destructoresBtn.setEnabled(false);
                                submarinosBtn.setEnabled(true);
                                submarino01.setContador(1);
                                JOptionPane.showMessageDialog(null,
                                        "3 destructores seleccionadas correctamente\n"+
                                                "presiona el boton correspondiente de arriba",

                                        "PopUp Dialog",
                                        JOptionPane.INFORMATION_MESSAGE);

                                break;
                        }

                }
            }
        }

    private class EscuchaSubmarinos implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getSource() == submarinosBtn){
                JOptionPane.showMessageDialog(null,
                        "Selecciona 2 submarinos de 3 casillas cada una,\n"+
                                "DEBEN estar seguidas",

                        "PopUp Dialog",
                        JOptionPane.INFORMATION_MESSAGE);
                for (int i = 0; i < 10; i++) {

                    for (int j = 0; j < 10; j++) {
                        matrizCelda[i][j].addActionListener(escuchaSubmarinos);
                    }
                }
            }else{

                Celda celdaSeleccionada = (Celda) e.getSource();
                int fila = celdaSeleccionada.getFila() + 1;
                int columna = celdaSeleccionada.getColumna() + 1;



                switch (submarino01.getContador()){
                    case 1:
                        System.out.println("submarino01Contador=" + submarino01.getContador() + "");

                        modelBatalla.submarinos(submarinos, fila, columna, submarino01.getContador());
                        celdaSeleccionada.setBackground(Color.PINK);

                        submarino01.setContador(2);
                        System.out.println("submarino01Contador=" + submarino01.getContador() + "");
                        break;
                    case 2:
                        System.out.println("submarino01Contador=" + submarino01.getContador() + "");

                        modelBatalla.submarinos(submarinos, fila, columna, submarino01.getContador());
                        celdaSeleccionada.setBackground(Color.PINK);

                        submarino01.setContador(3);
                        System.out.println("submarino01Contador=" + submarino01.getContador() + "");
                        break;
                    case 3:
                        System.out.println("submarino01Contador=" + submarino01.getContador() + "");
                        System.out.println("CASO 22222222222");
                        modelBatalla.submarinos(submarinos, fila, columna, submarino01.getContador());

                        boolean comparadorIgualdadFilas = modelBatalla.comparadorIgualdad(fila, submarino01.getFilasArray());
                        boolean comparadorSeguidosFilas = modelBatalla.comparadorSeguidos(submarino01.getFilasArray());
                        boolean comparadorIgualdadColumnas = modelBatalla.comparadorIgualdad(columna, submarino01.getColumnasArray());
                        boolean comparadorSeguidosColumnas = modelBatalla.comparadorSeguidos(submarino01.getColumnasArray());

                        submarino01.setContador(4);
                        modelBatalla.c2(comparadorIgualdadFilas, comparadorSeguidosColumnas, comparadorIgualdadColumnas, comparadorSeguidosFilas, matrizCelda, submarino01);
                        celdaSeleccionada.setBackground(Color.PINK);
                        break;
                    case 4:
                        System.out.println("submarino01Contador=" + submarino01.getContador() + "");

                        modelBatalla.submarinos(submarinos, fila, columna, submarino01.getContador());
                        celdaSeleccionada.setBackground(Color.PINK);

                        submarino01.setContador(5);
                        System.out.println("submarino01Contador=" + submarino01.getContador() + "");
                        break;
                    case 5:
                        System.out.println("submarino01Contador=" + submarino01.getContador() + "");

                        System.out.println("SEBASSSSSSSSSSSSSSSSSSSSSSSS");

                        modelBatalla.submarinos(submarinos, fila, columna, submarino01.getContador());
                        boolean comparadorIgualdadFilas2 = modelBatalla.comparadorIgualdad(fila, submarino02.getFilasArray());
                        boolean comparadorSeguidosFilas2 = modelBatalla.comparadorSeguidos(submarino02.getFilasArray());
                        boolean comparadorIgualdadColumnas2 = modelBatalla.comparadorIgualdad(columna, submarino02.getColumnasArray());
                        boolean comparadorSeguidosColumnas2 = modelBatalla.comparadorSeguidos(submarino02.getColumnasArray());


                        celdaSeleccionada.setBackground(Color.PINK);
                        submarino01.setContador(6);
                        modelBatalla.c2(comparadorIgualdadFilas2, comparadorSeguidosColumnas2, comparadorIgualdadColumnas2, comparadorSeguidosFilas2, matrizCelda, submarino01);
                        System.out.println("submarino02Contador=" + submarino01.getContador() + "");
                        break;
                    case 6:
                        System.out.println("submarino01Contador=" + submarino01.getContador() + "");

                        System.out.println("SEBASSSSSSSSSSSSSSSSSSSSSSSS");

                        modelBatalla.submarinos(submarinos, fila, columna, submarino01.getContador());
                        boolean comparadorIgualdadFilas3 = modelBatalla.comparadorIgualdad(fila, submarino02.getFilasArray());
                        boolean comparadorSeguidosFilas3 = modelBatalla.comparadorSeguidos(submarino02.getFilasArray());
                        boolean comparadorIgualdadColumnas3 = modelBatalla.comparadorIgualdad(columna, submarino02.getColumnasArray());
                        boolean comparadorSeguidosColumnas3 = modelBatalla.comparadorSeguidos(submarino02.getColumnasArray());


                        celdaSeleccionada.setBackground(Color.PINK);

                        modelBatalla.c2(comparadorIgualdadFilas3, comparadorSeguidosColumnas3, comparadorIgualdadColumnas3, comparadorSeguidosFilas3, matrizCelda, submarino01);
                        System.out.println("submarino02Contador=" + submarino01.getContador() + "");

                        submarinosBtn.setEnabled(false);
                        portaavionesBtn.setEnabled(true);
                        submarino01.setContador(0);
                        JOptionPane.showMessageDialog(null,
                                "2 submarinos seleccionadas correctamente\n"+
                                        "presiona el boton correspondiente de arriba",

                                "PopUp Dialog",
                                JOptionPane.INFORMATION_MESSAGE);

                        break;


                }

            }
        }
    }

    private class EscuchaPortaavion implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == portaavionesBtn) {
                JOptionPane.showMessageDialog(null,
                        "Selecciona 1 portaavion de 4 casillas,\n" +
                                "DEBEN estar seguidas",

                        "PopUp Dialog",
                        JOptionPane.INFORMATION_MESSAGE);

                for (int i = 0; i < 10; i++) {

                    for (int j = 0; j < 10; j++) {
                        matrizCelda[i][j].addActionListener(escuchaPortaavion);
                    }
                }
            }else {

                Celda celdaSeleccionada1 = (Celda) e.getSource();
                celdaSeleccionada1.setBackground(Color.MAGENTA);
                celdaSeleccionada1.removeActionListener(escucha);


                int fila = celdaSeleccionada1.getFila() + 1;
                int columna = celdaSeleccionada1.getColumna() + 1;

                portaavion01.setFilasArray(fila);
                System.out.println(fila);

                portaavion01.setColumnasArray(columna);


                if (portaavion01.getContador() == 4) {

                    boolean comparadorIgualdadFilas = modelBatalla.comparadorIgualdad(fila, portaavion01.getFilasArray());
                    boolean comparadorSeguidosFilas = modelBatalla.comparadorSeguidos(portaavion01.getFilasArray());
                    boolean comparadorIgualdadColumnas = modelBatalla.comparadorIgualdad(columna, portaavion01.getColumnasArray());
                    boolean comparadorSeguidosColumnas = modelBatalla.comparadorSeguidos(portaavion01.getColumnasArray());


                    modelBatalla.c2(comparadorIgualdadFilas, comparadorSeguidosColumnas, comparadorIgualdadColumnas, comparadorSeguidosFilas, matrizCelda, portaavion01);
                    fragatasBtn.setVisible(false);
                    destructoresBtn.setVisible(false);
                    submarinosBtn.setVisible(false);
                    portaavionesBtn.setVisible(false);
                    empezarJuego.setVisible(true);


                    JOptionPane.showMessageDialog(null,
                            "1 portaavion seleccionado correctamente\n"+
                                    "presiona el boton correspondiente de arriba",

                            "PopUp Dialog",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }

        }


    }
}

