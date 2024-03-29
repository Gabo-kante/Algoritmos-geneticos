/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TSP;

import Herramientas.HerramientasTSP;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author gabri
 */
public class Individuo {

    private int[] genotipo;
    private int fitness;
    public int[][] distanciasCaminos;

    public Individuo() {
    }

    public Individuo(int ciudadInicial, int matrizCargada[][]) {
        genotipo = new int[matrizCargada[0].length];
        genotipo[0] = ciudadInicial;
        this.distanciasCaminos = matrizCargada;
        creaeGenotipoAleatorio();
        calcularFitness();
    }

    public Individuo(int genotipo[], int matrizCargada[][]) {       
        this.genotipo = genotipo.clone();
        this.distanciasCaminos = matrizCargada;
        calcularFitness();
    }

    public Individuo(int ciudadInicial, int nCiudades) {
        genotipo = new int[nCiudades];
        genotipo[0] = ciudadInicial;        
        this.distanciasCaminos = HerramientasTSP.inicializaCaminos(nCiudades);
        creaeGenotipoAleatorio();
        calcularFitness();
        //HerramientasTSP.escribir(distanciasCaminos);

    }

    public void calcularFitness() {
        this.fitness = 0;
        if (distanciasCaminos != null) {
            this.fitness = 0;
            for (int j = 1; j < distanciasCaminos.length; j++) {
                this.fitness += distanciasCaminos[this.genotipo[j - 1]][this.genotipo[j]];
                //System.out.println("Sumado: " + distanciasCaminos[this.genotipo[j - 1]][this.genotipo[j]]);

            }
            this.fitness += distanciasCaminos[this.genotipo[0]][this.genotipo[distanciasCaminos.length - 1]];
            //System.out.println("Sumado: " + distanciasCaminos[this.genotipo[0]][this.genotipo[distanciasCaminos.length - 1]]);

            //System.out.println("Fitness: " + this.fitness);
        }

    }

    public void calcularFitness2() {
        this.fitness = 0;
        if (distanciasCaminos != null) {
            this.fitness = 0;
            for (int j = 1; j < distanciasCaminos.length; j++) {
                this.fitness += distanciasCaminos[this.genotipo[j - 1]][this.genotipo[j]];
                System.out.println("Sumado: " + distanciasCaminos[this.genotipo[j - 1]][this.genotipo[j]]);

            }
            this.fitness += distanciasCaminos[this.genotipo[0]][this.genotipo[distanciasCaminos.length - 1]];
            System.out.println("Sumado: " + distanciasCaminos[this.genotipo[0]][this.genotipo[distanciasCaminos.length - 1]]);

            System.out.println("Fitness: " + this.fitness);
        }

    }

    public void creaeGenotipoAleatorio() {
        ArrayList<Integer> ciudades = new ArrayList<>();
        for (int x = 0; x < genotipo.length; x++) {
            ciudades.add(x);
        }
        ciudades.remove(this.genotipo[0]);
        Random ran = new Random();
        // llenar los espacios vacios restantes del genotipo 
        for (int x = 1; x < genotipo.length; x++) {
            int pos = ran.nextInt(ciudades.size());
            int c = ciudades.get(pos);
            this.genotipo[x] = c;
            // eliminamos de las ciudades
            ciudades.remove(pos);
        }
        //System.out.println("Gebotipo creado aleatorio-> "+Arrays.toString(genotipo));

    }
    
    public void actualizarIndividuo(){
        calcularFitness();    
    }
    
    

    public void setGenotipo(int[] genotipo) {
        this.genotipo = genotipo;
    }

    public void setFitness(int fitness) {
        this.fitness = fitness;
        
    }
    public void setFitness() {
        calcularFitness();        
    }

    public void setDistanciasCaminos(int[][] distanciasCaminos) {
        this.distanciasCaminos = distanciasCaminos;
    }

    public int[] getGenotipo() {
        return genotipo;
    }

    public int getFitness() {
        return fitness;
    }

    public int[][] getDistanciasCaminos() {
        return distanciasCaminos;
    }

    public static void main(String[] args) {
        Individuo i1 = new Individuo(3, 4);
        System.out.println("FITNESS FINAL>> " + i1.getFitness());
        System.out.println();
        HerramientasTSP.imprimirMat(i1.getDistanciasCaminos());
        System.out.println("");
        System.out.println("***************************************************************");

       /*int matrizCargada[][] = new int[4][4];
        matrizCargada = HerramientasTSP.inicializaCaminos(4);
        Individuo i2 = new Individuo(3, matrizCargada);
        System.out.println("FITNESS FINAL>> " + i2.getFitness());
        System.out.println();
        HerramientasTSP.imprimirMat(i2.getDistanciasCaminos());*/
       
       

       

    }

}
