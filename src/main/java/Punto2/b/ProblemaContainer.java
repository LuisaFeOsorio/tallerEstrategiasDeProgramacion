package Punto2.b;

import java.util.HashMap;
import java.util.*;

public class ProblemaContainer {
    public static void main (String[] args) {

        List<Objeto> objetos = new ArrayList<>();
        objetos.add(new Objeto("A", 60, 10));
        objetos.add(new Objeto("B", 100, 20));
        objetos.add(new Objeto("C", 120, 30));

        System.out.println("OBJETOS A INSERTAR EN EL CONTAINER: \n ------------ {Datos del Objeto = valorFraccional} -----------");
        for (Objeto aux : objetos){
            System.out.println(aux.getNombre()+","+aux.getPeso()+","+aux.getValor());
        }
        double capacidadMochila = 50;

        HashMap<Objeto, Double> solucion = llenarContainer(objetos, capacidadMochila);

        System.out.println("Los objetos vertidos en el container son: "+solucion);
    }

    public static HashMap<Objeto,Double> llenarContainer(List<Objeto>objetos, double capacidad){
        // Ordenar objetos por relación valor/peso descendente
        objetos.sort((o1, o2) -> Double.compare(o2.getRatio(), o1.getRatio()));

        HashMap<Objeto, Double> resultado = new HashMap<>();
        double espacioRestante = capacidad;

        for (Objeto obj : objetos) {
            if (espacioRestante <= 0) break;

            double cantidadTomada = Math.min(obj.getPeso(), espacioRestante);
            double fraccion = cantidadTomada / obj.getPeso();
            resultado.put(obj, fraccion);
            espacioRestante -= cantidadTomada;
        }

        return resultado;
    }

}
