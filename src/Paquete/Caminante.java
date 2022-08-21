/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Paquete;



/**
 *
 * @author agustinalonso
 */
public class Caminante implements Runnable {

    PanelSnake panel;
    boolean estado = true;
    
    public Caminante(PanelSnake panel){
        this.panel = panel;
    }
    
    @Override
    public void run() {
        
        while(estado){
            panel.avanzar();
            panel.repaint();
        
             try{
                Thread.sleep(200);
             } catch(InterruptedException ex){
           
             }
        }
    }
    
    public void parar(){
        this.estado = false;
    }
    
}
