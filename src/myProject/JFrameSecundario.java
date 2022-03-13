package myProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFrameSecundario extends JFrame{

    public JFrameSecundario() {

        this.getContentPane().setBackground(getBackground());
        this.setLocationRelativeTo(null);
        this.setSize(500,500);
        //this.pack();
        this.setTitle("Tablero del rival");

        ModelBatalla modelBatalla = new ModelBatalla();
        Rival rival = new Rival();
        JPanel tableroAparte = new JPanel();
        tableroAparte.setPreferredSize(new Dimension(500,500));
        tableroAparte.setLayout(new GridLayout(11,11));
        this.add(tableroAparte);
        /*JLabel hola = new JLabel();
        hola.setText("holi");
        this.add(hola);*/

        for(int i = 0; i < 10; i++){

            for(int j = 0; j < 10; j++){
                //matrizCeldaRival[i][j] = new Celda(i,j);
                rival.getMatrizCeldaRival()[i][j] = new Celda(i,j);

                //matrizCelda[i][j].addActionListener(escucha);
                //tableroPrincipal.add(matrizCeldaRival[i][j]);
                tableroAparte.add(rival.getMatrizCeldaRival()[i][j]);
                //matrizCeldaRival[i][j].cambiarFondo();
                rival.getMatrizCeldaRival()[i][j].cambiarFondo();
            }
        }

        Celda[][] matrizPostFragatas = modelBatalla.fragatasAleatorias(rival.getMatrizCeldaRival(), rival.getCeldasRival());
        Celda[][] matrizPostFragatas2 = modelBatalla.fragatasAleatorias(matrizPostFragatas, rival.getCeldasRival());
        Celda[][] matrizPostFragatas3 = modelBatalla.fragatasAleatorias(matrizPostFragatas2, rival.getCeldasRival());
        Celda[][] matrizPostFragatas4 = modelBatalla.fragatasAleatorias(matrizPostFragatas3, rival.getCeldasRival());
        Celda[][] matrizPostDestructores = modelBatalla.creacionDestructoresJuntos(matrizPostFragatas4,2);
        Celda[][] matrizPostDestructores2 = modelBatalla.creacionDestructoresJuntos(matrizPostDestructores,2);
        Celda[][] matrizPostDestructores3 = modelBatalla.creacionDestructoresJuntos(matrizPostDestructores2 ,2);
        Celda[][] matrizPostSubmarinos = modelBatalla.creacionSubmarinosJuntos(matrizPostDestructores3,3);
        Celda[][] matrizPostSubmarinos2 = modelBatalla.creacionSubmarinosJuntos(matrizPostSubmarinos,3);
        modelBatalla.creacionPortaavionJunto(matrizPostSubmarinos2 ,4);

    }


    public void abrirJframe(){
        JFrameSecundario tablero = new JFrameSecundario();
        tablero.setVisible(true);
        this.dispose();
    }
}
