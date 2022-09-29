package ejercicio01_binario;

import java.io.*;
import java.text.NumberFormat;

public class Main {

    private static File registros;
    private static int cargos;
    private static int abonos;

    static {
        registros = new File("registros.dat");
        cargos = 0;
        abonos = 0;
    }

    public static void main(String[] args) {
        crearFicheroContable();
        int saldo = 0;
        saldo = leerRegistrosContables(saldo);
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        System.out.printf("Tu saldo es de %s%n",numberFormat.format(saldo));
        System.out.printf("Has tenido %d abonos%n", abonos);
        System.out.printf("Has tenido %d cargos%n", cargos);
    }

    private static int leerRegistrosContables(int saldo) {
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(registros);
            DataInputStream dis = new DataInputStream(fis);

            while (true) {
                int registro =  dis.readInt();
                saldo += registro;
                if (registro > 0)
                    abonos++;
                else
                    cargos++;
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        catch (EOFException eofException){

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return saldo;
    }

    private static void crearFicheroContable() {

        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(registros);
            DataOutputStream dos = new DataOutputStream(fos);
            for (int i = 0; i < 1000; i++) {
                int x = (int) (Math.random() * 1501);
                if (i % 2 == 0)
                    x *= -1;
                dos.writeInt(x);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


}
