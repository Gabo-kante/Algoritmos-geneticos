/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TSP;

import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author gabri
 */
public class PoblacionTSP {
        
 private LinkedList<IndividuoTSP> poblacion;
    private int i;
    private int tam;

    public PoblacionTSP(int i,int tam){
        this.i = i;
        this.tam=tam;
        this.poblacion = new LinkedList<>();
        inicializarAleatorimente();
    }

    public PoblacionTSP(LinkedList<IndividuoTSP> muestra, int[][]Matriz){
        this.poblacion = new LinkedList<>();
        for(int x=0;x<muestra.size();x++){
            this.poblacion.add(new IndividuoTSP(muestra.get(x).getGenotipo(),Matriz));
        }
    }

      public PoblacionTSP(){
        this.poblacion = new LinkedList<>();
        
    }

    public PoblacionTSP(PoblacionTSP n, int[][] Matriz){
        this.poblacion = new LinkedList<>();
        for(IndividuoTSP aux: n.getPoblacion()){
            this.poblacion.add(new IndividuoTSP(aux.getGenotipo(),Matriz));

        }

    }

    public void inicializarAleatorimente(){

       for(int x=0; x< this.i; x++){
            this.poblacion.add(new IndividuoTSP(this.tam));

       }

    }
    public LinkedList<IndividuoTSP> generarMuestraAleatoria(double p){
        int c = (int)((this.i*p)/100);
        LinkedList<IndividuoTSP> muestra = new LinkedList<>();
        int pa = 0;
        Random ran = new Random();
        for(int x=0; x<c;x++){
            pa = ran.nextInt(this.i);
            muestra.add(this.poblacion.get(pa));

        }
     return muestra;
    }

    public LinkedList<IndividuoTSP> generarMuestraMejores(double p){
        int c = (int)((this.i*p)/100);
        LinkedList<IndividuoTSP> muestra = new LinkedList<>();
     return muestra;
    }
   
   public LinkedList<IndividuoTSP> getPoblacion(){

    return poblacion;
   }
   
   public int getFitnessTotal(){
   int fitT=0;
   
   for(int i=0;i<poblacion.size();i++){
    fitT+=poblacion.get(i).getFitness();
   
   }
   return fitT;
   }
   
   public void mostrarPob(){
       System.out.println("# de Individuos : "+poblacion.size());
   for(int z=0;z<poblacion.size();z++){
     String aux = "Genotipo: ";
        for (int i = 0; i < poblacion.get(z).getGenotipo().length; i++) {
           
            if (i <= poblacion.get(z).getGenotipo().length - 1) {
                 aux += poblacion.get(z).getGenotipo()[i] + ",";
                

            }else{aux += poblacion.get(z).getGenotipo()[i];}
        }
        aux += " Fenotipo => " + poblacion.get(z).getFitness();
        System.out.println(aux);
   }
   }
}
