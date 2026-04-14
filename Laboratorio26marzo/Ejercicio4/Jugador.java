package Laboratorio26marzo.Ejercicio4;

public class Jugador {

    private String nombre;
    private int puntos;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntos = 0;
    }

    public String getNombre() { return nombre; }
    public int getPuntos() { return puntos; }
    public void sumarPuntos(int cantidad) { this.puntos += cantidad; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Jugador)) return false;
        return this.nombre.equals(((Jugador) obj).nombre);
    }

    @Override
    public String toString() {
        return nombre + " (puntos: " + puntos + ")";
    }
}