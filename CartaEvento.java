// carta evento
public class CartaEvento extends Carta {
    private String situacion;

    public CartaEvento(String id, String nombre, int costoEnergia, String descripcion, String situacion) {
        super(id, nombre, costoEnergia, descripcion);
        this.situacion = situacion;
    }

    @Override
    public void jugarCarta() {
        System.out.println("Evento especial en el campus!");
        System.out.println("Situacion activa: " + situacion);
    }
    
    @Override
    public String toString() {
        return super.toString() + String.format(" [Evento: %s]", situacion);
    }
}
