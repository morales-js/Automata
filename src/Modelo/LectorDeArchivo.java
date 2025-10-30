package Modelo;

import java.io.*;
import java.util.*;

public class LectorDeArchivo {

    public static Automata leerDesdeArchivo(File archivo) {
        Automata automata = new Automata();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            List<String> transLines = new ArrayList<>();
            List<String> cadenas = new ArrayList<>();
            boolean leyendoTrans = false, leyendoCadenas = false;

            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (linea.isEmpty()) continue;

                if (linea.startsWith("Simbolos:")) {
                    automata.setSimbolos(parseList(linea.replace("Simbolos:", "")));
                    leyendoTrans = false; leyendoCadenas = false;
                } 
                else if (linea.startsWith("Estados:")) {
                    automata.setEstados(parseList(linea.replace("Estados:", "")));
                    leyendoTrans = false; leyendoCadenas = false;
                } 
                else if (linea.startsWith("Estado inicial:")) {
                    automata.setEstadoInicial(linea.replace("Estado inicial:", "").trim());
                    leyendoTrans = false; leyendoCadenas = false;
                } 
                else if (linea.startsWith("Estados de aceptación:") || linea.startsWith("Estado de aceptación:")) {
                    automata.setEstadosAceptacion(parseList(linea.substring(linea.indexOf(":") + 1)));
                    leyendoTrans = false; leyendoCadenas = false;
                } 
                else if (linea.startsWith("Transiciones:")) {
                    leyendoTrans = true;
                    leyendoCadenas = false;
                    transLines.clear();
                } 
                else if (linea.startsWith("Cadenas a analizar:") || linea.startsWith("Cadenas:")) {
                    leyendoTrans = false;
                    leyendoCadenas = true;
                } 
                else {
                    if (leyendoTrans) transLines.add(linea);
                    else if (leyendoCadenas) cadenas.add(linea);
                }
            }

            // Crear mapa de transiciones
            Map<String, Map<String, String>> transiciones = new HashMap<>();
            List<String> simbolos = Optional.ofNullable(automata.getSimbolos()).orElse(new ArrayList<>());
            List<String> estados = Optional.ofNullable(automata.getEstados()).orElse(new ArrayList<>());

            if (!transLines.isEmpty()) {
                boolean usaFlecha = transLines.stream().anyMatch(l -> l.contains("->"));
                if (usaFlecha) {
                    // formato tipo Q0->Q1,Q2,Q3
                    for (String lineaT : transLines) {
                        String[] partes = lineaT.split("->");
                        if (partes.length != 2) continue;
                        String origen = partes[0].trim();
                        String[] destinos = partes[1].split(",");
                        Map<String, String> mapa = new HashMap<>();
                        for (int i = 0; i < simbolos.size() && i < destinos.length; i++)
                            mapa.put(simbolos.get(i), destinos[i].trim());
                        transiciones.put(origen, mapa);
                    }
                } else {
                    // formato compacto (una línea por estado)
                    for (int i = 0; i < estados.size(); i++) {
                        String estado = estados.get(i);
                        Map<String, String> mapa = new HashMap<>();
                        if (i < transLines.size()) {
                            String[] destinos = transLines.get(i).split(",");
                            for (int j = 0; j < simbolos.size() && j < destinos.length; j++)
                                mapa.put(simbolos.get(j), destinos[j].trim());
                        } else {
                            // Si no hay línea, se autorreferencia (evita nulls)
                            for (String s : simbolos) mapa.put(s, estado);
                        }
                        transiciones.put(estado, mapa);
                    }
                }
            }

            // asignar todo al autómata
            automata.setTransiciones(transiciones);
            automata.setCadenas(cadenas);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // aseguramos que no haya nulls
        if (automata.getSimbolos() == null) automata.setSimbolos(new ArrayList<>());
        if (automata.getEstados() == null) automata.setEstados(new ArrayList<>());
        if (automata.getEstadosAceptacion() == null) automata.setEstadosAceptacion(new ArrayList<>());
        if (automata.getTransiciones() == null) automata.setTransiciones(new HashMap<>());
        if (automata.getCadenas() == null) automata.setCadenas(new ArrayList<>());
        return automata;
        
    }

    private static List<String> parseList(String linea) {
        List<String> lista = new ArrayList<>();
        for (String s : linea.split(",")) {
            if (!s.trim().isEmpty()) lista.add(s.trim());
        }
        return lista;
    }
}
