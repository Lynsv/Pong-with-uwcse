package main.objetos;

import main.motor.Imagen;
import main.motor.Input;
import main.motor.Motor;
import main.motor.Objeto;

import java.io.IOException;

/**
 * @author lean
 * @created 31/10/26
 */
public class Jugador extends Objeto {
    Input input;
    public Jugador(double x, double y, String imagen, Motor motor,Input input) throws IOException {
        super(x, y, new Imagen(imagen), motor);
        this.input = input;
    }

    @Override
    public void actualizar(double delta){
        if(input.isDown('w')){
            y-=velocidad*delta;
        }
        if(input.isDown('s')){
            y+=velocidad*delta;
        }
        renderizar();
    }

    final private int velocidad = 300;
}
