/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TSP;

import java.util.Random;

/**
 *
 * @author gabri
 */
public class Seleccion {
     public static IndividuoTSP seleccionAleatoria(PoblacionTSP pob, int[][]mat) {
        Random ran = new Random();
        int pos = ran.nextInt(pob.getPoblacion().size());

        return new IndividuoTSP(pob.getPoblacion().get(pos).getGenotipo(),mat);
    }

    public IndividuoTSP seleccionRuleta(PoblacionTSP pob) {
        int sumatotal = pob.getFitnessTotal();
        double[] probabilidad = new double[pob.getPoblacion().size()];
        double[] probacumulada = new double[pob.getPoblacion().size()];

     
        for (int i = 0; i < pob.getPoblacion().size(); i++) {
            probabilidad[i] = (double) pob.getPoblacion().get(i).getFitness() / sumatotal;
        }
        probacumulada[0] = probabilidad[0];

        for (int i = 1; i < pob.getPoblacion().size(); i++) {
            probacumulada[i] = probabilidad[i] + probacumulada[i - 1];
        }
        double numale = Math.random();
            int pos = 0;
        for (int i = 1; i < probacumulada.length; i++) {
                if(numale<= probacumulada[i]  && numale >probacumulada[i-1] ){
                pos=i;
                break;
                }
        }
        return pob.getPoblacion().get(pos);
    }
}
