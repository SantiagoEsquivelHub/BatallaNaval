package myProject;

import javax.swing.*;
import java.awt.*;


public class Celda extends JButton {
    int fila;
    int columna;
    boolean estado;
    boolean estado2;
    Color color;
    boolean fragata;
    boolean destructor;
    boolean submarino;
    boolean portaavion;
    int golpes;

    public Celda(int fila, int columna){
        this.fila = fila;
        this.columna = columna;
        this.estado = false;
        this.estado2 = false;
        this.color = Color.CYAN;
        this.setBackground(color);
        this.fragata = false;
        this.destructor = false;
        this.submarino = false;
        this.portaavion = false;
        this.golpes = 0;
    }

    /**
     * Get submarino private attribute
     */

    public boolean isSubmarino() {
        return submarino;
    }

    /**
     * Change submarino that is passed in the function
     */

    public void setSubmarino(boolean submarino) {
        this.submarino = submarino;
    }

    /**
     * Get portaavion private attribute
     */

    public boolean isPortaavion() {
        return portaavion;
    }

    /**
     * Change portaavion that is passed in the function
     */

    public void setPortaavion(boolean portaavion) {
        this.portaavion = portaavion;
    }

    /**
     * Get color private attribute
     */

    public Color getColor() {
        return color;
    }

    /**
     * Change color that is passed in the function
     */

    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Get fragata private attribute
     */

    public boolean isFragata() {
        return fragata;
    }

    /**
     * Change fragata that is passed in the function
     */

    public void setFragata(boolean fragata) {
        this.fragata = fragata;
    }

    /**
     * Get estado2 private attribute
     */

    public boolean getEstado2() {
        return estado2;
    }

    /**
     * Change estado2 that is passed in the function
     */

    public void setEstado2(boolean estado2) {
        this.estado2 = estado2;
    }

    /**
     * Get estado private attribute
     */

    public boolean getEstado() {
        return estado;
    }

    /**
     * Get destuctor private attribute
     */

    public boolean isDestructor() {
        return destructor;
    }

    /**
     * Change destructor that is passed in the function
     */

    public void setDestructor(boolean destructor) {
        this.destructor = destructor;
    }

    /**
     * Get golpes private attribute
     */

    public int getGolpes() {
        return golpes;
    }

    /**
     * Add 1 golpes private attribute
     */

    public void setGolpes() {
        this.golpes = golpes+1;
    }

    /**
     * Change estado that is passed in the function
     */

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * Get columna private attribute
     */

    public int getColumna() {

        return columna;

    }

    /**
     * Get fila private attribute
     */

    public int getFila() {

        return fila;

    }

    /**
     * Change background color Celda to Gray
     */

    public void cambiarFondo(){
        setBackground(Color.gray);
    }

    /**
     * Change background color Celda to Cyan
     */

    public void restaurarFondo(){
        setBackground(Color.cyan);
    }
}
