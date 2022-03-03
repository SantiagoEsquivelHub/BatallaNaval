package myProject;

import javax.swing.*;


public class Celda extends JButton {
    int fila;
    String columna;

    public Celda(String nombre, String columna, int fila){

    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }
}
