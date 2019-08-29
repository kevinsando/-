
package model;
import controller.Ball;
import vist.Game;

public class arregloBalls {
    private Ball[] arreglo;
    private int n=10;
    private int k=0;
    private Game game;
    public arregloBalls(Game game) {
        this.game=game;
        this.n=10;
        this.k=0;
        arreglo = new Ball[n];
    }
    public void llenar(int k){
        this.k=k;
        for(int i=0;i<k;i++){
            arreglo[i]=new Ball(game);
        }
    }
    
    
    
}
