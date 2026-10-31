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
    int limiteSuperior = 22;
    int limiteInferior = 514;
    int offset = 10;
    boolean bajar = true;

    public IAPong(double x, double y, String imagen, Motor motor) throws IOException {
        super(x, y, new Imagen(imagen), motor);
    }

    public void setPelota(Pelota pelota){
        this.pelota = pelota;
    }

    @Override
    public void actualizar(double delta){
        if(pelota == null) return;

        if(pelota.getY()-offset > y && y <= limiteInferior)
            y += velocidad*delta;
        if(pelota.getY()+offset < y && y >= limiteSuperior)
            y-= velocidad*delta;
        renderizar();
    }

    private int velocidad = 300;
    private Pelota pelota;
}
