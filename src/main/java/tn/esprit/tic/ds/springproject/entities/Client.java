package tn.esprit.tic.ds.springproject.entities;
import java.io.Serializable;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;

import java.io.Serializable;

@Entity
@Table( name = "Client")

public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idClient")
    private Long idClient; // Clé primaire
    private String identifiant;
    @Temporal(TemporalType.DATE)
    private Date datePremiereVisite;
// Constructeur et accesseurs (getters) et mutateurs (setters)
    @OneToMany(mappedBy="client")
    private ArrayList<Commande> commandes;

}
