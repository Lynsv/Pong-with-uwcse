package main.objetos;

import main.motor.Imagen;
import main.motor.Motor;
import main.motor.Objeto;

import java.io.IOException;

/**
 * @author lean
 * @created 31/10/26
 */
public class Jugador extends Objeto {
    public Jugador(double x, double y, String imagen, Motor motor) throws IOException {
        super(x, y, new Imagen(imagen), motor);
    }

    @Override
    public void actualizar(double delta){
        renderizar();
    }
}
