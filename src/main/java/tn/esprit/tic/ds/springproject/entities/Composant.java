package tn.esprit.tic.ds.springproject.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Composant")
public class Composant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idComposant")
    private Long idComposant; // Clé primaire
    private String composant;
    private Float prix;
    @ManyToOne
    Menu menu;
    @OneToOne
    private DetailComposant detailComposant;

}
