package tn.esprit.tic.ds.springproject.repositories;
import tn.esprit.tic.ds.springproject.entities.Menu;


import java.util.List;

public interface MenuRepository {
    //1.4 liste des menus selon le type menu avec le prix  des composants est supérieur à un montant donné en paramètres
    List<Menu> findByTypeMenuAndComposantsPrixGreaterThan(Enum typemenu ,Float prix);
}
