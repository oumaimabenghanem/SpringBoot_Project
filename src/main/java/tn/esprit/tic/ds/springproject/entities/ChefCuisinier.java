package tn.esprit.tic.ds.springproject.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;

@Entity
@Table( name = "ChefCuisinier")

public class ChefCuisinier implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idChefCuisinier")
    private Long idChefCuisinier; // Clé primaire
    private String nom;
    private String prenom;
    @Enumerated(EnumType.STRING)

    private TypeChef typeChef;
    @ManyToMany(mappedBy="chefCuisiniers", cascade = CascadeType.ALL)
    private ArrayList<Menu> menus;

}
