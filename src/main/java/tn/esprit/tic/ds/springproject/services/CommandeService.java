package tn.esprit.tic.ds.springproject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tic.ds.springproject.entities.Client;
import tn.esprit.tic.ds.springproject.entities.Commande;
import tn.esprit.tic.ds.springproject.entities.Menu;
import tn.esprit.tic.ds.springproject.repositories.ClientRepository;
import tn.esprit.tic.ds.springproject.repositories.CommandeRepository;
import tn.esprit.tic.ds.springproject.repositories.MenuRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class CommandeService implements ICommandeService {
    private final CommandeRepository commandeRepository;
    private final ClientRepository clientRepository;
    private final MenuRepository menuRepository;
    @Override
    public List<Commande> findByClientId(Long idClient) {
        return commandeRepository.findByClientIdClient(idClient);
    }

    @Override
    public List<Commande> retrieveByClientIdAndDateCommande(Long idClient, LocalDate dateFrom, LocalDate dateTo) {
        return commandeRepository.findByClientIdClientAndDateCommandeBetween(idClient, dateFrom, dateTo);
    }

    @Override
    public List<Commande> retrieveByClientIdAndDateCommandeOrderByNoteAsc(Long idClient, LocalDate dateFrom, LocalDate dateTo) {
        return commandeRepository.findByClientIdClientAndDateCommandeBetweenOrderByNoteAsc(idClient, dateFrom, dateTo);
    }

    @Override
    public Commande retrieveCommande(Long idCommande) {
        return commandeRepository.findById(idCommande).orElse(null);
    }

    @Override
    public List<Commande> retrieveAllCommandes() {
        return commandeRepository.findAll();
    }

    @Override
    public Commande addCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    @Override
    public List<Commande> addCommandes(List<Commande> commandes) {
        return commandeRepository.saveAll(commandes);
    }

    @Override
    public Commande updateCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    @Override
    public void removeCommande(Long idCommande) {
        commandeRepository.deleteById(idCommande);
    }

    @Override
    public List<Commande> listeCommandesParClient(String identifiant) {
        return commandeRepository.findByClientIdentifiant(identifiant);
    }

    @Override
    public void ajouterCommandeEtaffecterAClientEtMenu(Commande commande, String identifiant, String libelleMenu) {
        Client c = clientRepository.findByIdentifiant(identifiant);
        Menu m = menuRepository.findByLibelleMenu(libelleMenu);
        commande.setClient(c);
        commande.setMenu(m);
        commande.setTotalRemise((m.getPrixTotal()*commande.getPourcentageRemise())/100);
        commande.setTotalCommande(m.getPrixTotal()*commande.getTotalRemise());
        commandeRepository.save(commande);
    }
}
