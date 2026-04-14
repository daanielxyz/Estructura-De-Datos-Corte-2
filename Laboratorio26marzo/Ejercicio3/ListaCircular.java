package Laboratorio26marzo.Ejercicio3;

public class ListaCircular<T> {

    private Nodo<T> nodoPrimero;
    private Nodo<T> nodoUltimo;
    private Nodo<T> actual;
    private int tamanio = 0;

    public boolean estaVacia() {
        return nodoPrimero == null;
    }

    public void agregarFinal(T valorNodo) {

        Nodo<T> nuevoNodo = new Nodo<>(valorNodo);

        if (estaVacia()) {
            nodoPrimero = nodoUltimo = nuevoNodo;
        } else {
            nodoUltimo.setNextNodo(nuevoNodo);
            nuevoNodo.setNextNodo(nodoPrimero);
            nodoUltimo = nuevoNodo;
        }

        tamanio++;
    }

    public void imprimirLista() {

        if (estaVacia()) {
            System.out.println("Lista vacía");
            return;
        }

        Nodo<T> aux = nodoPrimero;

        do {
            System.out.print(aux.getData() + "\t");
            aux = aux.getNextNodo();
        } while (aux != nodoPrimero);

        System.out.println();
    }


    public void iniciar() {
        actual = nodoPrimero;
    }

    public T siguiente() {
        if (actual == null) return null;

        T dato = actual.getData();
        actual = actual.getNextNodo();
        return dato;
    }

    public T eliminar(T dato) {

        if (estaVacia()) {
            throw new RuntimeException("La lista está vacía");
        }

        Nodo<T> nodo = nodoPrimero;
        Nodo<T> previo = nodoUltimo; 

        do {
            if (nodo.getData().equals(dato)) {

                // Caso: único nodo
                if (nodoPrimero == nodoUltimo) {
                    nodoPrimero = nodoUltimo = null;
                    actual = null;
                }
                // Caso: eliminar primero
                else if (nodo == nodoPrimero) {
                    nodoPrimero = nodoPrimero.getNextNodo();
                    nodoUltimo.setNextNodo(nodoPrimero);
                }
                // Caso: eliminar último
                else if (nodo == nodoUltimo) {
                    nodoUltimo = previo;
                    nodoUltimo.setNextNodo(nodoPrimero);
                }
                // Caso: nodo intermedio
                else {
                    previo.setNextNodo(nodo.getNextNodo());
                }

                // Ajustar puntero actual
                if (actual == nodo) {
                    actual = nodo.getNextNodo();
                }

                tamanio--;
                return dato;
            }

            previo = nodo;
            nodo = nodo.getNextNodo();

        } while (nodo != nodoPrimero);

        throw new RuntimeException("El elemento no existe");
    }

}