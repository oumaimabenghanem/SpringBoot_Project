package tn.esprit.tic.ds.springproject.repositories;

import tn.esprit.tic.ds.springproject.entities.Restaurant;

import java.util.Date;
import java.util.List;

public interface RestaurantRepository {

    //1.5. liste des restaurants ayant une capacité supérieur à 100 (paramètre)
    //et dont la chaine de restauration a été crée avant 2020 (paramètre)

    List<Restaurant> findByNbPlacesMaxGreaterThanAndChaineRestaurationDateCreationLessThan(Long max, Date date);
}
