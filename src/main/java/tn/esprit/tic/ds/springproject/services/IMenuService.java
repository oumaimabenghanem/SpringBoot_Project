package tn.esprit.tic.ds.springproject.services;

import org.springframework.stereotype.Service;
import tn.esprit.tic.ds.springproject.entities.Client;
import tn.esprit.tic.ds.springproject.entities.Menu;

import java.util.List;

@Service

public interface IMenuService {
    List<Menu> findByTypeMenuAndComposantsPrixGreaterThan(Enum typemenu , Float prix);
    List<Menu> retrieveAllMenus();
    Menu addMenu(Menu e);
    Menu updateMenu(Menu e);
    Menu retrieveMenu(Long idMenu);
    void removeMenu(Long idMenu);
    List<Menu> addMenus(List<Menu> Menus);

}
