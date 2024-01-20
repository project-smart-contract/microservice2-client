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
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String titre;
    private String sousTitre;
    private int numOrdre;
    private String texte;

    @ManyToOne
    @JoinColumn(name="contrat_id", nullable=false)
    private Contrat contrat;
}
