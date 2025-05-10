package Punto3;

public class RelacionDeRecurrencia {


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

        // Método principal
        public static void main(String[] args) {
            int n = 8;  // Número de niveles
            int[][] tabla = construirTablaCombinatoria(n);

            System.out.println("Tabla bidimensional de combinatoria (Triángulo de Pascal):");
            imprimirTabla(tabla);

            // Ejemplo:
            System.out.println("C(4,0) = " + tabla[4][0]);
            System.out.println("C(4,4) = " + tabla[4][4]);
        }
    }


