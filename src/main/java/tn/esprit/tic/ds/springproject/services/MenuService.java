package tn.esprit.tic.ds.springproject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tic.ds.springproject.entities.Client;
import tn.esprit.tic.ds.springproject.entities.Menu;
import tn.esprit.tic.ds.springproject.repositories.MenuRepository;

import java.util.List;

@Service
@AllArgsConstructor

public class MenuService implements IMenuService{
    MenuRepository menuRepository;
    @Override
    public List<Menu> findByTypeMenuAndComposantsPrixGreaterThan(Enum typemenu, Float prix) {
        return menuRepository.findByTypeMenuAndComposantsPrixGreaterThan(typemenu,prix);
    }

    @Override
    public List<Menu> retrieveAllMenus() {
        return (List<Menu>) menuRepository.findAll();
    }

    @Override
    public Menu addMenu(Menu e) {
        return menuRepository.save(e);
    }

    @Override
    public Menu updateMenu(Menu e) {
        return menuRepository.save(e);
    }

    @Override
    public Menu retrieveMenu(Long idMenu) {
        return menuRepository.findById(idMenu).orElse(null);
    }

    @Override
    public void removeMenu(Long idMenu) {
        menuRepository.deleteById(idMenu);
    }

    @Override
    public List<Menu> addMenus(List<Menu> Menus) {
        return (List<Menu>) menuRepository.saveAll(Menus);
    }
}
