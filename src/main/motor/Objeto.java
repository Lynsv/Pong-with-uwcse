package main.motor;

import uwcse.graphics.GWindow;
import uwcse.graphics.ImageShape;

/**
 * @author lean
 * @created 31/10/26
 */

public class Objeto {
    public Objeto(double x, double y, Imagen imagen, Motor motor){
        this.x = x;
        this.y = y;
        this.imagen = imagen;
        this.motor = motor;
    }

    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }

    public Imagen getImagen(){
        return imagen;
    }

    public void actualizar(double delta){

    }

    public void renderizar(){
        motor.renderizar(this);
    }
    private Imagen imagen;
    final protected Motor motor;
    protected double x;
    protected double y;
}
