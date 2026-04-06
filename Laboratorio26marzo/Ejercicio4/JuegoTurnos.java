package Laboratorio26marzo.Ejercicio4;

import listas.NodoDoble;

public class JuegoTurnos {

    private NodoDoble<Jugador> primero;
    private NodoDoble<Jugador> actual;
    private int tamanio;

    public JuegoTurnos() {
        primero = null;
        actual = null;
        tamanio = 0;
    }

    public void agregarJugador(Jugador jugador) {
        NodoDoble<Jugador> nuevoNodo = new NodoDoble<>(jugador);

        if (estaVacio()) {
            primero = nuevoNodo;
            primero.setNext(primero);
            primero.setPrevious(primero);
            actual = primero;
        } else {
            NodoDoble<Jugador> ultimo = primero.getPrevious();
            ultimo.setNext(nuevoNodo);
            nuevoNodo.setPrevious(ultimo);
            nuevoNodo.setNext(primero);
            primero.setPrevious(nuevoNodo);
        }

        tamanio++;
        System.out.println("Jugador agregado: " + jugador.getNombre());
    }

    public void siguienteTurno() {
        if (estaVacio()) { System.out.println("No hay jugadores."); return; }
        actual = actual.getNext();
        System.out.println("Turno de: " + actual.getValue());
    }

    public void turnoAnterior() {
        if (estaVacio()) { System.out.println("No hay jugadores."); return; }
        actual = actual.getPrevious();
        System.out.println("Turno anterior: " + actual.getValue());
    }

    public void mostrarTurnoActual() {
        if (actual == null) { System.out.println("No hay turno activo."); return; }
        System.out.println("Jugando ahora: " + actual.getValue());
    }

    public void expulsarJugador(Jugador jugador) {
        if (estaVacio()) { System.out.println("No hay jugadores."); return; }

        NodoDoble<Jugador> aux = primero;

        for (int i = 0; i < tamanio; i++) {
            if (aux.getValue().equals(jugador)) {

                if (tamanio == 1) {
                    primero = null;
                    actual = null;
                    tamanio--;
                    System.out.println("Jugador expulsado: " + jugador.getNombre());
                    return;
                }

                if (aux == actual) actual = actual.getNext();
                if (aux == primero) primero = primero.getNext();

                aux.getPrevious().setNext(aux.getNext());
                aux.getNext().setPrevious(aux.getPrevious());

                tamanio--;
                System.out.println("Jugador expulsado: " + jugador.getNombre());
                return;
            }
            aux = aux.getNext();
        }

        System.out.println("Jugador no encontrado: " + jugador.getNombre());
    }

    public void mostrarJugadores() {
        if (estaVacio()) { System.out.println("No hay jugadores."); return; }
        System.out.println("=== Jugadores en la partida ===");
        NodoDoble<Jugador> aux = primero;
        for (int i = 0; i < tamanio; i++) {
            if (aux == actual) System.out.print("[TURNO] ");
            System.out.println(aux.getValue());
            aux = aux.getNext();
        }
    }

    public boolean estaVacio() {
        return primero == null;
    }
}