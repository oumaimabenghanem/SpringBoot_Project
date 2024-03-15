package tn.esprit.tic.ds.springproject.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tic.ds.springproject.entities.Client;
import tn.esprit.tic.ds.springproject.entities.Menu;
import tn.esprit.tic.ds.springproject.services.IMenuService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/menu")

public class MenuController {
    IMenuService menuService;
    @GetMapping("/findByTypeMenuAndComposants")
    public List<Menu> findByTypeMenuAndComposants(Enum typeMenu, Float prix) {
        List<Menu> listeMenus = menuService.findByTypeMenuAndComposantsPrixGreaterThan(typeMenu, prix);
        return  listeMenus;
    }
    @GetMapping("/retrieve-all-menus")
    public List<Menu> getMenus() {
        return  menuService.retrieveAllMenus();

    }
    @GetMapping("/retrieve-menu/{menu-id}")
    public Menu retrieveMenu(@PathVariable("menu-id") Long menuId) {
        return menuService.retrieveMenu(menuId);
    }
    @PostMapping("/add-menu")
    public Menu addClient(@RequestBody Menu m) {
        Menu menu = menuService.addMenu(m);
        return menu;
    }
    @DeleteMapping("/remove-menu/{menu-id}")
    public void removeMenu(@PathVariable("menu-id") Long menuId) {
        menuService.removeMenu(menuId);
    }
    @PutMapping("/update-menu")
    public Menu updateClient(@RequestBody Menu m) {
        Menu menu= menuService.updateMenu(m);
        return menu;
    }


}
