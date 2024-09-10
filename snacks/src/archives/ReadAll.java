package archives;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReadAll {
    public static void main(String[] args) {
        String nameFile = "miArchivo.txt";

        try {
            // Leer todas las lineas del archivo
            List<String> lines = Files.readAllLines(Paths.get(nameFile));
            System.out.println("-- Contenido --");

            for(String line : lines) {
                System.out.println(line);
            }

        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e);
            e.printStackTrace();
        }
    }
}
