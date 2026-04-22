package EjerciciosListas.ListaOrdenada;

import java.util.Iterator;

public class ListaOrdenada<T extends Comparable<T>> implements Iterable<T> {


    private Nodo<T> first;
    private int size;

    public void setFirst(Nodo<T> first) {
        this.first = first;
    }

    public Nodo<T> getFirst() {
        return first;
    }

    public ListaOrdenada(){
        first = null;
        size = 0;
    }

    public boolean isEmpty() {return first == null;}

    public void insertInOrder(T value){
        Nodo<T> newNode = new Nodo(value);

        if (first == null || value.compareTo(first.getValue()) < 0){
            newNode.setNext(first);
            first = newNode;
        } else{
            Nodo<T> current = first;
            while(current.getNext() != null && current.getNext().getValue().compareTo(value) < 0){
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }
        size++;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private Nodo<T> current = first;

            public boolean hasNext() {
                return current != null;
            }

            public T next() {
                T value = current.getValue();
                current = current.getNext();
                return value;
            }
        };
    }

    public int size(){
        return size;
    }

    public void printList(){
        for (T value : this){
            System.out.print(value + " -> ");
        }
        System.out.println("null");
    }

    public void remove(T value){
        if (first == null) return;
        while(first.getValue().equals(value)){
            first = first.getNext();
            size--;
        }

        Nodo<T> current = first;
        while(current != null && current.getNext() != null){
            if (current.getValue().equals(value)){
                current.setNext(current.getNext().getNext());
                size--;
            }else{
                current = current.getNext();
            }
        }
    }
}
