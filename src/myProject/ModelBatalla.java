package myProject;

import java.util.ArrayList;

public class ModelBatalla {
    ArrayList<Integer> filasArray = new ArrayList<Integer>();
    ArrayList<Integer> columnasArray = new ArrayList<Integer>();
    int contador = 0;


    public void setFilasArray(int numFilas) {
        filasArray.add(numFilas);
        contador++;
        //System.out.println(numFilas);

    }

    public boolean comparadorFilas(int numFila){

        for(int i = 0; i < filasArray.size(); i++){
            if(filasArray.get(i) == numFila){
               return true;
            }
        }
        return false;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public boolean comparadorColumnas(int numColumna){
        for(int i = 0; i < columnasArray.size(); i++){
            if(columnasArray.get(i) == numColumna){
                return true;
            }
        }

        return false;
    }

    public void setColumnasArray(int numColumnas) {
        filasArray.add(numColumnas);
        contador++;
        //System.out.println(numColumnas);
    }

}
