package ejercicio02_objetos;

import ejercicio02_objetos.modelos.Partida;
import ejercicio02_objetos.streams.MyOOS;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        File partidas = new File("saved.dat");

        do{
            opcion = menu(scanner);
            switch (opcion){
                case 1:
                    crearPartida(scanner, partidas);
                    break;
                case 2:
                    mostrarPartidas(partidas);
                    break;
                case 3:
                    eliminarPartidas(scanner, partidas);
                    break;
                case 4:
                    System.out.println("Bye Bye...");
                    break;
            }
        }while (opcion != 4);



    }

    private static void eliminarPartidas(Scanner scanner, File partidas) {
        System.out.println("Seguro, seguuuurooooo, mira que no hay vuelta atrás (si/no)");
        String respuesta = scanner.nextLine()
                                    .toLowerCase()
                                    .trim();
        if (respuesta.equals("si")){
            if (partidas.delete()){
                System.out.println("A tomar por culo la copia");
            }
            else {
                System.out.println("El juego es .... y no se deja borrar");
            }
        }
        else {
            System.out.println("Buena elección.....");
        }
    }

    private static void mostrarPartidas(File partidas) {
        if (partidas.exists()) {
            try {
                FileInputStream inputStream = new FileInputStream(partidas);
                ObjectInputStream ois = new ObjectInputStream(inputStream);
                while (true) {
                    Partida p = (Partida) ois.readObject();
                    System.out.println(p.toString());
                }
            } catch (EOFException ex) { }
            catch (ClassNotFoundException | IOException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            System.out.println("No tengo partidas guardadas");
        }
    }

    private static void crearPartida(Scanner scanner, File partidas) {
        try{
            Partida partida = datosPartida(scanner);
            ObjectOutputStream oos;
            if (partidas.exists()){
               oos = new MyOOS(new FileOutputStream(partidas, true));
            }
            else {
                oos = new ObjectOutputStream(new FileOutputStream(partidas));
            }
            oos.writeObject(partida);

            oos.close();

        }catch (InputMismatchException ex){
            System.out.println("Error con los datos de la partida");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Partida datosPartida(Scanner scanner) throws InputMismatchException {
        System.out.println("Dime la vida");
        int vida = scanner.nextInt();
        System.out.println("Dime la pantalla en la que estás");
        int pantalla = scanner.nextInt();
        scanner.nextLine();
        return new Partida(vida, pantalla);
    }

    private static int menu(Scanner scanner) {
        int opcion;
        do {
            System.out.println("1- Guardar Partida");
            System.out.println("2- Mostrar Partidas");
            System.out.println("3- Eliminar Partidas");
            System.out.println("4- Salir");
            try {
                opcion = scanner.nextInt();
            }
            catch (InputMismatchException exception){
                opcion = 0;
                System.out.println("Eres bobo????");
                scanner.nextLine();
            }
        }while (opcion < 1 || opcion > 4);
        scanner.nextLine();
        return opcion;
    }
}
