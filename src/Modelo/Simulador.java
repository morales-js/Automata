package Modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Simulador {

    private Automata automata;
    private String cadena;
    private String estadoActual;
    private int indice; // índice del símbolo actual
    private List<StepInfo> pasos;
    private boolean terminado;
    private boolean aceptado;

    // 🔹 Clase interna para registrar cada paso
    public static class StepInfo {
        public String origen;
        public String destino;
        public String simbolo;

        public StepInfo(String origen, String destino, String simbolo) {
            this.origen = origen;
            this.destino = destino;
            this.simbolo = simbolo;
        }
    }

    // 🔹 Constructor
    public Simulador(Automata automata, String cadena) {
        this.automata = automata;
        this.cadena = cadena;
        this.estadoActual = automata.getEstadoInicial();
        this.indice = 0;
        this.pasos = new ArrayList<>();
        this.terminado = false;
        this.aceptado = false;
    }

    // 🔹 Iniciar simulación
    public void iniciar() {
        this.estadoActual = automata.getEstadoInicial();
        this.indice = 0;
        this.pasos.clear();
        this.terminado = false;
        this.aceptado = false;
    }

    // 🔹 Avanzar un paso
    public boolean siguiente() {
        if (terminado || indice >= cadena.length()) {
            return false;
        }

        String simbolo = String.valueOf(cadena.charAt(indice));
        Map<String, Map<String, String>> trans = automata.getTransiciones();

        if (!trans.containsKey(estadoActual) || !trans.get(estadoActual).containsKey(simbolo)) {
            terminado = true;
            aceptado = false;
            return false;
        }

        String nuevoEstado = trans.get(estadoActual).get(simbolo);
        pasos.add(new StepInfo(estadoActual, nuevoEstado, simbolo));

        estadoActual = nuevoEstado;
        indice++;

        // Si ya procesó toda la cadena:
        if (indice == cadena.length()) {
            terminado = true;
            aceptado = automata.getEstadosAceptacion().contains(estadoActual);
        }

        return true;
    }

    // 🔹 Retroceder un paso
    public void anterior() {
        if (indice <= 0) return;

        StepInfo ultimo = pasos.remove(pasos.size() - 1);
        estadoActual = ultimo.origen;
        indice--;
        terminado = false;
    }

    // 🔹 Reiniciar simulación
    public void reiniciar() {
        iniciar();
    }

    // 🔹 Getters importantes
    public String getEstadoActual() {
        return estadoActual;
    }

    public List<StepInfo> getPasos() {
        return pasos;
    }

    public int getIndice() {
        return indice;
    }

    // 🔹 Métodos requeridos por tu vista
    public boolean terminado() {
        return terminado;
    }

    public boolean aceptado() {
        return aceptado;
    }
}
