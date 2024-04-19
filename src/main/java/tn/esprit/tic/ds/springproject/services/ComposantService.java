package tn.esprit.tic.ds.springproject.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.tic.ds.springproject.entities.Composant;
import tn.esprit.tic.ds.springproject.entities.Menu;
import tn.esprit.tic.ds.springproject.repositories.ComposantRepository;
import tn.esprit.tic.ds.springproject.repositories.MenuRepository;

import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j

public class ComposantService implements IComposant{
    private final MenuRepository menuRepository;
    private final ComposantRepository composantRepository;


    @Override
    public Menu ajoutComposantsEtMiseAjourPrixMenu(Set<Composant> composants, Long idMenu) {
        //Set<Composant> s = new HashSet<Composant>();
        Menu menu = menuRepository.findById(idMenu).orElse(null);
        if (menu == null) {
            return null;
        }else{
            float prixtot = 0;
            for(Composant composant : composants){
                composant.setMenu(menu);
                prixtot+=composant.getPrix();
            }
            if(prixtot<=20) {
                menu.setPrixTotal(prixtot);
                composantRepository.saveAll(composants);
                menuRepository.save(menu);
            }
            else{
                log.error("Prix total dépasse 20 dinars");
            }
        }
        return menuRepository.findById(idMenu).get();

    }
//    @Override
//    public Menu ajoutComposantsEtMiseAjourPrixMenu(Set<Composant> composants, Long idMenu) {
//        Menu menu = menuRepository.findById(idMenu)
//                .orElseThrow(() -> new IllegalArgumentException("Menu not found with id: " + idMenu));
//
//        composants.forEach(c -> c.setMenu(menu));
//
//        Float prixTotal = composants.stream()
//                .map(Composant::getPrix)
//                .reduce(0f, Float::sum);
//
//        if (prixTotal > 20f) {
//            String errorMessage = "Le prix total du menu ne doit pas dépasser 20 dinars";
//            log.error(errorMessage);
//            throw new RuntimeException(errorMessage);
//        }
//
//        menu.setPrixTotal(prixTotal);
//
//        composantRepository.saveAll(composants);
//        menuRepository.save(menu);
//
//        return menu;
//    }
}
