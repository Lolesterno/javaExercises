package archives;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CreateFile {
    public static void main(String[] args) {
        String nameArchive = "miArchivo.txt";
        File archive = new File(nameArchive);

        try {
            if(archive.exists()) {
                System.out.println("El archivo ya existe");
            } else {
                // Crear el archivo
                PrintWriter out = new PrintWriter(new FileWriter(archive));
                out.close(); // Guardar el archivo

                System.out.println("Archivo Creado correctamente");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e);
            e.printStackTrace();
        }
    }
}
