package zona_fit.data;

import zona_fit.connection.SqlConnection;
import zona_fit.domain.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static zona_fit.connection.SqlConnection.getConnection;

public class ClientDao implements IClientDao {

    @Override
    public List<Client> getClients() {
        List<Client> clients = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConnection();

        String sql = "SELECT * FROM client ORDER BY id";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Client client = new Client();
                client.setId(rs.getInt("id"));
                client.setName(rs.getString("name"));
                client.setLastname(rs.getString("lastname"));
                client.setMembresia(rs.getInt("membresia"));
                clients.add(client);
            }

        } catch (Exception e) {
            System.out.println("Error al obtener los clientes");
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexion de BD: " + e.getMessage());
            }
        }

        return clients;
    }

    @Override
    public boolean getClientById(Client client) {
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConnection();
        String sql = "SELECT  * FROM client WHERE id = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, client.getId());
            rs = ps.executeQuery();

            if (rs.next()) {
                client.setName(rs.getString("name"));
                client.setLastname(rs.getString("lastname"));
                client.setMembresia(rs.getInt("membresia"));
                return true;
            }

        } catch (Exception e) {
            System.out.println("Error al recuperar el cliente por el id: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexion de la BD");
            }
        }

        return false;
    }

    @Override
    public boolean createClient(Client client) {
        PreparedStatement ps;
        Connection con = getConnection();
        String sql = "INSERT INTO client (name, lastname, membresia)"
                    + " VALUES(?, ?, ?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, client.getName());
            ps.setString(2, client.getLastname());
            ps.setInt(3, client.getMembresia());
            ps.execute();

            return true;

        } catch (Exception e) {
            System.out.println("Error al agregar cliente: " +  e.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexion a la BD: " + e.getMessage());
            }
        }

        return false;
    }

    @Override
    public boolean updateClient(Client client) {
        PreparedStatement ps;
        Connection con = getConnection();
        String sql = "UPDATE client SET name=?, lastname=?, membresia=? " +
                "WHERE id = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, client.getName());
            ps.setString(2, client.getLastname());
            ps.setInt(3, client.getMembresia());
            ps.setInt(4, client.getId());
            ps.execute();

            return true;

        } catch (Exception e) {
            System.out.println("Error al actualizar el cliente: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexion a la BD: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean deleteClient(Client client) {
        PreparedStatement ps;
        Connection con = getConnection();
        String sql = "DELETE FROM client WHERE id = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, client.getId());
            ps.execute();
            return true;

        } catch (Exception e) {
            System.out.println("Error al eliminar el cliente: " +  e.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexion a la BD: " + e.getMessage());
            }
        }

        return false;
    }
}
