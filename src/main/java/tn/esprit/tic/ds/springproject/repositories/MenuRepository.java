package tn.esprit.tic.ds.springproject.repositories;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.tic.ds.springproject.entities.Client;
import tn.esprit.tic.ds.springproject.entities.Menu;
import tn.esprit.tic.ds.springproject.entities.TypeComposant;
import tn.esprit.tic.ds.springproject.entities.TypeMenu;


import java.util.List;
@Repository

public interface MenuRepository extends /*JpaRepository*/ /*PagingAndSortingRepository*/ CrudRepository<Menu,Long> {
    //1.4 liste des menus selon le type menu avec le prix  des composants est supérieur à un montant donné en paramètres
    List<Menu> findByTypeMenuAndComposantsPrixGreaterThan(Enum typemenu ,Float prix);
    //2.1 List nom Menu Par le type Menu Ordonne Par PrixTotal
    @Query("SELECT m.libelleMenu FROM Menu m WHERE m.typeMenu = :typeMenu ORDER BY m.prixTotal")
    List<String> findMenuLibelleMenuByTypeMenuOrderedByPriceTotal(@Param("typeMenu") TypeMenu typeMenu);
    //2.2 list Menu Par TypeComposant (exemple : les menus contenant de la viande blanche)
    @Query("SELECT m FROM Menu m JOIN m.composants c Join DetailComposant dc WHERE c.detailComposant.idDetailComposant = dc.idDetailComposant and dc.typeComposant = :typeComposant")
    List<Menu> findMenusByMenuDetailComposantTypeComposant(@Param("typeComposant") TypeComposant typeComposant);
    // 9.1 Afficher les noms des menus ordonnés par prix total
    @Query("SELECT m.libelleMenu FROM Menu m " +
            "Where m.typeMenu = :typeMenu " +
            "ORDER BY m.prixTotal")
    List<String> retrieveMenuLabelByTypeMenuOrderedByPrice(@Param("typeMenu") TypeMenu typeMenu);

    Menu findByLibelleMenu(String libelle);
}
