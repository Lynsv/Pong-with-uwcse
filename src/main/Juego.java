package main;
import main.motor.Imagen;
import main.motor.Motor;
import main.objetos.IAPong;
import main.objetos.Jugador;
import main.objetos.Marcador;
import main.objetos.Pelota;

import java.io.IOException;

public class Juego {
    public static void main(String[] args) throws InterruptedException, IOException {
        Motor motor = new Motor("Pong",800,600);
        Imagen fondo = new Imagen("Background.png");
        motor.getVentana().add(fondo.getForma());

        Marcador marcador = new Marcador(380,100,motor, new String[]{"digit0.png","digit1.png","digit2.png","digit3.png"});
        IAPong ia = new IAPong(700,278,"palo.png",motor);
        Jugador jugador = new Jugador(80,278,"palo.png",motor);
        Pelota pelota = new Pelota(368,278,"pelota.png",motor,marcador,jugador,ia);
        ia.setPelota(pelota);

        motor.add(marcador);
        motor.add(ia);
        motor.add(pelota);
        motor.add(jugador);
        motor.showfps();
        motor.iniciar();
    }
}