package myProject;

import javax.swing.*;
import java.awt.*;

/**
 * This class is used for ...
 * @autor Paola-J Rodriguez-C paola.rodriguez@correounivalle.edu.co
 * @version v.1.0.0 date:21/11/2021
 */
public class GUI extends JFrame {

    private Header headerProject;
    private Escucha escucha;
    private JPanel tableroPosicion, tableroPrincipal;
    private JLabel tableroPosicionTitulo,tableroPrincipalTitulo;
    private Celda celdaA1, celdaA2, celdaA3, celdaA4, celdaA5, celdaA6, celdaA7, celdaA8, celdaA9, celdaA10,
                    celdaB1, celdaB2, celdaB3, celdaB4, celdaB5, celdaB6, celdaB7, celdaB8, celdaB9, celdaB10,
                    celdaC1, celdaC2, celdaC3, celdaC4, celdaC5, celdaC6, celdaC7, celdaC8, celdaC9, celdaC10,
                    celdaD1, celdaD2, celdaD3, celdaD4, celdaD5, celdaD6, celdaD7, celdaD8, celdaD9, celdaD10,
                    celdaE1, celdaE2, celdaE3, celdaE4, celdaE5, celdaE6, celdaE7, celdaE8, celdaE9, celdaE10,
                    celdaF1, celdaF2, celdaF3, celdaF4, celdaF5, celdaF6, celdaF7, celdaF8, celdaF9, celdaF10,
                    celdaG1, celdaG2, celdaG3, celdaG4, celdaG5, celdaG6, celdaG7, celdaG8, celdaG9, celdaG10,
                    celdaH1, celdaH2, celdaH3, celdaH4, celdaH5, celdaH6, celdaH7, celdaH8, celdaH9, celdaH10,
                    celdaI1, celdaI2, celdaI3, celdaI4, celdaI5, celdaI6, celdaI7, celdaI8, celdaI9, celdaI10,
                    celdaJ1, celdaJ2, celdaJ3, celdaJ4, celdaJ5, celdaJ6, celdaJ7, celdaJ8, celdaJ9, celdaJ10;
    private JButton celdaA, celdaB, celdaC, celdaD, celdaE, celdaF, celdaG, celdaH, celdaI, celdaJ,
                    celda, celda1, celda2, celda3, celda4, celda5, celda6, celda7, celda8, celda9, celda10;

    ;

    /**
     * Constructor of GUI class
     */
    public GUI(){
        initGUI();

        //Default JFrame configuration
        this.setTitle("Batalla Naval");
        this.setSize(1200,700);
        //this.pack();
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
        //Set up JComponents
        headerProject = new Header("Batalla Naval", Color.BLACK);

        tableroPosicion = new JPanel();
        tableroPosicion.setLayout(new GridLayout(11,11));
        this.add(tableroPosicion,BorderLayout.WEST);

        tableroPrincipal= new JPanel();
        tableroPrincipal.setLayout(new GridLayout(11,11));
        this.add(tableroPrincipal,BorderLayout.EAST);



        celdaA1 = new Celda("", "A",1);
        celdaA2 = new Celda("","A",2);
        celdaA3 = new Celda("","A",3);
        celdaA4 = new Celda("","A",4);
        celdaA5 = new Celda("","A",5);
        celdaA6 = new Celda("","A",6);
        celdaA7 = new Celda("","A",7);
        celdaA8 = new Celda("","A",8);
        celdaA9 = new Celda("","A",9);
        celdaA10 = new Celda("","A",10);

        celdaB1 = new Celda("","B",1);
        celdaB2 = new Celda("","B",2);
        celdaB3 = new Celda("","B",3);
        celdaB4 = new Celda("","B",4);
        celdaB5 = new Celda("","B",5);
        celdaB6 = new Celda("","B",6);
        celdaB7 = new Celda("","B",7);
        celdaB8 = new Celda("","B",8);
        celdaB9 = new Celda("","B",9);
        celdaB10 = new Celda("","B",10);

        celdaC1 = new Celda("","C",1);
        celdaC2 = new Celda("","C",2);
        celdaC3 = new Celda("","C",3);
        celdaC4 = new Celda("","C",4);
        celdaC5 = new Celda("","C",5);
        celdaC6 = new Celda("","C",6);
        celdaC7 = new Celda("","C",7);
        celdaC8 = new Celda("","C",8);
        celdaC9 = new Celda("","C",9);
        celdaC10 = new Celda("","C",10);

        celdaD1 = new Celda("","D",1);
        celdaD2 = new Celda("","D",2);
        celdaD3 = new Celda("","D",3);
        celdaD4 = new Celda("","D",4);
        celdaD5 = new Celda("","D",5);
        celdaD6 = new Celda("","D",6);
        celdaD7 = new Celda("","D",7);
        celdaD8 = new Celda("","D",8);
        celdaD9 = new Celda("","D",9);
        celdaD10 = new Celda("","D",10);

        celdaE1 = new Celda("","E",1);
        celdaE2 = new Celda("","E",2);
        celdaE3 = new Celda("","E",3);
        celdaE4 = new Celda("","E",4);
        celdaE5 = new Celda("","E",5);
        celdaE6 = new Celda("","E",6);
        celdaE7 = new Celda("","E",7);
        celdaE8 = new Celda("","E",8);
        celdaE9 = new Celda("","E",9);
        celdaE10 = new Celda("","E",10);

        celdaF1 = new Celda("","F",1);
        celdaF2 = new Celda("","F",2);
        celdaF3 = new Celda("","F",3);
        celdaF4 = new Celda("","F",4);
        celdaF5 = new Celda("","F",5);
        celdaF6 = new Celda("","F",6);
        celdaF7 = new Celda("","F",7);
        celdaF8 = new Celda("","F",8);
        celdaF9 = new Celda("","F",9);
        celdaF10 = new Celda("","F",10);

        celdaG1 = new Celda("","G",1);
        celdaG2 = new Celda("","G",2);
        celdaG3 = new Celda("","G",3);
        celdaG4 = new Celda("","G",4);
        celdaG5 = new Celda("","G",5);
        celdaG6 = new Celda("","G",6);
        celdaG7 = new Celda("","G",7);
        celdaG8 = new Celda("","G",8);
        celdaG9 = new Celda("","G",9);
        celdaG10 = new Celda("","G",10);

        celdaH1 = new Celda("","H",1);
        celdaH2 = new Celda("","H",2);
        celdaH3 = new Celda("","H",3);
        celdaH4 = new Celda("","H",4);
        celdaH5 = new Celda("","H",5);
        celdaH6 = new Celda("","H",6);
        celdaH7 = new Celda("","H",7);
        celdaH8 = new Celda("","H",8);
        celdaH9 = new Celda("","H",9);
        celdaH10 = new Celda("","H",10);

        celdaI1 = new Celda("","I",1);
        celdaI2 = new Celda("","I",2);
        celdaI3 = new Celda("","I",3);
        celdaI4 = new Celda("","I",4);
        celdaI5 = new Celda("","I",5);
        celdaI6 = new Celda("","I",6);
        celdaI7 = new Celda("","I",7);
        celdaI8 = new Celda("","I",8);
        celdaI9 = new Celda("","I",9);
        celdaI10 = new Celda("","I",10);

        celdaJ1 = new Celda("","J",1);
        celdaJ2 = new Celda("","J",2);
        celdaJ3 = new Celda("","J",3);
        celdaJ4 = new Celda("","J",4);
        celdaJ5 = new Celda("","J",5);
        celdaJ6 = new Celda("","J",6);
        celdaJ7 = new Celda("","J",7);
        celdaJ8 = new Celda("","J",8);
        celdaJ9 = new Celda("","J",9);
        celdaJ10 = new Celda("","J",10);

        celda = new JButton("");
        celda1 = new JButton("1");
        celda2 = new JButton("2");
        celda3 = new JButton("3");
        celda4 = new JButton("4");
        celda5 = new JButton("5");
        celda6 = new JButton("6");
        celda7 = new JButton("7");
        celda8 = new JButton("8");
        celda9 = new JButton("9");
        celda10 = new JButton("10");

        celdaA = new JButton("A");
        celdaB = new JButton("B");
        celdaC = new JButton("C");
        celdaD = new JButton("D");
        celdaE = new JButton("E");
        celdaF = new JButton("F");
        celdaG = new JButton("G");
        celdaH = new JButton("H");
        celdaI = new JButton("I");
        celdaJ = new JButton("J");


        tableroPrincipal.add(celda);
        tableroPrincipal.add(celdaA);
        tableroPrincipal.add(celdaB);
        tableroPrincipal.add(celdaC);
        tableroPrincipal.add(celdaD);
        tableroPrincipal.add(celdaE);
        tableroPrincipal.add(celdaF);
        tableroPrincipal.add(celdaG);
        tableroPrincipal.add(celdaH);
        tableroPrincipal.add(celdaI);
        tableroPrincipal.add(celdaJ);


        tableroPrincipal.add(celda1);
        tableroPrincipal.add(celdaA1);
        tableroPrincipal.add(celdaA2);
        tableroPrincipal.add(celdaA3);
        tableroPrincipal.add(celdaA4);
        tableroPrincipal.add(celdaA5);
        tableroPrincipal.add(celdaA6);
        tableroPrincipal.add(celdaA7);
        tableroPrincipal.add(celdaA8);
        tableroPrincipal.add(celdaA9);
        tableroPrincipal.add(celdaA10);

        tableroPrincipal.add(celda2);
        tableroPrincipal.add(celdaB1);
        tableroPrincipal.add(celdaB2);
        tableroPrincipal.add(celdaB3);
        tableroPrincipal.add(celdaB4);
        tableroPrincipal.add(celdaB5);
        tableroPrincipal.add(celdaB6);
        tableroPrincipal.add(celdaB7);
        tableroPrincipal.add(celdaB8);
        tableroPrincipal.add(celdaB9);
        tableroPrincipal.add(celdaB10);

        tableroPrincipal.add(celda3);
        tableroPrincipal.add(celdaC1);
        tableroPrincipal.add(celdaC2);
        tableroPrincipal.add(celdaC3);
        tableroPrincipal.add(celdaC4);
        tableroPrincipal.add(celdaC5);
        tableroPrincipal.add(celdaC6);
        tableroPrincipal.add(celdaC7);
        tableroPrincipal.add(celdaC8);
        tableroPrincipal.add(celdaC9);
        tableroPrincipal.add(celdaC10);

        tableroPrincipal.add(celda4);
        tableroPrincipal.add(celdaD1);
        tableroPrincipal.add(celdaD2);
        tableroPrincipal.add(celdaD3);
        tableroPrincipal.add(celdaD4);
        tableroPrincipal.add(celdaD5);
        tableroPrincipal.add(celdaD6);
        tableroPrincipal.add(celdaD7);
        tableroPrincipal.add(celdaD8);
        tableroPrincipal.add(celdaD9);
        tableroPrincipal.add(celdaD10);

        tableroPrincipal.add(celda5);
        tableroPrincipal.add(celdaE1);
        tableroPrincipal.add(celdaE2);
        tableroPrincipal.add(celdaE3);
        tableroPrincipal.add(celdaE4);
        tableroPrincipal.add(celdaE5);
        tableroPrincipal.add(celdaE6);
        tableroPrincipal.add(celdaE7);
        tableroPrincipal.add(celdaE8);
        tableroPrincipal.add(celdaE9);
        tableroPrincipal.add(celdaE10);

        tableroPrincipal.add(celda6);
        tableroPrincipal.add(celdaF1);
        tableroPrincipal.add(celdaF2);
        tableroPrincipal.add(celdaF3);
        tableroPrincipal.add(celdaF4);
        tableroPrincipal.add(celdaF5);
        tableroPrincipal.add(celdaF6);
        tableroPrincipal.add(celdaF7);
        tableroPrincipal.add(celdaF8);
        tableroPrincipal.add(celdaF9);
        tableroPrincipal.add(celdaF10);

        tableroPrincipal.add(celda7);
        tableroPrincipal.add(celdaG1);
        tableroPrincipal.add(celdaG2);
        tableroPrincipal.add(celdaG3);
        tableroPrincipal.add(celdaG4);
        tableroPrincipal.add(celdaG5);
        tableroPrincipal.add(celdaG6);
        tableroPrincipal.add(celdaG7);
        tableroPrincipal.add(celdaG8);
        tableroPrincipal.add(celdaG9);
        tableroPrincipal.add(celdaG10);

        tableroPrincipal.add(celda8);
        tableroPrincipal.add(celdaH1);
        tableroPrincipal.add(celdaH2);
        tableroPrincipal.add(celdaH3);
        tableroPrincipal.add(celdaH4);
        tableroPrincipal.add(celdaH5);
        tableroPrincipal.add(celdaH6);
        tableroPrincipal.add(celdaH7);
        tableroPrincipal.add(celdaH8);
        tableroPrincipal.add(celdaH9);
        tableroPrincipal.add(celdaH10);

        tableroPrincipal.add(celda9);
        tableroPrincipal.add(celdaI1);
        tableroPrincipal.add(celdaI2);
        tableroPrincipal.add(celdaI3);
        tableroPrincipal.add(celdaI4);
        tableroPrincipal.add(celdaI5);
        tableroPrincipal.add(celdaI6);
        tableroPrincipal.add(celdaI7);
        tableroPrincipal.add(celdaI8);
        tableroPrincipal.add(celdaI9);
        tableroPrincipal.add(celdaI10);

        tableroPrincipal.add(celda10);
        tableroPrincipal.add(celdaJ1);
        tableroPrincipal.add(celdaJ2);
        tableroPrincipal.add(celdaJ3);
        tableroPrincipal.add(celdaJ4);
        tableroPrincipal.add(celdaJ5);
        tableroPrincipal.add(celdaJ6);
        tableroPrincipal.add(celdaJ7);
        tableroPrincipal.add(celdaJ8);
        tableroPrincipal.add(celdaJ9);
        tableroPrincipal.add(celdaJ10);



      /*  tableroPrincipal.add(celda1);
        tableroPrincipal.add(celda2);
        tableroPrincipal.add(celda3);
        tableroPrincipal.add(celda4);
        tableroPrincipal.add(celda5);
        tableroPrincipal.add(celda6);
        tableroPrincipal.add(celda7);
        tableroPrincipal.add(celda8);
        tableroPrincipal.add(celda9);
        tableroPrincipal.add(celda10);*/




        tableroPosicionTitulo = new JLabel();
        tableroPosicionTitulo.setText("Tablero Posicion");
        //tableroPosicion.add(tableroPosicionTitulo);

        tableroPrincipalTitulo = new JLabel();
        tableroPrincipalTitulo.setText("Tablero Principal");
        //tableroPrincipal.add(tableroPrincipalTitulo);



        this.add(headerProject,BorderLayout.NORTH); //Change this line if you change JFrame Container's Layout
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
    private class Escucha {

    }
}
