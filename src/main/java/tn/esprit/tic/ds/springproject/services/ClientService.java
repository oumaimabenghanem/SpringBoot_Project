package tn.esprit.tic.ds.springproject.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.tic.ds.springproject.entities.Client;
import tn.esprit.tic.ds.springproject.repositories.ClientRepository;

import java.util.Date;
import java.util.List;
@Service
@AllArgsConstructor
@Slf4j
public class ClientService implements IClientService{
    ClientRepository clientRepository;
    @Override
    public List<Client> retrieveAllClients() {
        return (List<Client>) clientRepository.findAll();
    }

    @Override
    public Client addClient(Client e) {
        return clientRepository.save(e);
    }

    @Override
    public Client updateClient(Client e) {
        System.out.println("Client "+e.getIdentifiant()+" ,Date premiere visite : "+e.getDatePremiereVisite());
        log.info("Client "+e.getIdentifiant()+" ,Date premiere visite : "+e.getDatePremiereVisite());
        return clientRepository.save(e);
    }

    @Override
    public Client retrieveClient(Long idClient) {
        return clientRepository.findById(idClient).orElse(null);
    }

    @Override
    public void removeClient(Long idClient) {
        clientRepository.deleteById(idClient);
    }

    @Override
    public List<Client> addClients(List<Client> Clients) {
        Client c = Client.builder().identifiant("Oumaima").datePremiereVisite(new Date(2024,04,04)).build();
        List<Client> client1 = (List<Client>) clientRepository.saveAll(Clients);
        return client1;
    }
}
