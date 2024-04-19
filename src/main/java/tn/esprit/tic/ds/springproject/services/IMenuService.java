package tn.esprit.tic.ds.springproject.services;

import org.springframework.stereotype.Service;
import tn.esprit.tic.ds.springproject.entities.*;

import java.util.List;
import java.util.Set;

@Service

public interface IMenuService {
    List<Menu> findByTypeMenuAndComposantsPrixGreaterThan(Enum typemenu , Float prix);
    List<Menu> retrieveAllMenus();
    Menu addMenu(Menu e);
    Menu updateMenu(Menu e);
    Menu retrieveMenu(Long idMenu);
    void removeMenu(Long idMenu);
    List<Menu> addMenus(List<Menu> Menus);
    ChefCuisinier affecterChefCuisinierAMenu(Long idChefCuisinier, Long idMenu);

    ChefCuisinier desaffecterChefCuisinierDuMenu(Long idMenu, Long idChef);

    List<String> nomMenuparTypeMenuOrdonneParTprixTotal(TypeMenu typeMenu);

    List<Menu> listeMenuSelonTypeMenuEtprixComposantsSuperieurAUnMontant(TypeMenu typeMenu, Float prixTotal);



}
