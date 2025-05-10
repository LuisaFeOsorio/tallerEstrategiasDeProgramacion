package Punto2.c;

import java.util.*;

public class RedFibraOptica {


    public static void main(String[] args) {
        // Ejemplo de uso
        int numMunicipios = 5;
        List<Conexion> conexiones = new ArrayList<>();
        conexiones.add(new Conexion(0, 1, 10)); // Municipio 0 - Municipio 1, costo 10
        conexiones.add(new Conexion(0, 2, 20));
        conexiones.add(new Conexion(1, 2, 30));
        conexiones.add(new Conexion(1, 3, 5));
        conexiones.add(new Conexion(2, 3, 15));
        conexiones.add(new Conexion(3, 4, 8));

        List<Conexion> redMinima = encontrarRedMinima(numMunicipios, conexiones);

        System.out.println("Red de fibra óptica de mínimo costo:");
        int costoTotal = 0;
        for (Conexion conexion : redMinima) {
            System.out.printf("Municipio %d - Municipio %d: $%,d COP%n",
                    conexion.municipioA, conexion.municipioB, conexion.costo);
            costoTotal += conexion.costo;
        }

        System.out.printf("Costo total de la red: $%,d COP%n", costoTotal);
    }

    public static List<Conexion> encontrarRedMinima(int numMunicipios, List<Conexion> conexiones) {
            // Implementación del algoritmo de Prim

            List<Conexion> resultado = new ArrayList<>();
            Set<Integer> municipiosConectados = new HashSet<>();
            PriorityQueue<Conexion> colaPrioridad = new PriorityQueue<>(
                    (a, b) -> a.costo - b.costo
            );

            // Empezar con el primer municipio (podría ser cualquiera)
            if (!conexiones.isEmpty()) {
                municipiosConectados.add(conexiones.get(0).municipioA);

                // Agregar todas las conexiones del municipio inicial a la cola
                for (Conexion conexion : conexiones) {
                    if (conexion.municipioA == conexiones.get(0).municipioA ||
                            conexion.municipioB == conexiones.get(0).municipioA) {
                        colaPrioridad.add(conexion);
                    }
                }
            }

            while (municipiosConectados.size() < numMunicipios && !colaPrioridad.isEmpty()) {
                Conexion conexionMinima = colaPrioridad.poll();

                int nuevoMunicipio = -1;
                if (municipiosConectados.contains(conexionMinima.municipioA) &&
                        !municipiosConectados.contains(conexionMinima.municipioB)) {
                    nuevoMunicipio = conexionMinima.municipioB;
                } else if (municipiosConectados.contains(conexionMinima.municipioB) &&
                        !municipiosConectados.contains(conexionMinima.municipioA)) {
                    nuevoMunicipio = conexionMinima.municipioA;
                }

                if (nuevoMunicipio != -1) {
                    resultado.add(conexionMinima);
                    municipiosConectados.add(nuevoMunicipio);

                    // Agregar todas las conexiones del nuevo municipio a la cola
                    for (Conexion conexion : conexiones) {
                        if ((conexion.municipioA == nuevoMunicipio &&
                                !municipiosConectados.contains(conexion.municipioB)) ||
                                (conexion.municipioB == nuevoMunicipio &&
                                        !municipiosConectados.contains(conexion.municipioA))) {
                            colaPrioridad.add(conexion);
                        }
                    }
                }
            }

            return resultado;
        }
}
