package tn.esprit.tic.ds.springproject.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table( name = "ChaineRestauration")

public class ChaineRestauration implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idChaineRestauration")
    private Long idChaineRestauration; // Clé primaire

    private String libelle;
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    @OneToMany(mappedBy="chaineRestauration")
    private List<Restaurant> restaurants;
}
