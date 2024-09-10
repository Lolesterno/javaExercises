package archives;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ReadFile {
    public static void main(String[] args) {
        // Leer el archivo
        String fileName = "miArchivo.txt";
        File file = new File(fileName);

        try {
            System.out.println("-- Contenido --");

            // Abrir el archivo
            BufferedReader in = new BufferedReader(new FileReader(file));
            // Leer 1 linea a linea el archivo
            String line = in.readLine();

            // Leer todas las lineas
            while (line != null) {
                System.out.println(line);
                // Movernos a la siguiente linea
                line = in.readLine();
            }

            // Cerrar archivo
            in.close();

        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e);
        }

    }
}
