package ejercicio02_objetos.modelos;

import java.io.Serializable;

public class Partida implements Serializable {

    private int vida;
    private int pantalla;

    public Partida(int vida, int pantalla) {
        this.vida = vida;
        this.pantalla = pantalla;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getPantalla() {
        return pantalla;
    }

    public void setPantalla(int pantalla) {
        this.pantalla = pantalla;
    }

    @Override
    public String toString() {
        return "Partida{" +
                "vida=" + vida +
                ", pantalla=" + pantalla +
                '}';
    }
}
