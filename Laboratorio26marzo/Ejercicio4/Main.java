package Laboratorio26marzo.Ejercicio4;

public class Main {
    public static void main(String[] args) {

        JuegoTurnos juego = new JuegoTurnos();

        juego.agregarJugador(new Jugador("Ana"));
        juego.agregarJugador(new Jugador("Luis"));
        juego.agregarJugador(new Jugador("Maria"));
        juego.agregarJugador(new Jugador("Carlos"));

        System.out.println();
        juego.mostrarJugadores();

        System.out.println("\n--- Avanzando turnos ---");
        juego.siguienteTurno();
        juego.siguienteTurno();
        juego.mostrarTurnoActual();

        System.out.println("\n--- Retrocediendo turno ---");
        juego.turnoAnterior();
        juego.mostrarTurnoActual();

        System.out.println("\n--- Expulsando a Luis ---");
        juego.expulsarJugador(new Jugador("Luis"));

        System.out.println();
        juego.mostrarJugadores();

        System.out.println("\n--- Continua el ciclo circular ---");
        juego.siguienteTurno();
        juego.siguienteTurno();
        juego.siguienteTurno();
    }
}