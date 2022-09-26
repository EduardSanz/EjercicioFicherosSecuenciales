package ejercicio01;

import javax.swing.text.NumberFormatter;
import java.io.*;
import java.text.NumberFormat;

public class Main {
    public static void main(String[] args) {
        double saldo = 0;
        int numCargos = 0, numAbonos = 0;

        File ficheroCargos = new File("listado.txt");
        try (FileReader isr = new FileReader(ficheroCargos)) {
            BufferedReader bf = new BufferedReader(isr);
            String linea;
            while ((linea = bf.readLine()) != null){
                double cargo = Double.parseDouble(linea);
                saldo += cargo;
                if (cargo > 0){
                    numAbonos++;
                }
                else {
                    numCargos++;
                }
            }

            NumberFormat nf = NumberFormat.getCurrencyInstance();
            System.out.printf("Tienes %s en cuenta, con %d cargo y %d abonos ", nf.format(saldo), numCargos, numAbonos);
            bf.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
