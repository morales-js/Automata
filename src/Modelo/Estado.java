/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author moralesjs_
 */
// INFORMAICON QUE SE GUARDARA DEL AUTOMATA QUE SE LEERA DEL ARCHIVO
public class Estado {

    private String nombre;
    private boolean esInicial;
    private boolean esAceptacion;

    public Estado(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isInicial() {
        return esInicial;
    }

    public boolean isAceptacion() {
        return esAceptacion;
    }

    public void setInicial(boolean esInicial) {
        this.esInicial = esInicial;
    }

    public void setAceptacion(boolean esAceptacion) {
        this.esAceptacion = esAceptacion;
    }

    @Override
    public String toString() {
        return nombre + (esInicial ? " (Inicial)" : "") + (esAceptacion ? " (Aceptación)" : "");
    }

}
