package myProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is used for ...
 * @autor Paola-J Rodriguez-C paola.rodriguez@correounivalle.edu.co
 * @version v.1.0.0 date:21/11/2021
 */
public class GUI extends JFrame {

    private Header headerProject;
    private Escucha escucha;
    private ModelBatalla modelBatalla;
    private ImageIcon imagenBienvenida;
    private JLabel bienvenida, imagen;
    private JPanel panelBienvenido, tableroPosicion, tableroPrincipal;
    private Celda[][] matrizCelda = new Celda[10][10];
    private JButton guiaJuego, jugar;

    private Barco fragata01, fragata02, fragata03, fragata04,submarino01,submarino02,portaavion01,destructor01, destructor02, destructor03;


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
        fragata01 = new Barco(0);
        fragata02 = new Barco(0);
        fragata03 = new Barco(0);
        fragata04 = new Barco(0);


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
        panelBienvenido.add(imagen, constraints);

/*
        tableroPosicion = new JPanel();
        tableroPosicion.setLayout(new GridLayout(11,11));
        tableroPosicion.setVisible(false);
        this.add(tableroPosicion);*/


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
                        GUIA_PORTAAVIONES,

                        "PopUp Dialog",
                        JOptionPane.INFORMATION_MESSAGE);

                for(int i = 0; i < 10; i++){

                    for(int j = 0; j < 10; j++){
                        matrizCelda[i][j].addActionListener(escucha);
                    }
                }

            }else{

                Celda celdaSeleccionada = (Celda)e.getSource();

                int fila = celdaSeleccionada.getFila()+1;
                int columna = celdaSeleccionada.getColumna()+1;

                if(modelBatalla.comparadorFilas(fila,portaavion01.getFilasArray())){

                    System.out.println("Funciona");

                }

                portaavion01.setFilasArray(fila);
                System.out.println(portaavion01.getContador()+" valor contador");
                portaavion01.setColumnasArray(columna);

                if(portaavion01.getContador() == 4 ) {
                    System.out.println("4 celdas seleccionadas");
                    JOptionPane.showMessageDialog(null,
                        "Posiciones del portaaviones registrada,\n" +
                                "ahora elige las posiciones de los 2 submarinos ",

                        "PopUp Dialog",
                        JOptionPane.INFORMATION_MESSAGE);

                }


                celdaSeleccionada.setBackground(Color.YELLOW);
                celdaSeleccionada.removeActionListener(escucha);
}

               /*JOptionPane.showMessageDialog(null,
                        "Fila: "+fila+", Columna: "+columna+"",

                        "PopUp Dialog",
                        JOptionPane.INFORMATION_MESSAGE);*/
            }

        }
    }

