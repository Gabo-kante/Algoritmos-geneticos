/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SATbooleana;


import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author gabri
 */
public class Muta {

    public static void mutarGenotipo(double probUSR, Individuo ind, ArrayList<Instancias> instancias) {
        // Generamos una probabilidad aleatoria entre 0-1
        Random aux = new Random();
        double probRandom = aux.nextDouble() * 1;

        if (probRandom <= probUSR) {
            // modificar un bit aleatorio del genotipo
            Random ran = new Random();
            int pos = ran.nextInt(ind.getGenotipo().length);
            if (ind.getGenotipo()[pos] == 1) {
                ind.getGenotipo()[pos] = 0;
            } else {
                ind.getGenotipo()[pos] = 1;
            }

            // actualizamos el fenotipo y el fitness nuevos con solo llamar al calcular fitness
            ind.calcularFitness(instancias);

        }
    }
}