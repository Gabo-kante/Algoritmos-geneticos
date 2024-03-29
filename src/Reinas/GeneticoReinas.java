/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reinas;

import Grafica.Histograma;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author gabri
 */
public class GeneticoReinas {
    
    Poblacion poblacionActual;
    int numGeneraciones, tamPoblacion, tamIndividuos;
    double pMuta;
    int[] mask;
    int[] mejoresFitness;

    public GeneticoReinas() {

    }

    public GeneticoReinas(int numGeneraciones, int tamPoblacion, int tamIndividuos, double pMuta, int[] mask) {
        this.poblacionActual = new Poblacion(tamPoblacion, tamIndividuos);
        this.numGeneraciones = numGeneraciones;
        this.tamPoblacion = tamPoblacion;
        this.tamIndividuos = tamIndividuos;
        this.pMuta = pMuta;
        this.mask = new int[mask.length];
        this.mejoresFitness = new int[numGeneraciones];
        this.mask = mask.clone();
    }
    
    public void crearNuevasGeneraciones(){
        // Iteramos de acuerdo al numero de generaciones
        for (int generacion = 1; generacion <= this.numGeneraciones; generacion++) {
            // Creamos un ArrayList para la nueva poblacion
            ArrayList<Individuo> nuevaPoblacion = new ArrayList<>();
            for (int individuo = 0; individuo < this.tamPoblacion; individuo++) {
                // seleccionamos aleatoriamente los padres
                Random ran = new Random();
                
                int posMadre = ran.nextInt(tamPoblacion-1);
                int posPadre = ran.nextInt(tamPoblacion-1);
                
                Individuo madre = this.poblacionActual.getIndividuos().get(posMadre);                    
                Individuo padre = this.poblacionActual.getIndividuos().get(posPadre);
                
                
                // Cruzamos para crear a los hijos
                Individuo hijo = Cruza.cruzar(padre, madre, mask);
                
                //Evaluamos si el hijo va mutar o no
                Muta.mutarGenotipo(pMuta, hijo);
                
                // agregamos el hijo
                nuevaPoblacion.add(hijo);
            }
            
            // actualizamos la nueva población
            this.poblacionActual = new Poblacion(nuevaPoblacion);
            System.out.println("Generacion: " + generacion + " creada");
            
            // pedimos el mejor a la poblacion 
            Individuo mejorIndividuo = this.poblacionActual.getMejorIndividuo();
            
            mejoresFitness[generacion-1] = mejorIndividuo.getFitness();
            //System.out.println("El mejor individuo tiene genotipo: " + Arrays.toString(mejorIndividuo.getGenotipo()));
            //System.out.println("Con el fitness: " + mejorIndividuo.getFitness());
            System.out.println();

            
        }
        // pedimos el mejor a la poblacion 
        Individuo mejorIndividuo = this.poblacionActual.getMejorIndividuo();
        
        System.out.println("El mejor individuo tiene genotipo: "+Arrays.toString(mejorIndividuo.getGenotipo()));
        System.out.println("Con el fitness: "+mejorIndividuo.getFitness()); 
        System.out.println();

        Histograma h1 = new Histograma(mejoresFitness);
        h1.graficar();

        
    }

    public void setPoblacionActual(Poblacion poblacionActual) {
        this.poblacionActual = poblacionActual;
    }

    public Poblacion getPoblacionActual() {
        return poblacionActual;
    }
    
    
    

    


    
    
}
