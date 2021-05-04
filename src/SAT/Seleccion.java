/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAT;

import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author gabri
 */
public class Seleccion {
  
  public static Individuo seleccionAleatoria(Poblacion pob,LinkedList<int[]> m){
        Random ran = new Random();
       int pos = ran.nextInt(pob.getPoblacion().size());

       return new Individuo(pob.getPoblacion().get(pos).getGenotipo(),m); 
    }
}