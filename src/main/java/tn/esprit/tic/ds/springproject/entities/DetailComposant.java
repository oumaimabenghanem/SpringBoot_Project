package tn.esprit.tic.ds.springproject.entities;

import jakarta.persistence.*;

import java.io.Serializable;
@Entity
@Table( name = "DetailComposant")

public class DetailComposant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idDetailComposant")
    private Long idDetailComposant; // Clé primaire
    private Float imc;
    @Enumerated(EnumType.STRING)

    private TypeComposant typeComposant;
}
