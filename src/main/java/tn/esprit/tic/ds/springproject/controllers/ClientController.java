package tn.esprit.tic.ds.springproject.controllers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tic.ds.springproject.entities.Client;
import tn.esprit.tic.ds.springproject.services.IClientService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/client")

public class ClientController {
    IClientService clientService;
    // http://localhost:8089/menu/client/retrieve-all-clients
    @GetMapping("/retrieve-all-clients")
    public List<Client> getClients() {
       return  clientService.retrieveAllClients();

    }
    // http://localhost:8089/menu/client/retrieve-client/8
    @GetMapping("/retrieve-client/{client-id}")
    public Client retrieveClient(@PathVariable("client-id") Long clientId) {
        return clientService.retrieveClient(clientId);
    }
    // http://localhost:8089/menu/client/add-client
    @PostMapping("/add-client")
    public Client addClient(@RequestBody Client c) {
        Client client = clientService.addClient(c);
        return client;
    }
    // http://localhost:8089/menu/client/remove-client/1
    @DeleteMapping("/remove-client/{client-id}")
    public void removeClient(@PathVariable("client-id") Long clientId) {
        clientService.removeClient(clientId);
    }
    // http://localhost:8089/menu/client/update-client
    @PutMapping("/update-client")
    public Client updateClient(@RequestBody Client c) {
        Client client= clientService.updateClient(c);
        return client;
    }
}