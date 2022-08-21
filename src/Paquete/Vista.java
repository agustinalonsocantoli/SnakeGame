/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Paquete;

import java.awt.event.KeyEvent;


/**
 *
 * @author agustinalonso
 */
public class Vista extends javax.swing.JFrame {

    PanelSnake panel; 
    
    public Vista() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        panel = new PanelSnake(800, 30); 
        this.add(panel);
        panel.setBounds(10, 10, 800, 800);
        panel.setOpaque(false);
        
        PanelFondo fondo = new PanelFondo(800, 30);
        this.add(fondo);
        fondo.setBounds(10, 10, 800, 800);
        
        this.requestFocus(true);
        
    }

  
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 820, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 820, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                panel.cambiarDireccion("iz");
                break;
            case KeyEvent.VK_RIGHT:
                panel.cambiarDireccion("de");
                break;
            case KeyEvent.VK_UP:
                panel.cambiarDireccion("ab"); 
                break;
            case KeyEvent.VK_DOWN:
                panel.cambiarDireccion("ar");
                break;
            default:
                break;
        }
    }//GEN-LAST:event_formKeyPressed


    public static void main(String args[]) {
        
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
