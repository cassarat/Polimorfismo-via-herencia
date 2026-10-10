public class DriverProgram {
    public static void main(String[] args) {
        //inicio del Modelo
        Mazo mazoPrincipal = new Mazo();
        Jugador jugador1 = new Jugador(10); // El jugador inicia con 10 de energía

        // 2. inicio de la vista
        VistaConsola vista = new VistaConsola();

        // 3. Inicio del Controlador mas  el modelo y la vista
        ControladorJuego controlador = new ControladorJuego(mazoPrincipal, jugador1, vista);

        // 4. Inicia el programa
        controlador.iniciarJuego();
    }
}