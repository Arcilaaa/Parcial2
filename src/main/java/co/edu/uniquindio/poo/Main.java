package co.edu.uniquindio.poo;

import java.util.Scanner;

/** Menú para probar el punto 2 (historial) y el punto 4a (ABB por rango). */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n MENU ");
            System.out.println("1. Punto 2 - Ejemplo del enunciado");
            System.out.println("2. Punto 2 - Probar con mis datos");
            System.out.println("3. Punto 4 - Ejemplo del enunciado");
            System.out.println("4. Punto 4 - Probar con mis datos");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1: punto2Ejemplo(); break;
                case 2: punto2Datos(sc); break;
                case 3: punto4Ejemplo(); break;
                case 4: punto4Datos(sc); break;
                case 0: System.out.println("Fin."); break;
                default: System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    // PUNTO 2
    static void punto2Ejemplo() {
        Pila<String> historial = new Pila<>();
        for (int i = 1; i <= 6; i++) historial.push("A" + i);
        probarSegmento(historial, 2, 4);
    }

    static void punto2Datos(Scanner sc) {
        System.out.print("¿Cuántas acciones tiene el historial? ");
        int n = sc.nextInt();
        Pila<String> historial = new Pila<>();
        for (int i = 1; i <= n; i++) historial.push("A" + i);   // A1 el más antiguo, A_n en la cima
        System.out.print("Posición inicio: ");
        int ini = sc.nextInt();
        System.out.print("Posición fin: ");
        int fin = sc.nextInt();
        probarSegmento(historial, ini, fin);
    }

    static void probarSegmento(Pila<String> historial, int ini, int fin) {
        System.out.println("Original (tope -> fondo): " + historial.mostrar());
        Pila<String> seg = Ejercicio2.obtenerSegmento(historial, ini, fin);
        System.out.println("Segmento [" + ini + "," + fin + "]:        " + seg.mostrar());
        System.out.println("Original después:         " + historial.mostrar());
    }

    //  PUNTO 4
    static void punto4Ejemplo() {
        NodoABB raiz = null;
        for (int k : new int[]{41, 20, 52, 16, 6, 13, 12, 60, 22, 47, 50, 60, 43, 44})
            raiz = Ejercicio4.insertar(raiz, k);
        probarRango(raiz, 20, 50);
    }

    static void punto4Datos(Scanner sc) {
        System.out.print("¿Cuántas claves va a insertar? ");
        int n = sc.nextInt();
        NodoABB raiz = null;
        for (int i = 1; i <= n; i++) {
            System.out.print("Clave " + i + ": ");
            raiz = Ejercicio4.insertar(raiz, sc.nextInt());
        }
        System.out.print("Límite inferior: ");
        int inf = sc.nextInt();
        System.out.print("Límite superior: ");
        int sup = sc.nextInt();
        probarRango(raiz, inf, sup);
    }

    static void probarRango(NodoABB raiz, int inf, int sup) {
        System.out.println("Equipos con código en [" + inf + "," + sup + "]: "
                + Ejercicio4.contarEquiposEnRango(raiz, inf, sup));
    }
}