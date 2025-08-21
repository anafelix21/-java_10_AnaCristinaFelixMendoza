package actividad;

public class Coche {
    String marca;
    int anio;

    // Constructor
    public Coche(String marca, int anio) {
        this.marca = marca;
        this.anio = anio;
    }

    public void mostrarInfo() {
        System.out.println("Marca: " + marca + ", Año: " + anio);
    }
}