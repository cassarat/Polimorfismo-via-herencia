// clase carta curso
public class CartaCurso extends Carta {
    private int creditos;
    private int nivelDificultad;

    public CartaCurso(String id, String nombre, int costoEnergia, String descripcion, int creditos, int nivelDificultad) {
        super(id, nombre, costoEnergia, descripcion);
        this.creditos = creditos;
        this.nivelDificultad = nivelDificultad;
    }

    @Override
    public void jugarCarta() {
        System.out.println("Inscribiendo curso de " + creditos + " créditos.");
        System.out.println("Prepárate, el nivel de dificultad es de: " + nivelDificultad + "/10.");
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" [Curso: Créditos %d, Dificultad %d]", creditos, nivelDificultad);
    }
}