package Punto1.a;

public class ElementoMayoría {

    public static int encontrarElementoMayoría(int[] arreglo) {
        int candidato = encontrarRecursivo(arreglo, 0, arreglo.length - 1);
        int cantidad = contarEnRango(arreglo, candidato, 0, arreglo.length - 1);
        return cantidad > arreglo.length / 2 ? candidato : -1;
    }

    private static int encontrarRecursivo(int[] arreglo, int inicio, int fin) {
        if (inicio == fin) {
            return arreglo[inicio];
        }

        int medio = (inicio + fin) / 2;
        int izquierda = encontrarRecursivo(arreglo, inicio, medio);
        int derecha = encontrarRecursivo(arreglo, medio + 1, fin);

        if (izquierda == derecha) {
            return izquierda;
        }

        int conteoIzquierda = contarEnRango(arreglo, izquierda, inicio, fin);
        int conteoDerecha = contarEnRango(arreglo, derecha, inicio, fin);

        if (conteoIzquierda > (fin - inicio + 1) / 2) {
            return izquierda;
        } else if (conteoDerecha > (fin - inicio + 1) / 2) {
            return derecha;
        } else {
            return -1;
        }
    }

    private static int contarEnRango(int[] arreglo, int numero, int inicio, int fin) {
        int contador = 0;
        for (int i = inicio; i <= fin; i++) {
            if (arreglo[i] == numero) {
                contador++;
            }
        }
        return contador;
    }

    // Método principal para probar
    public static void main(String[] args) {
        int[] ejemplo1 = {2, 2, 1, 1, 1, 2, 2};
        int[] ejemplo2 = {1, 2, 3};

        System.out.println("Elemento mayoría en ejemplo1: " + encontrarElementoMayoría(ejemplo1)); // Salida: 2
        System.out.println("Elemento mayoría en ejemplo2: " + encontrarElementoMayoría(ejemplo2)); // Salida: -1
    }
}

