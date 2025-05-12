package Punto3;

public class SucesionLucas {

    // Método con programación dinámica por tabulación

    //Complejidad =   O(n)
    public static int lucasTabulacion(int n) {
        if (n == 0) return 2;
        if (n == 1) return 1;

        int[] tabla = new int[n + 1];
        tabla[0] = 2;
        tabla[1] = 1;

        for (int i = 2; i <= n; i++) {
            tabla[i] = tabla[i - 1] + tabla[i - 2];
        }

        return tabla[n];
    }

    // Método con programación dinámica por memorización

    //Complejidad =   O(n)
    public static int lucasMemorizacion(int n, int[] memoria) {
        if (n == 0) return 2;
        if (n == 1) return 1;

        if (memoria[n] != -1) return memoria[n];

        memoria[n] = lucasMemorizacion(n - 1, memoria) + lucasMemorizacion(n - 2, memoria);
        return memoria[n];
    }

    // Método principal
    public static void main(String[] args) {
        int n = 10;

        System.out.println("Lucas por tabulación:");
        for (int i = 0; i <= n; i++) {
            System.out.print(lucasTabulacion(i) + " ");
        }

        System.out.println("\n\nLucas por memorización:");
        int[] memoria = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            memoria[i] = -1;
        }
        for (int i = 0; i <= n; i++) {
            System.out.print(lucasMemorizacion(i, memoria) + " ");
        }
    }
}

