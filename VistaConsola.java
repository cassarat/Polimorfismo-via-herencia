import java.util.List;
import java.util.Scanner;

public class VistaConsola {
    private Scanner scanner;

    public VistaConsola() {
        this.scanner = new Scanner(System.in);
    }

    // menu principal de catalogo
    public int mostrarMenuPrincipal() {
        System.out.println("\n=== UVG CARD BATTLE ===");
        System.out.println("1. Listar todas las cartas en el mazo");
        System.out.println("2. Buscar una carta por ID o Nombre");
        System.out.println("3. Ordenar el mazo por costo de energía");
        System.out.println("4. Jugar Turno");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
        
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1; // Retorna -1 si el usuario mete texto en lugar de números
        }
    }

    // menu espeficio para las acciones durante la partida
    public int mostrarMenuTurno(int energiaActual) {
        System.out.println("\n--- TU TURNO ---");
        System.out.println("Energía disponible: " + energiaActual);
        System.out.println("1. Usar una carta");
        System.out.println("2. Tomar una carta");
        System.out.println("3. Pasar el turno");
        System.out.print("Elige una acción: ");
        
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    //metodo entrada/salida para mantener al modelo aislado de la consola
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public String solicitarInput(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    // metodo para imprimir cualquier lista de cartas
    public void mostrarListaCartas(List<Carta> cartas) {
        if (cartas.isEmpty()) {
            System.out.println("No hay cartas para mostrar.");
            return;
        }
        for (Carta c : cartas) {
            System.out.println(c.toString());
        }
    }
}