package co.edu.uniquindio.poo;

import java.util.ArrayList;
import java.util.List;

public class Vehiculo {

    private String tipoVehiculo;
    private int capacidad;
    private List<Paquete> paquetesCargados;


    public Vehiculo(String tipoVehiculo, int capacidad) {
        this.tipoVehiculo = tipoVehiculo;
        this.capacidad = capacidad;
        this.paquetesCargados = new ArrayList<>();


    }


    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    // Método para agregar un paquete al vehículo y descontar su peso
    public void agregarPaquete(Paquete paquete) {
        paquetesCargados.add(paquete);
        this.capacidad -= paquete.getPeso();
    }

    // Obtener la lista de paquetes que ya lleva adentro
    public List<Paquete> getPaquetesCargados() {
        return paquetesCargados;
    }



    @Override
    public String toString() {
        return "Vehiculo{" +
                "tipoVehiculo='" + tipoVehiculo + '\'' +
                ", capacidad =" + capacidad +
                '}';
    }

}
