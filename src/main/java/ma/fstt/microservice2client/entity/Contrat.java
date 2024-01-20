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
    private Date echeance;
    private Date dateEcheance;

    @OneToMany(mappedBy = "contrat")
    private List<Section> sections = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "contrat_vehicule",
            joinColumns = @JoinColumn(name = "contrat_id"),
            inverseJoinColumns = @JoinColumn(name = "vehicule_id"))
    private List<Vehicule> vehicules = new ArrayList<>();
}
