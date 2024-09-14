package gm.zona_fit;

import gm.zona_fit.model.Client;
import gm.zona_fit.service.IClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class ZonaFitApplication implements CommandLineRunner {

    @Autowired
    private IClientService clientService;

    private static final Logger logger = LoggerFactory.getLogger(ZonaFitApplication.class);
    String ln = System.lineSeparator();

    public static void main(String[] args) {
        logger.info("Iniciando App ...");

        // Levanta el factory de Spring
        SpringApplication.run(ZonaFitApplication.class, args);

        logger.info("Aplicacion Finalizada ...");
    }

    @Override
    public void run(String... args) throws Exception {
        zonaFitApp();
    }

    private void zonaFitApp() {
        boolean exit = false;
        Scanner console = new Scanner(System.in);

        while (!exit) {
            int option = viewMenu(console);
            exit = execOptions(console, option);
        }
    }

    private int viewMenu(Scanner console) {
        logger.info("""
                \n** Bienvenidos a Zona Fit Clientes
                1. Listar Clientes
                2. Buscar Cliente
                3. Agregar Cliente
                4. Actualizar Cliente
                5. Eliminar Cliente
                6. Salir
                Escoje una opcion: \s
                """);
        int option = Integer.parseInt(console.nextLine());
        return option;
    }

    private boolean execOptions(Scanner console, int option) {
        boolean exit = false;
        switch (option) {
            case 1 -> {
                logger.info(ln + "Listado de clientes: " + ln);
                List<Client> clients = clientService.getClients();
                clients.forEach(client -> logger.info(client.toString() + ln));
            }

            case 2 -> {
                logger.info(ln + "Introduce el id del usuario a buscar: " + ln);
                int idClient = Integer.parseInt(console.nextLine());
                Client client = clientService.findClientById(idClient);

                if(client != null) {
                    logger.info("Cliente encontrado: " + client);
                } else {
                    logger.info("Sin registros ...");
                }
            }

            case 3 -> {
                logger.info(ln + "Agregar nuevo Cliente" + ln);
                logger.info("Nombre: ");
                String name = console.nextLine();
                logger.info("Apellido: ");
                String lastname = console.nextLine();
                logger.info("Membresia: ");
                int membresia = Integer.parseInt(console.nextLine());

                Client client = new Client();
                client.setName(name);
                client.setLastname(lastname);
                client.setMembresia(membresia);

                clientService.saveClient(client);
                logger.info("Cliente Agregado correctamente: " + client + ln);
            }

            case 4 -> {
                logger.info(ln + "Actualizar usuario" + ln);
                logger.info(ln + "Escribe el id del usuario a Actualizar" +ln);
                int idClient = Integer.parseInt(console.nextLine());

                Client client = clientService.findClientById(idClient);

                if(client != null) {
                    logger.info("Nombre: ");
                    String name = console.nextLine();
                    logger.info("Apellido: ");
                    String lastname = console.nextLine();
                    logger.info("Membresia");
                    Integer membresia = Integer.parseInt(console.nextLine());


                    client.setName(name);
                    client.setLastname(lastname);
                    client.setMembresia(membresia);

                    clientService.saveClient(client);
                    logger.info("Cliente Actualizado: " + client);
                }
            }

            case 5 -> {
                logger.info(ln + "Eliminar un Cliente" + ln);
                logger.info("Ingrese el id del cliente a borrar: ");
                int idClient = Integer.parseInt(console.nextLine());

                Client client = clientService.findClientById(idClient);
                if(client != null) {
                    clientService.deleteClient(client);

                    logger.info("Cliente eliminado correctamente");
                }

            }

            case 6 -> {
                logger.info("Adios! :)");
                exit = true;
            }
        }

        return exit;
    }
}
