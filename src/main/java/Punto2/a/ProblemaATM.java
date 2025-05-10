package Punto2.a;

import javax.swing.*;
import java.util.Arrays;
import java.util.HashMap;

public class ProblemaATM {
    public static void main(String []args) {
        System.out.println("-----Cajero electronico: Ingrese el dinero a retirar (disvisible entre 10Mil)");
        int [] billetes = {10000, 20000, 50000, 100000};
        HashMap<Integer, Integer> cantDisponibles = new HashMap<>();
        cantDisponibles.put(10000, 300);
        cantDisponibles.put(20000, 200);
        cantDisponibles.put(50000, 100);
        cantDisponibles.put(100000, 50);
        String peticionDinero= JOptionPane.showInputDialog(null, args, "Cajero electronico, DIGITE EL DINERO QUE DESEA SACAR(min = 10.000)", 0);
        int dinero= Integer.parseInt(peticionDinero);
        System.out.println("Billetes a devolver ");
        System.out.println(devolverBilletes(billetes,cantDisponibles, dinero));
    }


    public static HashMap<Integer, Integer> devolverBilletes(int[] billetes, HashMap<Integer, Integer> disponibles, int dinero) {
        Arrays.sort(billetes);
        HashMap<Integer, Integer> billetesADevolver = new HashMap<>();

        for (int i = billetes.length - 1; i >= 0; i--) {
            int valorBillete = billetes[i];
            if (dinero >= valorBillete && disponibles.containsKey(valorBillete) && disponibles.get(valorBillete) > 0) {
                int cantidadADevolver = Math.min(dinero / valorBillete, disponibles.get(valorBillete));

                if (cantidadADevolver > 0) {
                    billetesADevolver.put(valorBillete, cantidadADevolver);
                    dinero -= cantidadADevolver * valorBillete;
                    disponibles.put(valorBillete, disponibles.get(valorBillete) - cantidadADevolver); // Actualiza la disponibilidad
                }
            }
        }
        return billetesADevolver;
    }
}
