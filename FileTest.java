/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Archivos;

import java.util.Scanner;
import java.io.IOException;
import java.util.InputMismatchException;

/**
 *
 * @author Hp
 */
public class FileTest {

    public static MyFile files = new MyFile();

    public static void main(String[] args) {
        int Menu = 0;
        String Direccion = "";
        Scanner lea = new Scanner(System.in);

        do {
            System.out.println("|-------------------------|");
            System.out.println("| 1- Set Archivo /Folder  |");
            System.out.println("| 2- Ver informacion      |");
            System.out.println("| 3- Crear File           |");
            System.out.println("| 4- Crear Folder         |");
            System.out.println("| 5- Borrar               |");
            System.out.println("| 6- Dir                  |");
            System.out.println("| 7- Tree                 |");
            System.out.println("| 8- Escribir en archivo  |");
            System.out.println("| 9- Leer archivo         |");
            System.out.println("| 10- Salir               |");
            System.out.println("|-------------------------|");

            try {
                System.out.println("\nIngrese una Opcion acorde al Menu");
                Menu = lea.nextInt();
                lea.nextLine();  // Limpiar el buffer

                if (Menu == 1) { //Set File
                    System.out.println("Ingrese la Direccion de su File");
                    Direccion = lea.next();
                    files.setFile(Direccion);

                } else if (Menu == 2) { //Info
                    files.info();

                } else if (Menu == 3) { //Archivo (.txt, .pdf, .word....)
                    if (files.crearFile()) {
                        System.out.println("Archivo se ha creado");
                    } else {
                        System.out.println("No se creo el Archivo");
                    }

                } else if (Menu == 4) { //Foler
                    if (files.crearFolder()) {
                        System.out.println("Folder se ha creado");
                    } else {
                        System.out.println("No se Creo el Folder");
                    }

                } else if (Menu == 5) { //Borrar
                    files.borrar();

                } else if (Menu == 6) { //Dir
                    files.dir();

                } else if (Menu == 7) {// Tree
                    files.tree();

                } else if (Menu == 10) {
                    System.out.println("Saliendo del programa.");

                } else if (Menu == 8) { // Escribir
                    int MenuEs = 0;
                    System.out.println("");
                    System.out.println("|      **Seleccione una Opcion**     |");
                    System.out.println("| 1- Añadir Contenido a lo Existente |");
                    System.out.println("| 2- Reescribir el Contenido Actual  |");
                    System.out.println("\nElija una Opcion Acorde al Menu");
                    MenuEs = lea.nextInt();
                    lea.nextLine();

                    System.out.println("\nIngrese el Texto que desea añadir o Reescribir");
                    String Texto = lea.nextLine();
                    if (MenuEs == 1) {
                        files.AddContenido(Texto);
                        System.out.println("");
                    } else if (MenuEs == 2) {
                        files.Reescribir(Texto);
                        System.out.println("");
                    }

                } else if (Menu == 9) { // Leer
                    int MenuL = 0;
                    System.out.println("");
                    System.out.println("|  **Seleccione una Opcion**  |");
                    System.out.println("| 1- Leer con FileReader      |");
                    System.out.println("| 2- Leer con BufferedReader  |");
                    System.out.println("\nElija una Opcion Acorde al Menu");
                    MenuL = lea.nextInt();
                    lea.nextLine();
                    if (MenuL == 1) {
                        files.LeerFileReader();
                        System.out.println("");
                    } else if (MenuL == 2) {
                        files.LeerBufferedReader();
                        System.out.println("");
                    }
                }

            } catch (InputMismatchException e) {
                System.out.println("Indique una opcion Valida Acorde al Menu");
                lea.nextLine();

            } catch (NullPointerException e) {
                System.out.println("Porfavor seleccione la opcion 1");

            } catch (IOException e) {
                System.out.println("Error" + e.getMessage());
            }

        } while (Menu != 10);
    }
}
