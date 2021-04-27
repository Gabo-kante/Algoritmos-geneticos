/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TSP;

import Files.CrearFile;
import Files.CrearFileMatriz;
import Files.LeerFileMatriz;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author gabri
 */
public class Generaciones {

    private int num_G;
    private double pMuta;
    private PoblacionTSP pobActual;
    private int tamPob;
    private int tamt;
    double gens[];
    int[][] matriz;
    
    public double[] getGens() {
        return gens;
    }

    public void setGens(double[] gens) {
        this.gens = gens;
    }

    public Generaciones(int num_G, double pMuta, int tamPob, int tamg, int Mdist) throws IOException {
        this.num_G = num_G;
        this.pMuta = pMuta;
        this.tamPob = tamPob;
        CrearFileMatriz md = new CrearFileMatriz(new MatrizDist(tamg,Mdist).Matriz,tamg,Mdist);
        this.matriz = LeerFileMatriz.tokenizarDataSet4(tamg,Mdist);
        MatrizDist red = new MatrizDist(this.matriz,Mdist);
        red.imprimirMat();
        CrearFile c = new CrearFile(new PoblacionTSP(tamPob, tamg).getPoblacion(), num_G, pMuta, tamPob, tamg,this.matriz);
       this.pobActual = new PoblacionTSP(Files.LeerFile.tokenizarDataSet2(num_G, pMuta, tamPob, tamg),red.Matriz);
       this.pobActual.mostrarPob();
        this.tamt = tamg;
    }

    public void evolucionar() {
        int mascara[] = new int[tamt];
        Random ran = new Random();
        for (int x = 0; x < tamt; x++) {
            mascara[x] = ran.nextInt(2);
        }
        IndividuoTSP mejor;
        gens = new double[num_G];
        for (int g = 0; g < this.num_G; g++) {
            PoblacionTSP nueva = new PoblacionTSP();
            mejor = Seleccion.seleccionAleatoria(this.pobActual,this.matriz);
            for (int i = 0; i < this.tamPob; i++) {
                IndividuoTSP madre = Seleccion.seleccionAleatoria(this.pobActual,this.matriz);
                IndividuoTSP padre = Seleccion.seleccionAleatoria(this.pobActual,this.matriz);
                IndividuoTSP hijo = Cruza.Act_cruza(madre, padre, mascara,this.matriz);

                if (Math.random() < this.pMuta) {
                    Muta.aplicarMutaAleatoria(hijo);
                }
                   nueva.getPoblacion().add(hijo);
                if (hijo.getFitness() <= mejor.getFitness()) {
                    mejor = new IndividuoTSP(hijo.getGenotipo(),this.matriz);
                }
            }
            System.out.println("Generación #" + g + " ===> " + mejor.toString());
           
            gens[g] = mejor.getFitness();
            this.pobActual = new PoblacionTSP(nueva,this.matriz);
           
            CrearFile c = new CrearFile(this.pobActual.getPoblacion(), num_G, pMuta, tamPob, tamt,this.matriz);

        }

    }

}
