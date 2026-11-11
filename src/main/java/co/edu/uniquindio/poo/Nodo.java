package co.edu.uniquindio.poo;

public class Nodo<T> {
    T dato;
    Nodo<T> sig;
    Nodo(T dato) { this.dato = dato; }
}