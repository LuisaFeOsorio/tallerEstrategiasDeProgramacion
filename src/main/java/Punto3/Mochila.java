package Punto3;

public class Mochila {


    public static void main(String[] args) {
        int[] valores = {2, 5, 10, 14, 15};
        int[] pesos = {1, 3, 4, 5, 7};
        int capacidad = 8;


        int[][] memo = new int[valores.length][capacidad + 1];
        for (int i = 0; i < valores.length; i++) {
            for (int j = 0; j <= capacidad; j++) {
                memo[i][j] = -1;
            }
        }

        int resultado = mochilaMaxima(valores, pesos, capacidad, 0, memo);
        System.out.println("Valor máximo que se puede llevar: " + resultado);
    }

    // Función recursiva con memorización
    public static int mochilaMaxima(int[] valores, int[] pesos, int capacidad, int i, int[][] memo) {
        if (i == valores.length || capacidad == 0) {
            return 0;
        }

        if (memo[i][capacidad] != -1) {
            return memo[i][capacidad];
        }

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
