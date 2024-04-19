package tn.esprit.tic.ds.springproject.services;

import org.springframework.stereotype.Service;
import tn.esprit.tic.ds.springproject.entities.*;

import java.util.Set;

@Service

public interface IComposant {
    Menu ajoutComposantsEtMiseAjourPrixMenu(Set<Composant> composants, Long idMenu);
}
