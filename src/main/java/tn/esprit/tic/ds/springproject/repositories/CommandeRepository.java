package tn.esprit.tic.ds.springproject.repositories;

import tn.esprit.tic.ds.springproject.entities.Commande;

import java.util.Date;
import java.util.List;

public interface CommandeRepository {
    //1.1 Liste des commandes d'un client
    List<Commande> findByClientIdClient(Long IdClient);

    //1.2  Liste des commandes d'un client dont la date commande entre deux dates
    List<Commande> findByClientIdClientAndDateCommandeBetween(Long IdClient, Date dFrom, Date dTo);

    //1.3 liste des commandes dont la date commande entre deux dates ordonné par note ordre croissant
    List<Commande> findByDateCommandeBetweenAndOrderByNoteAsc(Date dFrom, Date dTo);


}
