package Arboles;

import colas.Nodo;

public class recorrerInOrden {
    public void recorrerInOrden(Nodo root){
        if(root == null) return;
        recorrerInOrden(root.getHijoIzquierdo());
        imprimir(root.getDato();
        recorrerInOrden(root.getHijoDerecho());
}
