package co.edu.uniquindio.poo;

import java.io.IO;

public class SeleccionSolicitudes {

    protected Nodo<Paquete> inicio;
    protected Nodo<Paquete> fin;
    protected int tam;

    public SeleccionSolicitudes() {
        inicio = null;
        fin = null;
        tam = 0;
    }


    /**
     * Agrega un elemento al final de la Cola.
     * offer/add
     */
    public void encolar(Paquete paquete) {

        Nodo<Paquete> nuevo = new Nodo<>(paquete);

        if (inicio == null && fin == null && tam == 0) {
            inicio = nuevo;
            fin = nuevo;
        } else {
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }
        tam++;
    }

    /**
     * Elimina el primer elemento de la COLA.
     * poll
     */
    public Nodo<Paquete> desencolar() {
        Nodo<Paquete> aux = null;

        if (inicio != null) {
            aux = inicio;

            inicio = inicio.getSiguiente();
            tam--;
        }

        return aux;
    }

    /**
     * Busca un elemento dentro de la COLA.
     */
    public boolean buscar(Paquete datoBuscar) {
        Nodo<Paquete> aux = inicio;
        while (aux != null) {

            if (aux.getDato().equals(datoBuscar)) {
                return true;
            }
            aux = aux.getSiguiente();
        }

        return false;
    }

    /**
     * Retorna la posición del elemento dentro de la COLA.
     * Si no existe retorna -1.
     */
    public int localizar(Paquete datoBuscar) {
        Nodo<Paquete> aux = inicio;
        int count = 0;
        while (aux != null) {
            if (aux.getDato().equals(datoBuscar)) {
                return count;
            }
            count++;
            aux = aux.getSiguiente();
        }
        return -1;
    }

    /**
     * Retorna los elementos de la COLA como String.
     */
    public String mostrar() {
        String listaString = "[";
        if (inicio == null) {
            listaString += " Null";
        } else {
            Nodo<Paquete> aux = inicio;
            while (aux != null) {
                listaString += " " + aux.getDato();
                aux = aux.getSiguiente();
            }
        }
        listaString += " ]";
        return listaString;
    }



    /**
     * Método principal para seleccionar paquetes priorizando URGENTE y luego NORMAL.
     */
    public void seleccionarPaquete(Vehiculo vehiculo) {
        SeleccionSolicitudes seleccion = new SeleccionSolicitudes();



        if (inicio == null || vehiculo == null) {
            return;
        }

        int n1 = tam; // 1. Consultamos el tamaño actual de la cola (N)
        procesarPasadaRecursiva(vehiculo, n1, Tipo.URGENTE,seleccion);

        int n2 = tam; // 1. Consultamos el nuevo tamaño actual de la cola (N)
        procesarPasadaRecursiva(vehiculo, n2, Tipo.NORMAL, seleccion);

        IO.println("Lista de paquetes no aceptados" + "\n" +mostrar() + "\n");

        IO.println("Cola de los seleccionados" + "\n" + seleccion.mostrar()+ "\n");

        IO.println("Capacidad Actual del vehiculo \n" + vehiculo.getCapacidad());


    }











    private void procesarPasadaRecursiva(Vehiculo vehiculo, int numPaquetes, Tipo tipoObjetivo, SeleccionSolicitudes seleccion) {
        // Caso base: si ya recorrimos los N elementos o la cola está vacía
        if (numPaquetes <= 0 || inicio == null) {
            return;
        }

        // 2. En cada llamada recursiva desencolamos el elemento del frente
        Nodo<Paquete> nodoActual = desencolar();
        if (nodoActual == null) {
            return;
        }
        Paquete paquete = nodoActual.getDato();

        // 3 y 4. Verificamos si cumple el tipo objetivo y si cabe en el vehículo
        if (paquete.getTipo() == tipoObjetivo && vehiculo.getCapacidad() >= paquete.getPeso()) {
            vehiculo.agregarPaquete(paquete); // Lo asignamos al vehículo (no se reencola)
            seleccion.encolar(paquete);

            System.out.println(paquete.toString()+  "\n" + "ACEPTADO  \n" + "Tipo de paquete " + paquete.getTipo()+ "\n" + "Capacidad del vehiculo " + vehiculo.getCapacidad() +"Kg" + "\n");
        }
        else {
            encolar(paquete);
            System.out.println(paquete.toString() + "\n" + "   No aceptado por orden de prioridad  " + paquete.getTipo() + "\n"+ " O pot la capicidad del vehiculo no alcanza " + vehiculo.getCapacidad() + "\n");// Si no cumple o no cabe, vuelve al final de la cola
        }





        // 5 y 6. Llamada recursiva reduciendo en 1 la cantidad de elementos pendientes
        procesarPasadaRecursiva(vehiculo, numPaquetes - 1, tipoObjetivo, seleccion);


    }













    public Nodo<Paquete> getInicio() {
        return inicio;
    }

    public void setInicio(Nodo<Paquete> inicio) {
        this.inicio = inicio;
    }

    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }

    public Nodo<Paquete> getFin() {
        return fin;
    }

    public void setFin(Nodo<Paquete> fin) {
        this.fin = fin;
    }

}
