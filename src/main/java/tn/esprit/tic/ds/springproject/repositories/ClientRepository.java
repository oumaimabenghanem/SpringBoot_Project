package tn.esprit.tic.ds.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tic.ds.springproject.entities.Client;
import tn.esprit.tic.ds.springproject.entities.Commande;

import java.util.List;
@Repository
public interface ClientRepository extends /*JpaRepository*/ /*PagingAndSortingRepository*/ CrudRepository <Client,Long>
{ //le 1er param nom entity et le 2eme type de id


}
