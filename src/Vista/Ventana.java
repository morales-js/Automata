/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.AutomataControlador;
import Modelo.Automata;
import Modelo.LectorDeArchivo;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author moralesjs_ MostrarDatos
 */
public class Ventana extends javax.swing.JFrame {
    
    private AutomataControlador controlador;
    
    public Ventana() {
        initComponents();
        btnAbrir.setVisible(false);
        setTitle("AFD");

        controlador = new AutomataControlador(this); // Conecta vista con el controlador
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

  
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        choice1 = new java.awt.Choice();
        popupMenu1 = new java.awt.PopupMenu();
        panel = new javax.swing.JPanel();
        lblEstado = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Estados = new javax.swing.JLabel();
        Eaceptacion = new javax.swing.JLabel();
        Simbolos = new javax.swing.JLabel();
        txtEstados = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCadenas = new javax.swing.JTable();
        EInicial1 = new javax.swing.JLabel();
        txtAceptacion = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        miTablaTransiciones = new javax.swing.JTable();
        EInicial2 = new javax.swing.JLabel();
        txtSimbolos = new javax.swing.JTextField();
        txtInicial = new javax.swing.JTextField();
        txtFinal = new javax.swing.JTextField();
        Eaceptacion1 = new javax.swing.JLabel();
        btnReiniciar = new javax.swing.JButton();
        lblImagen = new javax.swing.JLabel();
        generarImagen1 = new javax.swing.JButton();
        btnIniciar = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        btnAnterior1 = new javax.swing.JButton();
        btnAnalizar = new javax.swing.JButton();
        btnAbrir = new javax.swing.JButton();
        Eaceptacion2 = new javax.swing.JLabel();
        Eaceptacion3 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        Abrir = new javax.swing.JMenuItem();
        btnnuevo = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        ManualUsuario = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        popupMenu1.setLabel("popupMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel.setBackground(new java.awt.Color(204, 204, 204));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblEstado.setBackground(new java.awt.Color(0, 153, 0));
        lblEstado.setText("Estado: ");
        panel.add(lblEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, -1, -1));

        textArea.setEditable(false);
        textArea.setColumns(20);
        textArea.setLineWrap(true);
        textArea.setRows(5);
        jScrollPane2.setViewportView(textArea);

        panel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 223, 310));

        jPanel2.setBackground(new java.awt.Color(7, 65, 115));
        jPanel2.setToolTipText("");
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Yu Gothic", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("AUTÓMATA FINITO DETERMINISTA");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/grafos.png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 20, -1, -1));

        panel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 1010, 110));

        Estados.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        Estados.setText("Estados:");
        panel.add(Estados, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 110, -1, 22));

        Eaceptacion.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        Eaceptacion.setText("AFD: ");
        panel.add(Eaceptacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 220, -1, -1));

        Simbolos.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        Simbolos.setText("Simbolos: ");
        panel.add(Simbolos, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, -1, -1));
        panel.add(txtEstados, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 110, 245, -1));

        tablaCadenas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", null},
                {null, null}
            },
            new String [] {
                "No.", "Cadenas"
            }
        ));
        jScrollPane1.setViewportView(tablaCadenas);

        panel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 282, 96));

        EInicial1.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        EInicial1.setText("Estado Inicial:");
        panel.add(EInicial1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, -1, -1));
        panel.add(txtAceptacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 170, 250, -1));

        miTablaTransiciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Estado", "Simbolo1", "Simbolo2"
            }
        ));
        jScrollPane3.setViewportView(miTablaTransiciones);

        panel.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, 282, 96));

        EInicial2.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        EInicial2.setText("Estado Final:");
        panel.add(EInicial2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 140, -1, -1));

        txtSimbolos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSimbolosActionPerformed(evt);
            }
        });
        panel.add(txtSimbolos, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, 245, -1));
        panel.add(txtInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, 245, -1));

        txtFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFinalActionPerformed(evt);
            }
        });
        panel.add(txtFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 140, 245, -1));

        Eaceptacion1.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        Eaceptacion1.setText("Aceptacion:");
        panel.add(Eaceptacion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, -1, -1));

        btnReiniciar.setText("🔁 Reiniciar");
        btnReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarActionPerformed(evt);
            }
        });
        panel.add(btnReiniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 470, -1, 20));

        lblImagen.setBackground(new java.awt.Color(204, 204, 204));
        lblImagen.setText("-");
        panel.add(lblImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 250, 470, 300));

        generarImagen1.setText("📊 Generar Imágen");
        generarImagen1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarImagen1ActionPerformed(evt);
            }
        });
        panel.add(generarImagen1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 500, -1, 20));

        btnIniciar.setText("▶ Iniciar");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });
        panel.add(btnIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 440, -1, 20));

        btnSiguiente.setText("⏭ Siguiente");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });
        panel.add(btnSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 440, -1, 20));

        btnAnterior1.setText("⏮ Anterior");
        btnAnterior1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnterior1ActionPerformed(evt);
            }
        });
        panel.add(btnAnterior1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 440, -1, 20));

        btnAnalizar.setText("Analizar Cadenas");
        btnAnalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarActionPerformed(evt);
            }
        });
        panel.add(btnAnalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 470, -1, 20));

        btnAbrir.setText("Abrir");
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });
        panel.add(btnAbrir, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, 20, 10));

        Eaceptacion2.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        Eaceptacion2.setText("Transiciones Autómata:");
        panel.add(Eaceptacion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, -1, -1));

        Eaceptacion3.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        Eaceptacion3.setText("Cadenas:");
        panel.add(Eaceptacion3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, -1, -1));

        getContentPane().add(panel, java.awt.BorderLayout.CENTER);

        jMenuBar2.setBackground(new java.awt.Color(0, 51, 204));
        jMenuBar2.setForeground(new java.awt.Color(0, 0, 204));

        jMenu3.setText("Archivo");

        Abrir.setText("Abrir");
        Abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbrirActionPerformed(evt);
            }
        });
        jMenu3.add(Abrir);

        btnnuevo.setText("Nuevo");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });
        jMenu3.add(btnnuevo);

        jMenuItem3.setText("Guardar");
        jMenu3.add(jMenuItem3);

        jMenuItem4.setText("Salir");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuBar2.add(jMenu3);

        jMenu4.setText("Acerca de");
        jMenu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu4ActionPerformed(evt);
            }
        });

        ManualUsuario.setText("Manual Usuario");
        ManualUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManualUsuarioActionPerformed(evt);
            }
        });
        jMenu4.add(ManualUsuario);

        jMenuBar2.add(jMenu4);

        jMenu2.setText("Modelos");

        jMenuItem1.setText("Modelo 1");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setText("Modelo 2");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem5.setText("Modelo 3");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuBar2.add(jMenu2);

        setJMenuBar(jMenuBar2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mostrarAutomataEnInterfaz(Automata automata) {
    txtSimbolos.setText(String.join(",", automata.getSimbolos()));
    txtEstados.setText(String.join(",", automata.getEstados()));
    txtInicial.setText(automata.getEstadoInicial());
    txtFinal.setText(String.join(",", automata.getEstadosAceptacion()));

    // Tabla de cadenas
    DefaultTableModel modeloCadenas = (DefaultTableModel) tablaCadenas.getModel();
    modeloCadenas.setRowCount(0);
    int i = 1;
    for (String cadena : automata.getCadenas()) {
        modeloCadenas.addRow(new Object[]{i++, cadena});
    }

    // Tabla de transiciones
    DefaultTableModel modeloTrans = (DefaultTableModel) miTablaTransiciones.getModel();
    modeloTrans.setRowCount(0);
    
    for (Map.Entry<String, Map<String, String>> entrada : automata.getTransiciones().entrySet()) {
        String estado = entrada.getKey();
        Map<String, String> destinos = entrada.getValue();
        modeloTrans.addRow(new Object[]{estado, destinos.get("0"), destinos.get("1")});
    
    }
    }
    
    //mostrarDatos
    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        // TODO add your handling code here:
      JFileChooser fc = new JFileChooser();
    if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
        File archivoSeleccionado = fc.getSelectedFile();
        controlador.cargarArchivo(archivoSeleccionado);

        // Mostrar contenido en el JTextArea
        try (BufferedReader br = new BufferedReader(new FileReader(archivoSeleccionado))) {
            StringBuilder contenido = new StringBuilder();
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
            textArea.setText(contenido.toString());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al leer el archivo: " + e.getMessage());
        }
    }

        
        
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void txtSimbolosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSimbolosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSimbolosActionPerformed

    private void btnAnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarActionPerformed
        // TODO add your handling code here:
          controlador.analizarCadenas();
   
    }//GEN-LAST:event_btnAnalizarActionPerformed

    private void btnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarActionPerformed
        // TODO add your handling code here:
    controlador.reiniciarSimulacion();

    }//GEN-LAST:event_btnReiniciarActionPerformed

    private void generarImagen1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarImagen1ActionPerformed
        // TODO add your handling code here:
//        controlador.generarImagenAutomata();
        controlador.generarImagenAutomata();
    }//GEN-LAST:event_generarImagen1ActionPerformed

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
   controlador.iniciarSimulacion(tablaCadenas.getSelectedRow());
    }//GEN-LAST:event_btnIniciarActionPerformed
    
    
    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        // TODO add your handling code here:
     controlador.siguientePaso();
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnAnterior1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnterior1ActionPerformed
        // TODO add your handling code here:
        controlador.anteriorPaso();
    }//GEN-LAST:event_btnAnterior1ActionPerformed

    
    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        // TODO add your handling code here:
    controlador.crearNuevoAutomata();
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void AbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbrirActionPerformed
        // TODO add your handling code here:
        btnAbrirActionPerformed(evt);
    }//GEN-LAST:event_AbrirActionPerformed

    private void jMenu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu4ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jMenu4ActionPerformed

    private void ManualUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManualUsuarioActionPerformed
     try {
        // Crear el archivo PDF
        com.itextpdf.text.Document documento = new com.itextpdf.text.Document();
         String ruta = System.getProperty("user.home") + File.separator + "Documents" + File.separator + "AFD_Simulador";
         new File(ruta).mkdirs();
         com.itextpdf.text.pdf.PdfWriter.getInstance(documento, new java.io.FileOutputStream(ruta + File.separator + "Manual_Usuario_AFD.pdf"));

        documento.open();

        // Título
        com.itextpdf.text.Font tituloFont = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 18, com.itextpdf.text.Font.BOLD);
        com.itextpdf.text.Paragraph titulo = new com.itextpdf.text.Paragraph("Manual de Usuario - Simulador de AFD", tituloFont);
        titulo.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
        documento.add(titulo);
        documento.add(new com.itextpdf.text.Paragraph(" "));

        // Contenido principal
        String contenido = """
        Este programa permite cargar, visualizar y simular autómatas finitos deterministas (AFD).
        
        Funcionalidades principales:
        1. Cargar un archivo .txt con la definición del autómata.
        2. Visualizar su grafo (generado automáticamente con Graphviz).
        3. Analizar cadenas para determinar si son aceptadas o rechazadas.
        4. Crear nuevos autómatas de forma manual con el botón "Nuevo".
        
        Estructura esperada del archivo:
        
        Simbolos: 0,1
        Estados: Q0,Q1,Q2
        Estado inicial: Q0
        Estados de aceptación: Q2
        Transiciones:
        Q0->Q1,Q0
        Q1->Q2,Q0
        Q2->Q2,Q1
        Cadenas a analizar:
        0,1,0
        1,0,1,1
        
        Recomendaciones:
        - Asegúrese de tener Graphviz instalado y configurado en el sistema.
        - Los archivos deben tener formato de texto plano (.txt).
        - Puede reiniciar y analizar paso a paso una simulación desde la interfaz.
        """;

        com.itextpdf.text.Paragraph cuerpo = new com.itextpdf.text.Paragraph(contenido);
        documento.add(cuerpo);

        documento.close();

        javax.swing.JOptionPane.showMessageDialog(this, "Manual de usuario generado correctamente como 'Manual_Usuario_AFD.pdf'. En DOCUMENTOS/ AFD SIMULADOR");
    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Error al generar el PDF: " + e.getMessage());
        e.printStackTrace();
    }
    }//GEN-LAST:event_ManualUsuarioActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        Inicio ini = new Inicio();
        ini.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        controlador.cargarModeloDesdeArchivo("modelo1");
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void txtFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFinalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFinalActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        controlador.cargarModeloDesdeArchivo("modelo2");
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        controlador.cargarModeloDesdeArchivo("modelo3");
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    
     public void mostrarDatos(Automata automata) {
        // Aquí actualizas tus campos (símbolos, estados, etc.) automata.getCadenas(
        txtSimbolos.setText(String.join(",", automata.getSimbolos()));
        txtEstados.setText(String.join(",", automata.getEstados()));
        txtInicial.setText(automata.getEstadoInicial());
        txtAceptacion.setText(String.join(",", automata.getEstadosAceptacion()));  
        
        System.out.println("🔍 Transiciones cargadas: " + automata.getTransiciones());

 // 🔹 Construir encabezados dinámicos según los símbolos
         String[] columnas = new String[automata.getSimbolos().size() + 1];
         columnas[0] = "Estado";
         for (int i = 0; i < automata.getSimbolos().size(); i++) {
             columnas[i + 1] = "Símbolo " + automata.getSimbolos().get(i);
         }
         DefaultTableModel modeloTrans = new DefaultTableModel(columnas, 0);

// 🔹 Llenar filas con cada transición
         for (String estado : automata.getTransiciones().keySet()) {
             Object[] fila = new Object[columnas.length];
             fila[0] = estado;
             for (int i = 0; i < automata.getSimbolos().size(); i++) {
                 String simbolo = automata.getSimbolos().get(i);
                 fila[i + 1] = automata.getTransiciones().get(estado).get(simbolo);
             }
             modeloTrans.addRow(fila);
         }
         miTablaTransiciones.setModel(modeloTrans);
         
         // Mostrar cadenas
   List<String> cadenas = automata.getCadenas();
         if (cadenas == null) {
             cadenas = new ArrayList<>();
         }
         DefaultTableModel cadenasModel = (DefaultTableModel) tablaCadenas.getModel();
         cadenasModel.setRowCount(0);
         int i = 1;
         for (String cadena : cadenas) {
             cadenasModel.addRow(new Object[]{i++, cadena});
         }


         
    }
     //mostrarImagen
    public void limpiarImagen() {
    lblImagen.setIcon(null);
    lblImagen.repaint();
}
     
    public List<String> obtenerCadenas() {
        List<String> cadenas = new ArrayList<>();
        for (int i = 0; i < tablaCadenas.getRowCount(); i++) {
            Object val = tablaCadenas.getValueAt(i, 1);
            if (val != null && !val.toString().isEmpty()) {
                cadenas.add(val.toString());
            }
        }
        return cadenas;
    }
    

    
    
    //limpiarImagen
    public void mostrarResultado(String cadena, boolean aceptada) {
               JOptionPane.showMessageDialog(this, "Cadena " + cadena + " → " + (aceptada ? "ACEPTADA ✅" : "RECHAZADA ❌"));
    }
  
    public void mostrarValidezAFD(boolean valido) {
    if (valido) {
        lblEstado.setText("✅ Contenido válido: corresponde a un AFD");
        lblEstado.setForeground(new java.awt.Color(0, 128, 0)); // verde
    } else {
        lblEstado.setText("❌ Contenido inválido: no cumple las reglas de un AFD");
        lblEstado.setForeground(java.awt.Color.RED);
    }
}
    
  public void mostrarImagen(String ruta) {
    ImageIcon icon = new ImageIcon(ruta);
    Image scaled = icon.getImage().getScaledInstance(
        lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH
    );
    lblImagen.setIcon(new ImageIcon(scaled));
}
  // MODELOS mostrar CONTENIDO EN JTEXTAREA
  public void mostrarContenidoArchivo(String contenido) {
    textArea.setText(contenido);
}
  
  
    
    
    
        public void refrescarPaso(Modelo.Simulador simulador) {
    if (simulador == null) return;

    // Estado actual y paso (indice)
    String estadoActual = simulador.getEstadoActual();
    int indice = simulador.getIndice(); // número de símbolos ya procesados

    // BUSCAR la fila que corresponde al estadoActual en la tabla de transiciones (col 0)
    int filaResaltada = -1;
    for (int r = 0; r < miTablaTransiciones.getRowCount(); r++) {
        Object v = miTablaTransiciones.getValueAt(r, 0);
        if (v != null && v.toString().equals(estadoActual)) {
            filaResaltada = r;
            break;
        }
    }

    // Determinar columna para el símbolo procesado (col 1..n) mostrar
    int colResaltada = -1;
    if (indice > 0 && simulador.getPasos() != null && simulador.getPasos().size() >= indice) {
        String simboloProcesado = simulador.getPasos().get(indice - 1).simbolo;
        // Buscar en encabezados la columna que termina o contiene el símbolo
        for (int c = 1; c < miTablaTransiciones.getColumnCount(); c++) {
            String header = miTablaTransiciones.getColumnName(c);
            // Normaliza: quitar mayúsc/minúsc y espacios
            String h = header.trim();
            if (h.endsWith(simboloProcesado) || h.equals(simboloProcesado) || h.contains(simboloProcesado)) {
                colResaltada = c;
                break;
            }
        }
    }
    
  

//mostrar



// -- Instalamos un renderer temporal que pinta la celda resaltada refrescar
     // Copias finales para la clase interna (efectivamente final)
    final int filaFinal = filaResaltada;
    final int colFinal = colResaltada;

    // Renderer que pinta la celda resaltada y el estado actual (col 0)
    DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            // Resetear colores por si acaso
            c.setBackground(Color.WHITE);
            c.setForeground(Color.BLACK);

            if (filaFinal >= 0 && colFinal >= 0 && row == filaFinal && column == colFinal) {
                c.setBackground(Color.YELLOW);                // celda transición (símbolo aplicado)
            } else if (filaFinal >= 0 && row == filaFinal && column == 0) {
                c.setBackground(new Color(173, 216, 230));    // fila del estado actual (col 0)
            } else {
                // mantener selección visual por defecto
                if (isSelected) c.setBackground(table.getSelectionBackground());
                else c.setBackground(Color.WHITE);
            }
            return c;
        }
    };

    // Aplicar renderer a todas las columnas
    for (int c = 0; c < miTablaTransiciones.getColumnCount(); c++) {
        miTablaTransiciones.getColumnModel().getColumn(c).setCellRenderer(renderer);
    }
    miTablaTransiciones.repaint();

    // Actualizar etiqueta de estado (puedes personalizar)
    String texto = "Estado actual: " + (estadoActual == null ? "NULL" : estadoActual)
                 + " | Paso: " + indice + "/" + (simulador.getPasos() == null ? 0 : simulador.getPasos().size());
    lblEstado.setText(texto);

    // Si terminó, mostrar resultado (opcional)
    if (simulador.terminado()) {
        boolean acept = simulador.aceptado();
        JOptionPane.showMessageDialog(this, "Simulación terminada. Resultado: " + (acept ? "ACEPTADA" : "RECHAZADA"));
    }
    
    
    
}
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Abrir;
    private javax.swing.JLabel EInicial1;
    private javax.swing.JLabel EInicial2;
    private javax.swing.JLabel Eaceptacion;
    private javax.swing.JLabel Eaceptacion1;
    private javax.swing.JLabel Eaceptacion2;
    private javax.swing.JLabel Eaceptacion3;
    private javax.swing.JLabel Estados;
    private javax.swing.JMenuItem ManualUsuario;
    private javax.swing.JLabel Simbolos;
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnAnalizar;
    private javax.swing.JButton btnAnterior1;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnReiniciar;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JMenuItem btnnuevo;
    private java.awt.Choice choice1;
    private javax.swing.JButton generarImagen1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JTable miTablaTransiciones;
    private javax.swing.JPanel panel;
    private java.awt.PopupMenu popupMenu1;
    private javax.swing.JTable tablaCadenas;
    private javax.swing.JTextArea textArea;
    private javax.swing.JTextField txtAceptacion;
    private javax.swing.JTextField txtEstados;
    private javax.swing.JTextField txtFinal;
    private javax.swing.JTextField txtInicial;
    private javax.swing.JTextField txtSimbolos;
    // End of variables declaration//GEN-END:variables
}
