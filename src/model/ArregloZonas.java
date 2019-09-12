/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author MIGUEL
 */
public class ArregloZonas {
    
    private ArrayList<Zona> zonas;
    
    public ArregloZonas(){
        this.zonas = new ArrayList<>();
    }
    
    public void choque(Ball bola){
        for(int i = 0; i < zonas.size(); i++){
            zonas.get(i).choque(bola);
        }
    }
    
    public void iniciarZonas(Contador contador){
        //Zonas verdes
        zonas.add(new Zona(245, 170,contador, true));
        zonas.add(new Zona(0, 160,contador, true));
        zonas.add(new Zona(125, 40,contador, true));
        zonas.add(new Zona(125, 300,contador, true));
        
        //Zonas rojas
        zonas.add(new Zona(220, 80,contador, false));
        zonas.add(new Zona(30, 65,contador, false));
        zonas.add(new Zona(220, 260,contador, false));
        zonas.add(new Zona(15, 250,contador, false));
    }
    
}
