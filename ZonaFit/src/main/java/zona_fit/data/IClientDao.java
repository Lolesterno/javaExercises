package zona_fit.data;

import zona_fit.domain.Client;

import java.util.List;

public interface IClientDao {
    List<Client> getClients();

    boolean getClientById(Client client);

    boolean createClient(Client client);

    boolean updateClient(Client client);

    boolean deleteClient(Client client);
}
