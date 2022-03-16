package myProject;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Rival {
    private int contadorGanar = 0;
    private int contadorPerder = 0;
    private int contadorDestructores = 0;
    private int contadorTurno = 1;
    private ArrayList<Celda> celdasRival = new ArrayList<Celda>();
    private Celda[][] matrizCeldaRivalAparte = new Celda[10][10];
    private Celda[][] matrizCeldaRival = new Celda[10][10];
    private ArrayList<Integer> filasDest01Rival = new ArrayList<Integer>();
    private ArrayList<Integer> columnasDest01Rival= new ArrayList<Integer>();
    private ArrayList<Celda> celdasDest01Rival = new ArrayList<Celda>();
    private ArrayList<Celda> fragatasRival = new ArrayList<Celda>();
    private ArrayList<Celda> destructores01Rival = new ArrayList<Celda>();
    private ArrayList<Celda> destructores02Rival = new ArrayList<Celda>();
    private ArrayList<Celda> destructores03Rival = new ArrayList<Celda>();
    private ArrayList<Celda> destructoresRivalAux = new ArrayList<Celda>();
    private ArrayList<Celda> arrayGanarAux = new ArrayList<Celda>();
    private ArrayList<Celda> arrayGanarSubAux = new ArrayList<Celda>();
    private ArrayList<Celda> arrayGanarPorAux = new ArrayList<Celda>();

    public ArrayList<Celda> getArrayGanarPorAux() {
        return arrayGanarPorAux;
    }

    public void setArrayGanarPorAux(ArrayList<Celda> arrayGanarPorAux) {
        this.arrayGanarPorAux = arrayGanarPorAux;
    }

    public ArrayList<Celda> getArrayGanarSubAux() {
        return arrayGanarSubAux;
    }

    public void setArrayGanarSubAux(ArrayList<Celda> arrayGanarSubAux) {
        this.arrayGanarSubAux = arrayGanarSubAux;
    }

    /**
     * Get contadorTurno private attribute
     */

    public int getContadorTurno() {
        return contadorTurno;
    }

    /**
     * Add 1 to contadorTurno private attribute
     */

    public void setContadorTurno() {
        this.contadorTurno = contadorTurno+1;
    }

    /**
     * Get contadorGanar private attribute
     */

    public int getContadorGanar() {
        return contadorGanar;
    }

    /**
     * Add 1 to contadorGanar private attribute
     */

    public void setContadorGanar() {
        this.contadorGanar = contadorGanar+1;
    }

    /**
     * Add 1 to contadorGanar private attribute
     */

    public void setContadorDestructores() {
        this.contadorDestructores = contadorDestructores+1;
    }

    /**
     * Get the ArrayList destructoresRivalAux private attribute
     */

    public ArrayList<Celda> getDestructoresRivalAux() {
        return destructoresRivalAux;
    }

    /**
     * Get contadorPerder private attribute
     */

    public int getContadorPerder() {
        return contadorPerder;
    }

    /**
     * Add 1 contadorPerder private attribute
     */

    public void setContadorPerder() {
        this.contadorPerder = contadorPerder+1;
    }

    /**
     * Get ArrayList celdasRival private attribute
     */

    public ArrayList<Celda> getCeldasRival() {
        return celdasRival;
    }

    /**
     * Get Celda[][] matrizCeldaRival private attribute
     */

    public Celda[][] getMatrizCeldaRival() {

        return matrizCeldaRival;
    }

   /* public Celda[][] getMatrizCeldaRivalAparte() {

        return matrizCeldaRival;
    }*/

    /**
     * Get ArrayList arrayGanarAux private attribute
     */

    public ArrayList<Celda> getArrayGanarAux() {
        return arrayGanarAux;
    }


    public ArrayList<Celda> getDestructores01Rival() {
        return destructores01Rival;
    }

    public ArrayList<Celda> getDestructores02Rival() {
        return destructores02Rival;
    }

    public ArrayList<Celda> getDestructores03Rival() {
        return destructores03Rival;
    }

    public ArrayList<Celda> getFragatasRival() {
        return fragatasRival;
    }

}