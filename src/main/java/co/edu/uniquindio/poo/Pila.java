package co.edu.uniquindio.poo;
/** Pila propia (LIFO) con nodos enlazados. */
public class Pila<T> {
    private Nodo<T> tope;
    private int tam;

    public void push(T x) { Nodo<T> n = new Nodo<>(x); n.sig = tope; tope = n; tam++; }
    public T pop() {
        if (isEmpty()) throw new RuntimeException("Pila vacía");
        T x = tope.dato; tope = tope.sig; tam--; return x;
    }
    public T peek() { if (isEmpty()) throw new RuntimeException("Pila vacía"); return tope.dato; }
    public boolean isEmpty() { return tope == null; }
    public int size() { return tam; }

    /** Pasa todos los elementos de 'origen' a 'destino' (invierte el orden). */
    public static <T> void vaciar(Pila<T> origen, Pila<T> destino) {
        while (!origen.isEmpty()) destino.push(origen.pop());
    }
    /** Muestra tope -> fondo sin alterar la pila. */
    public String mostrar() {
        Pila<T> aux = new Pila<>();
        StringBuilder sb = new StringBuilder();
        while (!isEmpty()) { T x = pop(); aux.push(x); sb.append(x); if (!isEmpty()) sb.append(" -> "); }
        vaciar(aux, this);
        return sb.length() == 0 ? "(vacía)" : sb.toString();
    }
}