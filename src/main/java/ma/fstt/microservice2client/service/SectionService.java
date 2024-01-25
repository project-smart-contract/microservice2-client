package ma.fstt.microservice2client.service;

import ma.fstt.microservice2client.entity.Contrat;
import ma.fstt.microservice2client.entity.Section;
import ma.fstt.microservice2client.entity.Vehicule;
import ma.fstt.microservice2client.repository.ContratRepository;
import ma.fstt.microservice2client.repository.SectionRepository;
import ma.fstt.microservice2client.repository.VehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SectionService {

    @Autowired
    private SectionRepository sectionRepository;

    @Autowired
    private ContratRepository contratRepository;

    @Autowired
    private VehiculeRepository vehiculeRepository;

    public void initialiserSections() {
        Contrat contrat = contratRepository.findById(1).orElse(null);
        Vehicule vehicule = vehiculeRepository.findById(1).orElse(null);

        if (contrat != null && vehicule != null) {
            Section section1 = new Section();
            section1.setId(1);
            section1.setTitre("Contrat");
            section1.setSousTitre("Details contrat");
            section1.setNumOrdre(1);
            section1.setTexte("Contrat Numéro de Police: " + contrat.getNumPolice() + ", Date de Début: " + contrat.getDateDebut() + ", Échéance: " + contrat.getEcheance() + ", Date d'Échéance: " + contrat.getDateEcheance());
            section1.setContrat(contrat);
            sectionRepository.save(section1);

            Section section2 = new Section();
            section2.setId(2);
            section2.setTitre("Vehicule Assurée");
            section2.setSousTitre("Details de vehicule");
            section2.setNumOrdre(2);
            section2.setTexte("Véhicule Immatriculation: " + vehicule.getImmatriculation() + ", Nombre de Places: " + vehicule.getNombrePlace() + ", Puissance CV: " + vehicule.getPuissanceCv() + ", Énergie Carburant: " + vehicule.getEnergieCarbu() + ", Marque: " + vehicule.getMarque() + ", Modèle: " + vehicule.getModel() + ", WWW: " + vehicule.isWww() + ", Type de Véhicule: " + vehicule.getVehicule_type() + ", Année du Modèle: " + vehicule.getAnneeModel());
            section2.setContrat(contrat);
            sectionRepository.save(section2);
        }
    }
}

