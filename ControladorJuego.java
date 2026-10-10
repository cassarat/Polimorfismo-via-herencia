public class ControladorJuego {
    private Mazo modeloMazo;
    private Jugador jugadorActivo;
    private VistaConsola vista;

    public ControladorJuego(Mazo modeloMazo, Jugador jugadorActivo, VistaConsola vista) {
        this.modeloMazo = modeloMazo;
        this.jugadorActivo = jugadorActivo;
        this.vista = vista;
    }

    // Bucle principal del juego
    public void iniciarJuego() {
        boolean salir = false;
        while (!salir) {
            int opcion = vista.mostrarMenuPrincipal();
            switch (opcion) {
                case 1:
                    vista.mostrarMensaje("\n--- Catalogo de cartas ---");
                    vista.mostrarListaCartas(modeloMazo.getCartas());
                    break;
                case 2:
                    String criterio = vista.solicitarInput("ingrese el ID o nombre de la carta a buscar: ");
                    Carta encontrada = modeloMazo.buscarCarta(criterio);
                    if (encontrada != null) {
                        vista.mostrarMensaje("\nCarta encontrada:\n" + encontrada.toString());
                    } else {
                        vista.mostrarMensaje("\nNo se encontro ninguna carta con ese criterio.");
                    }
                    break;
                case 3:
                    modeloMazo.ordenarPorEnergia();
                    vista.mostrarMensaje("\nel mazo ha sido ordenado por costo de energía.");
                    vista.mostrarListaCartas(modeloMazo.getCartas());
                    break;
                case 4:
                    ejecutarTurno();
                    break;
                case 5:
                    vista.mostrarMensaje("Gracias por jugar UVG Card Battle!");
                    salir = true;
                    break;
                default:
                    vista.mostrarMensaje("Opcion no valida. Intente de nuevo:)");
            }
        }
    }

    // logica para el juego por turnos
    private void ejecutarTurno() {
        boolean finTurno = false;
        while (!finTurno) {
            int accion = vista.mostrarMenuTurno(jugadorActivo.getEnergiaActual());
            switch (accion) {
                case 1:
                    // Usar una carta (Aquí brilla el polimorfismo)
                    String idCarta = vista.solicitarInput("Ingrese el ID de la carta que desea usar (Ej. C001): ");
                    Carta cartaUsar = modeloMazo.buscarCarta(idCarta);
                    
                    if (cartaUsar != null) {
                        if (jugadorActivo.tieneEnergiaSuficiente(cartaUsar.getCostoEnergia())) {
                            vista.mostrarMensaje("\n--- RESOLUCIÓN DE CARTA ---");
                            
                            // Llamada polimórfica: el sistema sabe exactamente qué comportamiento ejecutar
                            // dependiendo si es CartaCurso, CartaCatedratico o CartaEvento
                            cartaUsar.jugarCarta(); 
                            
                            jugadorActivo.modificarEnergia(-cartaUsar.getCostoEnergia());
                            vista.mostrarMensaje("Has usado la carta exitosamente.");
                            finTurno = true; // Termina la acción del turno
                        } else {
                            vista.mostrarMensaje("No tienes energía suficiente para usar esta carta.");
                        }
                    } else {
                        vista.mostrarMensaje("Carta no encontrada en el mazo.");
                    }
                    break;
                case 2:
                    // Tomar una carta
                    Carta robada = modeloMazo.robarCarta();
                    if (robada != null) {
                        vista.mostrarMensaje("\nHas tomado del mazo: " + robada.getNombre());
                        finTurno = true;
                    } else {
                        vista.mostrarMensaje("\nNo quedan cartas en el mazo.");
                    }
                    break;
                case 3:
                    // Pasar el turno recupera energía para planificar la estrategia
                    vista.mostrarMensaje("\nHas pasado tu turno. Recuperas 3 puntos de energía.");
                    jugadorActivo.modificarEnergia(3);
                    finTurno = true;
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida. Intente de nuevo.");
            }
        }
    }
}