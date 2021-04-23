/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import ejercicio2.Genetico;


/**
 *
 * @author gabri
 */
public class Test_AlgoritmosGeneticos {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]){
        Genetico gn= new Genetico(50,1000,0.12);
        gn.evolution();
        System.out.println();
    }
    
}