/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TSP;

import graficar.Grafica;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author gabri
 */
public class IndividuoTSP {

    private int genotipo[];
    private int[] fenotipo;
    private long fitness;
    private int[][] matriz;
    IndividuoTSP() {
    }

    public int[] getGenotipo() {
        return genotipo;
    }

    public void setGenotipo(int[] genotipo) {
        this.genotipo = genotipo;
    }

    public int[] getFenotipo() {
        return fenotipo;
    }

    public void setFenotipo(int[] fenotipo) {
        this.fenotipo = fenotipo;
    }

    public long getFitness() {
        return fitness;
    }

    public void setFitness(long fitness) {
        this.fitness = fitness;
    }

       public IndividuoTSP(int n) {
        this.genotipo = new int[n];
        inicializarAleatoriamente(n);
    }
            public IndividuoTSP(int [][] matriz) {
        this.matriz = matriz;
    }
              public IndividuoTSP(IndividuoTSP ind, int[][] matriz) {
                  this.fitness = ind.fitness;
                  this.genotipo = ind.genotipo;
                  this.matriz = matriz;
    }
    public IndividuoTSP(int n, int[][] mat) {
        this.genotipo = new int[n];
        this.matriz = mat;
        inicializarAleatoriamente(n);
        calcularFitness();
    }

    public IndividuoTSP(int aux[], int[][] mat) {
        this.genotipo = aux.clone();
        this.matriz = mat;
        calcularFitness();
    }
   public IndividuoTSP(int aux[]) {
        this.genotipo = aux.clone();
    }
    public void calcularFitness() {
        this.fitness = 0;
        for (int j = 1; j < this.matriz.length; j++) {
            this.fitness += this.matriz[this.genotipo[j - 1]][this.genotipo[j]];
             }
        this.fitness += this.matriz[this.genotipo[0]][this.genotipo[this.matriz.length - 1]];
        // System.out.println("Fitnes= "+this.fitness);

    }

    public void calcularFenotipo() {

    }

    private void inicializarAleatoriamente(int n) {
        Set<Integer> generados = new HashSet<>();
        Random rnd = new Random();
        for (int i = 0; i < n; i++) {
            int aleatorio = -1;
            boolean generado = false;
            while (!generado) {
                int posible = (int) (Math.random() * (n - 0) + 0);;
                if (!generados.contains(posible)) {
                    generados.add(posible);
                    this.genotipo[i] = posible;
                    aleatorio = posible;
                    generado = true;
                }
            }
        }
 System.out.print("Genotipo: ");
        for (int i = 0; i < n; i++) {
            if (i < n-1) {
                System.out.print(this.genotipo[i] + ",");
            } else {
                System.out.println( this.genotipo[i]);

            }
        }

    }

    public void calcularFit() {
        this.fitness = 0;

    }
    public boolean validar(){
    for(int i = 0;i<genotipo.length;i++){
      for(int j = 0;j<genotipo.length;j++){
                if(i!=j && genotipo[i] == genotipo[j]){
                 return false;
                }
                
    }
    }
    return true;
    }
     public void imprimirIndividuo(){
         for(int i=0;i<genotipo.length;i++){
         if(i!=genotipo.length-1){
         System.out.print(genotipo[i]+",");
         }else{
                  System.out.println(genotipo[i]);

         }
         }
     }

    @Override
    public String toString() {
          String aux = "Genotipo: ";
        for (int i = 0; i < genotipo.length; i++) {
            aux += genotipo[i] + ",";
            if (i == genotipo.length - 1) {
                aux += genotipo[i];

            }
        }
        aux += " Fenotipo => " + this.fitness;
        return aux;
    }

    public static void main(String args[]) throws IOException {
      
      // System.out.println("Prueba #" + i + ": ");
       
            Generaciones gen1 = new Generaciones(20,.5,5,4,15);
            gen1.evolucionar();
           Grafica graf1 = new Grafica("Comportamiento (200,.2,400,25)","Generación","Fitness");
           graf1.crearSerie("Datos : (200,.2,400,25)",gen1.getGens());
           graf1.mostrarGrafica();
            
//            
//             Generaciones gen2 = new Generaciones(1000,.2,500,100);
//            gen2.evolucionar();
//            Grafica graf2 = new Grafica("Comportamiento (000,.2,500,100)","Generación","Fitness");
//            graf2.crearSerie("Datos : (000,.2,500,100)",gen2.getGens());
//            graf2.mostrarGrafica();
//            
//             Generaciones gen3 = new Generaciones(2500,.1,400,150);
//            gen3.evolucionar();
//            Grafica graf3 = new Grafica("Comportamiento (2500,.1,400,150)","Generación","Fitness");
//            graf3.crearSerie("Datos : (2500,.1,400,150)",gen3.getGens());
//            graf3.mostrarGrafica();
//            
//             Generaciones gen4 = new Generaciones(10000,.05,1000,5000);
//            gen4.evolucionar();
//            Grafica graf4 = new Grafica("Comportamiento (10000,.05,1000,500)","Generación","Fitness");
//            graf4.crearSerie("Datos : (10000,.05,1000,5000)",gen4.getGens());
//            graf4.mostrarGrafica();
    }
}
