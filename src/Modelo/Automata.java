/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author moralesjs_
 */
public class Automata {
    private List<String> simbolos = new ArrayList<>();
    private List<String> estados = new ArrayList<>();
    private String estadoInicial = "";
    private List<String> estadosAceptacion = new ArrayList<>();
    private Map<String, Map<String, String>> transiciones;
    private List<String> cadenas = new ArrayList<>();

    // Getters y setters
        public List<String> getSimbolos() {
        return simbolos == null ? new ArrayList<>() : simbolos;
    }

    public void setSimbolos(List<String> simbolos) {
        this.simbolos = simbolos == null ? new ArrayList<>() : simbolos;
    }

    public List<String> getEstados() {
        return estados == null ? new ArrayList<>() : estados;
    }

    public void setEstados(List<String> estados) {
        this.estados = estados == null ? new ArrayList<>() : estados;
    }

    public String getEstadoInicial() {
        return estadoInicial;
    }

    public void setEstadoInicial(String estadoInicial) {
        this.estadoInicial = estadoInicial;
    }

    public List<String> getEstadosAceptacion() {
        return estadosAceptacion == null ? new ArrayList<>() : estadosAceptacion;
    }

    public void setEstadosAceptacion(List<String> estadosAceptacion) {
        this.estadosAceptacion = estadosAceptacion == null ? new ArrayList<>() : estadosAceptacion;
    }

    public Map<String, Map<String, String>> getTransiciones() {
        return transiciones;
    }

    public void setTransiciones(Map<String, Map<String, String>> transiciones) {
        this.transiciones = transiciones;
    }

    public List<String> getCadenas() {
        return cadenas == null ? new ArrayList<>() : cadenas;
    }

    public void setCadenas(List<String> cadenas) {
        this.cadenas = cadenas == null ? new ArrayList<>() : cadenas;
    }


    // 🔹 Método para analizar una cadena
    public boolean analizarCadena(String cadena) {
   if (cadena == null) return false;

    String estadoActual = estadoInicial;

    // Determinar símbolos: si contiene comas -> split, si no -> cada char
    String[] simbolosCadena;
    if (cadena.contains(",")) {
        simbolosCadena = cadena.split(",");
    } else {
        // convertir cada caracter en un símbolo string
        simbolosCadena = new String[cadena.length()];
        for (int i = 0; i < cadena.length(); i++) {
            simbolosCadena[i] = String.valueOf(cadena.charAt(i));
        }
    }

    for (String s : simbolosCadena) {
        s = s.trim();
        if (s.isEmpty()) continue;

        // Debug opcional (comenta en producción)
        System.out.println("Analizando símbolo '" + s + "' desde estado " + estadoActual);

        Map<String, String> mapa = transiciones.get(estadoActual);
        if (mapa == null) {
            System.out.println("No hay transiciones definidas para el estado " + estadoActual);
            return false;
        }
        if (!mapa.containsKey(s)) {
            System.out.println("No existe transición para símbolo '" + s + "' en estado " + estadoActual);
            return false;
        }
        estadoActual = mapa.get(s);
    }

    boolean aceptada = estadosAceptacion != null && estadosAceptacion.contains(estadoActual);
    System.out.println("Cadena finalizó en estado " + estadoActual + " -> " + (aceptada ? "ACEPTADA" : "RECHAZADA"));
    return aceptada;
}
    
    // ✅ Verifica si el autómata cumple las reglas de un AFD
public boolean esAFDValido() {
    if (transiciones == null || simbolos == null) return false;

    for (String estado : transiciones.keySet()) {
        Map<String, String> mapa = transiciones.get(estado);
        if (mapa == null) return false;

        for (String simbolo : simbolos) {
            if (!mapa.containsKey(simbolo) || mapa.get(simbolo) == null || mapa.get(simbolo).isEmpty()) {
                return false; // falta una transición
            }
        }
    }
    return true;
}
    
}
//generar