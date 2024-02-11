package tn.esprit.tic.ds.springproject.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;

@Entity
@Table( name = "Restaurant")


public class Restaurant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idRestaurant")
    private Long idRestaurant; // Clé primaire

    private String nom;
    private Long nbPlacesMax;
    @ManyToOne
    ChaineRestauration chaineRestauration;
    @OneToMany
    private ArrayList<Menu> menus;

}
