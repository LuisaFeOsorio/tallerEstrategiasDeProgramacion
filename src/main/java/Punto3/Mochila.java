package Punto3;

public class Mochila {

    //Programacion dinamica

    //Objetivo: Añadir la mayor cantidad de valor sin pasarse del peso
    //Complejidad:

    //Usando recursión con memorización para evitar recalcular
    //los mismos resultados múltiples veces.


    //Complejidad: 0(n*w)
    //n = número de objetos (valores.length)
    //W = capacidad máxima de la mochila (capacidad)


    public static void main(String[] args) {
        int[] valores = {2, 5, 10, 14, 15};
        int[] pesos = {1, 3, 4, 5, 7};
        int capacidad = 8;

      //Creamos la matriz para almacenar los valores
        int[][] memo = new int[valores.length][capacidad + 1];
        for (int i = 0; i < valores.length; i++) {
            for (int j = 0; j <= capacidad; j++) {
                memo[i][j] = -1;
            }
        }
        // Llamamos a la función recursiva que calcula el valor máximo que se puede obtener
        int resultado = mochilaMaxima(valores, pesos, capacidad, 0, memo);
        System.out.println("Valor máximo que se puede llevar: " + resultado);
    }

    // Función recursiva con memorización
    public static int mochilaMaxima(int[] valores, int[] pesos, int capacidad, int i, int[][] memo) {

        // Si no hay más objetos para analizar o la capacidad es 0,
        // no se puede llevar nada
        if (i == valores.length || capacidad == 0) {
            return 0;
        }

        //Verificamos si se ha hecho el calculo para no volver a recalcularlo

        if (memo[i][capacidad] != -1) {
            return memo[i][capacidad];
        }

        //Miramos si podemos tomar el objeto, sino pasamos al siguiente
        if (pesos[i] > capacidad) {

            memo[i][capacidad] = mochilaMaxima(valores, pesos, capacidad, i + 1, memo);
        } else {

            int incluir = valores[i] + mochilaMaxima(valores, pesos, capacidad - pesos[i], i + 1, memo);
            int noIncluir = mochilaMaxima(valores, pesos, capacidad, i + 1, memo);
            memo[i][capacidad] = Math.max(incluir, noIncluir);
        }
        return memo[i][capacidad];
    }
}
