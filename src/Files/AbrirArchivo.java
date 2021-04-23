/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Files;

import Reinas.Reina;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabri
 */
public class AbrirArchivo {

    public static void writte(ArrayList<Reina> poblacion) {
        File carpetanueva = new File("Files");
        carpetanueva.mkdirs();
        String carpeta = carpetanueva.getAbsolutePath();
        try {
            FileWriter filesin = new FileWriter(carpeta + "\\Pob_" + poblacion.size() + "Ind_" + poblacion.get(0).getGenotipo().length + "Gen.txt");
            BufferedWriter salida = new BufferedWriter(filesin);
            for (int i = 0; i < poblacion.size(); i++) {
                String individuo = Arrays.toString(poblacion.get(i).getGenotipo());
                char[] aux = individuo.substring(1, individuo.length() - 1).toCharArray();
                for (int j = 0; j < aux.length-1; j++) {
                    if (aux[j] == 32 || aux[j] == 44) {

                    } else {
                        salida.append(aux[j]);
                        salida.append(",");
                    }
                }
                salida.append(aux[aux.length - 1]);
                salida.append("\n");
            }
            salida.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AbrirArchivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AbrirArchivo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
