/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SATDist;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author gabri
 */
public class CruzaSAT {
      ArrayList<IndividuoSAT>  res = new ArrayList<>() ;
    public void Cruza(){
    }
    
    public static IndividuoSAT op_cruza ( IndividuoSAT gen1, IndividuoSAT gen2,int [] mask,LinkedList<int[]>muestras){
        
        int c1 [] = new int[mask.length];
        int c2 [] = new int[mask.length];

        for (int b=0; b < mask.length; b++){
            if(mask[b]==1){
                c1[b] = gen1.getGenotipo()[b];
                c2[b] = gen2.getGenotipo()[b];
            } else{
                c1[b]=gen2.getGenotipo()[b];
                c2[b] = gen1.getGenotipo()[b];

            }
        }
             IndividuoSAT aux = new IndividuoSAT(c1,muestras);       
             IndividuoSAT aux2 = new IndividuoSAT(c2,muestras);       

    
        if (aux.getFitness()>aux2.getFitness()){
            return aux;
        } else {
            return aux2;
        }
          
        
     }
}
