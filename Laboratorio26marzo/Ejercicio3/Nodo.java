package Laboratorio26marzo.Ejercicio3;

public class Nodo<T> {
    private Nodo<T> nextNodo;
    private T data;

    public Nodo(T data) {
        this.data = data;
        this.nextNodo = null;
    }

    public Nodo<T> getNextNodo() {
        return nextNodo;
    }

    public T getData() {
        return data;
    }

    public void setNextNodo(Nodo<T> nextNodo) {
        this.nextNodo = nextNodo;
    }

    public void setData(T data) {
        this.data = data;
    }
}
