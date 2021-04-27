/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TSP;

import Files.CrearFileMatriz;
import Files.LeerFileMatriz;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author gabri
 */
public class Cruza {

    ArrayList<IndividuoTSP> res = new ArrayList<>();

    public void Cruza() {
    }

    public static IndividuoTSP Act_cruza(IndividuoTSP gen1, IndividuoTSP gen2, int[] mask, int[][] matriz) {
        IndividuoTSP ret = null ;
        boolean sigue = true;
        while (sigue) {
            int c1[] = new int[mask.length];
            int c2[] = new int[mask.length];

            for (int b = 0; b < mask.length; b++) {
                if (mask[b] == 1) {
                    c1[b] = gen1.getGenotipo()[b];
                    c2[b] = gen2.getGenotipo()[b];
                } else {
                    c1[b] = gen2.getGenotipo()[b];
                    c2[b] = gen1.getGenotipo()[b];

                }
            }
            IndividuoTSP aux = new IndividuoTSP(c1,matriz);
            IndividuoTSP aux2 = new IndividuoTSP(c2,matriz);
                System.out.print("Hijo 1: ");
                aux.imprimirIndividuo();
                System.out.print("Hijo 2: ");
                aux2.imprimirIndividuo();

            if (aux.validar() && aux2.validar()) {
                sigue = false;

                if (aux.getFitness() <= aux2.getFitness()) {
                    ret = new IndividuoTSP(aux,matriz);

                } else {
                    ret =  new IndividuoTSP(aux2,matriz);
                }

            } else {
                System.out.println("No jalo cambio de mask");
                Random ran = new Random();
                for (int x = 0; x < mask.length; x++) {
                    mask[x] = ran.nextInt(2);
                    if (x != mask.length - 1) {
                        System.out.print(mask[x] + ",");
                    } else {
                        System.out.println(mask[x]);

                    }
                }
                sigue = true;
            }
        }
        return ret;
    }

    public static void main(String args[]) throws IOException {
//
//        LeerArchivoMatriz l = new  LeerArchivoMatriz ();
//
//        MatrizDist t = new MatrizDist( l.tokenizarDataSet4(8,100));
//        t.imprimirMat();
//        IndividuoTCP it = new IndividuoTCP(8,t.Matriz);
//        IndividuoTCP it2 = new IndividuoTCP(8,t.Matriz);

//         it.imprimirIndividuo();

    }
}
