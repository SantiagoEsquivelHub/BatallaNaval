package myProject;

import javax.swing.*;
import java.awt.*;


public class Celda extends JButton {
    int fila;
    int columna;
    boolean estado;

    /**Estado 0 = Mar => color: Cyan
     * Estado 1 = Fragata => color: Red
     * Estado 2 = Destructor => color: Green
     * Estado 3 = Submarino => Color: Green
     * Estado 4 = Portaavion => Color: Pink
     * */

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }


    public Celda(int fila, int columna){
        this.fila = fila;
        this.columna = columna;
        this.setBackground(Color.CYAN);
        this.estado = false;
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
