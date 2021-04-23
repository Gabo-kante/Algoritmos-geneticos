/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reinas;

import graficar.Grafica;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public class test {

    public static void main(String args[]) throws IOException {

       
        NReina gb = new NReina(10, 100, 0.15, 8);
        gb.evolucionar();
        double[] evolucion = gb.evolucionar();
       
        Files.AbrirArchivo.writte(gb.getPoblacionActual());
    }
}
