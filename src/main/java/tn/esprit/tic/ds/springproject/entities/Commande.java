package tn.esprit.tic.ds.springproject.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
@Entity
@Table( name = "Commande")


public class Commande implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idCommande")
    private Long idCommande; // Clé primaire
    @Temporal(TemporalType.DATE)
    private Date dateCommande;

    private Integer pourcentageRemise;
    private Float totalRemise;
    private Float totalCommande;
    private Long note;
// Constructeur et accesseurs (getters) et mutateurs (setters)

}
