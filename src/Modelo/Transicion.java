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
  private String desde;
    private String simbolo;
    private String hacia;

    public Transicion(String desde, String simbolo, String hacia) {
        this.desde = desde;
        this.simbolo = simbolo;
        this.hacia = hacia;
    }
    
     public String getDesde() { return desde; }
    public String getSimbolo() { return simbolo; }
    public String getHacia() { return hacia; }

    @Override
    public String toString() {
        return desde + " --" + simbolo + "→ " + hacia;
    }
            
}
