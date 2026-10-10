//Jugador
public class Jugador {
    private int energiaActual;

    public Jugador(int energiaInicial) {
        this.energiaActual = energiaInicial;
    }

    public int getEnergiaActual() {
        return energiaActual;
    }

    public void modificarEnergia(int cantidad) {
        this.energiaActual += cantidad;
        System.out.println("Energia actualizada; energia actual: " + this.energiaActual);
    }
    
    // si se puede validar si es posible jugar una carta
    public boolean tieneEnergiaSuficiente(int costo) {
        return this.energiaActual >= costo;
    }
}