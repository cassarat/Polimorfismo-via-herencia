//Mazo
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Mazo {
    private List<Carta> cartas;

    public Mazo() {
        this.cartas = new ArrayList<>();
        generarCargaInicial();
    }

    // Crea un catalogo en memoria con al menos 10 cartas aleatorias
    private void generarCargaInicial() {
        Random rand = new Random();
        String[] departamentos = {"Matemáticas", "Computación", "Física"};
        String[] situaciones = {"Semana de Parciales", "Feria de Clubes", "Caída del Internet en Campus"};

        for (int i = 1; i <= 10; i++) {
            int tipoCarta = rand.nextInt(3); // Genera 0, 1 o 2
            String id = "C" + String.format("%03d", i);
            int costo = rand.nextInt(5) + 1; // Costo de energía entre 1 y 5

            if (tipoCarta == 0) {
                cartas.add(new CartaCatedratico(id, "Catedrático " + i, costo, "Llamada de atención severa", departamentos[rand.nextInt(departamentos.length)], rand.nextInt(3) + 1, rand.nextInt(2) + 1));
            } else if (tipoCarta == 1) {
                cartas.add(new CartaCurso(id, "Curso " + i, costo, "Materia intensiva", rand.nextInt(5) + 3, rand.nextInt(10) + 1));
            } else {
                cartas.add(new CartaEvento(id, "Evento " + i, costo, "Afecta el tablero", situaciones[rand.nextInt(situaciones.length)]));
            }
        }
    }

    public List<Carta> getCartas() {
        return cartas;
    }

    // Ordenar el mazo por su costo de energia
    public void ordenarPorEnergia() {
        Collections.sort(cartas); 
    }

    // Buscar una carta por ID o por su nombre
    public Carta buscarCarta(String criterio) {
        for (Carta c : cartas) {
            if (c.getId().equalsIgnoreCase(criterio) || c.getNombre().equalsIgnoreCase(criterio)) {
                return c;
            }
        }
        return null;
    }
    
    // cuando el jugador decide tomar una carta
    public Carta robarCarta() {
        if (!cartas.isEmpty()) {
            return cartas.remove(0);
        }
        return null;
    }
}