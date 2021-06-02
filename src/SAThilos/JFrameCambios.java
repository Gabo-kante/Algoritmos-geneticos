/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAThilos;

import Herramientas.HerramientasSAThilos;
import Files.ArchivosSAThilos;
import Grafica.Grafica;
import java.awt.BorderLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartPanel;

/**
 *
 * @author gabri
 */
public class JFrameCambios extends javax.swing.JFrame {

    /**
     * Creates new form JFramePrincipal
     */
    

    public JFrameCambios() {
        initComponents();
        GeneticoSAT satBooleana;
        int numGeneraciones = 30000;
        int tamPoblacion = 100;
        int tamIndividuos = 100;
        double pMuta = 0.12;

        int[] mask = HerramientasSAThilos.generarMascaraAleatoria(tamIndividuos);
        ArrayList<Instancias> instancias = null;
        try {
            instancias = ArchivosSAThilos.tokenizarDataSet();
        } catch (IOException ex) {
            System.out.print("No se abrio ningun archivo");
        }

        satBooleana = new GeneticoSAT(numGeneraciones, tamPoblacion, tamIndividuos, pMuta, mask, instancias, this);
        

        ListenerHilos lis = new ListenerHilos(this, satBooleana);
        this.jButtonModificarParametros.addActionListener(lis);

        Thread hiloSAT = new Thread( satBooleana);
        hiloSAT.start();

    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        seleccion = new javax.swing.ButtonGroup();
        jTextFieldMuta = new javax.swing.JTextField();
        jButtonModificarParametros = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jPanelDeGrafica = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldNgen = new javax.swing.JTextField();
        jTextFieldTamPob = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        SeleccionAleatoria = new javax.swing.JRadioButton();
        SeleccionTorneo = new javax.swing.JRadioButton();
        SeleccionRuleta = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonModificarParametros.setText("Modificar Parametros");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jLabel1.setText("Probabilidad de muta ");

        jPanelDeGrafica.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout jPanelDeGraficaLayout = new javax.swing.GroupLayout(jPanelDeGrafica);
        jPanelDeGrafica.setLayout(jPanelDeGraficaLayout);
        jPanelDeGraficaLayout.setHorizontalGroup(
            jPanelDeGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 841, Short.MAX_VALUE)
        );
        jPanelDeGraficaLayout.setVerticalGroup(
            jPanelDeGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel3.setText("Numero de Generaciones");

        jTextFieldNgen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNgenActionPerformed(evt);
            }
        });

        jLabel2.setText("Tamaño de Población");

        seleccion.add(SeleccionAleatoria);
        SeleccionAleatoria.setText("Aleatoria");
        SeleccionAleatoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccionAleatoriaActionPerformed(evt);
            }
        });

        seleccion.add(SeleccionTorneo);
        SeleccionTorneo.setText("Torneo");

        seleccion.add(SeleccionRuleta);
        SeleccionRuleta.setText("Ruleta");

        jLabel4.setText("Selección: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextFieldNgen)
                                    .addComponent(jTextFieldTamPob))
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SeleccionRuleta)
                                    .addComponent(SeleccionTorneo)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(62, 62, 62))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextFieldMuta)
                                        .addGap(45, 45, 45)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(SeleccionAleatoria))))
                        .addGap(103, 103, 103))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(jButtonModificarParametros)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanelDeGrafica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldMuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SeleccionAleatoria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldTamPob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SeleccionRuleta))
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldNgen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SeleccionTorneo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonModificarParametros)
                .addGap(39, 39, 39))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelDeGrafica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNgenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNgenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNgenActionPerformed

    private void SeleccionAleatoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccionAleatoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SeleccionAleatoriaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrameCambios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameCambios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameCambios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameCambios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton SeleccionAleatoria;
    private javax.swing.JRadioButton SeleccionRuleta;
    private javax.swing.JRadioButton SeleccionTorneo;
    private javax.swing.JButton jButtonModificarParametros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanelDeGrafica;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextFieldMuta;
    private javax.swing.JTextField jTextFieldNgen;
    private javax.swing.JTextField jTextFieldTamPob;
    public static javax.swing.ButtonGroup seleccion;
    // End of variables declaration//GEN-END:variables


    public int tipoDeSeleccion() {
        if (this.getSeleccionAleatoria().isSelected()) {
            return 1;
        } else if (this.getSeleccionTorneo().isSelected()) {
            return 2;
        } else if (this.getSeleccionRuleta().isSelected()) {
            return 3;
        } else {
            return 0;
        }
    }

    public void actualizarGrafica(ArrayList<Integer> datops) {
        Grafica grafica = new Grafica("Generacion", "Fitness", "SATbooleana");
        grafica.crearSerie("Generaciones", datops);
        grafica.crearGrafica();
        ChartPanel cp = grafica.crearChartPanel(getjPanelDeGrafica().getSize());

        getjPanelDeGrafica().removeAll();
        getjPanelDeGrafica().add(cp, BorderLayout.CENTER);
        getjPanelDeGrafica().updateUI();

    }



    /**
     * @return the SeleccionAleatoria
     */
    public javax.swing.JRadioButton getSeleccionAleatoria() {
        return SeleccionAleatoria;
    }

    /**
     * @param SeleccionAleatoria the SeleccionAleatoria to set
     */
    public void setSeleccionAleatoria(javax.swing.JRadioButton SeleccionAleatoria) {
        this.SeleccionAleatoria = SeleccionAleatoria;
    }

    /**
     * @return the SeleccionRuleta
     */
    public javax.swing.JRadioButton getSeleccionRuleta() {
        return SeleccionRuleta;
    }

    /**
     * @param SeleccionRuleta the SeleccionRuleta to set
     */
    public void setSeleccionRuleta(javax.swing.JRadioButton SeleccionRuleta) {
        this.SeleccionRuleta = SeleccionRuleta;
    }

    /**
     * @return the SeleccionTorneo
     */
    public javax.swing.JRadioButton getSeleccionTorneo() {
        return SeleccionTorneo;
    }

    /**
     * @param SeleccionTorneo the SeleccionTorneo to set
     */
    public void setSeleccionTorneo(javax.swing.JRadioButton SeleccionTorneo) {
        this.SeleccionTorneo = SeleccionTorneo;
    }

    /**
     * @return the jButtonModificarParametros
     */
    public javax.swing.JButton getjButtonModificarParametros() {
        return jButtonModificarParametros;
    }

    /**
     * @param jButtonModificarParametros the jButtonModificarParametros to set
     */
    public void setjButtonModificarParametros(javax.swing.JButton jButtonModificarParametros) {
        this.jButtonModificarParametros = jButtonModificarParametros;
    }

    /**
     * @return the jLabel1
     */
    public javax.swing.JLabel getjLabel1() {
        return jLabel1;
    }

    /**
     * @param jLabel1 the jLabel1 to set
     */
    public void setjLabel1(javax.swing.JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    /**
     * @return the jLabel2
     */
    public javax.swing.JLabel getjLabel2() {
        return jLabel2;
    }

    /**
     * @param jLabel2 the jLabel2 to set
     */
    public void setjLabel2(javax.swing.JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    /**
     * @return the jLabel3
     */
    public javax.swing.JLabel getjLabel3() {
        return jLabel3;
    }

    /**
     * @param jLabel3 the jLabel3 to set
     */
    public void setjLabel3(javax.swing.JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    /**
     * @return the jLabel4
     */
    public javax.swing.JLabel getjLabel4() {
        return jLabel4;
    }

    /**
     * @param jLabel4 the jLabel4 to set
     */
    public void setjLabel4(javax.swing.JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }

    /**
     * @return the jPanelDeGrafica
     */
    public javax.swing.JPanel getjPanelDeGrafica() {
        return jPanelDeGrafica;
    }

    /**
     * @param jPanelDeGrafica the jPanelDeGrafica to set
     */
    public void setjPanelDeGrafica(javax.swing.JPanel jPanelDeGrafica) {
        this.jPanelDeGrafica = jPanelDeGrafica;
    }

    /**
     * @return the jScrollPane2
     */
    public javax.swing.JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    /**
     * @param jScrollPane2 the jScrollPane2 to set
     */
    public void setjScrollPane2(javax.swing.JScrollPane jScrollPane2) {
        this.jScrollPane2 = jScrollPane2;
    }

    /**
     * @return the jTextArea1
     */
    public javax.swing.JTextArea getjTextArea1() {
        return jTextArea1;
    }

    /**
     * @param jTextArea1 the jTextArea1 to set
     */
    public void setjTextArea1(javax.swing.JTextArea jTextArea1) {
        this.jTextArea1 = jTextArea1;
    }

    /**
     * @return the jTextFieldMuta
     */
    public javax.swing.JTextField getjTextFieldMuta() {
        return jTextFieldMuta;
    }

    /**
     * @param jTextFieldMuta the jTextFieldMuta to set
     */
    public void setjTextFieldMuta(javax.swing.JTextField jTextFieldMuta) {
        this.jTextFieldMuta = jTextFieldMuta;
    }

    /**
     * @return the jTextFieldNgen
     */
    public javax.swing.JTextField getjTextFieldNgen() {
        return jTextFieldNgen;
    }

    /**
     * @param jTextFieldNgen the jTextFieldNgen to set
     */
    public void setjTextFieldNgen(javax.swing.JTextField jTextFieldNgen) {
        this.jTextFieldNgen = jTextFieldNgen;
    }

    /**
     * @return the jTextFieldTamPob
     */
    public javax.swing.JTextField getjTextFieldTamPob() {
        return jTextFieldTamPob;
    }

    /**
     * @param jTextFieldTamPob the jTextFieldTamPob to set
     */
    public void setjTextFieldTamPob(javax.swing.JTextField jTextFieldTamPob) {
        this.jTextFieldTamPob = jTextFieldTamPob;
    }

    /**
     * @return the seleccion
     */
    public static javax.swing.ButtonGroup getSeleccion() {
        return seleccion;
    }

    /**
     * @param aSeleccion the seleccion to set
     */
    public static void setSeleccion(javax.swing.ButtonGroup aSeleccion) {
        seleccion = aSeleccion;
    }

}
