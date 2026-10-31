package main.motor;
import uwcse.graphics.GWindow;
import uwcse.graphics.TextShape;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lean
 * @created 31/10/26
 */

public class Motor {
    final List<Objeto> objetos = new ArrayList<>();
    final GWindow ventana;
    public final Input INPUT = new Input();

    TextShape fpsText;
    double timeCounter = 0;
    int fpsCounter = 0;
    int targetFps = 60;

    public Motor(String nombre,int ancho,int alto){
        ventana = new GWindow(nombre,ancho,alto);
        ventana.setExitOnClose();
        fpsText = new TextShape("0",0,0, Color.RED);
    }

    public GWindow getVentana(){
        return ventana;
    }

    public void add(Objeto objeto){
        objetos.add(objeto);
        renderizar(objeto);
        ventana.add(objeto.getImagen().getForma());
    }

    public void showfps(){
        ventana.add(fpsText);
    }

    public void remove(Objeto objeto){
        objetos.remove(objeto);
        ventana.remove(objeto.getImagen().getForma());
    }

    public void iniciar() throws InterruptedException{
        boolean isFirstFrame = true;
        double actual = 0;
        double anterior = 0;
        double deltaTime;
        while(reproducir){
            anterior = actual;
            actual = (double) System.nanoTime() /1_000_000_000;
            deltaTime = actual-anterior;
            if(isFirstFrame) {
                isFirstFrame = false;
                continue;
            }
            actualizar(deltaTime);
            contarFps(deltaTime);
            Thread.sleep(1000/ targetFps);
        }
    }


    public void salir(){
        reproducir = false;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.exit(200);
    }

    public void renderizar(Objeto objeto){
        ventana.addEventHandler(INPUT);
        objeto.getImagen().moveTo(objeto.getX(),objeto.getY());
    }

    private void actualizar(double delta){
        for (Objeto objeto : objetos) {
            objeto.actualizar(delta);
        }
    }

    private void contarFps(double delta){
        timeCounter += delta;
        fpsCounter++;
        if(timeCounter >= 1){
            fpsText.setText(Double.toString(fpsCounter));
            fpsCounter = 0;
            timeCounter = 0;
        }
    }

    private boolean reproducir = true;
}
