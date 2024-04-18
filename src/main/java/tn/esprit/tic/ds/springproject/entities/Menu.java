package tn.esprit.tic.ds.springproject.entities;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Menu")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Menu implements Serializable{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idMenu")
     Long idMenu; // Clé primaire
     String libelleMenu;
    @Enumerated(EnumType.STRING)

     TypeMenu typeMenu;
     Float prixTotal;
// Constructeur et accesseurs (getters) et mutateurs (setters)
    @OneToMany(mappedBy="menu")
     List<Commande> commandes;
    @OneToMany(mappedBy="menu")
     List<Composant> composants;
    @ManyToMany
     List<ChefCuisinier> chefCuisiniers;

}
