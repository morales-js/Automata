/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author moralesjs_
 */
public class Automata {

    private Estado estadoInicial;
    private List<Estado> estados = new ArrayList<>();
    private List<String> simbolos = new ArrayList<>();
    private List<Transicion> transiciones = new ArrayList<>();

    public void setEstadoInicial(Estado estado) {
        this.estadoInicial = estado;
        estado.setInicial(true);
    }

    public Estado getEstadoInicial() {
        return estadoInicial;
    }

    public List<Estado> getEstados() {
        return estados;
    }

    public List<String> getSimbolos() {
        return simbolos;
    }

    public List<Transicion> getTransiciones() {
        return transiciones;
    }

    public void agregarEstado(Estado e) {
         if (estados.stream().noneMatch(x -> x.getNombre().equals(e.getNombre()))) {
        estados.add(e);
    }
    }

    public void agregarSimbolo(String s) {
        simbolos.add(s);
    }

    public void agregarTransicion(Transicion t) {
        transiciones.add(t);
    }   
}
