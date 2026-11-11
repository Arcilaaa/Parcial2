package co.edu.uniquindio.poo;


import java.io.IO;

public class RetiroEvaluacion {

    private Nodo<Caja> cima;
    private int tamanio;


    public RetiroEvaluacion() {
        this.cima = null;
        this.tamanio = 0;
    }

    /**
     * Agrega en la cima de la pila
     * Push
     **/


    public void apilar(Caja caja) {

        Nodo<Caja> nuevoNodo = new Nodo<>(caja);
        nuevoNodo.setSiguiente(cima);
        cima = nuevoNodo;
        tamanio++;
    }


    /**
     * Elimina la cima de la pila
     * pop
     */
    public Nodo<Caja> desapilar() {
        Nodo<Caja> aux = cima;

        if (cima != null) {
            cima = cima.getSiguiente();
            tamanio--;
        }

        return aux;
    }


    /**
     * Retorna los elementos de la lista como String.
     */
    public String mostrar() {
        String listaString = "[";
        if (cima == null) {
            listaString += " Null";
        } else {
            Nodo<Caja> aux = cima;
            while (aux != null) {
                listaString += "  " + aux.getDato();
                aux = aux.getSiguiente();
            }
        }
        listaString += " ]";
        return listaString;
    }






    public boolean retirarCaja(String codigoBuscado) {
        RetiroEvaluacion pilaAux = new RetiroEvaluacion();
        boolean encontrada = false;

        // 1. Buscar la caja desapilando los elementos
        while (!this.estaVacia()) {
            Nodo<Caja> actual = this.desapilar();
            Caja caja = actual.getDato();

            if (caja != null && caja.getCodigo().equals(codigoBuscado)) {
                encontrada = true;
                break; // Se encontró la caja: NO se guarda en pilaAux para eliminarla definitivamente
            } else {
                pilaAux.apilar(caja); // Guarda temporalmente las cajas anteriores
            }
        }

        // 2. Regresar todas las demás cajas a la pila original respetando su orden
        while (!pilaAux.estaVacia()) {
            Nodo<Caja> temp = pilaAux.desapilar();
            this.apilar(temp.getDato());
        }

        return encontrada;
    }

















    public void reordenarEliminarr(String codigo) {
        // 1. Obtener el valor de la caja antes de retirarla
        int valorRetirado = -1;
        boolean existe = false;

        Nodo<Caja> aux = this.getCima();
        while (aux != null) {
            if (aux.getDato() != null && aux.getDato().getCodigo().equalsIgnoreCase(codigo)) {
                valorRetirado = aux.getDato().getValor();
                existe = true;
                break;
            }
            aux = aux.getSiguiente();
        }

        if (!existe) {
            System.out.println("No se encontró la caja con el código: " + codigo);
            IO.println(this.mostrar());
            return;

        }

        // 2. Retirar la caja llamando a retirarCaja (devuelve boolean)
        boolean cajaeli = this.retirarCaja(codigo);
        IO.println(cajaeli);
        IO.println(this.mostrar());

        // 3. Clasificar la pila restante según su POSICIÓN (1 = Cima)
        RetiroEvaluacion cajasPosPares = new RetiroEvaluacion();
        RetiroEvaluacion cajasPosImpares = new RetiroEvaluacion();

        int posicion = 1;
        while (!this.estaVacia()) {
            Nodo<Caja> actual = this.desapilar();
            Caja caja = actual.getDato();

            if (posicion % 2 == 0) {
                cajasPosPares.apilar(caja);
            } else {
                cajasPosImpares.apilar(caja);
            }
            posicion++;

        }

        IO.println("Pares  " + cajasPosPares.mostrar());
        IO.println("Impares  " + cajasPosImpares.mostrar());

        // 4. Reconstruir la pila según si el VALOR de la caja retirada era par o impar
        boolean esValorPar = (valorRetirado % 2 == 0);

        if (esValorPar) {
            // Regla: Posiciones impares en la cima, pares al fondo
            while (!cajasPosPares.estaVacia()) {
                this.apilar(cajasPosPares.desapilar().getDato());
            }
            while (!cajasPosImpares.estaVacia()) {
                this.apilar(cajasPosImpares.desapilar().getDato());
            }
        } else {
            // Regla: Posiciones pares en la cima, impares al fondo
            while (!cajasPosImpares.estaVacia()) {
                this.apilar(cajasPosImpares.desapilar().getDato());
            }
            while (!cajasPosPares.estaVacia()) {
                this.apilar(cajasPosPares.desapilar().getDato());
            }
        }
        IO.print("Reordemadas" + this.mostrar());
    }

















    /**
     * Retorna la posición del elemento dentro de la lista.
     * Si no existe retorna -1.
     */
    public int localizar(Caja datoBuscar) {
        Nodo<Caja> aux = cima;
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



    public boolean buscar(Caja datoBuscar) {
        Nodo<Caja> aux = cima;
        while (aux != null) {

            if (aux.getDato().equals(datoBuscar)) {
                return true;
            }
            aux = aux.getSiguiente();
        }

        return false;
    }


    public Nodo<Caja> getCima() {
        return cima;
    }

    public void setCima(Nodo<Caja> cima) {
        this.cima = cima;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }


    public boolean estaVacia() {
        return cima == null;
    }
}
