package ListasTipoCola;

import java.util.Random;

public class ColaEjercicio {


    private static final int tiempo_minimo_llegada_cajero = 2;
    private static final int tiempo_maximo_llegada_cajero = 4;
    private static final int salida_minima_cliente_cajero = 2;
    private static final int salida_maxima_cliente_cajero = 5;
    private static final int minuto_maximo_de_simulacion = 10 * 60;

    private int cantidadDeClientesAtendidos = 0;
    private int clientesEnCola = 0;
    private int entraCliente;
    private int clientesGenerados = 0;

    Cola<Integer> colaCajero;
    int cajero = -1;

    public ColaEjercicio() {
        colaCajero = new Cola<>();

        for (int tiempo = 0; tiempo < minuto_maximo_de_simulacion; tiempo++) {
            System.out.println("control de tiempo: " + tiempo);
            //System.out.println("control de clientes: " + generaCliente(tiempo));
            //System.out.println("control de cajero: " + salidaCliente(tiempo));
            if (tiempo == 0) {
                System.out.println("Entrada primer cliente: " + generaCliente(tiempo));
                entraCliente = generaCliente(tiempo);
                colaCajero.insertar(tiempo);
                clientesEnCola++;
                clientesGenerados++;
            }
            if (cajero == -1) {
                cajero = salidaCliente(tiempo);
                colaCajero.extraer();
                clientesEnCola--;
                System.out.println("Cajero en marcha, el cliente sale en el minuto: " + salidaCliente(tiempo));

            }
            if (entraCliente == tiempo) {
                entraCliente = generaCliente(tiempo);
                System.out.println("Entrada de cliente: " + generaCliente(tiempo));
                clientesEnCola++;
                System.out.println("clientes en la cola: " + clientesEnCola);
                colaCajero.insertar(tiempo);
                clientesGenerados++;
            }
            if (tiempo == cajero) {

                colaCajero.extraer();
                clientesEnCola--;
                cantidadDeClientesAtendidos++;
                System.out.println("Salida del cajero: ");
                System.out.println("clientes atendidos: " + cantidadDeClientesAtendidos);
                cajero = -1;
            }

            if ((minuto_maximo_de_simulacion - 1) == tiempo) {
                System.out.println("El ultimo cliente en que entra antes de cerrar es Pedro: " + colaCajero.primero());
            }
        }
    }

    public int generaCliente(int tiempo) {
        Random aleatorio = new Random();
        return tiempo + tiempo_minimo_llegada_cajero + aleatorio.nextInt(tiempo_maximo_llegada_cajero - tiempo_minimo_llegada_cajero);
    }

    public int salidaCliente(int tiempo) {
        Random aleatorio = new Random();
        return tiempo + salida_minima_cliente_cajero + aleatorio.nextInt(salida_maxima_cliente_cajero - salida_minima_cliente_cajero);
    }


    public void imprimir() {

        System.out.println("clientes en cola " + clientesEnCola);
        System.out.println("clientes atendidos " + cantidadDeClientesAtendidos);
        System.out.println("que hay en la cola " + colaCajero.size());
        System.out.println("Dentro del objeto cola hay: " + colaCajero.size());
        System.out.println("En la cola: " + clientesEnCola);
        System.out.println("Clientes generados totales: " + clientesGenerados);
        System.out.println("Que hace toString: " + colaCajero.toString());
        for (int i = 0; i < colaCajero.size(); i++) {
            System.out.println(colaCajero);
        }
        //System.out.println("prueba imprimir: " + colaCajero.imprimirObjeto());
    }

    public static void main(String[] args) {
        ColaEjercicio colaEjercicio = new ColaEjercicio();
        colaEjercicio.imprimir();
    }

}
/*Desarrollar un programa para la simulación de un cajero automático.
Se cuenta con la siguiente información:
- Llegan clientes a la puerta del cajero cada 2 ó 3 minutos.
- Cada cliente tarda entre 2 y 4 minutos para ser atendido.

Obtener la siguiente información:
1 - Cantidad de clientes que se atienden en 10 horas.
2 - Cantidad de clientes que hay en cola después de 10 horas.
3 - Hora de llegada del primer cliente que no es atendido
luego de 10 horas (es decir la persona que está primera en la cola cuando se cumplen 10 horas)*/