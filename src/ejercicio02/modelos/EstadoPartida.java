package ejercicio02.modelos;

public class EstadoPartida {

    private int vidasRestantes;
    private int pantallaActual;

    public EstadoPartida(int vidasRestantes, int pantallaActual) {
        this.vidasRestantes = vidasRestantes;
        this.pantallaActual = pantallaActual;
    }

    public int getVidasRestantes() {
        return vidasRestantes;
    }

    public void setVidasRestantes(int vidasRestantes) {
        this.vidasRestantes = vidasRestantes;
    }

    public int getPantallaActual() {
        return pantallaActual;
    }

    public void setPantallaActual(int pantallaActual) {
        this.pantallaActual = pantallaActual;
    }

    @Override
    public String toString() {
        return "EstadoPartida{" +
                "vidasRestantes=" + vidasRestantes +
                ", pantallaActual=" + pantallaActual +
                '}';
    }
}
