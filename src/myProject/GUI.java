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
    private static Escucha escucha;
    private ModelBatalla modelBatalla;
    private ImageIcon imagenBienvenida;
    private JLabel bienvenida, imagen;
    private JPanel panelBienvenido, tableroPosicion, tableroPrincipal;
    private Celda[][] matrizCelda = new Celda[10][10];
    private JButton guiaJuego, jugar;

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
        modelBatalla = new ModelBatalla();
        portaavion01 = new Barco(0);
        submarino01 = new Barco(0);
        submarino02 = new Barco(0);
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

        guiaJuego = new JButton("Guia de juego");
        guiaJuego.addActionListener(escucha);
        constraints.gridx=1;
        constraints.gridy=1;
        constraints.gridwidth = 1;
        panelBienvenido.add(guiaJuego, constraints);

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


            if(e.getSource() == guiaJuego){
                JOptionPane.showMessageDialog(null,
                        MENSAJE_GUIA,

                        "PopUp Dialog",
                        JOptionPane.INFORMATION_MESSAGE);
            }else if(e.getSource() == jugar){
                jugar.removeActionListener(escucha);
                imagen.setVisible(false);
                JOptionPane.showMessageDialog(null,
                        "Selecciona 4 fragatas ",

                        "PopUp Dialog",
                        JOptionPane.INFORMATION_MESSAGE);

                for(int i = 0; i < 10; i++){

                    for(int j = 0; j < 10; j++){
                        matrizCelda[i][j].addActionListener(escucha);
                    }
                }

            }else if(destructor01.getContador() == 1 || destructor01.getContador() == 2){

                Celda celdaSeleccionada = (Celda)e.getSource();
                int fila = celdaSeleccionada.getFila()+1;
                int columna = celdaSeleccionada.getColumna()+1;

                if(destructor01.getContador() == 1){

                    System.out.println("destructor01Contador="+destructor01.getContador()+"");

                    modelBatalla.destructores(destructores, fila, columna, destructor01.getContador());
                    celdaSeleccionada.setBackground(Color.GREEN);

                    destructor01.setContador(2);
                    System.out.println("destructor01Contador="+destructor01.getContador()+"");

                }else  if( destructor01.getContador() == 2){

                    System.out.println("destructor01Contador="+destructor01.getContador()+"");

                    modelBatalla.destructores(destructores, fila, columna, destructor02.getContador());

                    boolean comparadorIgualdadFilas = modelBatalla.comparadorIgualdad(fila,destructor01.getFilasArray());
                    boolean comparadorSeguidosFilas = modelBatalla.comparadorSeguidos(destructor01.getFilasArray());
                    boolean comparadorIgualdadColumnas = modelBatalla.comparadorIgualdad(columna,destructor01.getColumnasArray());
                    boolean comparadorSeguidosColumnas = modelBatalla.comparadorSeguidos(destructor01.getColumnasArray());


                    modelBatalla.c2(comparadorIgualdadFilas,comparadorSeguidosColumnas,comparadorIgualdadColumnas,comparadorSeguidosFilas, matrizCelda, destructor01);
                    celdaSeleccionada.setBackground(Color.GREEN);


                }/*else if(destructor02.getContador() == 3 || destructor01.getContador() == 4){
                    modelBatalla.destructores(destructores, fila, columna, destructor02.getContador());
                    destructor02.setContador(0);
                    System.out.println("destructor02Contador="+destructor02.getContador()+"");
                }else if(destructor03.getContador() == 6 || destructor01.getContador() == 1){
                    modelBatalla.destructores(destructores, fila, columna, destructor03.getContador());
                    destructor03.setContador(4);

                    System.out.println("destructor03Contador="+destructor03.getContador()+"");

                    JOptionPane.showMessageDialog(null,
                            "3 destructores seleccionadas correctamente,\n" +
                                    "ahora selecciona 2 submarinos de 3 casillas cada uno",

                            "PopUp Dialog",
                            JOptionPane.INFORMATION_MESSAGE);

                }*/
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
            else{
/*
                Celda celdaSeleccionada = (Celda)e.getSource();
                int fila = celdaSeleccionada.getFila()+1;
                int columna = celdaSeleccionada.getColumna()+1;

                portaavion01.setFilasArray(fila);
                //System.out.println(fila);
                portaavion01.setColumnasArray(columna);

                boolean comparadorIgualdadFilas = modelBatalla.comparadorIgualdad(fila,portaavion01.getFilasArray());
                boolean comparadorSeguidosFilas = modelBatalla.comparadorSeguidos(portaavion01.getFilasArray());
                boolean comparadorIgualdadColumnas = modelBatalla.comparadorIgualdad(columna,portaavion01.getColumnasArray());
                boolean comparadorSeguidosColumnas = modelBatalla.comparadorSeguidos(portaavion01.getColumnasArray());

                modelBatalla.c(comparadorIgualdadFilas,comparadorSeguidosColumnas,comparadorIgualdadColumnas,comparadorSeguidosFilas, matrizCelda, portaavion01);

                fila = 0;
                columna = 0;

                submarino01.setFilasArray(fila);
                //System.out.println(fila);
                submarino01.setColumnasArray(columna);

                boolean comparadorIgualdadFilas2 = modelBatalla.comparadorIgualdad(fila,submarino01.getFilasArray());
                boolean comparadorSeguidosFilas2 = modelBatalla.comparadorSeguidos(submarino01.getFilasArray());
                boolean comparadorIgualdadColumnas2 = modelBatalla.comparadorIgualdad(columna,submarino01.getColumnasArray());
                boolean comparadorSeguidosColumnas2 = modelBatalla.comparadorSeguidos(submarino01.getColumnasArray());

                modelBatalla.c2(comparadorIgualdadFilas2,comparadorSeguidosColumnas2,comparadorIgualdadColumnas2,comparadorSeguidosFilas2, matrizCelda, submarino01);
*/

                Celda celdaSeleccionada = (Celda)e.getSource();
                int fila = celdaSeleccionada.getFila()+1;
                int columna = celdaSeleccionada.getColumna()+1;


                    if(fragata01.getContador() == 1){
                        modelBatalla.fragatas(fragatas, fila, columna, fragata01.getContador());
                        fragata01.setContador(0);
                        //System.out.println("fragata01Contador="+fragata01.getContador()+"");
                    }else if(fragata02.getContador() == 2){
                        modelBatalla.fragatas(fragatas, fila, columna, fragata02.getContador());
                        fragata02.setContador(0);
                        //System.out.println("fragata02Contador="+fragata02.getContador()+"");
                    }else if(fragata03.getContador() == 3){
                        modelBatalla.fragatas(fragatas, fila, columna, fragata03.getContador());
                        fragata03.setContador(0);
                        //System.out.println("fragata03Contador="+fragata03.getContador()+"");
                    }else if(fragata04.getContador() == 4){
                        modelBatalla.fragatas(fragatas, fila, columna, fragata04.getContador());
                        fragata04.setContador(0);

                        destructor01.setContador(1);
                        destructor02.setContador(3);
                        destructor03.setContador(5);

                        //System.out.println("fragata04Contador="+fragata04.getContador()+"");

                        JOptionPane.showMessageDialog(null,
                                "4 fragatas seleccionadas correctamente,\n" +
                                        "ahora selecciona 3 destructores de 2 casillas cada uno",

                                "PopUp Dialog",
                                JOptionPane.INFORMATION_MESSAGE);


                    }








                   /* Celda celdaSeleccionada2 = (Celda)e.getSource();
                    int fila2 = celdaSeleccionada2.getFila()+1;
                    int columna2= celdaSeleccionada2.getColumna()+1;

                    modelBatalla.fragata(fragata02, fila2, columna2);*/









                celdaSeleccionada.setBackground(Color.YELLOW);
                celdaSeleccionada.removeActionListener(escucha);



               /* if(e.getSource() == submarino) {

                    if (submarino01.getContador() == 3) {


                        boolean comparadorIgualdadFilas = modelBatalla.comparadorIgualdad(fila, submarino01.getFilasArray());
                        boolean comparadorSeguidosFilas = modelBatalla.comparadorSeguidos(submarino01.getFilasArray());
                        boolean comparadorIgualdadColumnas = modelBatalla.comparadorIgualdad(columna, submarino01.getColumnasArray());
                        boolean comparadorSeguidosColumnas = modelBatalla.comparadorSeguidos(submarino01.getColumnasArray());

                        if ((comparadorIgualdadFilas && comparadorSeguidosColumnas) || (comparadorIgualdadColumnas && comparadorSeguidosFilas)) {
                            System.out.println("4 celdas seleccionadas");
                            JOptionPane.showMessageDialog(null,
                                    "Posiciones del portaaviones registrada,\n" +
                                            "ahora elige las posiciones de los 2 submarinos ",

                                    "PopUp Dialog",
                                    JOptionPane.INFORMATION_MESSAGE);

                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "Repite la seleccion del portaaviones",

                                    "PopUp Dialog",
                                    JOptionPane.INFORMATION_MESSAGE);

                            //Se reinicia el color de todas las celdas del tablero principal.

                            for (int i = 0; i < 10; i++) {

                                for (int j = 0; j < 10; j++) {
                                    matrizCelda[i][j].setBackground(Color.CYAN);
                                    matrizCelda[i][j].addActionListener(escucha);
                                }

                            }
                            celdaSeleccionada.setBackground(Color.CYAN);

                        }

                    }

                }
*/







                  /*  for(int i = 0; i < portaavion01.getFilasArray().size(); i++){

                        System.out.println("Fila arreglo malo:"+portaavion01.getFilasArray().get(i)+"");
                        portaavion01.getFilasArray().remove(portaavion01.getFilasArray().get(i));
                        //System.out.println("Tamano arreglo malo:"+portaavion01.getFilasArray().size()+"");
                    }*/





                /*else{

                    JOptionPane.showMessageDialog(null,
                            "Selecciona de nuevo",

                            "PopUp Dialog",
                            JOptionPane.INFORMATION_MESSAGE);
                }*/



}

               /*JOptionPane.showMessageDialog(null,
                        "Fila: "+fila+", Columna: "+columna+"",

                        "PopUp Dialog",
                        JOptionPane.INFORMATION_MESSAGE);*/
            }

        }
    }

