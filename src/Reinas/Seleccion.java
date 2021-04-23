/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reinas;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author gabri
 */
public class Seleccion {
     public static Reina seleccionAleatoria(ArrayList<Reina> pob){
        Random ran = new Random();
        int pos = ran.nextInt(pob.size());
        return new Reina(pob.get(pos));
    }
}
