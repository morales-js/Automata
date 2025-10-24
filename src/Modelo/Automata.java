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
    
  private List<String> simbolos;
    private List<String> estados;
    private String estadoInicial;
    private List<String> estadosAceptacion;
    private Map<String, Map<String, String>> transiciones;
    private List<String> cadenas;

    // Getters y setters
    public List<String> getSimbolos() { return simbolos; }
    public void setSimbolos(List<String> simbolos) { this.simbolos = simbolos; }

    public List<String> getEstados() { return estados; }
    public void setEstados(List<String> estados) { this.estados = estados; }

    public String getEstadoInicial() { return estadoInicial; }
    public void setEstadoInicial(String estadoInicial) { this.estadoInicial = estadoInicial; }

    public List<String> getEstadosAceptacion() { return estadosAceptacion; }
    public void setEstadosAceptacion(List<String> estadosAceptacion) { this.estadosAceptacion = estadosAceptacion; }

    public Map<String, Map<String, String>> getTransiciones() { return transiciones; }
    public void setTransiciones(Map<String, Map<String, String>> transiciones) { this.transiciones = transiciones; }

    public List<String> getCadenas() { return cadenas; }
    public void setCadenas(List<String> cadenas) { this.cadenas = cadenas; }

    // 🔹 Método para analizar una cadena
    public boolean analizarCadena(String cadena) {
        String estadoActual = estadoInicial;

        for (char simbolo : cadena.toCharArray()) {
            String s = String.valueOf(simbolo);
            if (!transiciones.containsKey(estadoActual) || !transiciones.get(estadoActual).containsKey(s)) {
                return false;
            }
            estadoActual = transiciones.get(estadoActual).get(s);
        }

        return estadosAceptacion.contains(estadoActual);
        
        
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