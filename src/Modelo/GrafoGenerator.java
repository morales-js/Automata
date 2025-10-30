package Modelo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class GrafoGenerator {

    public static String generarGrafo(Automata automata, String rutaSalida, String estadoActual, String origen, String destino, String simbolo) {
        String rutaDot = rutaSalida + ".dot";
        String rutaPng = rutaSalida + ".png";

        try (FileWriter writer = new FileWriter(rutaDot)) {
            writer.write("digraph AFD {\n");
            writer.write("rankdir=LR;\n");
            writer.write("splines=true;\n");
            writer.write("overlap=false;\n");
            writer.write("nodesep=0.5;\n");
            writer.write("ranksep=0.8;\n");
            writer.write("node [shape=circle, style=filled, fillcolor=white, fontname=\"Helvetica\"];\n");

            // Estados
            for (String estado : automata.getEstados()) {
                if (estado.equals(estadoActual)) {
                    writer.write(String.format("\"%s\" [fillcolor=lightblue, style=filled];\n", estado));
                } else if (automata.getEstadosAceptacion().contains(estado)) {
                    writer.write(String.format("\"%s\" [shape=doublecircle, fillcolor=lightyellow];\n", estado));
                } else {
                    writer.write(String.format("\"%s\";\n", estado));
                }
            }

            // Transiciones
            for (var entrada : automata.getTransiciones().entrySet()) {
                String origenEstado = entrada.getKey();
                var trans = entrada.getValue();

                for (var s : trans.keySet()) {
                    String destinoEstado = trans.get(s);
                    if (destinoEstado == null || destinoEstado.isEmpty()) continue;

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

            // 🔹 Agregar una flecha invisible para unir todos los grupos (solo visual)
            String[] estados = automata.getEstados().toArray(new String[0]);
            if (estados.length > 1) {
                writer.write(String.format("\"%s\" -> \"%s\" [style=invis];\n", estados[0], estados[estados.length - 1]));
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
