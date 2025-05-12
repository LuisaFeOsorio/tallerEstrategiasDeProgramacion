package Punto3;

public class RelacionDeRecurrencia {

    // Programación dinámica - Tabulación (completa tabla de Pascal)
    // Complejidad = O(n^2)
    public static int[][] construirTablaCombinatoria(int n) {
        int[][] tabla = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            for (int k = 0; k <= i; k++) {
                if (k == 0 || k == i) {
                    tabla[i][k] = 1;
                } else {
                    tabla[i][k] = tabla[i - 1][k - 1] + tabla[i - 1][k];
                }
            }
        }

        return tabla;
    }

    // Imprimir tabla en forma de triángulo de Pascal
    public static void imprimirTabla(int[][] tabla) {
        int n = tabla.length;
        for (int i = 0; i < n; i++) {
            for (int e = 0; e < n - i; e++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print(tabla[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Programación dinámica - Recursiva con memorización
    // Complejidad = O(n * k)
    public static int combinatoriaMemo(int n, int k, int[][] memo) {
        if (k == 0 || k == n) return 1;

        if (memo[n][k] != -1) return memo[n][k];

        memo[n][k] = combinatoriaMemo(n - 1, k - 1, memo) + combinatoriaMemo(n - 1, k, memo);
        return memo[n][k];
    }

    // Método principal
    public static void main(String[] args) {
        int n = 8;

        // Versión iterativa con tabla completa
        int[][] tabla = construirTablaCombinatoria(n);
        System.out.println("Tabla bidimensional de combinatoria (Triángulo de Pascal):");
        imprimirTabla(tabla);
        System.out.println("C(4,0) = " + tabla[4][0]);
        System.out.println("C(4,4) = " + tabla[4][4]);

        // Versión recursiva con memorización
        int[][] memo = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                memo[i][j] = -1;
            }
        }

        System.out.println("\nComprobación con recursión + memorización:");
        System.out.println("C(4,0) = " + combinatoriaMemo(4, 0, memo));
        System.out.println("C(4,4) = " + combinatoriaMemo(4, 4, memo));
        System.out.println("C(6,3) = " + combinatoriaMemo(6, 3, memo));
    }
}
