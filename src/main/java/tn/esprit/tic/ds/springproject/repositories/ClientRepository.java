package tn.esprit.tic.ds.springproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tic.ds.springproject.entities.Client;


@Repository
public interface ClientRepository extends /*JpaRepository*/ /*PagingAndSortingRepository*/ CrudRepository <Client,Long>
{ //le 1er param nom entity et le 2eme type de id
    Client findByIdentifiant(String identifiant);

}
