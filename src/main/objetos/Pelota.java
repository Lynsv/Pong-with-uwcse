package main.objetos;

import main.motor.Imagen;
import main.motor.Motor;
import main.motor.Objeto;
import main.motor.Sonido;

import java.io.IOException;
import java.util.Random;

/**
 * @author lean
 * @created 31/10/26
 */
public class Pelota extends Objeto {
    Random rand = new Random();
    int limiteIzq = 75;
    int limiteDer = 665;
    int jugadorAltura = 30;
    int jugadorAncho = 30;
    double originalX;
    double originalY;

    double anteriorJugador1;
    double actualJugador1 = 0;
    double anteriorJugador2;
    double actualJugador2 = 0;

    public Pelota(double x, double y, String imagen, Motor motor,Marcador marcador,Objeto jugador1, Objeto jugador2) throws IOException {
        super(x, y, new Imagen(imagen), motor);
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.marcador = marcador;

        actualJugador1 = jugador1.getY();
        actualJugador2 = jugador2.getY();
        originalX = x;
        originalY = y;
    }

    public void acelerar(){
        velocidad += 10;
    }

    private void iniciar(){
        if(motor.INPUT.isDown('p')){
            if(direccionX == 0){
                direccionX = rand.nextInt(-2,2);
                direccionY = rand.nextInt(-2,2);
            }else {
                reiniciar();
            }
        }
    }

    public void reiniciar(){
        direccionX = 0;
        while(direccionX == 0)
            direccionX = rand.nextInt(-2,2);
        direccionY = rand.nextInt(-2,2);
        x = originalX;
        y = originalY;
        velocidad = 100;
    }

    private void cambiarY(){
        if(y > 540 || y < 0){
            direccionY*=-1;
            sonido.reproducir();
            return;
        }
        if(x<limiteIzq){
            if(x <limiteIzq-jugadorAncho)
                return;
            if(jugador1.getY()+ jugadorAltura > y && jugador1.getY()- jugadorAltura < y){
                 anteriorJugador1 =  actualJugador1;
                 actualJugador1 = jugador1.getY();
                 double diferencia = actualJugador1-anteriorJugador1;
                 if(diferencia > 0)
                     direccionY = 1;
                 else if(diferencia < 0)
                     direccionY = -1;
                 else{
                     direccionY*=-1;
                     if(direccionY == 0) direccionY = rand.nextInt(-2,2);
                 }
            }
            sonido.reproducir();
             return;
        }

        if(x>limiteDer){
            if(x > limiteDer+jugadorAncho)
                return;
            if(jugador2.getY()+ jugadorAltura > y && jugador2.getY()- jugadorAltura < y){
                anteriorJugador2=  actualJugador2;
                actualJugador2 = jugador2.getY();
                double diferencia = actualJugador2-anteriorJugador2;
                if(diferencia > 0)
                    direccionY = 1;
                else if(diferencia < 0)
                    direccionY = -1;
                else
                    direccionY*=-1;
            }
            sonido.reproducir();
        }

    }

    private void cambiarX(){
        if(x < limiteIzq){
            if(x<0){
                reiniciar();
                marcador.marcarDer();
            }
            if(x <limiteIzq-jugadorAncho)
                return;
            if(jugador1.getY()+ jugadorAltura > y && jugador1.getY()- jugadorAltura < y && direccionX < 0){
                direccionX*=-1;
                acelerar();
                sonido.reproducir();
            }
        }
        if(x > limiteDer){
            if(x>800){
                reiniciar();
                marcador.marcarIzq();
            }
            if(x > limiteDer+jugadorAncho)
                return;

            if(jugador2.getY()+ jugadorAltura > y && jugador2.getY()- jugadorAltura < y && direccionX > 0){
                direccionX*=-1;
                acelerar();
                sonido.reproducir();
            }
        }

    }

    @Override
    public void actualizar(double delta){
        iniciar();
        if(direccionX == 0) return;
        cambiarX();
        cambiarY();
        x += velocidad*direccionX*delta;
        y += velocidad*direccionY*delta;
        renderizar();
    }

    private int direccionX = 0;
    private int direccionY = 0;
    private int velocidad = 100;

    private Objeto jugador1;
    private Objeto jugador2;
    private Marcador marcador;

    private Sonido sonido = new Sonido("pong.wav");
}
