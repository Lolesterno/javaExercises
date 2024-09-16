package gm.zona_fit.gui;

import gm.zona_fit.model.Client;
import gm.zona_fit.service.ClientService;
import gm.zona_fit.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@Component
public class ZonaFitForm extends JFrame{
    private JPanel RootPanel;
    private JTable clientsTable;
    private JTextField clientName;
    private JTextField lastnameField;
    private JTextField membresiaField;
    private JButton saveButton;
    private JButton deleteButton;
    private JButton clearButton;
    private DefaultTableModel tableModelClients;
    private Integer idClient;
    IClientService clientService;

    @Autowired
    public ZonaFitForm(ClientService clientService) {
        this.clientService = clientService;
        initForm();
        saveButton.addActionListener(e -> {
            saveClient();
        });
        clientsTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                clientSelected();
            }
        });
        deleteButton.addActionListener(e -> {
            deleteClient();
        });
        clearButton.addActionListener(e -> {
            clearForm();
        });
    }

    private void initForm() {
        setContentPane(RootPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 700);
        setLocationRelativeTo(null);
    }

    private void createUIComponents() {
        // Cabecera y creacion de la tabla
        // this.tableModelClients = new DefaultTableModel(0, 4);

        // Evitar editar desde la tabla
        this.tableModelClients = new DefaultTableModel(0, 4){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        String[] headers = { "id", "Nombre", "Apellido", "Membresia" };
        this.tableModelClients.setColumnIdentifiers(headers);
        this.clientsTable = new JTable(tableModelClients);

        // Solo se puede seleccionar uno
        this.clientsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Cargar el listado de clientes
        listClients();
    }

    private void listClients() {
        this.tableModelClients.setRowCount(0);
        var clients = this.clientService.getClients();
        clients.forEach(client -> {
            Object[] rowClient = {
                    client.getId(),
                    client.getName(),
                    client.getLastname(),
                    client.getMembresia()
            };
            this.tableModelClients.addRow(rowClient);
        });
    }

    private void saveClient() {
        if(clientName.getText().equals("")) {
            viewMessage("Ingresa un Nombre");
            clientName.requestFocusInWindow();
            return;
        }

        if(lastnameField.getText().equals("")){
            viewMessage("Ingresa un apellido");
            lastnameField.requestFocusInWindow();
            return;
        }

        if(membresiaField.getText().equals("")){
            viewMessage("Ingresa una membresia");
            membresiaField.requestFocusInWindow();
            return;
        }

        String name = clientName.getText();
        String lastname = lastnameField.getText();
        int membresia = Integer.parseInt(membresiaField.getText());

        Client client = new Client(this.idClient, name, lastname, membresia);

        this.clientService.saveClient(client);
        if(this.idClient == null) {
            viewMessage("Cliente Agregado correctamente");
        } else {
            viewMessage("Cliente actualizado correctamente");
        }

        clearForm();
        listClients();
    }

    private void clientSelected() {
        int row = clientsTable.getSelectedRow();
        if(row != -1) {
            String id = clientsTable.getModel().getValueAt(row, 0).toString();
            this.idClient = Integer.parseInt(id);
            String name = clientsTable.getModel().getValueAt(row, 1).toString();
            this.clientName.setText(name);
            String lastname = clientsTable.getModel().getValueAt(row, 2).toString();
            this.lastnameField.setText(lastname);
            String membresia = clientsTable.getModel().getValueAt(row, 3).toString();
            this.membresiaField.setText(membresia);
        }
    }

    private void deleteClient() {
        int row = clientsTable.getSelectedRow();
        if(row != -1) {
            String id = clientsTable.getModel().getValueAt(row, 0).toString();
            this.idClient = Integer.parseInt(id);
            Client client = new Client();
            client.setId(this.idClient);

            clientService.deleteClient(client);
            viewMessage("Cliente eliminado correctamente");
            clearForm();
            listClients();
        } else {
            viewMessage("Debe seleccionar un cliente para eliminar");
        }
    }

    private void clearForm() {
        clientName.setText("");
        lastnameField.setText("");
        membresiaField.setText("");

        this.idClient = null;
        this.clientsTable.getSelectionModel().clearSelection();
    }

    private void viewMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
