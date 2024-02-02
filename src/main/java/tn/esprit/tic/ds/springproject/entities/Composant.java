package tn.esprit.tic.ds.springproject.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table( name = "Composant")

public class Composant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idComposant")
    private Long idComposant; // Clé primaire
    private String composant;
    private Float prix;

}
