import java.util.Objects;

// clase base - carta
public abstract class Carta implements Comparable<Carta> {
    protected String id;
    protected String nombre;
    protected int costoEnergia;
    protected String descripcion;

    public Carta(String id, String nombre, int costoEnergia, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.costoEnergia = costoEnergia;
        this.descripcion = descripcion;
    }

    // metodo abstracto para el polimorfismo
    public abstract void jugarCarta();

    // Overloading (Sobrecarga) solicitado en la rúbrica
    public void jugarCarta(int multiplicador) {
        System.out.println(">>> Aplicando efecto de carta " + multiplicador + " veces <<<");
        for (int i = 0; i < multiplicador; i++) {
            this.jugarCarta();
        }
    }

    @Override
    public int compareTo(Carta otra) {
        return Integer.compare(this.costoEnergia, otra.costoEnergia);
    }

    // Override de toString y equals
    @Override
    public String toString() {
        return String.format("[%s] %s | Energía: %d | %s", id, nombre, costoEnergia, descripcion);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Carta carta = (Carta) obj;
        return Objects.equals(id, carta.id);
    }

    //los getters
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public int getCostoEnergia() { return costoEnergia; }
}