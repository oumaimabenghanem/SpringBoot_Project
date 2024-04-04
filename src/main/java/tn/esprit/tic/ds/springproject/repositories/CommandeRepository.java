package tn.esprit.tic.ds.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tic.ds.springproject.entities.Commande;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {
    //1.1 Liste des commandes d'un client
    List<Commande> findByClientIdClient(Long IdClient);

    //1.2  Liste des commandes d'un client dont la date commande entre deux dates
    List<Commande> findByClientIdClientAndDateCommandeBetween(Long IdClient, LocalDate dFrom, LocalDate dTo);

    //1.3 liste des commandes dont la date commande entre deux dates ordonné par note ordre croissant
    List<Commande> findByClientIdClientAndDateCommandeBetweenOrderByNoteAsc(Long idClient, LocalDate dateFrom, LocalDate dateTo);

    List<Commande> findByClientIdentifiant(String identifiant);

}
