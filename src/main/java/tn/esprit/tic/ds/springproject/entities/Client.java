package tn.esprit.tic.ds.springproject.entities;
import java.io.Serializable;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.Date;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table( name = "Client")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@RequiredArgsConstructor //les attributs non nulls
//@ToString
//@EqualsAndHashCode
@Builder //pour créer un objet de cette entité
@FieldDefaults(level = AccessLevel.PRIVATE )
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idClient")
    /*private*/ Long idClient; // Clé primaire
    @NonNull
    /*private*/ String identifiant;
    @NonNull
    @Temporal(TemporalType.DATE)
    /*private*/ Date datePremiereVisite;
    // Constructeur et accesseurs (getters) et mutateurs (setters)
    @OneToMany(mappedBy="client")
    /*private*/ List<Commande> commandes;
}
