package Laboratorio26marzo.Ejercicio2;

public class HistorialNavegador {

    private NodoDoble<Pagina> primero;
    private NodoDoble<Pagina> ultimo;
    private NodoDoble<Pagina> actual;

    public HistorialNavegador() {
        primero = null;
        ultimo = null;
        actual = null;
    }

    public void visitarPagina(Pagina pagina) {
        eliminarPaginasFuturas();

        NodoDoble<Pagina> nuevoNodo = new NodoDoble<>(pagina);

        if (estaVacio()) {
            primero = ultimo = nuevoNodo;
        } else {
            nuevoNodo.setPrevious(ultimo);
            ultimo.setNext(nuevoNodo);
            ultimo = nuevoNodo;
        }

        actual = ultimo;
        System.out.println("Visitando: " + pagina);
    }

    public void retroceder() {
        if (actual == null || actual.getPrevious() == null) {
            System.out.println("No hay página anterior.");
            return;
        }
        actual = actual.getPrevious();
        System.out.println("Retrocediendo a: " + actual.getValue());
    }

    public void avanzar() {
        if (actual == null || actual.getNext() == null) {
            System.out.println("No hay página siguiente.");
            return;
        }
        actual = actual.getNext();
        System.out.println("Avanzando a: " + actual.getValue());
    }

    public void mostrarPaginaActual() {
        if (actual == null) {
            System.out.println("No hay página actual.");
        } else {
            System.out.println("Página actual: " + actual.getValue());
        }
    }

    public void mostrarHistorial() {
        if (estaVacio()) {
            System.out.println("Historial vacío.");
            return;
        }
        System.out.println("=== Historial de navegación ===");
        NodoDoble<Pagina> aux = primero;
        while (aux != null) {
            if (aux == actual) System.out.print("[ACTUAL] ");
            System.out.println(aux.getValue());
            aux = aux.getNext();
        }
    }

    public boolean estaVacio() {
        return primero == null;
    }

    private void eliminarPaginasFuturas() {
        if (actual == null || actual.getNext() == null) return;
        actual.setNext(null);
        ultimo = actual;
        System.out.println("(Páginas futuras eliminadas)");
    }
}