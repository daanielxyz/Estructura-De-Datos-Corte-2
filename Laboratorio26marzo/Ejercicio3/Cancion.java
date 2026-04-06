package Laboratorio26marzo.Ejercicio3;

class Cancion {
    private String nombre;
    private String artista;
    private double duracion;

    public Cancion(String nombre, String artista, double duracion) {
        this.nombre = nombre;
        this.artista = artista;
        this.duracion = duracion;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre + " - " + artista + " (" + duracion + " min)";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Cancion)) return false;

        Cancion otra = (Cancion) obj;
        return this.nombre.equals(otra.nombre);
    }
}