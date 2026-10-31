package main.motor;

import uwcse.graphics.GWindowEvent;
import uwcse.graphics.GWindowEventAdapter;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lean
 * @created 31/10/26
 */
public class Input extends GWindowEventAdapter {
    private final Set<Character> teclasPresionadas =
            ConcurrentHashMap.newKeySet();

    @Override
    public void keyPressed(GWindowEvent event) {
        char tecla = Character.toLowerCase(event.getKey());
        teclasPresionadas.add(tecla);
    }

    @Override
    public void keyReleased(GWindowEvent event) {
        char tecla = Character.toLowerCase(event.getKey());
        teclasPresionadas.remove(tecla);
    }

    public boolean isDown(char tecla) {
        return teclasPresionadas.contains(
                Character.toLowerCase(tecla)
        );
    }
}
