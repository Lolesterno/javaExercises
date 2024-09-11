package snack_project.service;

import snack_project.domain.Snack;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ServiceSnacksFile implements IsSnacks {
    private final String FILE_NAME = "snacks.txt";
    // Lista de Snacks
    private List<Snack> snacks = new ArrayList<>();

    public ServiceSnacksFile() {
        // Crear el archivo
        File file = new File(FILE_NAME);
        boolean exist = false;

        try {
            exist = file.exists();
            if (exist) {
                this.snacks = getSnacksArray();
            } else {
                PrintWriter output = new PrintWriter(new FileWriter(file));
                output.close();

                System.out.println("Archivo creado correctamente");
            }
        } catch (Exception e) {
            System.out.println("Error al generar el archivo " + e);
        }

        // Si no existe el archivo, se cargan Datos iniciales
        if (!exist) {
            fisrtData();
        }

    }

    private void fisrtData() {
        this.addSnack(new Snack("Papas Fritas", 2500));
        this.addSnack(new Snack("Coca Cola", 3500));
        this.addSnack(new Snack("Galletas", 1500));
    }

    private List<Snack> getSnacksArray() {
        List<Snack> snacks = new ArrayList();
        try {
            List<String> lines = Files.readAllLines(Paths.get(FILE_NAME));
            for (String line: lines) {
                String[] elements = line.split(",");
                var idSnack = elements[0];
                String name = elements[1];
                String price = elements[2];

                Snack snack = new Snack(name, Double.parseDouble(price));
                snacks.add(snack);
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo " + e);
            e.printStackTrace();
        }

        return snacks;
    }

    @Override
    public void addSnack(Snack snack) {
        // Agregar el nuevo Snack, 1. Lista en memoria
        this.snacks.add(snack);
        // 2. Guardar en el archivo
        this.addFileSnack(snack);
    }

    private void addFileSnack(Snack snack) {
        boolean anex = false;
        File file = new File(FILE_NAME);

        try {
            anex = file.exists();
            PrintWriter output = new PrintWriter(new FileWriter(file, anex));
            output.println(snack.writeSnack());
            output.close();

        } catch (Exception e) {
            System.out.println("Error al agregar el archivo: " + e);
        }
    }

    @Override
    public void viewSnacks() {
        System.out.println(" --- Inventario --- ");
        var snackInventory = "";
        for(var snack:snacks){
            System.out.println(snack);
        }
    }

    @Override
    public List<Snack> getSnacks() {
        return this.snacks;
    }
}
