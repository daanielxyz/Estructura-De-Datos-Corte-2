package Laboratorio26marzo.Ejercicio2;

public class Main {
    public static void main(String[] args) {

        HistorialNavegador navegador = new HistorialNavegador();

        navegador.visitarPagina(new Pagina("https://google.com", "Google"));
        navegador.visitarPagina(new Pagina("https://github.com", "GitHub"));
        navegador.visitarPagina(new Pagina("https://stackoverflow.com", "Stack Overflow"));

        System.out.println();
        navegador.mostrarHistorial();

        System.out.println();
        navegador.retroceder();
        navegador.retroceder();
        navegador.retroceder(); // intento sin anterior

        System.out.println();
        navegador.avanzar();
        mostrarPaginaActual(navegador);

        System.out.println();
        // Visita nueva desde el medio → elimina Stack Overflow
        navegador.visitarPagina(new Pagina("https://wikipedia.org", "Wikipedia"));

        System.out.println();
        navegador.mostrarHistorial();
        navegador.avanzar(); // intento sin siguiente
    }

    private static void mostrarPaginaActual(HistorialNavegador nav) {
        nav.mostrarPaginaActual();
    }
}