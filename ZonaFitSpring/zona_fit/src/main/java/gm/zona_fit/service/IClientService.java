package gm.zona_fit.service;

import gm.zona_fit.model.Client;

import java.util.List;

public interface IClientService {
    public List<Client> getClients();

    public Client findClientById(Integer idClient);

    public void saveClient(Client client);

    public void deleteClient(Client client);
}
