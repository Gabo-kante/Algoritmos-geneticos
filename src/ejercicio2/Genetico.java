/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public class Genetico {
    
    private int tamPob;
    private int ngeneraciones;
    private double probMutacion;
    private ArrayList<Individuo> pobActual;
    
    
    public Genetico(int tamaPob, int ngenerations, double pmuta ){
        this.tamPob=tamaPob;
        this.ngeneraciones=ngenerations;
        this.probMutacion=pmuta;
        this.pobActual= new ArrayList<>();
        
    }
    public void evolution(){
        generarPobinicial();
        for(int i=1; i<this.ngeneraciones;i++){//generar nueva generación
            ArrayList<Individuo> nuevaP=new ArrayList<>();
            for(int j=0; j<this.tamPob;j++){//seleccionamos a padre y madre y retornamos su cruza y aplicamos una muta con respeacto a una probabilidad
                Individuo madre = Seleccion.seleccionAleatoria(this.pobActual);
                Individuo padre = Seleccion.seleccionAleatoria(this.pobActual);
                
                int[] mascara= Generar.generarBinario(madre.getGenotipo().length);
                Individuo hijo = Cruza.cruzapormascara(madre, padre, mascara);
                
                if(ProbabilidadMuta()){
                        Mutacion.mutasimp(hijo);
                }
                nuevaP.add(hijo);
            }
            this.pobActual.clear();
            sustituirPob(nuevaP);
        }
    
    }

    private void generarPobinicial() {
        //generar poblacion de individuos
        for(int i=0;i<this.tamPob;i++){
            this.pobActual.add(new Individuo(8));
            
        }
    }

    private boolean ProbabilidadMuta() {
        if(this.probMutacion<Math.random()){
            return true;
        }else{
            return false;
        }
        
    }

    public ArrayList<Individuo> getPobActual() {
        return pobActual;
    }

    private void sustituirPob(ArrayList<Individuo> nuevaP) {
        this.pobActual.clear();
        for(Individuo aux: nuevaP){
            this.pobActual.add(new Individuo (aux));
        }
    }
    
    
    
}
