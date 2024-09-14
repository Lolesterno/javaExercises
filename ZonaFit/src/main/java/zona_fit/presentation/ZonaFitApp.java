package zona_fit.presentation;

import zona_fit.data.ClientDao;
import zona_fit.data.IClientDao;
import zona_fit.domain.Client;

import java.util.List;
import java.util.Scanner;

public class ZonaFitApp {
    public static void main(String[] args) {
        zonaFitApp();
    }

    private static void zonaFitApp() {
        boolean exit = false;
        Scanner console = new Scanner(System.in);
        IClientDao clientDao = new ClientDao();

        while (!exit) {
            try {
                int option = viewMenu(console);
                exit = execOptions(console, option, clientDao);
            } catch (Exception e) {
                System.out.println("Error general al ejecutar las opciones: " + e.getMessage());
            }
            System.out.println();
        }
    }

    private static int viewMenu(Scanner console) {
        System.out.print("""
                ** Bienvenidos a Zona Fit Clientes
                1. Listar Clientes
                2. Buscar Cliente
                3. Agregar Cliente
                4. Actualizar Cliente
                5. Eliminar Cliente
                6. Salir
                """);
        System.out.print("Escoje una opcion: ");
        return Integer.parseInt(console.nextLine());
    }

    private static boolean execOptions(Scanner console, int option, IClientDao clientDao) {
        boolean exit = false;
        switch (option) {
            case 1 -> {
                System.out.println("--- Clientes --- ");
                List<Client> clients = clientDao.getClients();
                clients.forEach(System.out::println);
            }
            case 2 -> {
                System.out.print("Introduce el id del cliente a buscar:");
                int idClient = Integer.parseInt(console.nextLine());
                Client client = new Client(idClient);

                boolean find = clientDao.getClientById(client);
                if (find) {
                    System.out.println("Cliente encontrado: " + client);
                } else {
                    System.out.println("No se encontraron registros...");
                }
            }

            case 3 -> {
                System.out.println("-- Agregando nuevo cliente --");
                System.out.print("Introduce el nombre del nuevo cliente: ");
                String name = console.nextLine();
                System.out.print("Introduce el apellido del cliente: ");
                String lasname = console.nextLine();
                System.out.print("Introduce el valor de la membresia del usuario: ");
                int membresia = Integer.parseInt(console.nextLine());

                Client client = new Client(name, lasname, membresia);
                boolean addClient = clientDao.createClient(client);

                if (addClient) {
                    System.out.println("Cliente creado correctamente ..." + client);

                } else {
                    System.out.println("Cliente no agregado ...");
                }

            }

            case 4 -> {
                System.out.println("--Modificando el cliente --");
                System.out.print("Introduce el id del cliente a modificar: ");
                int idClient = Integer.parseInt(console.nextLine());
                System.out.print("Nuevo nombre: ");
                String name = console.nextLine();
                System.out.print("Nuevo apellido: ");
                String lastname = console.nextLine();
                System.out.print("Modifique su membresia: ");
                int membresia = Integer.parseInt(console.nextLine());

                Client client = new Client(idClient, name, lastname, membresia);
                boolean modify = clientDao.updateClient(client);

                if (modify) {
                    System.out.println("Cliente modificado :)");
                } else {
                    System.out.println("Hubo un error al modificar el cliente: " + client);
                }

            }

            case 5 -> {
                System.out.println("-- Eliminando Clientes --");
                System.out.print("Introduce el id del cliente a eliminar: ");
                int idClient = Integer.parseInt(console.nextLine());

                Client client = new Client(idClient);
                boolean deleteClient = clientDao.deleteClient(client);

                if(deleteClient) {
                    System.out.println("Cliente eliminado de la base de datos Correctamente");
                } else {
                    System.out.println("Cliente no existe :>)");
                }
            }

            case 6 -> {
                System.out.println("Adios :)");
                exit = true;
            }

            default -> System.out.println("Opcion no valida");
        }

        return exit;
    }

}
