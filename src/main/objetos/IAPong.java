package main.objetos;

import main.motor.Imagen;
import main.motor.Motor;
import main.motor.Objeto;

import java.io.IOException;

/**
 * @author lean
 * @created 31/10/26
 */
public class IAPong extends Objeto {
    boolean bajar = true;

    public IAPong(double x, double y, String imagen, Motor motor) throws IOException {
        super(x, y, new Imagen(imagen), motor);
    }

    @Override
    public void actualizar(double delta){
        if(bajar){
            y += 200*delta;
            if(y > 500){
                bajar = false;
            }
        }else {
            y -= 200*delta;
            if(y < 40){
                bajar = true;
            }
        }
        renderizar();
    }

}
