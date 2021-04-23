/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reinas;

import java.util.Random;

/**
 *
 * @author gabri
 */
public class Muta {
     public static void mutaSimple(Reina ind){
        Random ran = new Random();
        int pos = ran.nextInt(ind.getGenotipo().length);
        int nuevapos = ran.nextInt(ind.getGenotipo().length);
        ind.getGenotipo()[pos] = nuevapos;
        ind.calcularFitness();
    }
}
