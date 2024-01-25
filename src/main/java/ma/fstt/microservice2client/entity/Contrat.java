package ma.fstt.microservice2client.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.*;

import java.util.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contrat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String typeUsage;
    private String numPolice;
    private Date dateDebut;
    private String echeance;
    private Date dateEcheance;
    private int idClient;
    private  boolean isActive ;
    private  int idFormule ;

    @ManyToMany
    @JoinTable(
            name = "contrat_vehicule",
            joinColumns = @JoinColumn(name = "contrat_id"),
            inverseJoinColumns = @JoinColumn(name = "vehicule_id"))

    //@JsonManagedReference
    private List<Vehicule> vehicules = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "contrat_option_formules", joinColumns = @JoinColumn(name = "contrat_id"))
    @Column(name = "option_formule_id")
    private List<Long> optionFormules = new ArrayList<>();


//    @OneToMany(mappedBy = "contrat", cascade = CascadeType.ALL)
//    private List<Section> sections = new ArrayList<>();



}
