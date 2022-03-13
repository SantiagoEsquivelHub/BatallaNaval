package myProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static java.awt.Color.*;


public class ModelBatalla {
int error= 2;
Rival rival = new Rival();

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public boolean comparadorIgualdad(int numero, ArrayList<Integer> array) {

        int contador = 0;

        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) == numero) {
                contador++;
                //System.out.println("ContadorIgualdad"+contador+"");
            }
        }

        if(contador == array.size()){
            return true;
        }else{
            return false;
        }

    }

    public boolean comparadorSeguidos(ArrayList<Integer> array) {

        Collections.sort(array);
        int contador = 0;


            for (int i = 0; i < array.size(); i++) {
                int numSig = i+1;
                if(numSig < array.size()){

                    //System.out.println("numSig= "+numSig+"");

                    if ((array.get(numSig) - array.get(i)) == 1){
                    contador++;
                    //System.out.println("Cuantos num estan seguidos= "+contador+"");
                    }

                }

            }

           if(contador == array.size()-1){
                return true;
            }else{
                return false;
            }

    }


    public boolean comparador (boolean igualdadFilas, boolean seguidosColumnas, boolean igualdadColumnas, boolean seguidosFilas, Celda[][] matrizCelda, ArrayList<Celda> celditas, ActionListener escucha) {
        //if (destructor01.getContador() == 2) {
            if ((igualdadFilas && seguidosColumnas) || (igualdadColumnas && seguidosFilas)){
                //System.out.println("1 celda seleccionada");
            return true;
            } else {
                error--;
                JOptionPane.showMessageDialog(null,
                        "Repite la seleccion del destructor\n" +
                                "te quedan "+getError()+" intento, al llegar a 0 se cierra el juego",

                        "PopUp Dialog",
                        JOptionPane.INFORMATION_MESSAGE);


                    if(error == 0){
                        setError(2);
                        System. exit(0);
                    }

                    resetCelda(matrizCelda,celditas,escucha);
                    celditas.clear();
                return false;
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


    public Celda[][] resetCelda( Celda[][] matrizCelda, ArrayList<Celda> miCelda, ActionListener escucha){

        for(int i = 0; i < miCelda.size(); i++){
            int fila = miCelda.get(i).getFila();
            int columna = miCelda.get(i).getColumna();
            matrizCelda[fila][columna].setBackground(Color.cyan);
             matrizCelda[fila][columna].addActionListener(escucha);
        }
        return matrizCelda;
    }

    public Celda[][] eliminarEscuchasAnteriores( Celda[][] matrizCelda, ArrayList<Celda> misCeldas, ActionListener escucha){
        for(int i = 0; i < misCeldas.size(); i++){
            int fila = misCeldas.get(i).getFila();
            int columna = misCeldas.get(i).getColumna();
            matrizCelda[fila][columna].removeActionListener(escucha);
            System.out.println("SE QUITARON TODOS LOS ESCUCHAS");
        }
        return matrizCelda;
    }



    public Celda[][]  fragatasAleatorias(Celda[][] matrizCeldaRival, ArrayList<Celda> celdasRival) {

            Random aleatorio = new Random();
            int fila = aleatorio.nextInt(9);
            int columna = aleatorio.nextInt(9);

        if (matrizCeldaRival[fila][columna].getEstado() == false) {
            matrizCeldaRival[fila][columna].setColor(ORANGE);
            matrizCeldaRival[fila][columna].setBackground(ORANGE);
            matrizCeldaRival[fila][columna].setEstado(true);
            celdasRival.add(matrizCeldaRival[fila][columna]);
            //System.out.println("Filaaaa="+(fila+1)+" Columnaaaaaa="+(columna+1)+" Estado="+(matrizCeldaRival[fila][columna].getEstado())+"");

            //System.out.println("SizeCeldasRival="+celdasRival.size()+"");

        }else{
            //System.out.println("ERRORRRRRRRRRSUB");
            fragatasAleatorias(matrizCeldaRival, celdasRival);

        }



        return matrizCeldaRival;
    }

    public Celda[][] creacionSubmarinosJuntos(Celda[][] matrizCeldaRival, int cantidadCeldasJuntas, ArrayList<Celda> celdasRival) {



            for (int i = 0; i < cantidadCeldasJuntas; i++) {
                Random aleatorio = new Random();
                int fila = aleatorio.nextInt(8);
                int columna = aleatorio.nextInt(8);

                if (!matrizCeldaRival[fila][columna].getEstado() && !matrizCeldaRival[fila][columna+1].getEstado()  && !matrizCeldaRival[fila][columna+2].getEstado()) {
                    //System.out.println("FilaaaaSUB1="+(fila)+" ColumnaaaaaaSUB1="+(columna)+" EstadoSUB1="+(matrizCeldaRival[fila][columna].getEstado())+"");
                    matrizCeldaRival[fila][columna].setBackground(Color.PINK);
                    matrizCeldaRival[fila][columna].setEstado(true);
                    matrizCeldaRival[fila][columna].setColor(PINK);
                    matrizCeldaRival[fila][columna+1].setBackground(Color.PINK);
                    matrizCeldaRival[fila][columna+1].setEstado(true);
                    matrizCeldaRival[fila][columna+1].setColor(PINK);
                    matrizCeldaRival[fila][columna+2].setBackground(Color.PINK);
                    matrizCeldaRival[fila][columna+2].setEstado(true);
                    matrizCeldaRival[fila][columna+2].setColor(PINK);
                    celdasRival.add(matrizCeldaRival[fila][columna]);
                    celdasRival.add(matrizCeldaRival[fila][columna+1]);
                    celdasRival.add(matrizCeldaRival[fila][columna+2]);
                    break;
                } else if (!matrizCeldaRival[fila][columna].getEstado() && !matrizCeldaRival[fila+1][columna].getEstado() && !matrizCeldaRival[fila+2][columna].getEstado()) {
                    //System.out.println("FilaaaaSUB2="+(fila)+" ColumnaaaaaaSUB2="+(columna)+" EstadoSUB2="+(matrizCeldaRival[fila][columna].getEstado())+"");
                    matrizCeldaRival[fila][columna].setBackground(Color.PINK);
                    matrizCeldaRival[fila][columna].setEstado(true);
                    matrizCeldaRival[fila][columna].setColor(PINK);
                    matrizCeldaRival[fila+1][columna].setBackground(Color.PINK);
                    matrizCeldaRival[fila+1][columna].setEstado(true);
                    matrizCeldaRival[fila+1][columna].setColor(PINK);
                    matrizCeldaRival[fila+2][columna].setBackground(Color.PINK);
                    matrizCeldaRival[fila+2][columna].setEstado(true);
                    matrizCeldaRival[fila+2][columna].setColor(PINK);
                    celdasRival.add(matrizCeldaRival[fila][columna]);
                    celdasRival.add(matrizCeldaRival[fila+1][columna]);
                    celdasRival.add(matrizCeldaRival[fila+1][columna]);
                    break;
                }else{
                    //System.out.println("ERRORRRRRRRRRSUB");
                    creacionSubmarinosJuntos(matrizCeldaRival,cantidadCeldasJuntas, celdasRival);
                    break;
                }



        }
        return matrizCeldaRival;
    }

    public Celda[][] creacionDestructoresJuntos(Celda[][] matrizCeldaRival, int cantidadCeldasJuntas, ArrayList<Celda> celdasRival) {



            for (int i = 0; i < cantidadCeldasJuntas; i++) {
                Random aleatorio = new Random();
                int fila = aleatorio.nextInt(8);
                int columna = aleatorio.nextInt(8);

                if ((!matrizCeldaRival[fila][columna].getEstado() && !matrizCeldaRival[fila][columna+1].getEstado())   ) {
                    //System.out.println("FilaaaaDES1="+(fila)+" ColumnaaaaaaDES1="+(columna)+" EstadoDES1="+(matrizCeldaRival[fila][columna].getEstado())+"");
                    matrizCeldaRival[fila][columna].setBackground(Color.GREEN);
                    matrizCeldaRival[fila][columna].setEstado(true);
                    matrizCeldaRival[fila][columna].setColor(GREEN);
                    matrizCeldaRival[fila][columna+1].setBackground(Color.GREEN);
                    matrizCeldaRival[fila][columna+1].setEstado(true);
                    matrizCeldaRival[fila][columna+1].setColor(GREEN);
                    celdasRival.add(matrizCeldaRival[fila][columna]);
                    celdasRival.add(matrizCeldaRival[fila][columna+1]);
                    break;
                } else if (!matrizCeldaRival[fila][columna].getEstado() && !matrizCeldaRival[fila+1][columna].getEstado()) {
                    //System.out.println("FilaaaaDES2="+(fila)+" ColumnaaaaaaSUB1="+(columna)+" EstadoDES2="+(matrizCeldaRival[fila][columna].getEstado())+"");
                    matrizCeldaRival[fila][columna].setBackground(Color.GREEN);
                    matrizCeldaRival[fila][columna].setEstado(true);
                    matrizCeldaRival[fila][columna].setColor(GREEN);
                    matrizCeldaRival[fila+1][columna].setBackground(Color.GREEN);
                    matrizCeldaRival[fila+1][columna].setEstado(true);
                    matrizCeldaRival[fila+1][columna].setColor(GREEN);
                    celdasRival.add(matrizCeldaRival[fila][columna]);
                    celdasRival.add(matrizCeldaRival[fila+1][columna]);
                    break;
                }else{
                    //System.out.println("ERRORRRRRRRRRDESC");
                    creacionDestructoresJuntos(matrizCeldaRival,cantidadCeldasJuntas,celdasRival);
                    break;

                }


            }

        return matrizCeldaRival;
    }

    public Celda[][] creacionPortaavionJunto(Celda[][] matrizCeldaRival, int cantidadCeldasJuntas,  ArrayList<Celda> celdasRival) {



        for (int i = 0; i < cantidadCeldasJuntas; i++) {
            Random aleatorio = new Random();
            int fila = aleatorio.nextInt(6);
            int columna = aleatorio.nextInt(6);

            if (!matrizCeldaRival[fila][columna].getEstado() && !matrizCeldaRival[fila][columna+1].getEstado() && !matrizCeldaRival[fila][columna+2].getEstado() && !matrizCeldaRival[fila][columna+3].getEstado()) {
                matrizCeldaRival[fila][columna].setBackground(Color.MAGENTA);
                matrizCeldaRival[fila][columna].setEstado(true);
                matrizCeldaRival[fila][columna].setColor(MAGENTA);
                matrizCeldaRival[fila][columna + 1].setBackground(Color.MAGENTA);
                matrizCeldaRival[fila][columna + 1].setEstado(true);
                matrizCeldaRival[fila][columna + 1].setColor(MAGENTA);
                matrizCeldaRival[fila][columna + 2].setBackground(Color.MAGENTA);
                matrizCeldaRival[fila][columna + 2].setEstado(true);
                matrizCeldaRival[fila][columna + 2].setColor(MAGENTA);
                matrizCeldaRival[fila][columna + 3].setBackground(Color.MAGENTA);
                matrizCeldaRival[fila][columna + 3].setEstado(true);
                matrizCeldaRival[fila][columna + 3].setColor(MAGENTA);
                celdasRival.add(matrizCeldaRival[fila][columna]);
                celdasRival.add(matrizCeldaRival[fila][columna+1]);
                celdasRival.add(matrizCeldaRival[fila][columna+2]);
                celdasRival.add(matrizCeldaRival[fila][columna+3]);
                break;
            } else if(!matrizCeldaRival[fila][columna].getEstado() && !matrizCeldaRival[fila+1][columna].getEstado() && !matrizCeldaRival[fila+2][columna].getEstado() && !matrizCeldaRival[fila+3][columna].getEstado()){
                matrizCeldaRival[fila][columna].setBackground(Color.MAGENTA);
                matrizCeldaRival[fila][columna].setEstado(true);
                matrizCeldaRival[fila][columna].setColor(MAGENTA);
                matrizCeldaRival[fila + 1][columna].setBackground(Color.MAGENTA);
                matrizCeldaRival[fila + 1][columna].setEstado(true);
                matrizCeldaRival[fila + 1][columna].setColor(MAGENTA);
                matrizCeldaRival[fila + 2][columna].setBackground(Color.MAGENTA);
                matrizCeldaRival[fila + 2][columna].setEstado(true);
                matrizCeldaRival[fila + 2][columna].setColor(MAGENTA);
                matrizCeldaRival[fila + 3][columna].setBackground(Color.MAGENTA);
                matrizCeldaRival[fila + 3][columna].setEstado(true);
                matrizCeldaRival[fila + 3][columna].setColor(MAGENTA);
                celdasRival.add(matrizCeldaRival[fila][columna]);
                celdasRival.add(matrizCeldaRival[fila+1][columna]);
                celdasRival.add(matrizCeldaRival[fila+2][columna]);
                celdasRival.add(matrizCeldaRival[fila+3][columna]);
                break;
            }else{
                //System.out.println("ERRORRRRRRRRR");
                creacionPortaavionJunto(matrizCeldaRival,cantidadCeldasJuntas, celdasRival);
                break;
            }


        }
        return matrizCeldaRival;

    }

public Celda[][] matrizJuego(Celda[][] matriz, JPanel tablero){
    for(int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {

            /*matriz[i][j].setColor(matriz[i][j].getColor());
            matriz[i][j].setBackground(matriz[i][j].getColor());
            System.out.println(matriz[i][j].getColor());*/
            //rival.getMatrizCeldaRival()[i][j].setBackground(rival.getMatrizCeldaRival()[i][j].getColor());
            tablero.add(matriz[i][j]);
        }
    }
    return matriz;
}

    }



