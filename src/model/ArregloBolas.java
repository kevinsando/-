
package model;

import java.util.ArrayList;

/**
 *
 * @author MIGUEL
 */
public class ArregloBolas {
    
    private ArrayList<Ball> bolas;
    private int nivel;
    
    public ArregloBolas(){
        this.bolas = new ArrayList<>();
        this.nivel = 1;
        agregar();
    }
    
    public void agregar(){
        bolas.add(new Ball());
    }
    
    public void eliminar(){
        bolas.remove(bolas.size()-1);
    }
    
    public Ball consultar(int i){
        return bolas.get(i);
    }
    
    public int Tamano(){
        return bolas.size();
    }
    
    public void subirDeNivel(int i){
        int n = nivel;
        this.nivel = i;
        if(n < i){
            actualizarNivelArriba();
        }else{
            actualizarNivelAbajo(n);
        }      
    } 
    
    private void actualizarNivelArriba(){
        if(nivel == 2){
            bolas.add(new Ball());
            bolas.add(new Ball());
        }
        if(nivel == 3 && bolas.size() == 3){
            bolas.add(new Ball());
            bolas.add(new Ball());
        }else{
            if(nivel == 3 && bolas.size() == 1){
                bolas.add(new Ball());
                bolas.add(new Ball());
                bolas.add(new Ball());
                bolas.add(new Ball());
            }
        }      
    }
    
    private void actualizarNivelAbajo(int i){
        if(nivel == 2 && i == 3){
            bolas.remove(bolas.size()-1);
            bolas.remove(bolas.size()-1);
        }
        if(nivel == 1 && i == 3){
            bolas.remove(bolas.size()-1);
            bolas.remove(bolas.size()-1);
            bolas.remove(bolas.size()-1);
            bolas.remove(bolas.size()-1);
        }
        if(nivel == 1 && i == 2){
            bolas.remove(bolas.size()-1);
            bolas.remove(bolas.size()-1);
        }
    }
    
}
