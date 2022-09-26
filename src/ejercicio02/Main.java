package ejercicio02;

import ejercicio02.modelos.EstadoPartida;

import java.io.*;

public class Main {


    private static File ficherito;

    static {
        ficherito = new File("partida.bck");
    }

    public static void main(String[] args) {
        EstadoPartida partidita = new EstadoPartida(100, 7);
        try {
            guardarPartida(partidita);
            EstadoPartida pGuardada = recuperarPartida();
            System.out.println(pGuardada.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    static void guardarPartida(EstadoPartida partidita) throws IOException {
        File file = new File("partida.bck");
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(String.valueOf(partidita.getVidasRestantes()));
        bw.newLine();
        bw.write(String.valueOf(partidita.getPantallaActual()));
        bw.close();
        fw.close();
    }

    static EstadoPartida recuperarPartida() throws IOException {
        File file = new File("partida.bck");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        int vidasRestantes = Integer.parseInt(br.readLine());
        int pantallaActual = Integer.parseInt(br.readLine());
        br.close();
        fr.close();
        return new EstadoPartida(vidasRestantes, pantallaActual);
    }
}
