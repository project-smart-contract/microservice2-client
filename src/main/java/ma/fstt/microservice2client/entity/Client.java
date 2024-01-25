package ma.fstt.microservice2client.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String email;
    private String password;
    private String nomSoc;
    private String numSocie;


    private String nom;
    private String prenom;
    private String numeroTelephone;
    private String dateNaissance;

    private String adresse;
    private String cin;
    private String numPermis;

}