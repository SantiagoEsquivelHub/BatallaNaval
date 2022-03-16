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

    /**
     * Get error private attribute
     */

    public int getError() {
        return error;
    }

    /**
     * Change error that is passed in the function
     */

    public void setError(int error) {
        this.error = error;
    }

    /**
     * Check if in an ArrayList "array" all its elements are equal to a single "numero". Both parameters are entered in the function
     */

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

    /**
     * Compare if in an ArrayList "array" when taking pairs their subtraction is equal to 1, but previously they were arranged in ascending order. The parameter is entered in the function
     */

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

    /**
     * Compare if there is equality in the rows and the numbers are consecutive, or on the contrary, if the condition is met,
     * a true is returned and if it is false, a message is shown to the user that he can select other cells, he has a maximum of 2 attempts,
     * if exceeds them, the game is closed.
     */

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

    /**
     *Assign "fila" and "columna" parameters to a "barco(fragatas)" based on a "contador"
     */

    public void fragatas (ArrayList<Barco> barcos, int fila, int columna, int contador) {

        if(contador == 1){
            barcos.get(0).setFilasArray(fila);
            //System.out.println("Fila fragata01= "+fila+"");
            barcos.get(0).setColumnasArray(columna);
            //System.out.println("Columna fragata01= "+columna+"");
        }else if(contador == 2){
            barcos.get(1).setFilasArray(fila);
            //System.out.println("Fila fragata02= "+fila+"");
            barcos.get(1).setColumnasArray(columna);
            //System.out.println("Columna fragata02= "+columna+"");
        }else if(contador == 3){
            barcos.get(2).setFilasArray(fila);
            //System.out.println("Fila fragata03= "+fila+"");
            barcos.get(2).setColumnasArray(columna);
            //System.out.println("Columna fragata03= "+columna+"");
        }else if(contador == 4){
            barcos.get(3).setFilasArray(fila);
            //System.out.println("Fila fragata04= "+fila+"");
            barcos.get(3).setColumnasArray(columna);
            //System.out.println("Columna fragata04= "+columna+"");
        }

        }

    /**
     *Assign "fila" and "columna" parameters to a "barco(destructores)" based on a "contador"
     */

    public void destructores (ArrayList<Barco> barcos, int fila, int columna, int contador) {

        if(contador == 1 || contador == 2){
            barcos.get(0).setFilasArray(fila);
            //System.out.println("Fila destructor01= "+fila+"");
            barcos.get(0).setColumnasArray(columna);
            //System.out.println("Columna destructor01= "+columna+"");
        }else if(contador == 3 || contador == 4){
            barcos.get(1).setFilasArray(fila);
            //System.out.println("Fila destructor02= "+fila+"");
            barcos.get(1).setColumnasArray(columna);
            //System.out.println("Columna destructor02= "+columna+"");
        }else if(contador == 5 || contador == 6){
            barcos.get(2).setFilasArray(fila);
            //System.out.println("Fila destructor03= "+fila+"");
            barcos.get(2).setColumnasArray(columna);
            //System.out.println("Columna destructor03= "+columna+"");
        }

    }

    /**
     *Assign "fila" and "columna" parameters to a "barco(submarinos)" based on a "contador"
     */

    public void submarinos(ArrayList<Barco> barcos, int fila, int columna, int contador) {

        if(contador == 1 || contador == 2 || contador == 3 ){
            barcos.get(0).setFilasArray(fila);
            //System.out.println("Fila submarino01= "+fila+"");
            barcos.get(0).setColumnasArray(columna);
            //System.out.println("Columna submarino01= "+columna+"");
        }else if(contador == 4 || contador == 5 || contador == 6){
            barcos.get(1).setFilasArray(fila);
            //System.out.println("Fila submarino02= "+fila+"");
            barcos.get(1).setColumnasArray(columna);
            //System.out.println("Columna submarino02= "+columna+"");
        }

    }

    /**
     * Set a listener and change the background to Cyan for all the "Celda" objects of the "matrizCelda"
     */

    public Celda[][] resetCelda( Celda[][] matrizCelda, ArrayList<Celda> miCelda, ActionListener escucha){

        for(int i = 0; i < miCelda.size(); i++){
            int fila = miCelda.get(i).getFila();
            int columna = miCelda.get(i).getColumna();
            matrizCelda[fila][columna].setBackground(Color.cyan);
             matrizCelda[fila][columna].addActionListener(escucha);
        }
        return matrizCelda;
    }

    /**
     * Remove a listener to all the "Celda" objects of the "matrizCelda"
     */

    public Celda[][] eliminarEscuchasAnteriores( Celda[][] matrizCelda, ArrayList<Celda> misCeldas, ActionListener escucha){
        for(int i = 0; i < misCeldas.size(); i++){
            int fila = misCeldas.get(i).getFila();
            int columna = misCeldas.get(i).getColumna();
            matrizCelda[fila][columna].removeActionListener(escucha);
            //System.out.println("SE QUITARON TODOS LOS ESCUCHAS");
        }
        return matrizCelda;
    }

    /**
     * Randomly select the positions of rival "fragatas"(computer) and return "matrizRival"
     */


    public Celda[][]  fragatasAleatorias(Celda[][] matrizCeldaRival, ArrayList<Celda> celdasRival, ActionListener escucha) {

            Random aleatorio = new Random();
            int fila = aleatorio.nextInt(9);
            int columna = aleatorio.nextInt(9);

        if (matrizCeldaRival[fila][columna].getEstado() == false) {
            matrizCeldaRival[fila][columna].setColor(ORANGE);
            matrizCeldaRival[fila][columna].setBackground(ORANGE);
            matrizCeldaRival[fila][columna].setEstado(true);
            //matrizCeldaRival[fila][columna].addActionListener(escucha);
            matrizCeldaRival[fila][columna].setFragata(true);
            celdasRival.add(matrizCeldaRival[fila][columna]);
            //System.out.println("Filaaaa="+(fila+1)+" Columnaaaaaa="+(columna+1)+" Estado="+(matrizCeldaRival[fila][columna].getEstado())+"");

            //System.out.println("SizeCeldasRival="+celdasRival.size()+"");

        }else{
            //System.out.println("ERRORRRRRRRRRSUB");
            fragatasAleatorias(matrizCeldaRival, celdasRival, escucha);

        }



        return matrizCeldaRival;
    }

    /**
     * Randomly select the positions of rival "submarinos"(computer) and return "matrizRival"
     */

    public Celda[][] creacionSubmarinosJuntos(Celda[][] matrizCeldaRival, int cantidadCeldasJuntas, ArrayList<Celda> celdasRival, ActionListener escucha) {



            for (int i = 0; i < cantidadCeldasJuntas; i++) {
                Random aleatorio = new Random();
                int fila = aleatorio.nextInt(8);
                int columna = aleatorio.nextInt(8);

                if (!matrizCeldaRival[fila][columna].getEstado() && !matrizCeldaRival[fila][columna+1].getEstado()  && !matrizCeldaRival[fila][columna+2].getEstado()) {
                    //System.out.println("FilaaaaSUB1="+(fila)+" ColumnaaaaaaSUB1="+(columna)+" EstadoSUB1="+(matrizCeldaRival[fila][columna].getEstado())+"");
                    matrizCeldaRival[fila][columna].setBackground(Color.PINK);
                    matrizCeldaRival[fila][columna].setEstado(true);
                    matrizCeldaRival[fila][columna].setColor(PINK);
                    matrizCeldaRival[fila][columna].setSubmarino(true);
                    //matrizCeldaRival[fila][columna].addActionListener(escucha);
                    matrizCeldaRival[fila][columna+1].setBackground(Color.PINK);
                    matrizCeldaRival[fila][columna+1].setEstado(true);
                    matrizCeldaRival[fila][columna+1].setColor(PINK);
                    matrizCeldaRival[fila][columna+1].setSubmarino(true);
                    //matrizCeldaRival[fila][columna+1].addActionListener(escucha);
                    matrizCeldaRival[fila][columna+2].setBackground(Color.PINK);
                    matrizCeldaRival[fila][columna+2].setEstado(true);
                    matrizCeldaRival[fila][columna+2].setColor(PINK);
                    matrizCeldaRival[fila][columna+2].setSubmarino(true);
                    //matrizCeldaRival[fila][columna+2].addActionListener(escucha);
                    celdasRival.add(matrizCeldaRival[fila][columna]);
                    celdasRival.add(matrizCeldaRival[fila][columna+1]);
                    celdasRival.add(matrizCeldaRival[fila][columna+2]);
                    break;
                } else if (!matrizCeldaRival[fila][columna].getEstado() && !matrizCeldaRival[fila+1][columna].getEstado() && !matrizCeldaRival[fila+2][columna].getEstado()) {
                    //System.out.println("FilaaaaSUB2="+(fila)+" ColumnaaaaaaSUB2="+(columna)+" EstadoSUB2="+(matrizCeldaRival[fila][columna].getEstado())+"");
                    matrizCeldaRival[fila][columna].setBackground(Color.PINK);
                    matrizCeldaRival[fila][columna].setEstado(true);
                    matrizCeldaRival[fila][columna].setColor(PINK);
                    matrizCeldaRival[fila][columna].setSubmarino(true);
                    //matrizCeldaRival[fila][columna].addActionListener(escucha);
                    matrizCeldaRival[fila+1][columna].setBackground(Color.PINK);
                    matrizCeldaRival[fila+1][columna].setEstado(true);
                    matrizCeldaRival[fila+1][columna].setColor(PINK);
                    matrizCeldaRival[fila+1][columna].setSubmarino(true);
                    //matrizCeldaRival[fila+1][columna].addActionListener(escucha);
                    matrizCeldaRival[fila+2][columna].setBackground(Color.PINK);
                    matrizCeldaRival[fila+2][columna].setEstado(true);
                    matrizCeldaRival[fila+2][columna].setColor(PINK);
                    matrizCeldaRival[fila+2][columna].setSubmarino(true);
                    //matrizCeldaRival[fila+2][columna].addActionListener(escucha);
                    celdasRival.add(matrizCeldaRival[fila][columna]);
                    celdasRival.add(matrizCeldaRival[fila+1][columna]);
                    celdasRival.add(matrizCeldaRival[fila+2][columna]);
                    break;
                }else{
                    //System.out.println("ERRORRRRRRRRRSUB");
                    creacionSubmarinosJuntos(matrizCeldaRival,cantidadCeldasJuntas, celdasRival, escucha);
                    break;
                }



        }
        return matrizCeldaRival;
    }

    /**
     * Randomly select the positions of rival "destructores"(computer) and return "matrizRival"
     */

    public Celda[][] creacionDestructoresJuntos(Celda[][] matrizCeldaRival, int cantidadCeldasJuntas, ArrayList<Celda> celdasRival,  ActionListener escucha) {



            for (int i = 0; i < cantidadCeldasJuntas; i++) {
                Random aleatorio = new Random();
                int fila = aleatorio.nextInt(8);
                int columna = aleatorio.nextInt(8);

                if ((!matrizCeldaRival[fila][columna].getEstado() && !matrizCeldaRival[fila][columna+1].getEstado())   ) {
                    //System.out.println("FilaaaaDES1="+(fila)+" ColumnaaaaaaDES1="+(columna)+" EstadoDES1="+(matrizCeldaRival[fila][columna].getEstado())+"");
                    matrizCeldaRival[fila][columna].setBackground(Color.GREEN);
                    matrizCeldaRival[fila][columna].setEstado(true);
                    matrizCeldaRival[fila][columna].setColor(GREEN);
                    matrizCeldaRival[fila][columna].setDestructor(true);
                    //matrizCeldaRival[fila][columna].addActionListener(escucha);
                    matrizCeldaRival[fila][columna+1].setBackground(Color.GREEN);
                    matrizCeldaRival[fila][columna+1].setEstado(true);
                    matrizCeldaRival[fila][columna+1].setColor(GREEN);
                    matrizCeldaRival[fila][columna+1].setDestructor(true);
                    //matrizCeldaRival[fila][columna+1].addActionListener(escucha);
                    destructoresRivalRojos(matrizCeldaRival[fila][columna]);
                    destructoresRivalRojos(matrizCeldaRival[fila][columna+1]);
                    celdasRival.add(matrizCeldaRival[fila][columna]);
                    celdasRival.add(matrizCeldaRival[fila][columna+1]);
                    break;
                } else if (!matrizCeldaRival[fila][columna].getEstado() && !matrizCeldaRival[fila+1][columna].getEstado()) {
                    //System.out.println("FilaaaaDES2="+(fila)+" ColumnaaaaaaSUB1="+(columna)+" EstadoDES2="+(matrizCeldaRival[fila][columna].getEstado())+"");
                    matrizCeldaRival[fila][columna].setBackground(Color.GREEN);
                    matrizCeldaRival[fila][columna].setEstado(true);
                    matrizCeldaRival[fila][columna].setColor(GREEN);
                    matrizCeldaRival[fila][columna].setDestructor(true);
                    //matrizCeldaRival[fila][columna].addActionListener(escucha);
                    matrizCeldaRival[fila+1][columna].setBackground(Color.GREEN);
                    matrizCeldaRival[fila+1][columna].setEstado(true);
                    matrizCeldaRival[fila+1][columna].setColor(GREEN);
                    matrizCeldaRival[fila+1][columna].setDestructor(true);
                    //matrizCeldaRival[fila+1][columna].addActionListener(escucha);
                    destructoresRivalRojos(matrizCeldaRival[fila][columna]);
                    destructoresRivalRojos(matrizCeldaRival[fila+1][columna]);
                    celdasRival.add(matrizCeldaRival[fila][columna]);
                    celdasRival.add(matrizCeldaRival[fila+1][columna]);
                    break;
                }else{
                    //System.out.println("ERRORRRRRRRRRDESC");
                    creacionDestructoresJuntos(matrizCeldaRival,cantidadCeldasJuntas,celdasRival,escucha);
                    break;

                }


            }

        return matrizCeldaRival;
    }

    /**
     * Randomly select the positions of rival "portaavion"(computer) and return "matrizRival"
     */

    public void creacionPortaavionJunto(Celda[][] matrizCeldaRival, int cantidadCeldasJuntas,  ArrayList<Celda> celdasRival, ActionListener escucha) {



        for (int i = 0; i < cantidadCeldasJuntas; i++) {
            Random aleatorio = new Random();
            int fila = aleatorio.nextInt(6);
            int columna = aleatorio.nextInt(6);

            if (!matrizCeldaRival[fila][columna].getEstado() && !matrizCeldaRival[fila][columna+1].getEstado() && !matrizCeldaRival[fila][columna+2].getEstado() && !matrizCeldaRival[fila][columna+3].getEstado()) {
                matrizCeldaRival[fila][columna].setBackground(Color.MAGENTA);
                matrizCeldaRival[fila][columna].setEstado(true);
                matrizCeldaRival[fila][columna].setColor(MAGENTA);
                matrizCeldaRival[fila][columna].setPortaavion(true);
                //matrizCeldaRival[fila][columna].addActionListener(escucha);
                matrizCeldaRival[fila][columna+1].setBackground(Color.MAGENTA);
                matrizCeldaRival[fila][columna+1].setEstado(true);
                matrizCeldaRival[fila][columna+1].setColor(MAGENTA);
                matrizCeldaRival[fila][columna+1].setPortaavion(true);
                //matrizCeldaRival[fila][columna+1].addActionListener(escucha);
                matrizCeldaRival[fila][columna+2].setBackground(Color.MAGENTA);
                matrizCeldaRival[fila][columna+2].setEstado(true);
                matrizCeldaRival[fila][columna+2].setColor(MAGENTA);
                matrizCeldaRival[fila][columna+2].setPortaavion(true);
                //matrizCeldaRival[fila][columna+2].addActionListener(escucha);
                matrizCeldaRival[fila][columna+3].setBackground(Color.MAGENTA);
                matrizCeldaRival[fila][columna+3].setEstado(true);
                matrizCeldaRival[fila][columna+3].setColor(MAGENTA);
                matrizCeldaRival[fila][columna+3].setPortaavion(true);
                //matrizCeldaRival[fila][columna+3].addActionListener(escucha);
                celdasRival.add(matrizCeldaRival[fila][columna]);
                celdasRival.add(matrizCeldaRival[fila][columna+1]);
                celdasRival.add(matrizCeldaRival[fila][columna+2]);
                celdasRival.add(matrizCeldaRival[fila][columna+3]);
                break;
            } else if(!matrizCeldaRival[fila][columna].getEstado() && !matrizCeldaRival[fila+1][columna].getEstado() && !matrizCeldaRival[fila+2][columna].getEstado() && !matrizCeldaRival[fila+3][columna].getEstado()){
                matrizCeldaRival[fila][columna].setBackground(Color.MAGENTA);
                matrizCeldaRival[fila][columna].setEstado(true);
                matrizCeldaRival[fila][columna].setColor(MAGENTA);
                matrizCeldaRival[fila][columna].setPortaavion(true);
                //matrizCeldaRival[fila][columna].addActionListener(escucha);
                matrizCeldaRival[fila+1][columna].setBackground(Color.MAGENTA);
                matrizCeldaRival[fila+1][columna].setEstado(true);
                matrizCeldaRival[fila+1][columna].setColor(MAGENTA);
                matrizCeldaRival[fila+1][columna].setPortaavion(true);
                //matrizCeldaRival[fila+1][columna].addActionListener(escucha);
                matrizCeldaRival[fila+2][columna].setBackground(Color.MAGENTA);
                matrizCeldaRival[fila+2][columna].setEstado(true);
                matrizCeldaRival[fila+2][columna].setColor(MAGENTA);
                matrizCeldaRival[fila+2][columna].setPortaavion(true);
                //matrizCeldaRival[fila+2][columna].addActionListener(escucha);
                matrizCeldaRival[fila+3][columna].setBackground(Color.MAGENTA);
                matrizCeldaRival[fila+3][columna].setEstado(true);
                matrizCeldaRival[fila+3][columna].setColor(MAGENTA);
                matrizCeldaRival[fila+3][columna].setPortaavion(true);
                //matrizCeldaRival[fila+3][columna].addActionListener(escucha);
                celdasRival.add(matrizCeldaRival[fila][columna]);
                celdasRival.add(matrizCeldaRival[fila+1][columna]);
                celdasRival.add(matrizCeldaRival[fila+2][columna]);
                celdasRival.add(matrizCeldaRival[fila+3][columna]);
                break;
            }else{
                //System.out.println("ERRORRRRRRRRR");
                creacionPortaavionJunto(matrizCeldaRival,cantidadCeldasJuntas, celdasRival, escucha);
                break;
            }


        }


    }

    /**
     *
     */

    public void destructoresRivalRojos(Celda celda){

        if(rival.getDestructores01Rival().size() == 2 && rival.getDestructores02Rival().size() < 2){
            rival.getDestructores02Rival().add(celda);
            //System.out.println("contador="+rival.getContadorDestructores()+"");
            rival.setContadorDestructores();
            //System.out.println("PRIMER CICLO");

        }else if(rival.getDestructores01Rival().size() == 2 && rival.getDestructores02Rival().size() <= 1){
            rival.getDestructores03Rival().add(celda);
            rival.setContadorDestructores();
            //System.out.println("HOLAAAAAA="+rival.getDestructores02Rival().size()+"");
            //System.out.println("SEGUNDO CICLO");

        }else if(rival.getDestructores01Rival().size() == 2 && rival.getDestructores02Rival().size() == 2){
            rival.getDestructores03Rival().add(celda);
            rival.setContadorDestructores();
            //System.out.println("HOLAAAAAA="+rival.getDestructores02Rival().size()+"");

        }else{
            rival.getDestructores01Rival().add(celda);
            rival.setContadorDestructores();
        }


    }

    /**
     * Confirm if it is the opponent's turn to choose a random cell from the player's position board, and if so, select it
     */

public void turno(Celda[][] matrizCelda, ArrayList<Celda> celdasDesc01, ArrayList<Celda> celdasDesc02, ArrayList<Celda> celdasDesc03){

    Random aleatorio = new Random();
    int fila = aleatorio.nextInt(9);
    int columna = aleatorio.nextInt(9);



    if(matrizCelda[fila][columna].getEstado() && matrizCelda[fila][columna].isFragata() && !matrizCelda[fila][columna].getEstado2()){
        matrizCelda[fila][columna].setEstado(false);
        matrizCelda[fila][columna].setEstado2(true);
        matrizCelda[fila][columna].setBackground(RED);
        rival.setContadorGanar();
        //System.out.println("PIVOTE 1");
    }else if(matrizCelda[fila][columna].getEstado() && matrizCelda[fila][columna].isDestructor()){

        matrizCelda[fila][columna].setEstado(false);
        matrizCelda[fila][columna].setEstado2(true);
        matrizCelda[fila][columna].setGolpes();
        rival.getArrayGanarAux().add(matrizCelda[fila][columna]);
        matrizCelda[fila][columna].setBackground(BLACK);
        rival.setContadorGanar();



        //System.out.println("PIVOTE 2");
        if(rival.getArrayGanarAux().size() == 2){
            if(rival.getArrayGanarAux().get(0).getGolpes() == 1 && rival.getArrayGanarAux().get(1).getGolpes() == 1 && comparacionDesc(celdasDesc01, celdasDesc02, celdasDesc03)){

                System.out.println("YEIIIIIIIIIIIII");
               /* if(destructor01.getEstado()){

                    int fila1 = destructor01.getFilasArray().get(0);
                    int columna1 = destructor01.getColumnasArray().get(0);

                    int fila2 = destructor01.getFilasArray().get(1);
                    int columna2 = destructor01.getColumnasArray().get(1);

                    matrizCelda[fila1][columna1].setBackground(RED);
                    matrizCelda[fila2][columna2].setBackground(RED);
                }*/

               /* rival.getArrayGanarAux().get(0).setBackground(RED);
                rival.getArrayGanarAux().get(1).setBackground(RED);
                rival.getArrayGanarAux().clear();*/

            }
        }


    }else if(matrizCelda[fila][columna].getEstado() && matrizCelda[fila][columna].isSubmarino()){
        matrizCelda[fila][columna].setEstado(false);
        matrizCelda[fila][columna].setEstado2(true);
        //System.out.println("PIVOTE 3");
        matrizCelda[fila][columna].setGolpes();
        rival.getArrayGanarAux().add(matrizCelda[fila][columna]);
        matrizCelda[fila][columna].setBackground(BLACK);
        rival.setContadorGanar();
        //rival.setContadorTurno();


        if(rival.getArrayGanarAux().size() == 3){
            if(rival.getArrayGanarAux().get(0).getGolpes() == 1 && rival.getArrayGanarAux().get(1).getGolpes() == 1 && rival.getArrayGanarAux().get(2).getGolpes() == 1){


                rival.getArrayGanarAux().get(0).setBackground(RED);
                rival.getArrayGanarAux().get(1).setBackground(RED);
                rival.getArrayGanarAux().get(2).setBackground(RED);
                rival.getArrayGanarAux().clear();

            }
        }


    }else if(matrizCelda[fila][columna].getEstado() && matrizCelda[fila][columna].isPortaavion()){
        matrizCelda[fila][columna].setEstado(false);
        matrizCelda[fila][columna].setEstado2(true);
        matrizCelda[fila][columna].setGolpes();
        rival.getDestructoresRivalAux().add(matrizCelda[fila][columna]);
        matrizCelda[fila][columna].setBackground(BLACK);
        rival.setContadorGanar();
        //rival.setContadorTurno();
        //System.out.println(rival.getDestructoresRivalAux().size());

        if(rival.getArrayGanarAux().size() == 4){
            if(rival.getArrayGanarAux().get(0).getGolpes() == 1 && rival.getArrayGanarAux().get(1).getGolpes() == 1 && rival.getArrayGanarAux().get(2).getGolpes() == 1 && rival.getArrayGanarAux().get(3).getGolpes() == 1){


                rival.getArrayGanarAux().get(0).setBackground(RED);
                rival.getArrayGanarAux().get(1).setBackground(RED);
                rival.getArrayGanarAux().get(2).setBackground(RED);
                rival.getArrayGanarAux().get(3).setBackground(RED);
                rival.getArrayGanarAux().clear();

            }
        }


    }else if(matrizCelda[fila][columna].getEstado2() && !matrizCelda[fila][columna].getEstado()){
        turno(matrizCelda,celdasDesc01,celdasDesc02,celdasDesc03);

    }else{

        matrizCelda[fila][columna].setEstado2(true);
        matrizCelda[fila][columna].setBackground(BLUE);


        rival.setContadorTurno();
        //System.out.println("FINALLLLLLL");
    }

    if(rival.getContadorGanar() == 20){
        JOptionPane.showMessageDialog(null,

                "¡PERDISTE!",

                "PopUp Dialog",
                JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }


}

public boolean comparacionDesc(ArrayList<Celda> celdasDesc01, ArrayList<Celda> celdasDesc02, ArrayList<Celda> celdasDesc03){
    if(rival.getArrayGanarAux().equals(celdasDesc01)){

        celdasDesc01.get(0).setBackground(RED);
        celdasDesc01.get(1).setBackground(RED);
        rival.getArrayGanarAux().clear();
        return  true;
    }else if(rival.getArrayGanarAux().equals(celdasDesc02)){

        celdasDesc01.get(0).setBackground(RED);
        celdasDesc01.get(1).setBackground(RED);
        rival.getArrayGanarAux().clear();
        return  true;
    }else if(rival.getArrayGanarAux().equals(celdasDesc03)){

        celdasDesc01.get(0).setBackground(RED);
        celdasDesc01.get(1).setBackground(RED);
        rival.getArrayGanarAux().clear();
        return  true;
    }else{
        System.out.println("NO SON IGUALES");
        return false;

    }

}

    }



