package myProject;

import javax.swing.*;
import java.awt.*;


public class Celda extends JButton {
    int fila;
    int columna;
    boolean estado;
    Color color;
    boolean fragata;
    boolean destructor;
    boolean submarino;
    boolean portaavion;
    int golpes;

    public boolean isSubmarino() {
        return submarino;
    }

    public void setSubmarino(boolean submarino) {
        this.submarino = submarino;
    }

    public boolean isPortaavion() {
        return portaavion;
    }

    public void setPortaavion(boolean portaavion) {
        this.portaavion = portaavion;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isFragata() {
        return fragata;
    }

    public void setFragata(boolean fragata) {
        this.fragata = fragata;
    }

    /**Estado 0 = Mar => color: Cyan
     * Estado 1 = Fragata => color: Red
     * Estado 2 = Destructor => color: Green
     * Estado 3 = Submarino => Color: Green
     * Estado 4 = Portaavion => Color: Pink
     * */

    public boolean getEstado() {
        return estado;
    }

    public boolean isDestructor() {
        return destructor;
    }

    public void setDestructor(boolean destructor) {
        this.destructor = destructor;
    }

    public int getGolpes() {
        return golpes;
    }

    public void setGolpes() {
        this.golpes = golpes+1;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }


    public Celda(int fila, int columna){
        this.fila = fila;
        this.columna = columna;
        this.estado = false;
        this.color = Color.CYAN;
        this.setBackground(color);
        this.fragata = false;
        this.destructor = false;
        this.submarino = false;
        this.portaavion = false;
        this.golpes = 0;
    }

    public int getColumna() {

        return columna;

    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public int getFila() {

        return fila;

    }

    public void setFila(int fila) {

        this.fila = fila;
    }

    public void cambiarFondo(){
        setBackground(Color.gray);
    }

    public void restaurarFondo(){
        setBackground(Color.cyan);
    }
}
