package ejercicio02_binario;

import ejercicio02.modelos.EstadoPartida;

import java.io.*;

public class Main {

    private static File backUp;

    static {
        backUp = new File("estado_partida.dat");
    }

    public static void main(String[] args) {
        EstadoPartida estadoPartida = new EstadoPartida(10, 4);

        guardarPartida(estadoPartida);
        EstadoPartida partidaRecuperada = recuperarPartida();

        if (partidaRecuperada != null) {

        }
    }

    private static EstadoPartida recuperarPartida() {
        FileInputStream fis;
        try {
            fis = new FileInputStream(backUp);
            DataInputStream dis = new DataInputStream(fis);
            return new EstadoPartida(dis.readInt(), dis.readInt());
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
        return null;
    }

    private static void guardarPartida(EstadoPartida estadoPartida) {
        FileOutputStream fos;

        try {
            fos = new FileOutputStream(backUp);
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeInt(estadoPartida.getVidasRestantes());
            dos.writeInt(estadoPartida.getPantallaActual());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
