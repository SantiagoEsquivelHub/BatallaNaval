package myProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ModelBatalla {


    public boolean comparadorIgualdad(int numero, ArrayList<Integer> array) {

        int contador = 0;

        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) == numero) {
                contador++;
                System.out.println("ContadorIgualdad"+contador+"");
            }
        }

        if(contador == array.size()){
            return true;
        }else{
            return false;
        }

    }

    public boolean comparadorSeguidos(ArrayList<Integer> array) {

        int contador = 0;



            for (int i = 0; i < array.size(); i++) {
                int numSig = i+1;
                if(numSig < array.size()){

                    System.out.println("numSig= "+numSig+"");

                    if ((array.get(numSig) - array.get(i)) == 1){
                    contador++;
                    System.out.println("Cuantos num estan seguidos= "+contador+"");
                    }

                }

            }

           if(contador == array.size()-1){
                return true;
            }else{
                return false;
            }

    }


    public void c (boolean igualdadFilas, boolean seguidosColumnas, boolean igualdadColumnas, boolean seguidosFilas, Celda[][] matrizCelda, Barco portaavion01) {
        if (portaavion01.getContador() == 4) {
            if ((igualdadFilas && seguidosColumnas) || (igualdadColumnas && seguidosFilas)){
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
              /*  for (int i = 0; i < 10; i++) {

                    for (int j = 0; j < 10; j++) {
                        matrizCelda[i][j].setBackground(Color.CYAN);

                        //matrizCelda[i][j].addActionListener(escucha);
                    }

                }*/

            }

        }
    }


    public void c2 (boolean igualdadFilas, boolean seguidosColumnas, boolean igualdadColumnas, boolean seguidosFilas, Celda[][] matrizCelda, Barco destructor01) {
        //if (destructor01.getContador() == 2) {
            if ((igualdadFilas && seguidosColumnas) || (igualdadColumnas && seguidosFilas)){
                System.out.println("1 celda seleccionada");

            } else {
                JOptionPane.showMessageDialog(null,
                        "Repite la seleccion del destructor",

                        "PopUp Dialog",
                        JOptionPane.INFORMATION_MESSAGE);


            }

        //}
    }



    public void fragatas (ArrayList<Barco> barcos, int fila, int columna, int contador) {

        if(contador == 1){
            barcos.get(0).setFilasArray(fila);
            System.out.println("Fila fragata01= "+fila+"");
            barcos.get(0).setColumnasArray(columna);
            System.out.println("Columna fragata01= "+columna+"");
        }else if(contador == 2){
            barcos.get(1).setFilasArray(fila);
            System.out.println("Fila fragata02= "+fila+"");
            barcos.get(1).setColumnasArray(columna);
            System.out.println("Columna fragata02= "+columna+"");
        }else if(contador == 3){
            barcos.get(2).setFilasArray(fila);
            System.out.println("Fila fragata03= "+fila+"");
            barcos.get(2).setColumnasArray(columna);
            System.out.println("Columna fragata03= "+columna+"");
        }else if(contador == 4){
            barcos.get(3).setFilasArray(fila);
            System.out.println("Fila fragata04= "+fila+"");
            barcos.get(3).setColumnasArray(columna);
            System.out.println("Columna fragata04= "+columna+"");
        }

        }

    public void destructores (ArrayList<Barco> barcos, int fila, int columna, int contador) {

        if(contador == 1 || contador == 2){
            barcos.get(0).setFilasArray(fila);
            System.out.println("Fila destructor01= "+fila+"");
            barcos.get(0).setColumnasArray(columna);
            System.out.println("Columna destructor01= "+columna+"");
        }else if(contador == 3 || contador == 4){
            barcos.get(1).setFilasArray(fila);
            System.out.println("Fila destructor02= "+fila+"");
            barcos.get(1).setColumnasArray(columna);
            System.out.println("Columna destructor02= "+columna+"");
        }else if(contador == 5 || contador == 6){
            barcos.get(2).setFilasArray(fila);
            System.out.println("Fila destructor03= "+fila+"");
            barcos.get(2).setColumnasArray(columna);
            System.out.println("Columna destructor03= "+columna+"");
        }

    }

    public void submarinos(ArrayList<Barco> barcos, int fila, int columna, int contador) {

        if(contador == 1 || contador == 2 || contador == 3 ){
            barcos.get(0).setFilasArray(fila);
            System.out.println("Fila submarino01= "+fila+"");
            barcos.get(0).setColumnasArray(columna);
            System.out.println("Columna submarino01= "+columna+"");
        }else if(contador == 4 || contador == 5 || contador == 6){
            barcos.get(1).setFilasArray(fila);
            System.out.println("Fila submarino02= "+fila+"");
            barcos.get(1).setColumnasArray(columna);
            System.out.println("Columna submarino02= "+columna+"");
        }

    }

    }



