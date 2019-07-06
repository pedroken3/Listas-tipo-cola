package ListasTipoCola;

public class Cola<T> {



    private Nodo<T> primero;
    private Nodo<T> ultimo;
    private int contiene;

    public Cola() {
    primero = null;
    ultimo = null;
    contiene = 0;

    }

    public boolean isEmpty() {
        return primero == null;
    }

    public int size() {
        return contiene;
    }

    public T primero() {
        if (isEmpty()) {
            return null;
        }
        return primero.getElemento();
    }

    public T extraer() {

        if (isEmpty()) {
            return null;
        }

        T elemento = primero.getElemento();
        Nodo<T> auxiliar = primero.getSiguiente();
        primero = null;

        primero = auxiliar;
        contiene--;
        if (isEmpty()) {
            ultimo = null;
        }

        return elemento;
    }

    public T insertar(T elemento) {
        Nodo<T> auxiliar = new Nodo(elemento, null);

        if (isEmpty()) {
            primero = auxiliar;
            ultimo = auxiliar;
        } else {
            if (size() == 1){

                primero.setSiguiente(auxiliar);
            }else {
                ultimo.setSiguiente(auxiliar);

            }
            ultimo = auxiliar;
        }
        contiene++;
        return auxiliar.getElemento();
    }

    public String toString() {
        if (isEmpty()) {
            return "La lista esta vacia";
        }else {

            String cadena = "";

            Nodo<T> auxiliar = primero;
            while (auxiliar != null) {
                cadena += auxiliar;
                auxiliar = auxiliar.getSiguiente();
            }

            return cadena;
        }
    }
    public void imprimirObjeto(T elemento) {
        System.out.println("Intento de imprimir");
        Nodo<T> impresion = new Nodo(elemento, null);
        while (impresion != null) {
            System.out.println(impresion);
            impresion = impresion.getSiguiente();
        }
    }
}

/*
Confeccionaremos un programa que permita administrar una lista tipo cola.
Desarrollaremos los métodos de insertar, extraer, vacia e imprimir.*/