package main.motor;

import uwcse.graphics.ImageShape;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * @author lean
 * @created 31/10/26
 */
public class Imagen{
    public Imagen(String ubicacion) throws IOException {
        this.ubicacion = ubicacion;
        Image image= ImageIO.read(Objects.requireNonNull(this.getClass().getClassLoader().getResource("imagenes" + File.separator + ubicacion)));
        this.forma = new ImageShape(image,0,0);
    }
    public String getUbicacion(){
        return ubicacion;
    }

    public ImageShape getForma(){
        return forma;
    }

    public void moveTo(double x, double y){
        forma.moveTo((int)x,(int)y);
    }

    final private ImageShape forma;
    final private String ubicacion;
}
