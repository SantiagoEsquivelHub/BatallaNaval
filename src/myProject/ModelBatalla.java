package myProject;

import javax.swing.*;
import java.util.ArrayList;

public class ModelBatalla {


    public boolean comparadorIgualdad(int numero, ArrayList<Integer> array) {

        int contador = 0;

        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) == numero) {
                contador++;
                System.out.println(contador);
            }
        }

        if(contador == array.size()){
            return true;
        }else{
            return false;
        }

    }

    public boolean comparadorSeguidos(ArrayList<Integer> array) {

        int contador = 0;



            for (int i = 0; i < array.size(); i++) {
                int numSig = i+1;
                if(numSig < array.size()){

                    System.out.println("numSig= "+numSig+"");

                    if ((array.get(numSig) - array.get(i)) == 1){
                    contador++;
                    System.out.println("Cuantos num estan seguidos= "+contador+"");
                    }

                }

            }

           if(contador == array.size()-1){
                return true;
            }else{
                return false;
            }

    }


   /* public boolean c (boolean igualdad, boolean seguidos){

        if(igualdad && seguidos){
            System.out.println("4 celdas seleccionadas");
            JOptionPane.showMessageDialog(null,
                    "Posiciones del portaaviones registrada,\n" +
                            "ahora elige las posiciones de los 2 submarinos ",

                    "PopUp Dialog",
                    JOptionPane.INFORMATION_MESSAGE);
        }else{

        }

    }*/

}