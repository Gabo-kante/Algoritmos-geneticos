/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

/**
 *
 * @author gabri
 */
public class Cruza {
    public static Individuo cruzapormascara(Individuo madre, Individuo padre, int[] mask){
            int[] ac1= new int[madre.getGenotipo().length] ;
            int[] ac2= new int[madre.getGenotipo().length] ;
        for(int i=0;i<mask.length;i++){
            if(mask[i]==0){
                ac1[i]=padre.getGenotipo()[i];
                ac2[i]=madre.getGenotipo()[i];

            }else{
                ac1[i]=madre.getGenotipo()[i];
                ac2[i]=padre.getGenotipo()[i];

            }
        }
        Individuo n1= new Individuo(ac1);
        Individuo n2= new Individuo(ac2);

        if(n1.getFitness()>n2.getFitness()){
            return n1;
        }else{
            return n2;
        }
    }
    
}
