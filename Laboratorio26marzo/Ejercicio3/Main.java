package Laboratorio26marzo.Ejercicio3;

public class Main {
    public static void main(String[] args) {

        ListaCircular<Cancion> playlist = new ListaCircular<>();

        playlist.agregarFinal(new Cancion("Shape of You", "Ed Sheeran", 4.2));
        playlist.agregarFinal(new Cancion("Blinding Lights", "The Weeknd", 3.5));
        playlist.agregarFinal(new Cancion("One Dance", "Drake", 2.8));

        System.out.println(" Lista:");
        playlist.imprimirLista();

        playlist.iniciar();

        System.out.println("\n Reproducción:");
        for (int i = 0; i < 6; i++) {
            System.out.println("Reproduciendo: " + playlist.siguiente());
        }

        System.out.println("\n Eliminando 'Blinding Lights'");
        playlist.eliminar(new Cancion("Blinding Lights", "The Weeknd", 3.5));

        System.out.println("\n Lista actualizada:");
        playlist.imprimirLista();
    }
}