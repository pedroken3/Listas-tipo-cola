package ListasTipoCola;

public class Nodo<T> {
    private T elemento;
    private Nodo<T> siguiente;


    public Nodo(T elemento, Nodo<T> siguiente) {
        this.elemento = elemento;
        this.siguiente = siguiente;
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return "Elemento" + elemento;
    }
}

/*
Confeccionaremos un programa que permita administrar una lista tipo cola.
Desarrollaremos los métodos de insertar, extraer, vacia e imprimir.*/