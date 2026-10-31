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
    int limiteSuperior = 22;
    int limiteInferior = 514;
    public Jugador(double x, double y, String imagen, Motor motor) throws IOException {
        super(x, y, new Imagen(imagen), motor);

    }

    @Override
    public void actualizar(double delta){
        if(motor.INPUT.isDown('w') && y >= limiteSuperior){
            y-=velocidad*delta;
        }
        if(motor.INPUT.isDown('s') && y <= limiteInferior){
            y+=velocidad*delta;
        }
        renderizar();
    }

    final private int velocidad = 300;
}
