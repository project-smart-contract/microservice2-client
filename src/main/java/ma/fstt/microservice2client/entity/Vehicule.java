package ma.fstt.microservice2client.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String immatriculation;
    private int nombrePlace;
    private int puissanceCv;
    private String energieCarbu;
    private String marque;
    private String model;
    private String www;
    private String vehicule_type;
    private int anneeModel;
    private int idClient;

    @ManyToMany(mappedBy = "vehicules")
    @JsonIgnore
    //@JsonBackReference
    private List<Contrat> contrats = new ArrayList<>();
}
