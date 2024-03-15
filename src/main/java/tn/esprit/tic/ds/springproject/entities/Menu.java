package tn.esprit.tic.ds.springproject.entities;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "Menu")
public class Menu implements Serializable{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idMenu")
    private Long idMenu; // Clé primaire
    private String libelleMenu;
    @Enumerated(EnumType.STRING)

    private TypeMenu typeMenu;
    private Float prixTotal;
// Constructeur et accesseurs (getters) et mutateurs (setters)
    @OneToMany(mappedBy="menu")
    private List<Commande> commandes;
    @OneToMany(mappedBy="menu")
    private List<Composant> composants;
    @ManyToMany
    private List<ChefCuisinier> chefCuisiniers;

}
