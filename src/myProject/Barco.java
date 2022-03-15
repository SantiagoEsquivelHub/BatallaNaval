package myProject;

import java.util.ArrayList;

public class Barco {

    ArrayList<Integer> filasArray = new ArrayList<Integer>();
    ArrayList<Integer> columnasArray = new ArrayList<Integer>();
    int contador;
    boolean estado = false;

    public Barco(int contador) {
        this.contador = contador;
    }

    /**
     * Change contador that is passed in the function
     */

    public void setContador(int contador) {
        this.contador = contador;
    }

    /**
     * Get the contador private attribute
     */

    public int getContador() {
        return contador;
    }

    /**
     * Get the ArrayList columnasArray private attribute
     */

    public ArrayList<Integer> getColumnasArray() {
        return columnasArray;
    }

    /**
     * Add numColumnas to columnasArray that is passed in the function
     */

    public void setColumnasArray(int numColumnas) {
        columnasArray.add(numColumnas);
        //System.out.println(numColumnas);
    }

    /**
     * Get the ArrayList filasArray private attribute
     */

    public ArrayList<Integer> getFilasArray() {
        return filasArray;
    }

    /**
     * Add numColumnas to columnasArray that is passed in the function
     */

    public void setFilasArray(int numFilas) {
        filasArray.add(numFilas);
        contador ++;
        //System.out.println(numFilas);
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado() {
        this.estado = true;
    }

}
