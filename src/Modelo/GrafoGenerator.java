package Modelo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GrafoGenerator {

    public static String generarGrafo(Automata automata, String rutaSalida, 
                                      String estadoActual, String origen, String destino, String simbolo) {
        String rutaDot = rutaSalida + ".dot";
        String rutaPng = rutaSalida + ".png";

        try (FileWriter writer = new FileWriter(rutaDot)) {
            writer.write("digraph AFD {\n");
            writer.write("rankdir=LR;\n");
            writer.write("node [shape=circle, style=filled, fillcolor=white, fontname=\"Arial\"];\n");

            // 🔹 Estado inicial con flecha desde un nodo invisible
            writer.write("inicio [shape=point, width=0.1, label=\"\"];\n");
            writer.write(String.format("inicio -> \"%s\";\n", automata.getEstadoInicial()));

            // 🔹 Dibujar estados (inicial, actual, aceptación, normales)
            for (String estado : automata.getEstados()) {
                String color = "white";
                String shape = "circle";

                if (estado.equals(estadoActual)) {
                    color = "lightblue";
                }
                if (automata.getEstadosAceptacion().contains(estado)) {
                    shape = "doublecircle";
                }

                writer.write(String.format("\"%s\" [shape=%s, fillcolor=%s];\n", estado, shape, color));
            }

            // 🔹 Dibujar transiciones
            for (var entrada : automata.getTransiciones().entrySet()) {
                String origenEstado = entrada.getKey();
                var trans = entrada.getValue();

                for (var s : trans.keySet()) {
                    String destinoEstado = trans.get(s);

                    // Si es la transición actual, resáltala
                    if (origen != null && destino != null && simbolo != null &&
                        origen.equals(origenEstado) && destino.equals(destinoEstado)) {
                        writer.write(String.format("\"%s\" -> \"%s\" [label=\"%s\", color=red, penwidth=2.0];\n",
                                origenEstado, destinoEstado, s));
                    } else {
                        writer.write(String.format("\"%s\" -> \"%s\" [label=\"%s\"];\n",
                                origenEstado, destinoEstado, s));
                    }
                }
            }

            writer.write("}\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ProcessBuilder pb = new ProcessBuilder("dot", "-Tpng", rutaDot, "-o", rutaPng);
            pb.redirectErrorStream(true);
            Process p = pb.start();
            p.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rutaPng;
    }
}
