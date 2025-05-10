package Punto2.b;

public class Objeto {
    private String nombre;
    private double peso;
    private double valor;
    public Objeto(String nombre, double peso, double valor) {
        this.nombre = nombre;
        this.peso = peso;
        this.valor = valor;
    }
    public double getRatio(){
        return valor/ peso;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPeso() {
        return peso;
    }
    public double getValor() {
        return valor;
    }
    @Override
    public String toString() {
        return "nombre: "+nombre + " Valor: " + valor + ", Peso: " + peso ;
    }

}
