package tn.esprit.tic.ds.springproject.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tic.ds.springproject.entities.Client;
import tn.esprit.tic.ds.springproject.entities.Menu;
import tn.esprit.tic.ds.springproject.entities.TypeMenu;
import tn.esprit.tic.ds.springproject.services.IMenuService;

import java.util.List;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@AllArgsConstructor
@RequestMapping("/menu")

public class MenuController {
    IMenuService menuService;

    // http://localhost:8089/menu/menu/add-menu
    @Operation(summary = "Add a menu")
    @PostMapping("/add-menu")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Menu successfully added"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    public Menu addMenu(
            @Parameter(description = "Menu object to add", required = true)
            @RequestBody Menu m) {
        return menuService.addMenu(m);
    }

    // http://localhost:8089/menu/menu/find-menus-by-type-menu-and-price/DINER/500
    @Operation(summary = "Find menus by type and price",
            description = "Find menus by type and price greater than a given value")
    @GetMapping("/find-menus-by-type-menu-and-price/{typeMenu}/{prixTotal}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved menus by type and price"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Menus not found")
    })
    public List<Menu> listeMenuSelonTypeMenuEtprixComposantsSuperieurAUnMontant(
            @Parameter(description = "Type of menu", required = true)
            @PathVariable("typeMenu") TypeMenu typeMenu,
            @Parameter(description = "Total price", required = true)
            @PathVariable("prixTotal") Float prixTotal) {
        return menuService.listeMenuSelonTypeMenuEtprixComposantsSuperieurAUnMontant(typeMenu, prixTotal);
    }

    @GetMapping("/retrieve-all-menus")
    public List<Menu> getMenus() {
        return  menuService.retrieveAllMenus();

    }
    @GetMapping("/retrieve-menu/{menu-id}")
    public Menu retrieveMenu(@PathVariable("menu-id") Long menuId) {
        return menuService.retrieveMenu(menuId);
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

    // http://localhost:8089/menu/menu/affecter-chef-cuisinier-a-menu/2/1
    @Operation(summary = "Assign a chef cuisinier to a menu")
    @GetMapping("/affecter-chef-cuisinier-a-menu/{idMenu}/{idChefCuisinier}/")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Chef cuisinier successfully assigned to menu"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Menu or chef not found")
    })
    public void affecterChefCuisinierAMenu(
            @Parameter(description = "ID of the chef cuisinier", required = true)
            @PathVariable("idChefCuisinier") Long idChefCuisinier,
            @Parameter(description = "ID of the menu", required = true)
            @PathVariable("idMenu") Long idMenu) {
        menuService.affecterChefCuisinierAMenu(idChefCuisinier, idMenu);
    }

    // http://localhost:8089/menu/menu/find-menu-labels-by-type-menu-ordered-by-price/DINER
    @Operation(summary = "Find menu labels by type ordered by price",
            description = "Find menu labels by type ordered by price")
    @GetMapping("/find-menu-labels-by-type-menu-ordered-by-price/{typeMenu}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved menu labels"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Menu labels not found")
    })
    public List<String> nomMenuparTypeMenuOrdonneParTprixTotal(
            @Parameter(description = "Type of menu", required = true)
            @PathVariable("typeMenu") TypeMenu typeMenu) {
        return menuService.nomMenuparTypeMenuOrdonneParTprixTotal(typeMenu);
    }



}
