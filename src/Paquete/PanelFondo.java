/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Paquete;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author agustinalonso
 */
public class PanelFondo extends JPanel {
    
    Color colorFondo = Color.gray;
    int tammax; 
    int tam; 
    int can;
    int res;
    
    public PanelFondo(int tammax,int can){
        this.tammax = tammax;
        this.can = can;
        this.tam = tammax / can;
        this.res = tammax % can;
    }
    
    @Override
    public void paint(Graphics pintor){
        super.paint(pintor);
        pintor.setColor(colorFondo);
        
            for(int i = 0; i < can; i++){
                for(int j = 0; j < can; j++){
                    pintor.fillRect(res / 2 + i * tam, res / 2 + j * tam, tam - 1, tam - 1);
                }
            }
        }
    
}
