package co.edu.uniquindio.poo;

public class Paquete {
    private String codigo;
    private Tipo tipo;
    private int peso;


    public Paquete(String codigo, Tipo tipo, int peso) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.peso = peso;
    }


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }


    @Override
    public String toString() {
        return "Paquete{" +
                "codigo='" + codigo + '\'' +
                ", tipo=" + tipo +
                ", peso=" + peso + "Hg" +
                '}';
    }
}
