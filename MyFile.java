/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Archivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author Hp
 */
public class MyFile {

    private File myfile = null;

    void setFile(String direccion) {
        myfile = new File(direccion);
    }

    void info() {
        if (myfile.exists()) {
            System.out.println("\nNombre: " + myfile.getName());
            System.out.println("Path: " + myfile.getPath());
            System.out.println("Absoluta: " + myfile.getAbsolutePath());
            System.out.println("Bytes: " + myfile.length());
            System.out.println("Ultima Modificacion: " + new Date(myfile.lastModified()));
            System.out.println("Padre: " + myfile.getAbsoluteFile().getParentFile().getName());

            if (myfile.isFile()) {
                System.out.println("ES FILE");
            } else if (myfile.isDirectory()) {
                System.out.println("ES FOLDER");
            }
            System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-\n");

        } else { //myfile exist =false (No existe)
            System.out.println("No Existe");
        }
    }

    boolean crearFile() throws IOException {
        return myfile.createNewFile();
    }

    boolean crearFolder() {
        return myfile.mkdirs();
    }

    void borrar() {
        if (antidoto(myfile)) {
            System.out.println("Borrado");
        } else {
            System.out.println("No se pudo Borrar");
        }

    }

    boolean antidoto(File mf) { //borrar recursividad
        if (mf.isDirectory()) {
            for (File child : mf.listFiles()) {
                antidoto(child);
            }
        }
        return mf.delete();
    }

    void dir() {
        if (myfile.isDirectory()) {
            System.out.println("Directorio de: " + myfile.getAbsolutePath());
            System.out.println("");
            //Contadores
            int cfiles = 0, cdirs = 0, tbytes = 0;
            //recorrido
            for (File child : myfile.listFiles()) {
                if (!child.isHidden()) {
                    //Ultima modificacion
                    Date ultimo = new Date(child.lastModified());
                    System.out.print(ultimo + "\t");
                    //Si es File o Folder
                    if (child.isDirectory()) {
                        cdirs++;
                        System.out.print("<DIR>\t\t");
                    } else {
                        cfiles++;
                        tbytes += child.length();
                        System.out.print("    \t" + child.length() + "\t");
                    }
                    //mostrar objetos
                    System.out.println(child.getName());
                }
            }
            System.out.println(cfiles + " archivos\t" + tbytes + " bytes");
            System.out.println(cdirs + " dirs\t");
        }
    }

    private void tree(File dir, String tab) {
        if (dir.isDirectory()) {
            System.out.println(tab + dir.getName());
            for (File child : dir.listFiles()) { //Aqui Cambie la funcion pq lo anterior me produjo StackOverFlow -- cambiado myfile.list por dir.list
                if (!child.isHidden()) {
                    tree(child, tab + "--");
                }
            }
        }
    }

    void tree() {
        tree(myfile, "-");
    }
    
    public void AddContenido(String texto) {
        try (FileWriter writer = new FileWriter(myfile, true);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            bufferedWriter.write(" "+texto);
            System.out.println("Texto añadido al archivo.");
        } catch (IOException e) {
            System.out.println("Error al añadir contenido al archivo: " + e.getMessage());
        }
    }
    
    public void Reescribir(String texto) {
        try (FileWriter writer = new FileWriter(myfile, false);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            bufferedWriter.write(texto);
            System.out.println("Contenido del archivo reescrito.");
        } catch (IOException e) {
            System.out.println("Error al reescribir el archivo: " + e.getMessage());
        }
    }
    
    //Leer
    public void LeerFileReader() { //Version 1
        try (FileReader reader = new FileReader(myfile)) {
            int caracter;
            System.out.println("\nMostrando contenido con FileReader:\n");
            while ((caracter = reader.read()) != -1) {
                System.out.print((char) caracter);
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("FileReader Error: " + e.getMessage());
        }
    }
    
        public void LeerBufferedReader() { //Version 2
        try (BufferedReader reader = new BufferedReader(new FileReader(myfile))) {
            String linea;
            System.out.println("\nMostrando contenido con BufferedReader:\n");
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("BufferedReader Error: " + e.getMessage());
        }
    }
        
}