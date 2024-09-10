package archives;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class addContentFile {
    public static void main(String[] args) {
        boolean anex = false;
        String nameFile = "miArchivo.txt";

        File file = new File(nameFile);
        try{
            // Existe el archivo
            anex = file.exists();
            PrintWriter out = new PrintWriter(new FileWriter(file, anex));
            String newContent = "Nuevo\nContenido";
            out.println(newContent);
            out.close();

            System.out.println("Contenido agregado...");

        } catch (Exception e) {
            System.out.println("Error: " + e);
            e.printStackTrace();
        }
    }
}
