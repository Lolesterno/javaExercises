package snack_project.presentation;

import snack_project.domain.Snack;
import snack_project.service.IsSnacks;
import snack_project.service.ServiceSnacksFile;
import snack_project.service.ServiceSnacksList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MachineSnack {
    public static void main(String[] args) {
        machineSnacks();
    }

    public static void machineSnacks() {
        var exit = false;
        Scanner console = new Scanner(System.in);
        // Object Servicio Snacks
        //IsSnacks serviceSnacks = new ServiceSnacksList();
        IsSnacks serviceSnacks = new ServiceSnacksFile();

        // Menu
        List<Snack> products = new ArrayList<>();
        System.out.println("--- Bienvenido a Snacks Inc. ---");
        serviceSnacks.viewSnacks();

        while (!exit) {
            try {
                var option = sendMenu(console);
                exit = execOptions(option, console, products, serviceSnacks);

            }catch (Exception e) {
                System.out.println("Error: " + e);
            } finally {
                System.out.println();
            }
        }
    }

    private static int sendMenu(Scanner console) {
        System.out.print("""
                Menu: 
                1. Comprar Snack
                2. Mostrar Compra
                3. Agregar nuevo Snack
                4. Salir
                Elige una opcion: \s""");
        // Leer la opcion seleccionada y retornamos
        return Integer.parseInt(console.nextLine());
    }

    private static boolean execOptions(int option, Scanner console, List<Snack> products, IsSnacks serviceSnacks) {
        boolean exit = false;

        switch (option){
            case 1 -> buySnack(console, products, serviceSnacks);

            case 2 -> viewTicket(products);

            case 3 -> addSnack(console, serviceSnacks);

            case 4 -> exit = true;

            default -> System.out.println("Opcion invalida: "+ option);

        }

        return exit;
    }

    private static void buySnack(Scanner console, List<Snack> products, IsSnacks serviceSnacks) {
        System.out.print("Elige un snack (id): ");
        int idSnack = Integer.parseInt(console.nextLine());

        boolean snackFound = false;
        for (var snack: serviceSnacks.getSnacks()) {
            if(idSnack == snack.getIdSnack()) {
                // Agregamos el Snack
                products.add(snack);
                System.out.println("Item agregado Correctamente " + snack);
                snackFound = true;
                break;
            }
        }
        if(!snackFound) {
            System.out.println("No se encontro el item indicado: " + idSnack);
        }
    }

    private static void viewTicket(List<Snack> products) {
        String ticket = "*** Factura de venta *** ";
        double total = 0.0;

        for(var product: products) {
            ticket += "\n\t-" + product.getName() + " - $" + product.getPrice();
            total += product.getPrice();
        }

        ticket += "\n\tTotal -> $" + total;
        System.out.println(ticket);
    }

    private static void addSnack(Scanner console, IsSnacks serviceSnacks) {
        System.out.print("Nombre del nuevo producto: ");
        String name = console.nextLine();
        System.out.print("Precio: ");
        double price = Double.parseDouble(console.nextLine());

        serviceSnacks.addSnack(new Snack(name, price));

        System.out.println("Snack agregado correctamente!");
        serviceSnacks.viewSnacks();
    }

}
