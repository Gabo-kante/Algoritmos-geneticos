/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reinas;

import ejercicio2.Generar;
import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public class NReina {
    private int tamanoPob;
    private int numGeneraciones;
    private double probMuta;
    private int bits;
    private ArrayList<Reina> poblacionActual;

    public NReina(int tamanoPob, int numGeneraciones, 
            double probMuta,int bits) {
        this.tamanoPob = tamanoPob;
        this.numGeneraciones = numGeneraciones;
        this.probMuta = probMuta;
        this.bits =bits;
        this.poblacionActual = new ArrayList<>();
    }
    
    public double[] evolucionar(){
    
    double[] fitness  = new double[this.numGeneraciones];
    generarPoblacionInicial();    
    // proceso evolutivo que tiene relación con el numero de generaciones
    //fitness[0] = tools.mejorPoblacion(getPoblacionActual()).getFitness();
    for(int g=1;g<this.numGeneraciones;g++){
        ArrayList<Reina> nuevaPob = new ArrayList<>();
        // garantizar que se va a generar una población nueva 
        for (int i=0; i<this.tamanoPob;i++){
            // Seleccion de una madre 
            Reina madre = Seleccion.seleccionAleatoria(this.getPoblacionActual());
            // Seleccion de un padre
            Reina padre = Seleccion.seleccionAleatoria(this.getPoblacionActual());
            // cruza (Retornar el mejor ind de la cruza)
            int[] mask = Generar.generarBinario(madre.getGenotipo().length);
            Reina hijo = Cruza.cruzaPorMascaraBinaria(madre, padre, mask);
            // Se aplica una muta evaluando una probabilidad
            if (generarProbabilidadMuta()){
               Muta.mutaSimple(hijo);
            }
            nuevaPob.add(hijo);
        }
        // actualización de la población
        sustituirPoblacion(nuevaPob);
        //System.out.println("G: "+g+" Fitness"+tools.mejorPoblacion(getPoblacionActual()).getFitness());
        fitness[g] = tools.mejorPoblacion(getPoblacionActual()).getFitness();
    }
    
    
    return fitness;
    
    }

    private void generarPoblacionInicial() {
       // generar un población aleatoria de individuos
       for(int i=0; i < this.tamanoPob;i++){
           this.getPoblacionActual().add(new Reina(this.bits));
       }
       
    }

    private boolean generarProbabilidadMuta() {
       
        if (this.probMuta>Math.random()){
           return true;
       } else{ return false;}
        
    }

    private void sustituirPoblacion(ArrayList<Reina> nuevaPob) {
        this.getPoblacionActual().clear();
       for(Reina aux:nuevaPob){
           this.getPoblacionActual().add(new Reina(aux));
       }
    }

    /**
     * @return the poblacionActual
     */
    public ArrayList<Reina> getPoblacionActual() {
        return poblacionActual;
    }
}
