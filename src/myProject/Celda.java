package myProject;

import javax.swing.*;
import java.awt.*;


public class Celda extends JButton {
    int fila;
    int columna;


    public Celda(int fila, int columna){
        this.fila = fila;
        this.columna = columna;
        this.setBackground(Color.CYAN);
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
}
