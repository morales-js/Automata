/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author moralesjs_
 */
  //verificando tercer commit
public class Transicion {
    private Estado origen;
    private Estado destino;
    private String simbolo;
    
     public Transicion(Estado origen, Estado destino, String simbolo) {
        this.origen = origen;
        this.destino = destino;
        this.simbolo = simbolo;
    }

    public Estado getOrigen() {
        return origen;
    }

    public Estado getDestino() {
        return destino;
    }

    public String getSimbolo() {
        return simbolo;
    }

    @Override
    public String toString() {
        return origen.getNombre() + " --" + simbolo + "--> " + destino.getNombre();
    }
    
}
