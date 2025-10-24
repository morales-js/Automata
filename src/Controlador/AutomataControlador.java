package Controlador;

import Modelo.Automata;
import Modelo.GrafoGenerator;
import Modelo.LectorDeArchivo;
import Modelo.Simulador;
import Vista.Ventana;

import java.io.File;
import javax.swing.JOptionPane;

public class AutomataControlador {

    private Ventana vista;
    private Automata automata;
    private Simulador simulador;
    private final String rutaImagen = "automata"; // nombre base de la imagen del autómata

    // ====================== Constructor ======================
    public AutomataControlador(Ventana vista) {
        this.vista = vista;
    }

    // ====================== Cargar archivo ======================
    public void cargarArchivo(File archivo) {
        automata = LectorDeArchivo.leerDesdeArchivo(archivo);
        vista.mostrarDatos(automata);

        // 🔹 Mostrar si el autómata es un AFD válido
        boolean esValido = automata.esAFDValido();
        vista.mostrarValidezAFD(esValido);

        // 🔹 Generar imagen base del grafo
        try {
            GrafoGenerator.generarGrafo(automata, rutaImagen, null, null, null, null);
            vista.mostrarImagen(rutaImagen + ".png");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista, "No se pudo generar la imagen base del autómata.");
        }
    }

    // ====================== Analizar todas las cadenas ======================
    public void analizarCadenas() {
        if (automata == null) {
            JOptionPane.showMessageDialog(vista, "Primero carga un archivo.");
            return;
        }

        for (String cadena : vista.obtenerCadenas()) {
            boolean aceptada = automata.analizarCadena(cadena.replace(",", ""));
            vista.mostrarResultado(cadena, aceptada);
        }
    }

    // ====================== Iniciar simulación ======================
    public void iniciarSimulacion(int indexCadena) {
        if (automata == null) {
            JOptionPane.showMessageDialog(vista, "Carga un autómata primero.");
            return;
        }
        if (indexCadena < 0 || indexCadena >= automata.getCadenas().size()) {
            JOptionPane.showMessageDialog(vista, "Selecciona una cadena en la tabla.");
            return;
        }

        String raw = automata.getCadenas().get(indexCadena).replace(",", "");
        simulador = new Simulador(automata, raw);
        simulador.iniciar();

        // 🔹 Actualizar vista y grafo inicial
        vista.refrescarPaso(simulador);
        GrafoGenerator.generarGrafo(automata, rutaImagen, simulador.getEstadoActual(), null, null, null);
        vista.mostrarImagen(rutaImagen + ".png");
    }

    // ====================== Siguiente paso ======================
    public void siguientePaso() {
        if (simulador == null) {
            JOptionPane.showMessageDialog(vista, "Inicia primero una simulación.");
            return;
        }

        boolean avanzo = simulador.siguiente();
        if (!avanzo) {
            JOptionPane.showMessageDialog(vista, "No hay más pasos disponibles.");
            return;
        }

        // 🔹 Obtener información del paso actual
        Simulador.StepInfo step = simulador.getPasos().get(simulador.getIndice() - 1);

        // 🔹 Generar imagen actualizada
        GrafoGenerator.generarGrafo(
                automata,
                rutaImagen,
                simulador.getEstadoActual(),
                step.origen,
                step.destino,
                step.simbolo
        );
        vista.mostrarImagen(rutaImagen + ".png");

        // 🔹 Actualizar tabla
        vista.refrescarPaso(simulador);
    }

    // ====================== Paso anterior ======================
    public void anteriorPaso() {
        if (simulador == null) {
            JOptionPane.showMessageDialog(vista, "Inicia primero una simulación.");
            return;
        }

        simulador.anterior();

        // 🔹 Volver a graficar el estado actual
        GrafoGenerator.generarGrafo(automata, rutaImagen, simulador.getEstadoActual(), null, null, null);
        vista.mostrarImagen(rutaImagen + ".png");

        vista.refrescarPaso(simulador);
    }

    // ====================== Reiniciar simulación ======================
    public void reiniciarSimulacion() {
        if (simulador == null) {
            JOptionPane.showMessageDialog(vista, "Inicia primero una simulación.");
            return;
        }

        simulador.reiniciar();
        vista.refrescarPaso(simulador);

        GrafoGenerator.generarGrafo(automata, rutaImagen, simulador.getEstadoActual(), null, null, null);
        vista.mostrarImagen(rutaImagen + ".png");
    }
    
    
    public void generarImagenAutomata() {
    if (automata == null) {
        JOptionPane.showMessageDialog(vista, "Primero carga un autómata.");
        return;
    }

    try {
        GrafoGenerator.generarGrafo(automata, "automata", null, null, null, null);
        vista.mostrarImagen("automata.png");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(vista, "Error al generar la imagen: " + e.getMessage());
    }
}
}
