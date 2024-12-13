/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex2p2_jeremytosorto;

/**
 *
 * @author DELL
 */
public class Trainer {
    private String nombre, region;
    private double dinero;
    private int pokeballs;

    public Trainer(String nombre, String region) {
        this.nombre = nombre;
        this.region = region;
        this.dinero = 0;
        this.pokeballs = 10;
    }

    public Trainer() {
    }

    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public double getDinero() {
        return dinero;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }

    public int getPokeballs() {
        return pokeballs;
    }

    public void setPokeballs(int pokeballs) {
        this.pokeballs = pokeballs;
    }
    
    
}
