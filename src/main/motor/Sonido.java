package main.motor;

import uwcse.io.Sound;

import java.applet.AudioClip;
import java.io.File;

/**
 * @author lean
 * @created 31/10/26
 */
public class Sonido {
    public Sonido(String musica){
        sonido = new Sound(this.getClass().getClassLoader().getResource("sonidos"+ File.separator+musica));
    }

    public void reproducir(){
        sonido.play();
    }

    public void reproducirLoop(){
        sonido.loop();
    }

    final private Sound sonido;
}
