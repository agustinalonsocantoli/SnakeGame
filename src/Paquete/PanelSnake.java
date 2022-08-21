/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Paquete;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author agustinalonso
 */
public class PanelSnake extends JPanel {
    
    Color colorSanke = Color.green;
    Color colorComida = Color.red;
    int tammax; 
    int tam; 
    int can;
    int res;
    ArrayList<int[]> snake = new ArrayList<>();
    int[] comida = new int[2];
    String direccion = "de";
    String direccionProxima = "de";
    
    
   Thread hilo;
   Caminante camino;
    
    
    
    public PanelSnake(int tammax,int can){
        this.tammax = tammax;
        this.can = can;
        this.tam = tammax / can;
        this.res = tammax % can;
        
        int[] a = {can / 2 - 1, can / 2 - 1};
        int[] b = {can / 2, can / 2 - 1};
        snake.add(a);
        snake.add(b);
        generarComida();
        
        
        camino = new Caminante(this);
        hilo = new Thread(camino);
        hilo.start();
       
    }
    
    @Override
    public void paint(Graphics pintor){
        super.paint(pintor);
        pintor.setColor(colorSanke);
        
            //PINTANDO SNAKE
            for(int[] sn : snake){
                pintor.fillRect(res / 2 + sn[0] * tam, res / 2 + sn[1] * tam, tam - 1, tam - 1);
            }
            
            //PINTANDO COMIDA
            pintor.setColor(colorComida);
            pintor.fillRect(res / 2 + comida[0] * tam, res / 2 + comida[1] * tam, tam - 1, tam - 1);
        }
    
    public void avanzar(){
        igualarDireccion();
        int[] ultimo = snake.get(snake.size() - 1);
        int agregarX = 0;
        int agregarY = 0;
            switch(direccion){
                case "de" : agregarX = 1;
                break;
                case "iz" : agregarX = -1;
                break;
                case "ar" : agregarY = 1;
                break;
                case "ab" : agregarY = -1;
                break;
        }
            
        int[] nuevo = { Math.floorMod(ultimo[0] + agregarX, can)
                , Math.floorMod(ultimo[1] + agregarY, can) };
        
        boolean existe = false;
        for(int i = 0; i < snake.size(); i++){
            if(nuevo[0] == snake.get(i)[0] && nuevo[1] == snake.get(i)[1]){
                existe = true;
                break;
            }
        }
        if(existe){
            JOptionPane.showMessageDialog(this, "HAS PERDIDO");
        } else {
            if(nuevo[0] == comida[0] && nuevo[1] == comida[1]){
                snake.add(nuevo);
                generarComida();
                
            } else {
                snake.add(nuevo);
                snake.remove(0);
            }
        }
    }
    
    public void generarComida(){
        boolean existe = false;
        int a = (int) (Math.random()*can);
        int b = (int) (Math.random()*can);
        
            for(int[] sn : snake){
                if(sn[0] == a && sn[1] == b){
                    existe = true;
                    generarComida();
                    break;
                }
            }
        if(!existe){
            this.comida[0] = a;
            this.comida[1] = b;
        }    
    }
    
    public void cambiarDireccion(String dir){
        if(this.direccion.equals("de") || this.direccion.equals("iz") && dir.equals("ar") || dir.equals("ab")){
            this.direccionProxima = dir;
        }
        if(this.direccion.equals("ar") || this.direccion.equals("ab") && dir.equals("de") || dir.equals("iz")){
            this.direccionProxima = dir;
        }
    }
    
    public void igualarDireccion(){
        this.direccion = this.direccionProxima;
    }
    
}
