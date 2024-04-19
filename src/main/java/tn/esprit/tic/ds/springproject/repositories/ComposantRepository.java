package tn.esprit.tic.ds.springproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tic.ds.springproject.entities.Composant;
import tn.esprit.tic.ds.springproject.entities.Menu;
@Repository
public interface ComposantRepository extends /*JpaRepository*/ /*PagingAndSortingRepository*/ CrudRepository<Composant,Long> {
}
