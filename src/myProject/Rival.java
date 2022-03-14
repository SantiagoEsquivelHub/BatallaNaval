package myProject;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Rival {
    private int contadorGanar = 0;
    private int contadorPerder = 0;
    private int contadorDestructores = 0;

    public int getContadorDestructores() {
        return contadorDestructores;
    }

    public void setContadorDestructores() {
        this.contadorDestructores = contadorDestructores+1;
    }

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

    public ArrayList<Celda> getDestructoresRivalAux() {
        return destructoresRivalAux;
    }

    public void setDestructoresRivalAux(ArrayList<Celda> destructoresRivalAux) {
        this.destructoresRivalAux = destructoresRivalAux;
    }

    public ArrayList<Celda> getDestructores01Rival() {
        return destructores01Rival;
    }

    public void setDestructores01Rival(ArrayList<Celda> destructores01Rival) {
        this.destructores01Rival = destructores01Rival;
    }

    public ArrayList<Celda> getDestructores02Rival() {
        return destructores02Rival;
    }

    public void setDestructores02Rival(ArrayList<Celda> destructores02Rival) {
        this.destructores02Rival = destructores02Rival;
    }

    public ArrayList<Celda> getDestructores03Rival() {
        return destructores03Rival;
    }

    public void setDestructores03Rival(ArrayList<Celda> destructores03Rival) {
        this.destructores03Rival = destructores03Rival;
    }

    public ArrayList<Celda> getFragatasRival() {
        return fragatasRival;
    }

    public void setFragatasRival(ArrayList<Celda> fragatasRival) {
        this.fragatasRival = fragatasRival;
    }

    public int getContadorPerder() {
        return contadorPerder;
    }

    public void setContadorPerder() {
        this.contadorPerder = contadorPerder+1;
    }

    public ArrayList<Celda> getCeldasRival() {
        return celdasRival;
    }


    public void setCeldasRival(ArrayList<Celda> celdasRival) {
        this.celdasRival = celdasRival;
    }

    public Celda[][] getMatrizCeldaRival() {

        return matrizCeldaRival;
    }

    public Celda[][] getMatrizCeldaRivalAparte() {

        return matrizCeldaRival;
    }

    public ArrayList<Celda> getCeldasDest01Rival() {
        return celdasDest01Rival;
    }

    public void setCeldasDest01Rival(ArrayList<Celda> celdasDest01Rival) {
        this.celdasDest01Rival = celdasDest01Rival;
    }

    public void setMatrizCeldaRival(Celda[][] matrizCeldaRival) {
        this.matrizCeldaRival = matrizCeldaRival;
    }

    public ArrayList<Integer> getFilasDest01Rival() {
        System.out.println("FILAS=" + filasDest01Rival.get(0) + "");
        System.out.println("FILAS=" + filasDest01Rival.get(1) + "");
        return filasDest01Rival;
    }

    public void setFilasDest01Rival(ArrayList<Integer> filasDest01Rival) {
        this.filasDest01Rival = filasDest01Rival;
    }

    public ArrayList<Integer> getColumnasDest01Rival() {
        System.out.println("COLUMNAS=" + columnasDest01Rival.get(0) + "");
        System.out.println("COLUMNAS=" + columnasDest01Rival.get(1) + "");
        return columnasDest01Rival;
    }

    public void setColumnasDest01Rival(ArrayList<Integer> columnasDest01Rival) {
        this.columnasDest01Rival = columnasDest01Rival;
    }

    public int filaCeldasDes01Rival(int i) {
        int fila = celdasDest01Rival.get(i).getFila()+1;
        return fila;
    }

    public int columnaCeldasDes01Rival(int i) {
        int columna = celdasDest01Rival.get(i).getColumna()+1;
        return columna;
    }

    public void llenar(ArrayList<Celda> arrayCeldas) {
        for (int i = 0; i < arrayCeldas.size(); i++) {
            columnasDest01Rival.add(arrayCeldas.get(i).getColumna()+1);
            filasDest01Rival.add(arrayCeldas.get(i).getFila()+1);
        }
    }

}