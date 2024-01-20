package ma.fstt.microservice2client.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contrat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    //private String typeUsage;
    private String numPolice;
    private Date dateDebut;
    private String echeance;
    private Date dateEcheance;

    @ManyToMany
    @JoinTable(
            name = "contrat_vehicule",
            joinColumns = @JoinColumn(name = "contrat_id"),
            inverseJoinColumns = @JoinColumn(name = "vehicule_id"))
    private List<Vehicule> vehicules = new ArrayList<>();


//    @OneToMany(mappedBy = "contrat", cascade = CascadeType.ALL)
//    private List<Section> sections = new ArrayList<>();



}
