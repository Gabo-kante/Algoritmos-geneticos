/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

import java.util.Random;

/**
 *
 * @author gabri
 */
public class Mutacion {
    public static void mutasimp(Individuo in){
        Random ran= new Random();
        int pos = ran.nextInt(in.getGenotipo().length);
        if(in.getGenotipo()[pos]==1){
            in.getGenotipo()[pos]=0;
        }else{
            in.getGenotipo()[pos]=1;
        }
        in.calcularFitness();
    }
}
