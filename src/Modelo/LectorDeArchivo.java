/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author moralesjs_
 */
public class LectorDeArchivo {

    public class LectorArchivo {

        public static Automata cargarDesdeArchivo(File archivo) throws IOException {
            Automata automata = new Automata();
            Map<String, Estado> mapaEstados = new HashMap<>();

            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String linea;

        
        while ((linea = br.readLine()) != null) {
            if (linea.startsWith("Inicial:")) {
                String nombre = linea.split(":")[1].trim();
                Estado e = mapaEstados.computeIfAbsent(nombre, Estado::new);
                automata.agregarEstado(e);
                automata.setEstadoInicial(e);
            } else if (linea.startsWith("Aceptacion:")) {
                String[] partes = linea.split(":")[1].split(",");
                for (String p : partes) {
                    String nombre = p.trim();
                    Estado e = mapaEstados.computeIfAbsent(nombre, Estado::new);
                    e.setAceptacion(true);
                    automata.agregarEstado(e);
                }
            } else if (linea.startsWith("Simbolos:")) {
                String[] partes = linea.split(":")[1].split(",");
                for (String s : partes) automata.agregarSimbolo(s.trim());
            } else if (linea.startsWith("Transiciones:")) {
                continue; // saltamos a las siguientes líneas
            } else if (linea.contains(",")) {
                String[] partes = linea.split(",");
                String origen = partes[0].trim();
                 String simbolo = partes[1].trim();
                String destino = partes[2].trim();

                Estado eOrigen = mapaEstados.computeIfAbsent(origen, Estado::new);
                Estado eDestino = mapaEstados.computeIfAbsent(destino, Estado::new);

                automata.agregarEstado(eOrigen);
                automata.agregarEstado(eDestino);
                automata.agregarTransicion(new Transicion(eOrigen, eDestino, simbolo));
            }
        }

        br.close();
        return automata;
    }
    }
}
   
