package co.edu.uniquindio.poo;

/** Punto 4a: contar equipos en un rango dentro de un ABB (usa NodoABB). */
public class Ejercicio4 {

    public static int contarEquiposEnRango(NodoABB n, int inf, int sup) {
        if (n == null || inf > sup) return 0;
        if (n.clave < inf) return contarEquiposEnRango(n.der, inf, sup);  // el subárbol izq. no aporta
        if (n.clave > sup) return contarEquiposEnRango(n.izq, inf, sup);  // el subárbol der. no aporta
        return 1 + contarEquiposEnRango(n.izq, inf, sup) + contarEquiposEnRango(n.der, inf, sup);
    }

    /** Inserta una clave en el ABB (ignora duplicados). */
    public static NodoABB insertar(NodoABB r, int k) {
        if (r == null) return new NodoABB(k);
        if (k < r.clave) r.izq = insertar(r.izq, k);
        else if (k > r.clave) r.der = insertar(r.der, k);
        return r;
    }

    public static void main(String[] args) {
        NodoABB raiz = null;
        for (int k : new int[]{41, 20, 52, 16, 6, 13, 12, 60, 22, 47, 50, 60, 43, 44})
            raiz = insertar(raiz, k);
        System.out.println("contar [20,50]  = " + contarEquiposEnRango(raiz, 20, 50));
        System.out.println("contar [0,100]  = " + contarEquiposEnRango(raiz, 0, 100));
        System.out.println("contar [50,20]  = " + contarEquiposEnRango(raiz, 50, 20));
        System.out.println("contar [61,70]  = " + contarEquiposEnRango(raiz, 61, 70));
    }
}