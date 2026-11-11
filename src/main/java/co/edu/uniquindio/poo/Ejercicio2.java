package co.edu.uniquindio.poo;
/** Punto 2: obtener un segmento del historial (usa Pila y Nodo). */
public class Ejercicio2 {

    public static <T> Pila<T> obtenerSegmento(Pila<T> original, int inicio, int fin) {
        Pila<T> resultado = new Pila<>();
        if (inicio < 1 || inicio > fin || fin > original.size()) return resultado;
        Pila<T> aux = new Pila<>(), seg = new Pila<>();
        int pos = 1;
        while (!original.isEmpty()) {
            T a = original.pop();
            aux.push(a);                                   // copia de todo para restaurar
            if (pos >= inicio && pos <= fin) seg.push(a);  // solo el segmento (queda invertido)
            pos++;
        }
        Pila.vaciar(aux, original);                        // la original queda igual
        Pila.vaciar(seg, resultado);                       // 'inicio' queda en la cima
        return resultado;
    }

    public static void main(String[] args) {
        Pila<String> h = new Pila<>();
        for (int i = 1; i <= 6; i++) h.push("A" + i);
        System.out.println("Original: " + h.mostrar());
        System.out.println("Segmento(2,4): " + obtenerSegmento(h, 2, 4).mostrar());
        System.out.println("Segmento(3,3): " + obtenerSegmento(h, 3, 3).mostrar());
        System.out.println("Segmento(0,2): " + obtenerSegmento(h, 0, 2).mostrar());
        System.out.println("Segmento(4,2): " + obtenerSegmento(h, 4, 2).mostrar());
        System.out.println("Segmento(5,9): " + obtenerSegmento(h, 5, 9).mostrar());
        System.out.println("Original tras pruebas: " + h.mostrar());
    }
}