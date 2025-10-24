/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author moralesjs_
 */
public class LectorDeArchivo {

    public static Automata leerDesdeArchivo(File archivo) {
        Automata automata = new Automata();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();

                if (linea.startsWith("Simbolos:")) {
                    String[] simbolos = linea.replace("Simbolos:", "").trim().split(",");
                    automata.setSimbolos(Arrays.asList(simbolos));
                } else if (linea.startsWith("Estados:")) {
                    String[] estados = linea.replace("Estados:", "").trim().split(",");
                    automata.setEstados(Arrays.asList(estados));
                } else if (linea.startsWith("Estado inicial:")) {
                    automata.setEstadoInicial(linea.replace("Estado inicial:", "").trim());
                } else if (linea.startsWith("Estados de aceptación:")) {
                    String[] acept = linea.replace("Estados de aceptación:", "").trim().split(",");
                    automata.setEstadosAceptacion(Arrays.asList(acept));
                } else if (linea.startsWith("Transiciones:")) {
                    Map<String, Map<String, String>> transiciones = new HashMap<>();

                    // Leer todas las líneas de transiciones antes de "Cadenas a analizar:"
                    List<String> lineasTrans = new ArrayList<>();
                    while ((linea = br.readLine()) != null && !linea.startsWith("Cadenas a analizar:")) {
                        linea = linea.trim();
                        if (!linea.isEmpty()) {
                            lineasTrans.add(linea);
                        }
                    }

                    // Construir el mapa de transiciones según el orden de los estados
                    List<String> estados = automata.getEstados();
                    List<String> simbolos = automata.getSimbolos();

                    for (int i = 0; i < lineasTrans.size() && i < estados.size(); i++) {
                        String estado = estados.get(i);
                        String[] destinos = lineasTrans.get(i).split(",");

                        Map<String, String> mapa = new HashMap<>();
                        for (int j = 0; j < destinos.length && j < simbolos.size(); j++) {
                            mapa.put(simbolos.get(j).trim(), destinos[j].trim());
                        }

                        transiciones.put(estado, mapa);
                    }

                    automata.setTransiciones(transiciones);

                    // Leer cadenas
                    if (linea != null && linea.startsWith("Cadenas a analizar:")) {
                        List<String> cadenas = new ArrayList<>();
                        while ((linea = br.readLine()) != null) {
                            linea = linea.trim();
                            if (!linea.isEmpty()) {
                                cadenas.add(linea);
                            }
                        }
                        automata.setCadenas(cadenas);
                    }
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return automata;
    }
}
