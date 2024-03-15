package tn.esprit.tic.ds.springproject.services;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service

public interface ICommande {
    List<Commande> findByClientId(Long idClient);

    List<Commande> retrieveByClientIdAndDateCommande(Long idClient, LocalDate dateFrom, LocalDate dateTo);

    List<Commande> retrieveByClientIdAndDateCommandeOrderByNoteAsc(Long idClient, LocalDate dateFrom, LocalDate dateTo);

    Commande retrieveCommande(Long idCommande);

    List<Commande> retrieveAllCommandes();

    Commande addCommande(Commande commande);

    List<Commande> addCommandes(List<Commande> commandes);

    Commande updateCommande(Commande commande);

    void removeCommande(Long idCommande);

    List<Commande> listeCommandesParClient(String identifiant);

}
