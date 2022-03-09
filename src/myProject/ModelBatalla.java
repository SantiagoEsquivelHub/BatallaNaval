package myProject;

import java.util.ArrayList;

public class ModelBatalla {


    public boolean comparadorFilas(int numFila, ArrayList<Integer> ArrayFilas){

        int ultimoFila = ArrayFilas.size()-1;

        if(ArrayFilas.get(ultimoFila) == numFila){
           // System.out.println("Fila Dentro del Array: "+ArrayFilas.get(ultimoFila));
           // System.out.println("valor a comparar: "+numFila);
           // System.out.println("True");
            return true;
        }else{
           // System.out.println("Fila Dentro del Array: "+ArrayFilas.get(ultimoFila));
           // System.out.println("Valor a comparar: "+numFila);
           // System.out.println("False");
            return false;
        }
    }

}
