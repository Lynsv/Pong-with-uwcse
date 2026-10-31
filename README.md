# Juego de Pong con uwcse
El proyecto es una prueba básica de un juego de pong con la libreria de animaciones uwcse

## Diseño
### Motor
Se utiliza un motor principal que actua como un orquestador, el motor guarda todos los objetos y los llama para actualizar la logica de cada uno y cada objeto decide cuando renderizar esa logica.

Se implemento el uso de un deltaTime y se limitó a 60 fps

### IA
La IA es una implementación sencilla que solo sigue la posición de la pelota con un ajuste constante, sube cuando esta mas abajo y baja cuando esta mas arriba de la pelota

## Como Jugar
Para probarlo se debe descargar el repositorio completo y añadir la libreria uwcse.jar al proyecto
desde una IDE como IntelliJ IDEA ejecute el main principal en el archivo [Juego.java](src/main/Juego.java)

Para iniciar presione la tecla **P** y muévase hacia arriba o abajo con las teclas **W** y **S**

### Para ganar
El primero que logre tres puntos gana, la dificultad va aumentando con el tiempo porque la pelota acelera con cada toque.
Una vez gané el jugador o la IA el juego se congela durante tres segundos y se cierra automáticamente

[Screenshot](src/imagenes/Screenshot.png)


## Créditos:
**música**: tcarisland https://opengameart.org/content/happy-8-bit
