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
public class Generar {
    
    public static int[] generarBinario(int n){
        int[] arreglo= new int[n];
        Random ran= new Random();
        for(int i=0;i<n;i++){
            arreglo[i]=ran.nextInt(2);
        }
        return arreglo;
    }
    
}
