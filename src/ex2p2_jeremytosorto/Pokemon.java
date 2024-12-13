/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex2p2_jeremytosorto;

/**
 *
 * @author DELL
 */
public class Pokemon {
    private String nombre, tipo;
    private int nivel;
    private double ataque, defensa, catchRate, vida;

    public Pokemon(String nombre, String tipo, double ataque, double defensa, double catchRate, double vida) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.ataque = ataque;
        this.defensa = defensa;
        this.catchRate = catchRate;
        this.vida = vida;
        this.nivel=1;
    }

    public double getVida() {
        return vida;
    }

    public void setVida(double vida) {
        this.vida = vida;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public double getAtaque() {
        return ataque;
    }

    public void setAtaque(double ataque) {
        this.ataque = ataque;
    }

    public double getDefensa() {
        return defensa;
    }

    public void setDefensa(double defensa) {
        this.defensa = defensa;
    }

    public double getCatchRate() {
        return catchRate;
    }

    public void setCatchRate(double catchRate) {
        this.catchRate = catchRate;
    }

    @Override
    public String toString() {
        return "nombre= " + nombre + "\ntipo= " + tipo + "\nnivel= " + nivel + "\nataque= " + ataque + "\ndefensa= " + defensa + "\ncatchRate= " + catchRate + "\nvida= " + vida;
    }
    
    
}
