package main.objetos;

import main.motor.Imagen;
import main.motor.Motor;
import main.motor.Objeto;
import uwcse.graphics.ImageShape;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * @author lean
 * @created 31/10/26
 */
public class Marcador extends Objeto {

    int separacion = 100;

    public Marcador(int x,int y,Motor motor, String[] numeros) throws IOException {
        super(1000, 0, new Imagen("palo.png"), motor);
        for(String numero: numeros){
            Image image= ImageIO.read(Objects.requireNonNull(this.getClass().getClassLoader().getResource(
                    "imagenes" + File.separator +"Numeros"+ File.separator +numero)));
            marcadorIzq.add(new ImageShape(image,x,y));
            marcadorDer.add(new ImageShape(image,x,y));
        }
        ordenar();
    }

    private void ordenar(){
        for(int i =0;i<marcadorIzq.toArray().length;i++){
            ImageShape imagenIzq = marcadorIzq.get(i);
            ImageShape imagenDer = marcadorDer.get(i);

            imagenIzq.moveTo(imagenIzq.getX()-separacion,imagenIzq.getY());
            imagenDer.moveTo(imagenDer.getX()+separacion,imagenDer.getY());
        }

        for(int i = marcadorIzq.toArray().length;i>0;i--){
            ImageShape imagenIzq = marcadorIzq.get(i-1);
            ImageShape imagenDer = marcadorDer.get(i-1);

            motor.getVentana().add(imagenIzq);
            motor.getVentana().add(imagenDer);
        }
    }

    public void marcarIzq(){

        motor.getVentana().remove(marcadorIzq.getFirst());
        marcadorIzq.removeFirst();
        renderizar();
        if(marcadorIzq.size() <= 1) {
           motor.salir();
        }
    }

    public void marcarDer(){

        motor.getVentana().remove(marcadorDer.getFirst());
        marcadorDer.removeFirst();
        renderizar();
        if(marcadorDer.size() <= 1) {
            motor.salir();
        }
    }


    final List<ImageShape> marcadorIzq = new ArrayList<>();
    final List<ImageShape> marcadorDer = new ArrayList<>();
}
