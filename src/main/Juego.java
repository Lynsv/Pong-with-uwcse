package main;
import main.motor.Imagen;
import main.motor.Motor;
import main.objetos.IAPong;
import java.io.IOException;

public class Juego {
    public static void main(String[] args) throws InterruptedException, IOException {
        Motor motor = new Motor("Pong",800,600);
        Imagen fondo = new Imagen("Background.png");
        motor.getVentana().add(fondo.getForma());

        IAPong jugador = new IAPong(700,40,"palo.png",motor);
        motor.add(jugador);
        motor.iniciar();
    }
}