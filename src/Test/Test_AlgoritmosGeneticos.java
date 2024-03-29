/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import ejercicio2.Genetico;
import Files.Archivo;
import Reinas.GeneticoReinas;
import Herramientas.HerramientasReinas;
import Reinas.Individuo;
import TSPinclinaciones.GeneticoTSP;
import Herramientas.HerramientasTSPIncli;
import binario.Cruza;
import binario.GeneticoBinario;
import binario.Herramientas;
//import binario.Individuo;
import binario.Muta;
import binario.Poblacion;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author working
 */
public class Test_AlgoritmosGeneticos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Poblacion poblacionInicial = new Poblacion(10, 4);
        ArrayList<Individuo> individuos = new ArrayList<>();
       
        System.out.println("Lista");      
        for (Individuo aux : poblacionInicial.getIndividuos()) {

            System.out.println("Fenotipo: " + aux.getFenotipo() + "    Fitness: " + aux.getFitness());
        }
        System.out.println();
        
        

        System.out.println("Mejores");
        individuos = poblacionInicial.getNMejores(10);

        for (Individuo aux : individuos) {

            System.out.println("Fenotipo: " + aux.getFenotipo() + "    Fitness: " + aux.getFitness());
        }
        System.out.println();
        
        System.out.println("Fenotipo: " + individuos.get(0).getFenotipo() + "    Fitness: " + individuos.get(0).getFitness());
        Muta.mutarGenotipo(1, individuos.get(0));
        
        System.out.println("Fenotipo: " + individuos.get(0).getFenotipo() + "    Fitness: " + individuos.get(0).getFitness());*/
        
       /*int numGeneraciones = 400;
        int tamPoblacion = 100;
        int tamIndividuos = 8;
        double pMuta = 0.12;
        
        int[] mask = HerramientasReinas.generarMascaraAleatoria(tamIndividuos);
        GeneticoReinas reinas1 = new GeneticoReinas(numGeneraciones, tamPoblacion, tamIndividuos, pMuta, mask);
        reinas1.crearNuevasGeneraciones();
    
        ArrayList<Individuo> guardarMejores = new ArrayList<>();
        guardarMejores = (ArrayList<Individuo>) reinas1.getPoblacionActual().getMejoresIndividuos(10).clone();
        Archivo.escribir(guardarMejores);
        
        ArrayList<Individuo> tokenizada = new ArrayList<>();
        try {
            tokenizada = Archivo.tokenizarDataSet();
            for(Individuo aux : tokenizada)
                System.out.println(Arrays.toString(aux.getGenotipo()));
                
        } catch (IOException ex) {
            Logger.getLogger(Geneticos20212.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        int numGeneraciones = 10000;
        int tamPoblacion = 70;
        int nCiudades = 100;
        int ciudadInicial = 3;
        double pMuta = 0.12;
        int limiteInclinaciones = 5;

        if (ciudadInicial < nCiudades) {
//            GeneticoTSP tsp1 = new GeneticoTSP(numGeneraciones, tamPoblacion, pMuta, ciudadInicial, nCiudades, 5);
//            tsp1.crearNuevasGeneraciones();
            
            GeneticoTSP tsp2 = new GeneticoTSP(numGeneraciones, tamPoblacion, pMuta, ciudadInicial, HerramientasTSPIncli.cargarMatrizDeDistancias(), HerramientasTSPIncli.cargarInclinaciones());
            tsp2.crearNuevasGeneraciones();
        }
        
        
        
    }

}
