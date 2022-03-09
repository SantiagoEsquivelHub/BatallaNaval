package myProject;

import java.util.ArrayList;

public class Barco {

    ArrayList<Integer> filasArray = new ArrayList<Integer>();
    ArrayList<Integer> columnasArray = new ArrayList<Integer>();
    int contador;
    int estado = 0;

    public Barco(int contador) {
        this.contador = contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public int getContador() {
        return contador;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }


    public ArrayList<Integer> getColumnasArray() {
        return columnasArray;
    }

    public void setColumnasArray(int numColumnas) {
        columnasArray.add(numColumnas);
        //System.out.println(numColumnas);
    }

    public ArrayList<Integer> getFilasArray() {
        return filasArray;
    }

    public void setFilasArray(int numFilas) {
        filasArray.add(numFilas);
        contador ++;
        //System.out.println(numFilas);
    }

}
