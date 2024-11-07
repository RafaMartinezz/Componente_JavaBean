/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Solucion;

import Reloj.ComponenteRelojBean;
import Reloj.DefinirAlarmaEvent;
import javax.swing.JOptionPane;

/**
 * Main application window that demonstrates the use of the ComponenteRelojBean
 * component.
 * This class creates an instance of ComponenteRelojBean and listens for alarm
 * events.
 * When the alarm is triggered, a message dialog is displayed to the user.
 * 
 * This class serves as the main graphical interface for setting up and
 * responding to the clock's alarm feature.
 * 
 * @see Reloj.ComponenteRelojBean
 * @see Reloj.DefinirAlarmaEvent
 * 
 * @author rafa
 */
public class Solucion_DI03 extends javax.swing.JFrame {

    /**
     * Creates a new instance of Solucion_DI03 and initializes the form.
     * Sets up an alarm listener on the ComponenteRelojBean component to display a
     * message dialog when the alarm is triggered.
     */
    public Solucion_DI03() {
        initComponents();

        // Adds an alarm listener to the ComponenteRelojBean component to display a
        // dialog when the alarm is triggered.
        componenteRelojBean1.addDefinirAlarmaListener(new ComponenteRelojBean.DefinirAlarmaListener() {
            @Override
            public void capturarAlarma(DefinirAlarmaEvent ev) {
                // Show a dialog notifying the user that the countdown is complete.
                JOptionPane.showMessageDialog(null, "The countdown has finished", "Notification",
                        JOptionPane.INFORMATION_MESSAGE);

                // Turn off the alarm once triggered.
                componenteRelojBean1.setAlarm(false);
            }
        });
    }

    /**
     * This method is automatically called within the constructor to initialize the
     * form components.
     * WARNING: Do NOT modify this code. This method's content is always regenerated
     * by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        componenteRelojBean1 = new Reloj.ComponenteRelojBean();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        // Layout configuration for the frame
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(componenteRelojBean1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 300, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(componenteRelojBean1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Main method to launch the application.
     * 
     * @param args Command line arguments (not used).
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details, see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Solucion_DI03.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Solucion_DI03.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Solucion_DI03.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Solucion_DI03.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Solucion_DI03().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Reloj.ComponenteRelojBean componenteRelojBean1; // Component instance of ComponenteRelojBean
    // End of variables declaration//GEN-END:variables
}
