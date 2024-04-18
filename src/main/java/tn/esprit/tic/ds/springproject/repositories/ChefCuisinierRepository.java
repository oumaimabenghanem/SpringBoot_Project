package tn.esprit.tic.ds.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tic.ds.springproject.entities.ChefCuisinier;

@Repository

public interface ChefCuisinierRepository extends JpaRepository<ChefCuisinier, Long> {
}
