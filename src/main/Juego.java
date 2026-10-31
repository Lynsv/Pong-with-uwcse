package main;
import main.motor.Imagen;
import main.motor.Motor;
import main.objetos.IAPong;
import main.objetos.Jugador;
import main.objetos.Pelota;

import java.io.IOException;

public class Juego {
    public static void main(String[] args) throws InterruptedException, IOException {
        Motor motor = new Motor("Pong",800,600);
        Imagen fondo = new Imagen("Background.png");
        motor.getVentana().add(fondo.getForma());

        IAPong ia = new IAPong(700,40,"palo.png",motor);
        Pelota pelota = new Pelota(400,300,"pelota.png",motor);
        Jugador jugador = new Jugador(80,100,"palo.png",motor,motor.INPUT);

        motor.add(ia);
        motor.add(pelota);
        motor.add(jugador);
        motor.showfps();
        motor.iniciar();
    }
}